package com.moyinoluwa.makeupsearch.presentation.select_brand;

import com.moyinoluwa.makeupsearch.presentation.base.MvpPresenter;
import com.moyinoluwa.makeupsearch.presentation.base.MvpView;

/**
 * Created by moyinoluwa on 1/15/17.
 */

public class SelectBrandContract {

    public interface View extends MvpView {
        void switchActivity();
    }

    interface Presenter extends MvpPresenter<View> {
        void selectBrand();
    }
}
