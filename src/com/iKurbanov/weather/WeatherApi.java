package com.iKurbanov.weather;

public interface WeatherApi {
    String getTemperatureForCity(String cityName) throws Exception;
}
