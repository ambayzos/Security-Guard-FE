package com.securityguard.service;

import com.securityguard.entity.UserEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserInterface {


    @POST("/user/register")
    Call<String> daftarUser(@Body UserEntity userEntity);

    @POST("/user/login")
    Call<String> loginUser(@Body UserEntity userEntity);


}
