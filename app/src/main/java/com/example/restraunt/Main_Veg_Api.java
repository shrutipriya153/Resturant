package com.example.restraunt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Main_Veg_Api {
    String BASE="https://api.myjson.com/";
    @GET("bins/16om0g")
    Call<List<Model>> getMainVeg();
}
