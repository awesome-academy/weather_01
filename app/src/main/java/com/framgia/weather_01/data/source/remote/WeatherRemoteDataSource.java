package com.framgia.weather_01.data.source.remote;

import com.framgia.weather_01.data.model.Weather;
import com.framgia.weather_01.data.source.WeatherDataSource;

public class WeatherRemoteDataSource implements WeatherDataSource.RemoteDataSource {
    private static WeatherRemoteDataSource sInstance;

    public static WeatherRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new WeatherRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getDailyWeatherData(OnFetchDataJsonListener<Weather> listener) {

    }

    @Override
    public void getHourlyWeatherData(OnFetchDataJsonListener<Weather> listener) {

    }

    @Override
    public void querySearch(String searchString, OnFetchDataJsonListener<Weather> listener) {

    }
}
