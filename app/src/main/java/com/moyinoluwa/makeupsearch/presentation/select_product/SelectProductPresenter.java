package com.moyinoluwa.makeupsearch.presentation.select_product;

import android.os.Build;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.ViewGroup;

import com.moyinoluwa.makeupsearch.presentation.base.BasePresenter;

/**
 * Created by moyinoluwa on 1/15/17.
 */

public class SelectProductPresenter extends BasePresenter<SelectProductContract.View> implements
        SelectProductContract.Presenter {

    @Override
    public void selectProduct() {
        checkViewAttached();
        getView().switchActivity();
    }

    @Override
    public String getButtonName(String name) {
        checkViewAttached();
        return name;
    }

    @Override
    public void setTransition(ViewGroup sceneRoot) {
        checkViewAttached();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TransitionManager.beginDelayedTransition(sceneRoot,
                    new TransitionSet()
                            .addTransition(new Fade())
                            .addTransition(new Slide(Gravity.START)));
        }
    }
}
