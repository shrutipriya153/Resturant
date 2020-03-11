package com.example.restraunt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ST_VEG_API {
    String BASE="https://api.myjson.com/";
    @GET("bins/cb9o8")
    Call<List<Model>> getStVeg();
}
