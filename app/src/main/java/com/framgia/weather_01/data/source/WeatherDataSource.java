package com.framgia.weather_01.data.source;

import com.framgia.weather_01.data.model.Weather;
import com.framgia.weather_01.data.source.remote.OnFetchDataJsonListener;

public interface WeatherDataSource {
    interface RemoteDataSource {
        void getDailyWeatherData(OnFetchDataJsonListener<Weather> listener);

        void getHourlyWeatherData(OnFetchDataJsonListener<Weather> listener);

        void querySearch(String searchString, OnFetchDataJsonListener<Weather> listener);
    }
}
