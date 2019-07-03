package com.eugeneponomarev.weatherdarksky;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.eugeneponomarev.weatherdarksky.Common.Common;
import com.eugeneponomarev.weatherdarksky.Model.WeatherDarkSkyResult;
import com.eugeneponomarev.weatherdarksky.retrofitApi.IDarkSky;
import com.eugeneponomarev.weatherdarksky.retrofitApi.RetrofitClient;

import java.net.MalformedURLException;
import java.net.URL;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    static WeatherFragment instance;

    public static WeatherFragment getInstance() {
        if (instance == null)
            instance = new WeatherFragment();
        return instance;
    }


    public WeatherFragment() {
    }

    TextView name;
    Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        getWeatherInformation();

        name = (TextView) view.findViewById(R.id.name);
        button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherInformation();
            }
        });

        return view;
    }

    private void getWeatherInformation() {
        String nameLocation = Common.currentLocation.getLatitude() + "," + Common.currentLocation.getLongitude();
        Log.e("LocationFragment", nameLocation);

        RetrofitClient.getInstance()
                .iDarkSky()
                .getWeather(nameLocation)
                .enqueue(new Callback<WeatherDarkSkyResult>() {
                    @Override
                    public void onResponse(Call<WeatherDarkSkyResult> call, Response<WeatherDarkSkyResult> response) {
                        WeatherDarkSkyResult weatherDarkSkyResult = response.body();

                        name.setText(String.valueOf(weatherDarkSkyResult.getTimezone()));
                    }

                    @Override
                    public void onFailure(Call<WeatherDarkSkyResult> call, Throwable t) {
                        Log.e("INGOR", t.getMessage());
                        name.setText(t.getMessage());
                    }
                });
    }

}
