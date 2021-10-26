package com.securityguard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.securityguard.Adapter.AdapterFriend;
import com.securityguard.entity.UserEntity;
import com.securityguard.service.ApiClient;
import com.securityguard.service.UserInterface;
import com.securityguard.utility.JWTUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendActivity extends AppCompatActivity {
    RecyclerView tvList;
    UserEntity userEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        tvList = findViewById(R.id.rvList);
        String token = "Bearer "+getIntent().getStringExtra("token");
        try {
            Gson gson = new Gson();
            userEntity = gson.fromJson(JWTUtil.getBodyDecode(token), UserEntity.class);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        UserInterface userInterface = ApiClient.getRetrofit().create(UserInterface.class);
        Call<List<UserEntity>> call = userInterface.getUserFriendsList(userEntity, token);
        call.enqueue(new Callback<List<UserEntity>>() {
            @Override
            public void onResponse(Call<List<UserEntity>> call, Response<List<UserEntity>> response) {
                AdapterFriend adapterFriend = new AdapterFriend((ArrayList<UserEntity>) response.body(), FriendActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FriendActivity.this, LinearLayoutManager.VERTICAL, false);
                tvList.setLayoutManager(layoutManager);
                tvList.setAdapter(adapterFriend);
            }

            @Override
            public void onFailure(Call<List<UserEntity>> call, Throwable t) {
                System.out.println(t);
            }
        });
    }
}