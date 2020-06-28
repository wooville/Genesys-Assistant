package com.wooville.genassistant.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.wooville.genassistant.BuildConfig;

/* renamed from: com.wooville.genassistant.ui.main.Gear */
public class Gear implements Parcelable {
    public static final Creator<Gear> CREATOR = new Creator<Gear>() {
        public Gear createFromParcel(Parcel parcel) {
            return new Gear(parcel);
        }

        public Gear[] newArray(int i) {
            return new Gear[i];
        }
    };
    private String mClassification;
    private String mDescription;
    private String mName;

    public int describeContents() {
        return 0;
    }

    public Gear() {
        String str = BuildConfig.FLAVOR;
        this.mName = str;
        this.mClassification = str;
        this.mDescription = str;
    }

    public Gear(String str, String str2, String str3) {
        this.mName = str;
        this.mClassification = str2;
        this.mDescription = str3;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getClassification() {
        return this.mClassification;
    }

    public void setClassification(String str) {
        this.mClassification = str;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    protected Gear(Parcel parcel) {
        this.mName = parcel.readString();
        this.mClassification = parcel.readString();
        this.mDescription = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mClassification);
        parcel.writeString(this.mDescription);
    }
}
