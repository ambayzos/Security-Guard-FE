package com.securityguard.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class ApiClient {

    public static Retrofit retrofit;
    public static final String URL = "http://b7ce-2001-448a-2082-ccef-685f-1750-cd2b-6147.ngrok.io";

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
