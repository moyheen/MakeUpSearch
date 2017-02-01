package com.moyinoluwa.makeupsearch.presentation.select_product;

import android.view.View;
import android.view.ViewGroup;

import com.moyinoluwa.makeupsearch.presentation.base.BasePresenter;

/**
 * Created by moyinoluwa on 1/15/17.
 */

public class SelectProductPresenter extends BasePresenter<SelectProductContract.View> implements
        SelectProductContract.Presenter {

    private ViewGroup sceneRoot;
    private android.view.View view;

    public SelectProductPresenter(ViewGroup viewGroup, View view) {
        this.sceneRoot = viewGroup;
        this.view = view;
    }

    @Override
    public void selectProduct() {
        checkViewAttached();

        getView().selectButtonClick(view);
        getView().setTransition(sceneRoot);
        getView().switchViewsAfterTransition();
        getView().setProductTextName();
    }

}
