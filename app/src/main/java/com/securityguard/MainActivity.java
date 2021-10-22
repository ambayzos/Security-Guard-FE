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
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.securityguard.entity.UserEntity;
import com.securityguard.utility.JWTUtil;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    UserEntity userTemp;
    String token;
    Button btnMenu,btnCallPolice, btnFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMenu = findViewById(R.id.btnMenu);
        btnCallPolice = findViewById(R.id.btnCall);
        btnFriends = findViewById(R.id.btnTeman);

        // tokenJwt = "Bearer "+getIntent().getStringExtra("token");
        token = getIntent().getStringExtra("token");
        Gson gson = new Gson();
        try {
            userTemp = gson.fromJson(JWTUtil.getBodyDecode(token), UserEntity.class);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        //txtHello.setText("Hello "+userTemp.getNama());


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(MainActivity.this, view);
                popup.setOnMenuItemClickListener(MainActivity.this);
                popup.inflate(R.menu.menu_options);
                popup.show();
            }
        });

        btnCallPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnCall){
                    String phoneNumber = "110";
                    Intent intenDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                    startActivity(intenDial);
                }
            }
        });

        btnFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenFriend = new Intent(MainActivity.this, FriendActivity.class);
                startActivity(intenFriend);
            }
        });

    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(this, "Selected Item: " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
        switch (menuItem.getItemId()) {
            case R.id.menu_account:
                Intent inten = new Intent(this, DetailAccountActivity.class);
                inten.putExtra("token", token);
                startActivity(inten);
                return true;
            case R.id.menu_logout:
                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
                finish();
                return true;
            default:
                return false;
        }
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_options, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if (item.getItemId() == R.id.menu_account){
//           Intent inten = new Intent(MainActivity.this, DetailAccountActivity.class);
//            inten.putExtra("token", token);
//           startActivity(inten);
//            return true;
//        }else if(item.getItemId() == R.id.menu_logout){
//            Intent i = new Intent(this, LoginActivity.class);
//            startActivity(i);
//            finish();
//            return true;
//        }else {
//            return true;
//        }
//    }
}