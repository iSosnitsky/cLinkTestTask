package com.iKurbanov.weather;

//APIXU doesn't work well with cyrillic names
enum City {
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
