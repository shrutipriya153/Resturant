package com.example.restraunt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dess_Api {
    String BASE="https://api.myjson.com/";
    @GET("bins/b78bc")
    Call<List<Model>> getDes();

}
