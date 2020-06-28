package com.wooville.genassistant.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.wooville.genassistant.BuildConfig;

public class Talent implements Parcelable {
    public static final Creator<Talent> CREATOR = new Creator<Talent>() {
        public Talent createFromParcel(Parcel parcel) {
            return new Talent(parcel);
        }

        public Talent[] newArray(int i) {
            return new Talent[i];
        }
    };
    private String mDescription;
    private String mTalentName;

    public int describeContents() {
        return 0;
    }

    public Talent() {
        String str = BuildConfig.FLAVOR;
        this.mTalentName = str;
        this.mDescription = str;
    }

    public Talent(String str, String str2) {
        this.mTalentName = str;
        this.mDescription = str2;
    }

    public String getTalentName() {
        return this.mTalentName;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setTalentName(String str) {
        this.mTalentName = str;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    protected Talent(Parcel parcel) {
        this.mTalentName = parcel.readString();
        this.mDescription = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mTalentName);
        parcel.writeString(this.mDescription);
    }
}
