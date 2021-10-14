package com.securityguard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.securityguard.entity.UserEntity;
import com.securityguard.service.ApiClient;
import com.securityguard.service.UserInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText txtEmailLogin, txtPassLogin;
    Button btnLogin;
    TextView txtDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtEmailLogin = findViewById(R.id.edtEmailLogin);
        txtPassLogin = findViewById(R.id.edtPassLogin);
        btnLogin = findViewById(R.id.btnLogin);
        txtDaftar = findViewById(R.id.txtDaftar);

        UserInterface userInterface = ApiClient.getRetrofit().create(UserInterface.class);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserEntity user = new UserEntity();
                user.setEmail(txtEmailLogin.getText().toString());
                user.setKataSandi(txtPassLogin.getText().toString());

                Call<String> call = userInterface.loginUser(user);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()){
                            Intent iMainIntent = new Intent(LoginActivity.this, MainActivity.class);
                            iMainIntent.putExtra("token", response.body());
                            Toast.makeText(LoginActivity.this, response.body(), Toast.LENGTH_LONG).show();
                            System.out.println(response.body());
                            startActivity(iMainIntent);
                        }else{
                            Toast.makeText(LoginActivity.this, "Tidak berhasil Login", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Tidak Berhasil", Toast.LENGTH_SHORT).show();
                        System.out.println(t);
                    }
                });
            }
        });

        txtDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegistrasiActivity.class);
                startActivity(i);
            }
        });
    }
}