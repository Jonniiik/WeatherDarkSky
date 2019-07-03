package com.eugeneponomarev.weatherdarksky.retrofitApi;

import android.database.Observable;

import com.eugeneponomarev.weatherdarksky.Common.Common;
import com.eugeneponomarev.weatherdarksky.Model.WeatherDarkSkyResult;

import java.net.URL;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface IDarkSky {
    @GET(Common.APP_ID)
    Call<WeatherDarkSkyResult> getWeather(@Path("location") String location);
}