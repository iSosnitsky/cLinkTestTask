package com.iKurbanov;

import java.util.Scanner;

public class DisplayWeather {
    public static void main(String[] args) {
        WeatherApi weatherApi = new ApixuWeatherApiAdapter();



        Scanner reader = new Scanner(System.in);
        System.out.println("Введите название города, или нажмите Enter");
        String cityName = reader.nextLine();
        reader.close();

        if (!cityName.isEmpty()){
            System.out.println("Температура в "+cityName+": "+weatherApi.getTemperatureForCity(cityName)+"c°");
        } else {
            for(City city : City.values()){
                System.out.println("Температура в "+city.getRuName()+": "+weatherApi.getTemperatureForCity(city.getEngName())+"c°");
            }
        }
    }

    //APIXU doesn't work well with cyrillic names
    private enum City {
        DMG("Dimitrovgrad","Димитровград"),
        MSK("Moscow","Москва"),
        SPB("Saint-Petersburg","Санкт-петербург"),
        TKO("Tokyo","Токио");

        private String engName;
        private String ruName;

        public String getEngName() {
            return engName;
        }

        public String getRuName() {
            return ruName;
        }

        City(String engName, String ruName) {
            this.engName = engName;
            this.ruName = ruName;
        }
    }
}
