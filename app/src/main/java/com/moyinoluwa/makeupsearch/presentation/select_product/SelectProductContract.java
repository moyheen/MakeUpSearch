package com.moyinoluwa.makeupsearch.presentation.select_product;

import android.view.ViewGroup;

import com.moyinoluwa.makeupsearch.presentation.base.MvpPresenter;
import com.moyinoluwa.makeupsearch.presentation.base.MvpView;

/**
 * Created by moyinoluwa on 1/15/17.
 */

public class SelectProductContract {

    public interface View extends MvpView {
        public void selectButtonClick(android.view.View view);
        void setTransition(ViewGroup sceneRoot);
        void switchViewsAfterTransition();
        void setProductTextName();
        void switchActivity();
    }

    interface Presenter extends MvpPresenter<View> {
        void selectProduct();
    }
}
