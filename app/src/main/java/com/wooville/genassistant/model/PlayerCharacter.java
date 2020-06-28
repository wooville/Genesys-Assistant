package com.wooville.genassistant.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.wooville.genassistant.BuildConfig;
import java.util.ArrayList;

public class PlayerCharacter implements Parcelable {
    public static final Creator<PlayerCharacter> CREATOR = new Creator<PlayerCharacter>() {
        public PlayerCharacter createFromParcel(Parcel parcel) {
            return new PlayerCharacter(parcel);
        }

        public PlayerCharacter[] newArray(int i) {
            return new PlayerCharacter[i];
        }
    };
    private String mArchetype;
    private String mCareer;
    private String mCharacterName;
    private int[] mCharacteristics;
    private String mDes;
    private String mDesBody;
    private int mEncumbrance;
    private int mExperience;
    private String mFear;
    private String mFearBody;
    private String mFileName;
    private String mFlaw;
    private String mFlawBody;
    private ArrayList<Gear> mGear;
    private String mNotesText;
    private ArrayList<Skill> mSkillset;
    private int mStrainCurrent;
    private int mStrainThreshold;
    private String mStrength;
    private String mStrengthBody;
    private ArrayList<Talent> mTalents;
    private String mUriString;
    private int mWoundCurrent;
    private int mWoundThreshold;

    public int describeContents() {
        return 0;
    }

    public PlayerCharacter() {
        String str = BuildConfig.FLAVOR;
        this.mCharacterName = str;
        this.mArchetype = str;
        this.mCareer = str;
        this.mUriString = str;
        this.mNotesText = str;
        this.mFileName = str;
        this.mStrength = str;
        this.mStrengthBody = str;
        this.mFlaw = str;
        this.mFlawBody = str;
        this.mDes = str;
        this.mDesBody = str;
        this.mFear = str;
        this.mFearBody = str;
        this.mCharacteristics = new int[]{0, 0, 0, 0, 0, 0};
        this.mExperience = 0;
        this.mWoundThreshold = 0;
        this.mWoundCurrent = 0;
        this.mStrainThreshold = 0;
        this.mStrainCurrent = 0;
        this.mSkillset = new ArrayList<>();
        this.mTalents = new ArrayList<>();
        this.mGear = new ArrayList<>();
    }

    public PlayerCharacter(String str, int[] iArr) {
        this.mCharacterName = str;
        this.mCharacteristics = iArr;
        this.mExperience = 0;
        this.mSkillset = new ArrayList<>();
        this.mTalents = new ArrayList<>();
        this.mGear = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        this.mEncumbrance = getBrawn() + 5;
    }

    public String getCharacterName() {
        return this.mCharacterName;
    }

    public String getArchetype() {
        return this.mArchetype;
    }

    public String getCareer() {
        return this.mCareer;
    }

    public String getUriString() {
        return this.mUriString;
    }

