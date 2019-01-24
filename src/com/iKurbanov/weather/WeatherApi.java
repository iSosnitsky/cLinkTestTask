package com.iKurbanov.weather;

public interface WeatherApi {
    /**
     * @param cityName name of a city
     * @return Weather in provided city. In any format, for now.
     * @throws Exception API's are expected to have problems
     */
    String getTemperatureForCity(String cityName) throws Exception;
}
