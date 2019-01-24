package com.iKurbanov.weather;

import com.weatherlibrary.datamodel.WeatherModel;
import com.weatherlibraryjava.Repository;
import com.weatherlibraryjava.RequestBlocks;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URLEncoder;

public class ApixuWeatherApiAdapter implements WeatherApi {
    private final String apiKey = "8325b93519574382bd1153342192301";

    //APIXU's java api seems like a wrapper for their http api
    private final Repository repo = new Repository();

    //Takes a city name and returns the temperature there
    @Override
    public String getTemperatureForCity(String cityName) throws Exception{
        PrintStream originalStream = System.out;
        try {

            //I don't know why Apixu api wants to use System.out so much, but i won't let it happen
            System.setOut(new PrintStream(new OutputStream() {
                public void write(int b) {

                }
            }));

            WeatherModel weatherData = repo.GetWeatherData(apiKey, RequestBlocks.GetBy.CityName, URLEncoder.encode(cityName,"UTF-8"));

            //Returning the original out back in place
            System.setOut(originalStream);
            return String.valueOf(weatherData.getCurrent().temp_c);
        } catch (Exception e){
            System.setOut(originalStream);
            throw e;
        }
    }
}
