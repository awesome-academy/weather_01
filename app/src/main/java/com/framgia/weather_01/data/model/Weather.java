package com.framgia.weather_01.data.model;

public class Weather {
    private String mLatitude;
    private String mLongitude;
    private long mCurrentTime;
    private String mSummary;
    private String mIcon;
    private double mTemperature;
    private double mTemperatureMin;
    private double mTemperatureMax;
    private double mWindSpeed;

    public Weather() {
    }

    public Weather(WeatherBuilder weatherBuilder) {
        mLatitude = weatherBuilder.mLatitude;
        mLongitude = weatherBuilder.mLongitude;
        mCurrentTime = weatherBuilder.mCurrentTime;
        mSummary = weatherBuilder.mSummary;
        mIcon = weatherBuilder.mIcon;
        mTemperature = weatherBuilder.mTemperature;
        mTemperatureMin = weatherBuilder.mTemperatureMin;
        mTemperatureMax = weatherBuilder.mTemperatureMax;
        mWindSpeed = weatherBuilder.mWindSpeed;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String latitude) {
        mLatitude = latitude;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String longitude) {
        mLongitude = longitude;
    }

    public long getCurrentTime() {
        return mCurrentTime;
    }

    public void setCurrentTime(long currentTime) {
        mCurrentTime = currentTime;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public double getTemperature() {
        return mTemperature;
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public double getTemperatureMin() {
        return mTemperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        mTemperatureMin = temperatureMin;
    }

    public double getTemperatureMax() {
        return mTemperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        mTemperatureMax = temperatureMax;
    }

    public double getWindSpeed() {
        return mWindSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        mWindSpeed = windSpeed;
    }

    public static class WeatherBuilder {
        private String mLatitude;
        private String mLongitude;
        private long mCurrentTime;
        private String mSummary;
        private String mIcon;
        private double mTemperature;
        private double mTemperatureMin;
        private double mTemperatureMax;
        private double mWindSpeed;

        public WeatherBuilder() {
        }

        public WeatherBuilder(String latitude, String longitude, long currentTime, String summary,
                String icon, double temperature, double windSpeed) {
            mLatitude = latitude;
            mLongitude = longitude;
            mCurrentTime = currentTime;
            mSummary = summary;
            mIcon = icon;
            mTemperature = temperature;
            mWindSpeed = windSpeed;
        }

        public WeatherBuilder latitude(String latitude) {
            mLatitude = latitude;
            return this;
        }

        public WeatherBuilder longitude(String longitude) {
            mLongitude = longitude;
            return this;
        }

        public WeatherBuilder currentTime(long currentTime) {
            mCurrentTime = currentTime;
            return this;
        }

        public WeatherBuilder summary(String summary) {
            mSummary = summary;
            return this;
        }

        public WeatherBuilder icon(String icon) {
            mIcon = icon;
            return this;
        }

        public WeatherBuilder temperature(double temperature) {
            mTemperature = temperature;
            return this;
        }

        public WeatherBuilder temperatureMin(double temperatureMin) {
            mTemperatureMin = temperatureMin;
            return this;
        }

        public WeatherBuilder temperatureMax(double temperatureMax) {
            mTemperatureMax = temperatureMax;
            return this;
        }

        public WeatherBuilder windSpeed(double windSpeed) {
            mWindSpeed = windSpeed;
            return this;
        }

        public Weather build() {
            return new Weather(this);
        }
    }

    public class WeatherEntry {
        public static final String ICON = "icon";
        public static final String SUMMARY = "summary";
        public static final String TIME = "time";
        public static final String TEMPERATURE = "temperature";
        public static final String TEMPERATURE_MIN = "temperatureMin";
        public static final String TEMPERATURE_MAX = "temperatureMax";
        public static final String WIND_SPEED = "windSpeed";
    }
}
