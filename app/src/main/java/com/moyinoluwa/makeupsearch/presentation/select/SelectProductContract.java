package com.moyinoluwa.makeupsearch.presentation.select;

import com.moyinoluwa.makeupsearch.presentation.base.MvpPresenter;
import com.moyinoluwa.makeupsearch.presentation.base.MvpView;

/**
 * Created by moyinoluwa on 1/15/17.
 */

public class SelectProductContract {

    interface View extends MvpView {
        void switchActivity();
    }

    interface Presenter extends MvpPresenter<View> {
        void selectProduct();
    }
}
