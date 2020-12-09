package edu.csce4623.eaduran.covid_19calculator.API;

public class Config {
    public static final String DATA_URL = "https://api.covidactnow.org/v2/counties.json?apiKey=d6f5ac0f7c0143b683aa50bf7bf163dd";

    //Tags used in the JSON String
    public static final String TAG_STATE = "state";
    public static final String TAG_COUNTY = "county";


    //JSON array name
    public static final String JSON_ARRAY = "result";
}
