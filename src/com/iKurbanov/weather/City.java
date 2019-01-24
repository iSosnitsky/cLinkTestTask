package com.iKurbanov.weather;


/**
 * This ENUM contains 4 default city names
 */
enum City {
    DMG("Dimitrovgrad","Димитровград"),
    MSK("Moscow","Москва"),
    SPB("Saint-Petersburg","Санкт-петербург"),
    TKO("Tokyo","Токио");

    private String engName;
    private String ruName;

    /**
     * @return English city name, suited for ApixuAPI
     */
    public String getEngName() {
        return engName;
    }


    /**
     * @return Russian city name, intended to be displayed to the user
     */
    public String getRuName() {
        return ruName;
    }

    City(String engName, String ruName) {
        this.engName = engName;
        this.ruName = ruName;
    }
}
