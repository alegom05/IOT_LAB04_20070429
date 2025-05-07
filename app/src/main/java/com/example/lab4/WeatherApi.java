package com.example.lab4;

import com.example.lab4.LocationItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("v1/search.json")
    Call<List<LocationItem>> searchLocations(
            @Query("key") String apiKey,
            @Query("q") String query
    );
}
