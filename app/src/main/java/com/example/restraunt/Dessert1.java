package com.example.restraunt;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Dessert1 extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<Model> models;
    Button btn;
    St_Veg context;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert1);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();
        recyclerView=findViewById(R.id.recyclerstv);
        //recyclerView.setHasFixedSize(true);
        models=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new Adapter(models,this);
        recyclerView.setAdapter(adapter);
        //recyclerView.setItemAnimator(null);
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Dess_Api.BASE).addConverterFactory(GsonConverterFactory.create()).build();
        Dess_Api api=retrofit.create(Dess_Api.class);
        Call<List<Model>> call=api.getDes();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                progressDialog.dismiss();
                models=response.body();
                recyclerView.setAdapter(new Adapter(models,getApplicationContext()));

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

}

