package com.securityguard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.securityguard.entity.UserEntity;
import com.securityguard.service.ApiClient;
import com.securityguard.service.UserInterface;

import org.json.JSONObject;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrasiActivity extends AppCompatActivity {

    EditText txtNik,txtNama, txtTtl, txtEmail, txtNoTelp, txtAlamat, txtPass, txtRepass;
    Button btnDaftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        //txtNik = findViewById(R.id.txtNik);
        txtNama = findViewById(R.id.txtNama);
        txtTtl = findViewById(R.id.txtTtl);
        txtEmail = findViewById(R.id.txtEmailLogin);
        txtNoTelp = findViewById(R.id.txtNotelp);
        txtAlamat = findViewById(R.id.txtAlamat);
        txtPass = findViewById(R.id.txtPassLogin);
        txtRepass = findViewById(R.id.txtRepass);
        btnDaftar = findViewById(R.id.btnDaftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserEntity user = new UserEntity();
                //user.setNik(Long.parseLong(txtNik.getText().toString()));
                //user.setNik(txtNik.getText().toString());

                user.setNama(txtNama.getText().toString());
                user.setTtl(txtTtl.getText().toString());
                user.setEmail(txtEmail.getText().toString());
                user.setNoTelp(txtNoTelp.getText().toString());
                user.setAlamat(txtAlamat.getText().toString());
                user.setKataSandi(txtPass.getText().toString());
                user.setUlangKataSandi(txtRepass.getText().toString());

                UserInterface userInterface = ApiClient.getRetrofit().create(UserInterface.class);
                Call<String> call= userInterface.daftarUser(user);

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                       // if (validate());
                        Toast.makeText(RegistrasiActivity.this, "berhasil Register", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(RegistrasiActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(RegistrasiActivity.this,"Tidak Berhasil Register",Toast.LENGTH_SHORT).show();
                        System.out.println(t);
                    }
                });


            }
        });


    }

    private  boolean validate(){
        if (!txtPass.equals(txtRepass)){
             Toast.makeText(RegistrasiActivity.this,"Password Not matching",Toast.LENGTH_SHORT).show();
              return false;
        }else {
            Toast.makeText(RegistrasiActivity.this,"Password matching",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

//    private boolean validate() {
//
//        if(!txtPass.equals(txtRepass)){
//            Toast.makeText(RegistrasiActivity.this,"Password Not matching",Toast.LENGTH_SHORT).show();
//            return false;
//        else
//            Toast.makeText(RegistrasiActivity.this,"Password matching",Toast.LENGTH_SHORT).show();
//            return true;
//        }
//});
//
//        }
}