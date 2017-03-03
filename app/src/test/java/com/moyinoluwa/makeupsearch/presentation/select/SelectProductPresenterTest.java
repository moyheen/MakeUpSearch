package com.moyinoluwa.makeupsearch.presentation.select;

import android.view.ViewGroup;

import com.moyinoluwa.makeupsearch.presentation.base.BasePresenter;
import com.moyinoluwa.makeupsearch.presentation.select_product.SelectProductContract;
import com.moyinoluwa.makeupsearch.presentation.select_product.SelectProductPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by moyinoluwa on 1/15/17.
 */
public class SelectProductPresenterTest {

    @Mock
    SelectProductContract.View view;

    @Mock
    ViewGroup viewGroup;

    private SelectProductPresenter selectProductPresenter;
    private String PRODUCT_NAME = "bronzer";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        selectProductPresenter = new SelectProductPresenter(viewGroup, PRODUCT_NAME);
        selectProductPresenter.attachView(view);
    }

    @Test
    public void selectProduct_transitionPerformed_switchViews() {
        selectProductPresenter.selectProduct();

        verify(view).setTransition();
        verify(view).switchViewsAfterTransition();
        verify(view).setProductTextName(PRODUCT_NAME);
    }

    @Test(expected = BasePresenter.MvpViewNotAttachedException.class)
    public void selectProduct_NotAttached_ThrowsMvpException() {
        selectProductPresenter.detachView();

        selectProductPresenter.selectProduct();

        verify(view, never()).setTransition();
        verify(view, never()).switchViewsAfterTransition();
        verify(view, never()).setProductTextName(PRODUCT_NAME);
    }

}