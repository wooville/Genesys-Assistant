package com.wooville.genassistant.model;

import java.util.ArrayList;

public class Archetype {
    private int[] mCharacteristics;
    private int mExperience;
    private String mName;
    private ArrayList<Skill> mSkills;
    private int mStrain;
    private ArrayList<Talent> mTalents;
    private int mWounds;

    public Archetype() {
    }

    public Archetype(String str) {
        this.mName = str;
    }

    public Archetype(String str, int[] iArr, int i, int i2) {
        this.mName = str;
        this.mCharacteristics = iArr;
        this.mWounds = i;
        this.mStrain = i2;
    }

    public String getName() {
        return this.mName;
    }

    public int[] getCharacteristics() {
        return this.mCharacteristics;
    }

    public int getWounds() {
        return this.mWounds;
    }

    public int getStrain() {
        return this.mStrain;
    }

    public int getExperience() {
        return this.mExperience;
    }
}
