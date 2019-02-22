package com.framgia.weather_01.utils;

import com.framgia.weather_01.BuildConfig;

public class Constant {
    public static final String BASE_URL = "https://api.darksky.net/forecast/";
    public static final String BASE_API_KEY = BuildConfig.API_KEY;
    public static final String GET_METHOD = "GET";
    public static final int TIME_OUT = 5000;
    public static final String CURRENTLY = "currently";
    public static final String DAILY = "daily";
    public static final String HOURLY = "hourly";
    public static final String DATA = "data";
    public static final String TIME = "time";
    public static final String SUMMARY = "summary";
    public static final String ICON = "icon";
    public static final String WIND_SPEED = "windSpeed";
}
