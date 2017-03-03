package com.moyinoluwa.makeupsearch.presentation.search;

import com.moyinoluwa.makeupsearch.data.remote.model.MakeUpList;
import com.moyinoluwa.makeupsearch.presentation.base.MvpPresenter;
import com.moyinoluwa.makeupsearch.presentation.base.MvpView;

import java.util.List;

/**
 * Created by moyinoluwa on 2/8/17.
 */

public interface MakeUpSearchContract {

    interface View extends MvpView {
        void showSearchResults(List<MakeUpList> makeUpListList);

        void showError(String message);

        void showLoading();

        void hideLoading();
    }

    interface Presenter extends MvpPresenter<MakeUpSearchContract.View> {
        void search(String term);
    }
}
