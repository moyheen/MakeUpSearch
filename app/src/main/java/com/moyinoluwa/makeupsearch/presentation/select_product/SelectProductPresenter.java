package com.moyinoluwa.makeupsearch.presentation.select_product;

import android.view.View;

import com.moyinoluwa.makeupsearch.presentation.base.BasePresenter;

/**
 * Created by moyinoluwa on 1/15/17.
 */

public class SelectProductPresenter extends BasePresenter<SelectProductContract.View> implements
        SelectProductContract.Presenter {

    private android.view.View view;
    private String productName;

    public SelectProductPresenter(View view, String productName) {
        this.view = view;
        this.productName = productName;
    }

    @Override
    public void selectProduct() {
        checkViewAttached();

        getView().setTransition();
        getView().switchViewsAfterTransition();
        getView().setProductTextName(productName);
    }

}
