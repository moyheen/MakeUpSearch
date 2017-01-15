package com.moyinoluwa.makeupsearch.presentation.select_brand;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by moyinoluwa on 1/15/17.
 */
public class SelectBrandPresenterTest {

    @Mock
    SelectBrandContract.View view;

    SelectBrandPresenter selectBrandPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        selectBrandPresenter = new SelectBrandPresenter();
        selectBrandPresenter.attachView(view);
    }

    @Test
    public void selectProduct_productSelected_switchActivity() {
        selectBrandPresenter.selectBrand();

        verify(view).switchActivity();
    }

}