package com.example.restraunt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ST_NON_API {
    String BASE="https://api.myjson.com/";

    @GET("bins/k8c0o")
    Call<List<Model>> getStNon();
}
