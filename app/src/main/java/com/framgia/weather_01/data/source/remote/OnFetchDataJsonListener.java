package com.framgia.weather_01.data.source.remote;

import java.util.List;

public interface OnFetchDataJsonListener<T> {
    void onSuccess(List<T> dailyData, List<T> hourlyData);

    void onFail(Exception e);
}
