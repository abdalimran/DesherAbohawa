package com.github.abdalimran.desherabohawa.Interfaces;

import com.github.abdalimran.desherabohawa.ConditionPojoModels.ConditionResponse;
import com.github.abdalimran.desherabohawa.Forecast10dayPojoModels.Forecast10dayResponse;
import com.github.abdalimran.desherabohawa.GeolookupPojoModels.GeolookupResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API_Interface {

    @GET("api/{apikey}/conditions/q/BD/{city}.json")
    Call<ConditionResponse> getWeatherConditions(
            @Path("apikey") String apikey,
            @Path("city") String city);

    @GET("api/{apikey}/forecast10day/q/BD/{city}.json")
    Call<Forecast10dayResponse> getWeatherForecast(
            @Path("apikey") String apikey,
            @Path("city") String city);

    @GET("api/{apikey}/geolookup/q/{lat},{lon}.json")
    Call<GeolookupResponse> getGeolookup(
            @Path("apikey") String apikey,
            @Path("lat") double lat,
            @Path("lon") double lon);
}