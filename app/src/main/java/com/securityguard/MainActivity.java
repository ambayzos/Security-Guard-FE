package com.securityguard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.securityguard.entity.UserEntity;
import com.securityguard.utility.JWTUtil;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    UserEntity userTemp;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCallPolice = findViewById(R.id.btnCall);
        btnCallPolice.setOnClickListener(this);

       // tokenJwt = "Bearer "+getIntent().getStringExtra("token");
        token = getIntent().getStringExtra("token");
        Gson gson = new Gson();
        try {
            userTemp = gson.fromJson(JWTUtil.getBodyDecode(token), UserEntity.class);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        //txtHello.setText("Hello "+userTemp.getNama());

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCall){
            String phoneNumber = "110";
            Intent intenDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
            startActivity(intenDial);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menu_account){
           Intent inten = new Intent(MainActivity.this, DetailAccountActivity.class);
            inten.putExtra("token", token);
           startActivity(inten);
            return true;
        }else if(item.getItemId() == R.id.menu_logout){
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
            return true;
        }else {
            return true;
        }
    }


}