package com.moyinoluwa.makeupsearch.presentation.search;

import com.moyinoluwa.makeupsearch.data.MakeUpRepository;
import com.moyinoluwa.makeupsearch.data.remote.model.MakeUp;
import com.moyinoluwa.makeupsearch.presentation.base.BasePresenter;

import java.util.List;

import rx.Scheduler;
import rx.Subscriber;

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
    public void search(String brand, String product) {
        checkViewAttached();
        getView().showLoading();
        addSubscription(makeUpRepository.searchMakeUp(brand, product).subscribeOn(ioScheduler)
                .observeOn(mainScheduler).subscribe(new Subscriber<List<MakeUp>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().hideLoading();
                        getView().showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<MakeUp> makeUps) {
                        getView().hideLoading();

                        if (makeUps.isEmpty()) {
                            getView().showEmptyState();
                        } else {
                            getView().showSearchResults(makeUps);
                        }
                    }
                }));
    }
}
