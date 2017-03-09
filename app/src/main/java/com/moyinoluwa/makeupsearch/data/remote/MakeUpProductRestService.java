package com.moyinoluwa.makeupsearch.data.remote;

import com.moyinoluwa.makeupsearch.data.remote.model.MakeUp;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by moyinoluwa on 2/8/17.
 */

public interface MakeUpProductRestService {

    @GET("http://makeup-api.herokuapp.com/api/v1/products.json?")
    Observable<List<MakeUp>> searchMakeUpProducts(@Query("brand_name") String brandName, @Query
            ("product_type_name") String productTypeName);
}
