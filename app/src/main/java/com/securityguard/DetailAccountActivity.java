package com.securityguard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.securityguard.entity.UserEntity;
import com.securityguard.utility.JWTUtil;

import java.io.UnsupportedEncodingException;

public class DetailAccountActivity extends AppCompatActivity {
    //public static final String SET_OBJ = "set_obj";
    UserEntity userTemp;
    TextView txnama, txttempattgllahir, txnoTel, txemail, txtAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_account);

         txnama = findViewById(R.id.txnama);
         txttempattgllahir = findViewById(R.id.txttempattgl);
         txnoTel = findViewById(R.id.noTel);
         txemail = findViewById(R.id.txemail);
         txtAlamat = findViewById(R.id.txAlamat);

        String token = getIntent().getStringExtra("token");
         Gson gson = new Gson();
        try {
            userTemp = gson.fromJson(JWTUtil.getBodyDecode(token), UserEntity.class);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        txnama.setText(userTemp.getNama());
        txttempattgllahir.setText(userTemp.getTtl());
        txnoTel.setText(userTemp.getNoTelp());
        txemail.setText(userTemp.getEmail());
        txtAlamat.setText(userTemp.getAlamat());


    }
}