package com.eugeneponomarev.weatherdarksky.retrofitApi;

import com.eugeneponomarev.weatherdarksky.Common.Common;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient mInstance;

    private Retrofit mRetrofit;

    private RetrofitClient() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Common.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }


    public IDarkSky iDarkSky() {
        return mRetrofit.create(IDarkSky.class);
    }
}
