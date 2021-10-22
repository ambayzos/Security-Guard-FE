package com.securityguard.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class UserEntity implements Parcelable {

    @SerializedName("id")
    private long id;
    @SerializedName("nik")
    private long nik;
    @SerializedName("nama")
    private String nama;
    @SerializedName("jenisKelamin")
    private String jenisKelamin;
    @SerializedName("tempatLahir")
    private String tempatLahir;
    @SerializedName("tanggalLahir")
    private String tanggalLahir;
    @SerializedName("email")
    private String email;
    @SerializedName("noTelp")
    private String noTelp;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("kataSandi")
    private String kataSandi;
    @SerializedName("ulangKataSandi")
    private String ulangKataSandi;
    @SerializedName("role")
    private String role;


    public UserEntity() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.nik);
        dest.writeString(this.nama);
        dest.writeString(this.jenisKelamin);
        dest.writeString(this.tempatLahir);
        dest.writeString(this.tanggalLahir);
        dest.writeString(this.email);
        dest.writeString(this.noTelp);
        dest.writeString(this.alamat);
        dest.writeString(this.kataSandi);
        dest.writeString(this.ulangKataSandi);
        dest.writeString(this.role);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readLong();
        this.nik = source.readLong();
        this.nama = source.readString();
        this.jenisKelamin = source.readString();
        this.tempatLahir = source.readString();
        this.tanggalLahir = source.readString();
        this.email = source.readString();
        this.noTelp = source.readString();
        this.alamat = source.readString();
        this.kataSandi = source.readString();
        this.ulangKataSandi = source.readString();
        this.role = source.readString();
    }

    protected UserEntity(Parcel in) {
        this.id = in.readLong();
        this.nik = in.readLong();
        this.nama = in.readString();
        this.jenisKelamin = in.readString();
        this.tempatLahir = in.readString();
        this.tanggalLahir = in.readString();
        this.email = in.readString();
        this.noTelp = in.readString();
        this.alamat = in.readString();
        this.kataSandi = in.readString();
        this.ulangKataSandi = in.readString();
        this.role = in.readString();
    }

    public static final Creator<UserEntity> CREATOR = new Creator<UserEntity>() {
        @Override
        public UserEntity createFromParcel(Parcel source) {
            return new UserEntity(source);
        }

        @Override
        public UserEntity[] newArray(int size) {
            return new UserEntity[size];
        }
    };
}
