package com.wooville.genassistant.adapter;

import com.wooville.genassistant.R;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wooville.genassistant.model.PlayerCharacter;
import com.wooville.genassistant.tab.Tab1Overview;
import com.wooville.genassistant.tab.Tab1OverviewEdit;
import com.wooville.genassistant.tab.Tab2Skills;
import com.wooville.genassistant.tab.Tab2SkillsEdit;
import com.wooville.genassistant.tab.Tab3Talents;
import com.wooville.genassistant.tab.Tab3TalentsEdit;
import com.wooville.genassistant.tab.Tab4Motivations;
import com.wooville.genassistant.tab.Tab4MotivationsEdit;
import com.wooville.genassistant.tab.Tab5Gear;
import com.wooville.genassistant.tab.Tab5GearEdit;

/* renamed from: com.wooville.genassistant.ui.main.SectionsPagerAdapter */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    @StringRes
    private static final int[] TAB_TITLES = {R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4, R.string.tab_text_5};
    private boolean isEdit;
    private PlayerCharacter mCharacter;
    private final Context mContext;

    public int getCount() {
        return 5;
    }

    public SectionsPagerAdapter(Context context, FragmentManager fragmentManager, boolean z, PlayerCharacter playerCharacter) {
        super(fragmentManager);
        this.mContext = context;
        this.isEdit = z;
        this.mCharacter = playerCharacter;
    }

    public Fragment getItem(int i) {
        if (!this.isEdit) {
            switch (i){
                case 0:
                    return Tab1Overview.newInstance(this.mCharacter);
                case 1:
                    return Tab2Skills.newInstance(this.mCharacter);
                case 2:
                    return Tab3Talents.newInstance(this.mCharacter);
                case 3:
                    return Tab4Motivations.newInstance(this.mCharacter);
                case 4:
                    return Tab5Gear.newInstance(this.mCharacter);
                default:
                    return null;
            }
        } else {
            switch (i){
                case 0:
                    return Tab1OverviewEdit.newInstance(this.mCharacter);
                case 1:
                    return Tab2SkillsEdit.newInstance(this.mCharacter);
                case 2:
                    return Tab3TalentsEdit.newInstance(this.mCharacter);
                case 3:
                    return Tab4MotivationsEdit.newInstance(this.mCharacter);
                case 4:
                    return Tab5GearEdit.newInstance(this.mCharacter);
                default:
                    return null;
            }
        }
    }

    @Nullable
    public CharSequence getPageTitle(int i) {
        return this.mContext.getResources().getString(TAB_TITLES[i]);
    }
}
