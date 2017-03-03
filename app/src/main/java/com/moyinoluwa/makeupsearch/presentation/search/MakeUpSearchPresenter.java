package com.moyinoluwa.makeupsearch.presentation.search;

import com.moyinoluwa.makeupsearch.data.MakeUpRepository;
import com.moyinoluwa.makeupsearch.presentation.base.BasePresenter;

import rx.Scheduler;

/**
 * Created by moyinoluwa on 2/8/17.
 */

public class MakeUpSearchPresenter extends BasePresenter<MakeUpSearchContract.View> implements
        MakeUpSearchContract.Presenter {

    private final Scheduler mainScheduler, ioScheduler;
    private MakeUpRepository makeUpRepository;

    public MakeUpSearchPresenter(MakeUpRepository makeUpRepository, Scheduler ioScheduler, Scheduler
            mainScheduler) {
        this.makeUpRepository = makeUpRepository;
        this.ioScheduler = ioScheduler;
        this.mainScheduler = mainScheduler;
    }

    @Override
    public void search(String term) {

    }
}
