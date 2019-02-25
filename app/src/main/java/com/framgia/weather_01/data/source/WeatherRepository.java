package com.framgia.weather_01.data.source;

import com.framgia.weather_01.data.model.Weather;
import com.framgia.weather_01.data.source.remote.OnFetchDataJsonListener;

public class WeatherRepository {
    private static WeatherRepository sInstance;
    private WeatherDataSource.RemoteDataSource mRemoteDataSourceListener;

    private WeatherRepository(WeatherDataSource.RemoteDataSource remoteDataSourceListener) {
        mRemoteDataSourceListener = remoteDataSourceListener;
    }

    public static WeatherRepository getInstance(
            WeatherDataSource.RemoteDataSource remoteDataSourceListener) {
        if (sInstance == null) {
            sInstance = new WeatherRepository(remoteDataSourceListener);
        }
        return sInstance;
    }

    public void getDailyWeatherData(OnFetchDataJsonListener<Weather> listener) {
        mRemoteDataSourceListener.getDailyWeatherData(listener);
    }

    public void getHourlyWeatherData(OnFetchDataJsonListener<Weather> listener) {
        mRemoteDataSourceListener.getHourlyWeatherData(listener);
    }

    public void querySearch(String searchString, OnFetchDataJsonListener<Weather> listener) {
        mRemoteDataSourceListener.querySearch(searchString, listener);
    }
}
