package com.moyinoluwa.makeupsearch.presentation.select_product;

import com.moyinoluwa.makeupsearch.presentation.base.MvpPresenter;
import com.moyinoluwa.makeupsearch.presentation.base.MvpView;

/**
 * Created by moyinoluwa on 1/15/17.
 */

public class SelectProductContract {

    public interface View extends MvpView {

        void setTransition();

        void switchViewsAfterTransition();

        void setProductTextName(String productName);

        void switchActivity();
    }

    interface Presenter extends MvpPresenter<View> {
        void selectProduct();
    }
}
