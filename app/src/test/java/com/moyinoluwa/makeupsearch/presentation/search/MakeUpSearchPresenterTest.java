package com.moyinoluwa.makeupsearch.presentation.search;

import com.moyinoluwa.makeupsearch.data.MakeUpRepository;
import com.moyinoluwa.makeupsearch.data.remote.model.MakeUp;
import com.moyinoluwa.makeupsearch.presentation.base.BasePresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by moyinoluwa on 3/3/17.
 */
public class MakeUpSearchPresenterTest {

    @Mock
    MakeUpRepository makeUpRepository;
    @Mock
    MakeUpSearchContract.View view;

    private MakeUpSearchPresenter makeUpSearchPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        makeUpSearchPresenter = new MakeUpSearchPresenter(makeUpRepository, Schedulers.immediate
                (), Schedulers.immediate());
        makeUpSearchPresenter.attachView(view);
    }

    @Test
    public void search_ValidSearchTerm_ReturnsResults() {
        List<MakeUp> makeUpDummyList = getDummyMakeUpList();

        // Given
        when(makeUpRepository.searchMakeUp(anyString(), anyString())).thenReturn(Observable.just
                (makeUpDummyList));

        // When
        makeUpSearchPresenter.search("maybelline", "bronzer");

        // Then
        verify(view).showLoading();
        verify(view).hideLoading();
        verify(view).showSearchResults(makeUpDummyList);
        verify(view, never()).showError(anyString());

    }

    List<MakeUp> getDummyMakeUpList() {
        List<MakeUp> makeUpList = new ArrayList<>();
        makeUpList.add(makeUpDetails());
        makeUpList.add(makeUpDetails());
        return makeUpList;
    }

    private MakeUp makeUpDetails() {
        return new MakeUp(114, "covergirl", "CoverGirl Outlast Longwear " +
                "Lipstick Plum Fury (950)", "10.99", "https://d3t32hsnjxo7q6.cloudfront" +
                ".net/i/2d46e82f21b11f658a4378abcbd1c31b_ra,w158,h184_pa,w158,h184.png",
                "https://well.ca/products/covergirl-outlast-longwear-lipstick_105803.html",
                "https://well.ca", "With CoverGirl Outlast Longwear Lipstick you get both " +
                "moisture and colour! No need to choose!This long lasting lipstick doesn’t flake " +
                "or \ncrumble because it’s super-powered with moisture. It'll stays super fresh " +
                "and \nsuper flexible all day, leaving you with a light weight but very pigmented" +
                " lip look.", null, "lipstick", "lipstick", null, "2016-10-01T18:25:52.547Z",
                "2016-10-01T18:25:52.547Z", "http://makeup-api.herokuapp.com/api/v1/products/114" +
                ".json", null);
    }

    @Test
    public void search_MakeupRepositoryError_ErrorMsg() {
        String errorMessage = "No internet";

        // Given
        when(makeUpRepository.searchMakeUp(anyString(), anyString())).thenReturn(Observable.error
                (new IOException(errorMessage)));

        // When
        makeUpSearchPresenter.search("test", "test");

        // Then
        verify(view).showLoading();
        verify(view).hideLoading();
        verify(view, never()).showSearchResults(anyList());
        verify(view).showError(errorMessage);
    }

    @Test(expected = BasePresenter.MvpViewNotAttachedException.class)
    public void search_NotAttached_ThrowsMvpException() {
        // Given
        makeUpSearchPresenter.detachView();

        // When
        makeUpSearchPresenter.search("test", "test");

        // Then
        verify(view, never()).showLoading();
        verify(view, never()).showSearchResults(anyList());
    }
}