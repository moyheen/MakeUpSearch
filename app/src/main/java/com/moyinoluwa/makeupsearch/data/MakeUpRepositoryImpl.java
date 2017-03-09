package com.moyinoluwa.makeupsearch.data;

import com.moyinoluwa.makeupsearch.data.remote.MakeUpProductRestService;
import com.moyinoluwa.makeupsearch.data.remote.model.MakeUp;

import java.io.IOException;
import java.util.List;

import rx.Observable;

/**
 * Created by moyinoluwa on 2/8/17.
 */

public class MakeUpRepositoryImpl implements MakeUpRepository {

    private MakeUpProductRestService makeUpProductRestService;

    public MakeUpRepositoryImpl(MakeUpProductRestService makeUpProductRestService) {
        this.makeUpProductRestService = makeUpProductRestService;
    }

    @Override
    public Observable<List<MakeUp>> searchMakeUp(final String brandName, final String productName) {
        return Observable.defer(() -> makeUpProductRestService.searchMakeUpProducts(brandName,
                productName))
                .retryWhen(observable -> observable.flatMap(o -> {
                    if (o instanceof IOException) {
                        return Observable.just(null);
                    }
                    return Observable.error(o);
                }));
    }
}
