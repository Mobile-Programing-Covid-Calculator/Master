package edu.csce4623.eaduran.covid_19calculator.API;

import java.util.List;

import edu.csce4623.eaduran.covid_19calculator.API.CovidInfo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidInfoAPI {

    @GET("/v2/counties.json?apiKey=d6f5ac0f7c0143b683aa50bf7bf163dd/")
    //@GET("posts/")
    //@GET("counties.json?apiKey=d6f5ac0f7c0143b683aa50bf7bf163dd/")
    Call<List<CovidInfo>> loadInfo();

}
