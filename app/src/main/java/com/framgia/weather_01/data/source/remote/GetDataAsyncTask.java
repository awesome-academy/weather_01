package com.framgia.weather_01.data.source.remote;

import android.os.AsyncTask;
import com.framgia.weather_01.data.model.Weather;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.framgia.weather_01.utils.Constant.DAILY;
import static com.framgia.weather_01.utils.Constant.DATA;
import static com.framgia.weather_01.utils.Constant.GET_METHOD;
import static com.framgia.weather_01.utils.Constant.HOURLY;
import static com.framgia.weather_01.utils.Constant.TIME_OUT;

public class GetDataAsyncTask extends AsyncTask<String, Void, String> {

    private OnFetchDataJsonListener<Weather> mListener;

    public GetDataAsyncTask(OnFetchDataJsonListener<Weather> listener) {
        mListener = listener;
    }

    @Override
    protected String doInBackground(String... strings) {
        String json = "";
        try {
            json = getJsonFromUrl(strings[0]);
        } catch (IOException e) {
            mListener.onFail(e);
        }
        return json;
    }

    @Override
    protected void onPostExecute(String json) {
        super.onPostExecute(json);
        if (json != null) {
            try {
                mListener.onSuccess(getDailyDataFromJson(json), getHourlyDataFromJson(json));
            } catch (JSONException e) {
                mListener.onFail(e);
            }
        }
    }

    private String getJsonFromUrl(String url) throws IOException {
        URL apiUrl = new URL(url);
        HttpURLConnection httpUrlConnection = (HttpURLConnection) apiUrl.openConnection();
        httpUrlConnection.setRequestMethod(GET_METHOD);
        httpUrlConnection.setReadTimeout(TIME_OUT);
        httpUrlConnection.setConnectTimeout(TIME_OUT);
        httpUrlConnection.connect();

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        httpUrlConnection.disconnect();
        return stringBuilder.toString();
    }

    private JSONArray initJson(String json, String typeData) throws JSONException {
        return new JSONObject(json).getJSONObject(typeData).getJSONArray(DATA);
    }

    private List<Weather> getDailyDataFromJson(String json) throws JSONException {
        List<Weather> weatherList = new ArrayList<>();
        JSONArray dataDailyArray = initJson(json, DAILY);
        for (int i = 0; i < dataDailyArray.length(); i++) {
            weatherList.add(getDataFromDailyArrayObject(dataDailyArray.getJSONObject(i)));
        }
        return weatherList;
    }

    private List<Weather> getHourlyDataFromJson(String json) throws JSONException {
        List<Weather> weatherList = new ArrayList<>();
        JSONArray dataHourlyArray = initJson(json, HOURLY);
        for (int i = 1; i < dataHourlyArray.length(); i++) {
            weatherList.add(getDataFromHourlyArrayObject(dataHourlyArray.getJSONObject(i)));
        }
        return weatherList;
    }

    private Weather getDataFromDailyArrayObject(JSONObject jsonObject) throws JSONException {
        return new Weather.WeatherBuilder().currentTime(
                jsonObject.getInt(Weather.WeatherEntry.TIME))
                .icon(jsonObject.getString(Weather.WeatherEntry.ICON))
                .summary(jsonObject.getString(Weather.WeatherEntry.SUMMARY))
                .windSpeed(jsonObject.getDouble(Weather.WeatherEntry.WIND_SPEED))
                .temperatureMax(jsonObject.getDouble(Weather.WeatherEntry.TEMPERATURE_MAX))
                .temperatureMin(jsonObject.getDouble(Weather.WeatherEntry.TEMPERATURE_MIN))
                .build();
    }

    private Weather getDataFromHourlyArrayObject(JSONObject jsonObject) throws JSONException {
        return new Weather.WeatherBuilder().currentTime(
                jsonObject.getInt(Weather.WeatherEntry.TIME))
                .icon(jsonObject.getString(Weather.WeatherEntry.ICON))
                .temperature(jsonObject.getDouble(Weather.WeatherEntry.TEMPERATURE))
                .build();
    }
}
