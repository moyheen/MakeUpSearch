package com.moyinoluwa.makeupsearch.data;

import com.moyinoluwa.makeupsearch.data.remote.model.MakeUp;

import java.util.List;

import rx.Observable;

/**
 * Created by moyinoluwa on 2/8/17.
 */

public interface MakeUpRepository {

    Observable<List<MakeUp>> searchMakeUp(String brandName, String productName);
}
