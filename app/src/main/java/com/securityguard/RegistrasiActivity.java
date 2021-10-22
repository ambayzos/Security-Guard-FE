package com.securityguard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
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

    EditText txtNik,txtNama, txtTtl, txtEmail, txtNoTelp, txtAlamat, txtPass, txtRepass, txtTempatLahir;
    Spinner spnGender;
    Button btnDaftar;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        txtNik = findViewById(R.id.txtNik);
        txtNama = findViewById(R.id.txtNama);
        spnGender = findViewById(R.id.spnGender);
        txtTempatLahir = findViewById(R.id.txtTempatlahir);
        txtTtl = findViewById(R.id.txtTtl);
        txtEmail = findViewById(R.id.txtEmailLogin);
        txtNoTelp = findViewById(R.id.txtNotelp);
        txtAlamat = findViewById(R.id.txtAlamat);
        txtPass = findViewById(R.id.txtPassLogin);
        txtRepass = findViewById(R.id.txtRepass);
        btnDaftar = findViewById(R.id.btnDaftar);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.txtPassLogin,".{8,}", R.string.wrongpassword);
        awesomeValidation.addValidation(this, R.id.txtRepass, R.id.txtPassLogin, R.string.passworisnotcorrect);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserEntity user = new UserEntity();
                user.setNik(Long.parseLong(txtNik.getText().toString()));
                user.setNama(txtNama.getText().toString());
                user.setJenisKelamin(spnGender.getSelectedItem().toString());
                user.setTempatLahir(txtTempatLahir.getText().toString());
                user.setTanggalLahir(txtTtl.getText().toString());
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

                        if (awesomeValidation.validate()) {
                            Toast.makeText(com.securityguard.RegistrasiActivity.this, "Berhasil Register", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(com.securityguard.RegistrasiActivity.this, LoginActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(com.securityguard.RegistrasiActivity.this,"Tidak Berhasil Register",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(RegistrasiActivity.this,"Tidak Berhasil",Toast.LENGTH_SHORT).show();
                        System.out.println(t);
                    }
                });


            }
        });


    }

}