package com.eugeneponomarev.weatherdarksky;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eugeneponomarev.weatherdarksky.Common.Common;
import com.eugeneponomarev.weatherdarksky.Common.DataConverters;
import com.eugeneponomarev.weatherdarksky.Model.WeatherDarkSkyResult;
import com.eugeneponomarev.weatherdarksky.retrofitApi.RetrofitClient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    @Override
    public void onResume() {
        super.onResume();
        //getColorFragment();
    }

    static WeatherFragment instance;

    public static WeatherFragment getInstance() {
        if (instance == null)
            instance = new WeatherFragment();
        return instance;
    }


    public WeatherFragment() {
    }

    TextView nameTimezone, nameTime, textViewWeather;
    LinearLayout linearLayoutFragment;
    ImageView textViewImageWeather;
    String dataTime;
    Double dataTimeColor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        getWeatherInformation();
        iniComponent(view);
        getTimeCalendar();


        return view;
    }

    private void iniComponent(View view) {
        linearLayoutFragment = (LinearLayout) view.findViewById(R.id.linearLayoutFragment);
        nameTimezone = (TextView) view.findViewById(R.id.nameTimezone);
        nameTime = (TextView) view.findViewById(R.id.nameTime);
        textViewImageWeather = (ImageView) view.findViewById(R.id.textViewImageWeather);
        textViewWeather = (TextView) view.findViewById(R.id.textViewWeather);
    }

    private void getTimeCalendar() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        dataTime = dateFormat.format(calendar.getTime());
        nameTime.setText(String.valueOf(dataTime));
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

                        WeatherDarkSkyResult weatherDS = response.body();

                        assert weatherDS != null;
                        nameTimezone.setText(String.valueOf(weatherDS.getTimezone()));


                        String image = weatherDS.getCurrently().getIcon();
                        Log.e("IMAGE", image);
                        if (image.equals("clear-day")){
                            textViewImageWeather.setBackgroundColor(Color.WHITE);
                            textViewWeather.setText("Ясный день");
                        }
                        if (image.equals("cloudy")){
                            textViewImageWeather.setBackgroundColor(Color.BLACK);
                            textViewWeather.setText("Облачный");
                        }
                        if (image.equals("partly-cloudy-day")){
                            textViewImageWeather.setBackgroundColor(Color.BLUE);
                            textViewWeather.setText("Частично облачный день");
                        }
                        if (image.equals("partly-cloudy-night")){
                            textViewImageWeather.setBackgroundColor(Color.RED);
                            textViewWeather.setText("Частично облачная ночь");
                        }
                        if (image.equals("rain")){
                            textViewImageWeather.setBackgroundColor(Color.GREEN);
                            textViewWeather.setText("Дождь");
                        }
                        if (image.equals("snow")){
                            textViewImageWeather.setBackgroundColor(Color.YELLOW);
                            textViewWeather.setText("Снег");
                        }
                        if (image.equals("sleet")){
                            textViewImageWeather.setBackgroundColor(Color.BLUE);
                            textViewWeather.setText("Снег с дождем");
                        }
                        if (image.equals("wind")){
                            textViewImageWeather.setBackgroundColor(Color.RED);
                            textViewWeather.setText("Ветренно");
                        }
                        if (image.equals("fog")){
                            textViewImageWeather.setBackgroundColor(Color.WHITE);
                            textViewWeather.setText("Туман");
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherDarkSkyResult> call, Throwable t) {
                        Log.e("INGOR", t.getMessage());
                        nameTimezone.setText(t.getMessage());
                    }
                });
    }

    private void getColorFragment() {
        String dataTimeConvert;
        DateFormat dateFormat = new SimpleDateFormat("HH.mm");
        Calendar calendar = Calendar.getInstance();
        dataTimeConvert = dateFormat.format(calendar.getTime());

        try {
            dataTimeColor = Double.valueOf(dataTimeConvert);
        } catch (NumberFormatException e) {
            nameTime.setText(String.valueOf(e.getMessage()));
        }

        if (dataTimeColor == 00.00) {
            linearLayoutFragment.setBackgroundColor(Color.WHITE);
        }
        if (dataTimeColor > 00.00 && dataTimeColor < 05.00) {
            linearLayoutFragment.setBackgroundColor(Color.BLUE);
        }
        if (dataTimeColor > 05.00 && dataTimeColor < 12.00) {
            linearLayoutFragment.setBackgroundColor(Color.YELLOW);
        }
        if (dataTimeColor > 12.00 && dataTimeColor < 17.00) {
            linearLayoutFragment.setBackgroundColor(Color.DKGRAY);
        }
        if (dataTimeColor > 17.00 && dataTimeColor < 21.00) {
            linearLayoutFragment.setBackgroundColor(Color.RED);
        }
        if (dataTimeColor > 21.00) {
            linearLayoutFragment.setBackgroundColor(Color.BLACK);
        }

    }
}
//https://api.darksky.net/forecast/3d019c84c092a3f07e669516d3fb6c1f/51.5084983,-0.1257183}