package com.securityguard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCallPolice = findViewById(R.id.btnCall);
        btnCallPolice.setOnClickListener(this);
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
           Intent inten = new Intent(this, DetailAccountActivity.class);
           startActivity(inten);
            return true;
        }else if(item.getItemId() == R.id.menu_logout){
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            return true;
        }else {
            return true;
        }
    }


}