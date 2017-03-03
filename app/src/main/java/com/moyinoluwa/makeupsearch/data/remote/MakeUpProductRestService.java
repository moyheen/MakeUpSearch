package com.moyinoluwa.makeupsearch.data.remote;

import com.moyinoluwa.makeupsearch.data.remote.model.MakeUp;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by moyinoluwa on 2/8/17.
 */

public interface MakeUpProductRestService {

    @GET("/api/v1/products.json?brand={brand_name}&product_type={product_type_name}")
    Observable<MakeUp> searchMakeUpProducts(@Path("brand_name") String brandName, @Path
            ("product_type_name") String productTypeName);
}
