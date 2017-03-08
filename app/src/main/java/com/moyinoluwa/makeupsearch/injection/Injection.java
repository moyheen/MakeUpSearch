package com.moyinoluwa.makeupsearch.injection;

import com.moyinoluwa.makeupsearch.data.MakeUpRepository;
import com.moyinoluwa.makeupsearch.data.MakeUpRepositoryImpl;
import com.moyinoluwa.makeupsearch.data.remote.MakeUpProductRestService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by moyinoluwa on 2/8/17.
 */

public class Injection {

    private static final String BASE_URL = "https://api.github.com";
    private static OkHttpClient okHttpClient;
    private static MakeUpProductRestService makeupRestService;
    private static Retrofit retrofitInstance;


    public static MakeUpRepository provideUserRepo() {
        return new MakeUpRepositoryImpl(provideMakeupUserRestService());
    }

    static MakeUpProductRestService provideMakeupUserRestService() {
        if (makeupRestService == null) {
            makeupRestService = getRetrofitInstance().create(MakeUpProductRestService.class);
        }
        return makeupRestService;
    }

    static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
        }

        return okHttpClient;
    }

    static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            Retrofit.Builder retrofit = new Retrofit.Builder().client(Injection.getOkHttpClient()
            ).baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
            retrofitInstance = retrofit.build();

        }
        return retrofitInstance;
    }
}
