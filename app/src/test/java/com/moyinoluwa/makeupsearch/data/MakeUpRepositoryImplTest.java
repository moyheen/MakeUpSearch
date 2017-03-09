package com.moyinoluwa.makeupsearch.data;

import com.moyinoluwa.makeupsearch.data.remote.MakeUpProductRestService;
import com.moyinoluwa.makeupsearch.data.remote.model.MakeUp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by moyinoluwa on 2/9/17.
 */
public class MakeUpRepositoryImplTest {

    @Mock
    MakeUpProductRestService makeUpProductRestService;

    private MakeUpRepository makeUpRepository;

    private static final String BRAND_COVERGIRL = "covergirl";
    private static final String PRODUCT_TYPE_LIPSTICK = "lipstick";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        makeUpRepository = new MakeUpRepositoryImpl(makeUpProductRestService);
    }

    @Test
    public void searchMakeUp_200OkResponse_InvokesCorrectApiCalls() {
        // Given
        when(makeUpProductRestService.searchMakeUpProducts(anyString(), anyString())).thenReturn
                (Observable.just(makeUpList()).toList());

        // When
        TestSubscriber<List<MakeUp>> subscriber = new TestSubscriber<>();
        makeUpRepository.searchMakeUp(BRAND_COVERGIRL, PRODUCT_TYPE_LIPSTICK).subscribe(subscriber);

        // Then
        subscriber.awaitTerminalEvent();
        subscriber.assertNoErrors();

        List<List<MakeUp>> onNextEvents = subscriber.getOnNextEvents();
        List<MakeUp> makeup = onNextEvents.get(0);
        Assert.assertEquals(BRAND_COVERGIRL, makeup.get(0).getBrand());
        Assert.assertEquals(PRODUCT_TYPE_LIPSTICK, makeup.get(0).getProductType());
        verify(makeUpProductRestService).searchMakeUpProducts(BRAND_COVERGIRL,
                PRODUCT_TYPE_LIPSTICK);
    }

    private MakeUp makeUpList() {
        MakeUp makeUp = new MakeUp(114, "covergirl", "CoverGirl Outlast Longwear " +
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

        return makeUp;
    }

    @Test
    public void searchMakeUp_IoExceptionThenSuccess_SearchMakeUpRetried() {
        // Given
        when(makeUpProductRestService.searchMakeUpProducts(anyString(), anyString())).thenReturn
                (getIoExceptionError().toList(), Observable.just(makeUpList()).toList());

        // When
        TestSubscriber<List<MakeUp>> subscriber = new TestSubscriber<>();
        makeUpRepository.searchMakeUp(BRAND_COVERGIRL, PRODUCT_TYPE_LIPSTICK).subscribe(subscriber);

        // Then
        subscriber.awaitTerminalEvent();
        subscriber.assertNoErrors();

        verify(makeUpProductRestService, times(2)).searchMakeUpProducts(BRAND_COVERGIRL,
                PRODUCT_TYPE_LIPSTICK);
    }

    private Observable<MakeUp> getIoExceptionError() {
        return Observable.error(new IOException());
    }

    @Test
    public void searchMakeUp_OtherHttpError_searchTerminatedWithError() {
        // Given
        when(makeUpProductRestService.searchMakeUpProducts(anyString(), anyString())).thenReturn
                (get403ForbiddenError().toList());

        // When
        TestSubscriber<List<MakeUp>> subscriber = new TestSubscriber<>();
        makeUpRepository.searchMakeUp(BRAND_COVERGIRL, PRODUCT_TYPE_LIPSTICK).subscribe(subscriber);

        // Then
        subscriber.awaitTerminalEvent();
        subscriber.assertError(HttpException.class);

        verify(makeUpProductRestService).searchMakeUpProducts(BRAND_COVERGIRL,
                PRODUCT_TYPE_LIPSTICK);
    }

    private Observable<MakeUp> get403ForbiddenError() {
        return Observable.error(new HttpException(Response.error(403, ResponseBody.create
                (MediaType.parse("application/json"), "Forbidden"))));
    }

}