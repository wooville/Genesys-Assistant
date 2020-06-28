package com.wooville.genassistant.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.wooville.genassistant.BuildConfig;

public class Skill implements Parcelable, Cloneable {
    public static final Creator<Skill> CREATOR = new Creator<Skill>() {
        public Skill createFromParcel(Parcel parcel) {
            return new Skill(parcel);
        }

        public Skill[] newArray(int i) {
            return new Skill[i];
        }
    };
    private boolean mIsCareer;
    private String mSkillName;
    private int mSkillRank;
    private String mTiedAttribute;

    public int describeContents() {
        return 0;
    }

    public Skill() {
        String str = BuildConfig.FLAVOR;
        this.mSkillName = str;
        this.mTiedAttribute = str;
        this.mSkillRank = 0;
        this.mIsCareer = false;
    }

    public Skill(String str) {
        this.mSkillName = str;
    }

    public Skill(String str, String str2, int i, boolean z) {
        this.mSkillName = str;
        this.mTiedAttribute = str2;
        this.mSkillRank = i;
        this.mIsCareer = z;
    }

    public String getSkillName() {
        return this.mSkillName;
    }

    public String getTiedAttribute() {
        return this.mTiedAttribute;
    }

    public int getSkillRank() {
        return this.mSkillRank;
    }

    public Boolean getIsCareer() {
        return Boolean.valueOf(this.mIsCareer);
    }

    public void setSkillName(String str) {
        this.mSkillName = str;
    }

    public void setTiedAttribute(String str) {
        this.mTiedAttribute = str;
    }

    public void setSkillRank(int i) {
        this.mSkillRank = i;
    }

    public void setIsCareer(boolean z) {
        this.mIsCareer = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Skill)) {
            return false;
        }
        return ((Skill) obj).getSkillName().equals(getSkillName());
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.mSkillName.length(); i2++) {
            i += Character.getNumericValue(this.mSkillName.charAt(i2));
        }
        return i;
    }

    protected Skill(Parcel parcel) {
        this.mSkillName = parcel.readString();
        this.mTiedAttribute = parcel.readString();
        this.mSkillRank = parcel.readInt();
        this.mIsCareer = parcel.readByte() != 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mSkillName);
        parcel.writeString(this.mTiedAttribute);
        parcel.writeInt(this.mSkillRank);
        parcel.writeByte(this.mIsCareer ? (byte) 1 : 0);
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        try {
            return (Skill) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
