package com.example.restraunt;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class St_NonVeg extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<Model> models;
    St_Veg context;
    ProgressDialog progressDialog;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.veg, container, false);
        progressDialog=new ProgressDialog(getContext());
        progressDialog.setMessage("Loading.....");
        progressDialog.show();
        recyclerView=v.findViewById(R.id.recyclerstv);
        recyclerView.setHasFixedSize(true);
        models=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new Adapter(models,getContext());
        recyclerView.setAdapter(adapter);
        Retrofit retrofit=new Retrofit.Builder().baseUrl(ST_NON_API.BASE).addConverterFactory(GsonConverterFactory.create()).build();
        ST_NON_API api=retrofit.create(ST_NON_API.class);
        Call<List<Model>> call=api.getStNon();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                progressDialog.dismiss();
                models=response.body();
                recyclerView.setAdapter(new Adapter(models,getContext()));

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }

}
