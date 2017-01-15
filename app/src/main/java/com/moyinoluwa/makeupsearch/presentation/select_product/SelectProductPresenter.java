package com.moyinoluwa.makeupsearch.presentation.select_product;

import com.moyinoluwa.makeupsearch.presentation.base.BasePresenter;

/**
 * Created by moyinoluwa on 1/15/17.
 */

public class SelectProductPresenter extends BasePresenter<SelectProductContract.View> implements
        SelectProductContract.Presenter  {

    @Override
    public void selectProduct() {
        checkViewAttached();
        getView().switchActivity();
    }
}