    public String getNotesText() {
        return this.mNotesText;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public int[] getCharacteristics() {
        return this.mCharacteristics;
    }

    public int getBrawn() {
        return this.mCharacteristics[0];
    }

    public int getAgility() {
        return this.mCharacteristics[1];
    }

    public int getIntellect() {
        return this.mCharacteristics[2];
    }

    public int getCunning() {
        return this.mCharacteristics[3];
    }

    public int getWillpower() {
        return this.mCharacteristics[4];
    }

    public int getPresence() {
        return this.mCharacteristics[5];
    }

    public int getExperience() {
        return this.mExperience;
    }

    public int getWoundThreshold() {
        return this.mWoundThreshold;
    }

    public int getWoundCurrent() {
        return this.mWoundCurrent;
    }

    public int getStrainThreshold() {
        return this.mStrainThreshold;
    }

    public int getStrainCurrent() {
        return this.mStrainCurrent;
    }

    public ArrayList<Skill> getSkillset() {
        return this.mSkillset;
    }

    public ArrayList<Talent> getTalents() {
        return this.mTalents;
    }

    public ArrayList<Gear> getGear() {
        return this.mGear;
    }

    public void setCharacterName(String str) {
        this.mCharacterName = str;
    }

    public void setArchetype(String str) {
        this.mArchetype = str;
    }

    public void setCareer(String str) {
        this.mCareer = str;
    }

    public void setUriString(String str) {
        this.mUriString = str;
    }

    public void setNotesText(String str) {
        this.mNotesText = str;
    }

    public void setCharacteristics(int[] iArr) {
        this.mCharacteristics = iArr;
    }

    public void setBrawn(int i) {
        this.mCharacteristics[0] = i;
        this.mEncumbrance = getBrawn() + 5;
    }

    public void setAgility(int i) {
        this.mCharacteristics[1] = i;
    }

    public void setIntellect(int i) {
        this.mCharacteristics[2] = i;
    }

    public void setCunning(int i) {
        this.mCharacteristics[3] = i;
    }

    public void setWillpower(int i) {
        this.mCharacteristics[4] = i;
    }

    public void setPresence(int i) {
        this.mCharacteristics[5] = i;
    }

    public void setWoundThreshold(int i) {
        this.mWoundThreshold = i;
    }

    public void setWoundCurrent(int i) {
        this.mWoundCurrent = i;
    }

    public void setStrainThreshold(int i) {
        this.mStrainThreshold = i;
    }

    public void setStrainCurrent(int i) {
        this.mStrainCurrent = i;
    }

    public void setExperience(int i) {
        this.mExperience = i;
    }

    public void setSkillset(ArrayList<Skill> arrayList) {
        this.mSkillset = arrayList;
    }

    public void setTalents(ArrayList<Talent> arrayList) {
        this.mTalents = arrayList;
    }

    public void setGear(ArrayList<Gear> arrayList) {
        this.mGear = arrayList;
    }

    public String getStrength() {
        return this.mStrength;
    }

    public void setStrength(String str) {
        this.mStrength = str;
    }

    public String getStrengthBody() {
        return this.mStrengthBody;
    }

    public void setStrengthBody(String str) {
        this.mStrengthBody = str;
    }

    public String getFlaw() {
        return this.mFlaw;
    }

    public void setFlaw(String str) {
        this.mFlaw = str;
    }

    public String getFlawBody() {
        return this.mFlawBody;
    }

    public void setFlawBody(String str) {
        this.mFlawBody = str;
    }

    public String getDes() {
        return this.mDes;
    }

    public void setDes(String str) {
        this.mDes = str;
    }

    public String getDesBody() {
        return this.mDesBody;
    }

    public void setDesBody(String str) {
        this.mDesBody = str;
    }

    public String getFear() {
        return this.mFear;
    }

    public void setFear(String str) {
        this.mFear = str;
    }

    public String getFearBody() {
        return this.mFearBody;
    }

    public void setFearBody(String str) {
        this.mFearBody = str;
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public void addSkill(Skill skill) {
        this.mSkillset.add(skill);
    }

    public void addTalent(Talent talent) {
        this.mTalents.add(talent);
    }

    public void addGear(Gear gear) {
        this.mGear.add(gear);
    }

    public void setCareerSkills(ArrayList<Skill> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (this.mSkillset.indexOf(arrayList.get(i)) != -1) {
                ArrayList<Skill> arrayList2 = this.mSkillset;
                ((Skill) arrayList2.get(arrayList2.indexOf(arrayList.get(i)))).setIsCareer(true);
            } else {
                this.mSkillset.add(arrayList.get(i));
            }
        }
    }

    protected PlayerCharacter(Parcel parcel) {
        this.mCharacterName = parcel.readString();
        this.mArchetype = parcel.readString();
        this.mCareer = parcel.readString();
        this.mUriString = parcel.readString();
        this.mNotesText = parcel.readString();
        this.mStrength = parcel.readString();
        this.mStrengthBody = parcel.readString();
        this.mFlaw = parcel.readString();
        this.mFlawBody = parcel.readString();
        this.mDes = parcel.readString();
        this.mDesBody = parcel.readString();
        this.mFear = parcel.readString();
        this.mFearBody = parcel.readString();
        this.mFileName = parcel.readString();
        this.mCharacteristics = parcel.createIntArray();
        this.mExperience = parcel.readInt();
        this.mWoundThreshold = parcel.readInt();
        this.mWoundCurrent = parcel.readInt();
        this.mStrainThreshold = parcel.readInt();
        this.mStrainCurrent = parcel.readInt();
        this.mEncumbrance = parcel.readInt();
        if (parcel.readByte() == 1) {
            this.mSkillset = new ArrayList<>();
            parcel.readList(this.mSkillset, Skill.class.getClassLoader());
        } else {
            this.mSkillset = null;
        }
        if (parcel.readByte() == 1) {
            this.mTalents = new ArrayList<>();
            parcel.readList(this.mTalents, Talent.class.getClassLoader());
        } else {
            this.mTalents = null;
        }
        if (parcel.readByte() == 1) {
            this.mGear = new ArrayList<>();
            parcel.readList(this.mGear, Gear.class.getClassLoader());
            return;
        }
        this.mGear = null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCharacterName);
        parcel.writeString(this.mArchetype);
        parcel.writeString(this.mCareer);
        parcel.writeString(this.mUriString);
        parcel.writeString(this.mNotesText);
        parcel.writeString(this.mStrength);
        parcel.writeString(this.mStrengthBody);
        parcel.writeString(this.mFlaw);
        parcel.writeString(this.mFlawBody);
        parcel.writeString(this.mDes);
        parcel.writeString(this.mDesBody);
        parcel.writeString(this.mFear);
        parcel.writeString(this.mFearBody);
        parcel.writeString(this.mFileName);
        parcel.writeIntArray(this.mCharacteristics);
        parcel.writeInt(this.mExperience);
        parcel.writeInt(this.mWoundThreshold);
        parcel.writeInt(this.mWoundCurrent);
        parcel.writeInt(this.mStrainThreshold);
        parcel.writeInt(this.mStrainCurrent);
        parcel.writeInt(this.mEncumbrance);
        if (this.mSkillset == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this.mSkillset);
        }
        if (this.mTalents == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this.mTalents);
        }
        if (this.mGear == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeList(this.mGear);
    }
}
