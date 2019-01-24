package com.iKurbanov.weather;

import java.util.Scanner;

public class DisplayWeather {
    public static void main(String[] args) {
        WeatherApi weatherApi = new ApixuWeatherApiAdapter();



        Scanner reader = new Scanner(System.in);
        System.out.println("Введите название города, или нажмите Enter");
        String cityName = reader.nextLine();
        reader.close();

        if (!cityName.isEmpty()){
            try {
                System.out.println("Температура в " + cityName + ": " + weatherApi.getTemperatureForCity(cityName) + "c°");
            } catch (Exception e){
                System.out.println("Ошибка:");
                System.out.println(e.getMessage());
            }
        } else {
            try {
                for (City city : City.values()) {
                    System.out.println("Температура в " + city.getRuName() + ": " + weatherApi.getTemperatureForCity(city.getEngName()) + "c°");
                }
            } catch (Exception e){
                System.out.println("Ошибка:");
                System.out.println(e.getMessage());
            }
        }
    }


}
