package com.moyinoluwa.makeupsearch.presentation.select_brand;

import com.moyinoluwa.makeupsearch.presentation.base.BasePresenter;

/**
 * Created by moyinoluwa on 1/15/17.
 */

public class SelectBrandPresenter extends BasePresenter<SelectBrandContract.View> implements
        SelectBrandContract.Presenter {

    @Override
    public void selectBrand() {
        checkViewAttached();
        getView().switchActivity();
    }
}
