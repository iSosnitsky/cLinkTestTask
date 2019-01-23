package com.iKurbanov;

import com.weatherlibrary.datamodel.WeatherModel;
import com.weatherlibraryjava.Repository;
import com.weatherlibraryjava.RequestBlocks;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URLEncoder;

public class ApixuWeatherApiAdapter implements WeatherApi {
    private final String apiKey = "8325b93519574382bd1153342192301";
    //APIXU's java api seems like a simple wrapper for their http api
    private final Repository repo = new Repository();

    @Override
    public String getTemperatureForCity(String cityName) {
        PrintStream originalStream = System.out;
        try {
            System.setOut(new PrintStream(new OutputStream() {
                public void write(int b) {
                    //Not gonna happen
                }
            }));
            WeatherModel weatherData = repo.GetWeatherData(apiKey, RequestBlocks.GetBy.CityName, URLEncoder.encode(cityName,"UTF-8"));

            System.setOut(originalStream);
            return String.valueOf(weatherData.getCurrent().temp_c);
        } catch (Exception e){
            System.setOut(originalStream);
            System.out.println(e.getMessage());
        }
        return null;
    }
}
