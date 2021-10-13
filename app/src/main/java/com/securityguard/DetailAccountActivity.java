package com.securityguard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.securityguard.entity.UserEntity;
import com.securityguard.utility.JWTUtil;

import java.io.UnsupportedEncodingException;

public class DetailAccountActivity extends AppCompatActivity {

    UserEntity userTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_account);

        TextView txtHello = findViewById(R.id.txtHello);

        String token ="Bearer "+getIntent().getStringExtra("token");
         Gson gson = new Gson();
        try {
            userTemp = gson.fromJson(JWTUtil.getBodyDecode(token), UserEntity.class);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        txtHello.setText("hello"+userTemp.getNama());

    }
}