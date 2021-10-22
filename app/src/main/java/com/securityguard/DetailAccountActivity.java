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
    TextView txNik, txnama, txJenisKelamin, txtNonerHp, txTempatLahir, txTanggalLahir, txemail, txtAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_account);

         txNik = findViewById(R.id.txt_Nik);
         txnama = findViewById(R.id.txnama);
         txJenisKelamin = findViewById(R.id.txtJenisKelamin);
         txtNonerHp = findViewById(R.id.noTel);
         txTempatLahir = findViewById(R.id.txt_TempatLahir);
         txTanggalLahir = findViewById(R.id.tx_TanggalLahir);
         txemail = findViewById(R.id.txemail);
         txtAlamat = findViewById(R.id.txAlamat);

        String token = getIntent().getStringExtra("token");
         Gson gson = new Gson();
        try {
            userTemp = gson.fromJson(JWTUtil.getBodyDecode(token), UserEntity.class);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        txNik.setText(Long.toString(userTemp.getNik()));
        txnama.setText(userTemp.getNama());
        txJenisKelamin.setText(userTemp.getJenisKelamin());
        txtNonerHp.setText(userTemp.getNoTelp());
        txTempatLahir.setText(userTemp.getTempatLahir());
        txTanggalLahir.setText(userTemp.getTanggalLahir());
        txemail.setText(userTemp.getEmail());
        txtAlamat.setText(userTemp.getAlamat());


    }
}