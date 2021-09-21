package com.securityguard.entity;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Parcelable {

    private long id;
    private long nik;
    private String nama;
    private String ttl;
    private String email;
    private String noTelp;
    private String alamat;
    private String kataSandi;
    private String ulangKataSandi;
    private String role;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.nik);
        dest.writeString(this.nama);
        dest.writeString(this.ttl);
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
        this.ttl = source.readString();
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
        this.ttl = in.readString();
        this.email = in.readString();
        this.noTelp = in.readString();
        this.alamat = in.readString();
        this.kataSandi = in.readString();
        this.ulangKataSandi = in.readString();
        this.role = in.readString();
    }

    public static final Parcelable.Creator<UserEntity> CREATOR = new Parcelable.Creator<UserEntity>() {
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
