package com.moyinoluwa.makeupsearch.presentation.base;

/**
 * Created by moyinoluwa on 1/15/17.
 */

public interface MvpPresenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
