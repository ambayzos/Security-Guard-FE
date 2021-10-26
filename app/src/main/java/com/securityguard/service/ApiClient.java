package com.securityguard.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class ApiClient {

    public static Retrofit retrofit;
    public static final String URL = "https://451c-2001-448a-2082-aadb-a9d3-15cb-7608-a192.ngrok.io";

    public static Retrofit getRetrofit() {
        Gson gson = new GsonBuilder().setLenient().create();
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
