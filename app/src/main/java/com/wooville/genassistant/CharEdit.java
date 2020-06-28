package com.wooville.genassistant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.wooville.genassistant.adapter.SectionsPagerAdapter;
import com.wooville.genassistant.model.Gear;
import com.wooville.genassistant.model.PCCollect;
import com.wooville.genassistant.model.PlayerCharacter;
import com.wooville.genassistant.model.Skill;
import com.wooville.genassistant.model.Talent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

public class CharEdit extends AppCompatActivity implements PCCollect {
    /* access modifiers changed from: private */
    public PlayerCharacter mCharacter;
    private Button save_edit_btn;

    public void collectPC(PlayerCharacter playerCharacter) {
        this.mCharacter = playerCharacter;
        saveEditButton();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.mCharacter = (PlayerCharacter) getIntent().getExtras().getParcelable("character");
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_char_edit);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new SectionsPagerAdapter(this, getSupportFragmentManager(), true, this.mCharacter));
        ((TabLayout) findViewById(R.id.tabs)).setupWithViewPager(viewPager);
        saveEditButton();
    }

    public void saveEditButton() {
        this.save_edit_btn = (Button) findViewById(R.id.save_edit_button);
        this.save_edit_btn.setOnClickListener(null);
        this.save_edit_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "xp";
                String str2 = "presence";
                String str3 = "willpower";
                String str4 = "cunning";
                String str5 = "intellect";
                String str6 = "agility";
                String str7 = "brawn";
                String str8 = "career";
                String str9 = "archetype";
                String str10 = "name";
                String characterName = CharEdit.this.mCharacter.getCharacterName();
                String str11 = BuildConfig.FLAVOR;
                boolean equals = characterName.replaceAll("[^a-zA-Z0-9]", str11).equals(str11);
                String str12 = "character";
                if (!equals) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CharEdit.this.mCharacter.getCharacterName());
                    sb.append(".xml");
                    String sb2 = sb.toString();
                    try {
                        Context applicationContext = CharEdit.this.getApplicationContext();
                        String str13 = str;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(applicationContext.getFilesDir().getAbsolutePath());
                        sb3.append(File.separator);
                        sb3.append("characters");
                        File file = new File(sb3.toString());
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(file, sb2);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        String str14 = str2;
                        if (new File(file, CharEdit.this.mCharacter.getFileName()).exists() && !CharEdit.this.mCharacter.getFileName().equals(CharEdit.this.mCharacter.getCharacterName())) {
                            new File(file, CharEdit.this.mCharacter.getFileName()).delete();
                        }
                        CharEdit.this.mCharacter.setFileName(sb2);
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        XmlSerializer newSerializer = Xml.newSerializer();
                        StringWriter stringWriter = new StringWriter();
                        newSerializer.setOutput(stringWriter);
                        newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                        newSerializer.startTag(null, str12);
                        newSerializer.startTag(null, str10);
                        newSerializer.text(CharEdit.this.mCharacter.getCharacterName());
                        newSerializer.endTag(null, str10);
                        newSerializer.startTag(null, str9);
                        newSerializer.text(CharEdit.this.mCharacter.getArchetype());
                        newSerializer.endTag(null, str9);
                        newSerializer.startTag(null, str8);
                        newSerializer.text(CharEdit.this.mCharacter.getCareer());
                        newSerializer.endTag(null, str8);
                        newSerializer.startTag(null, str7);
                        newSerializer.text(String.valueOf(CharEdit.this.mCharacter.getBrawn()));
                        newSerializer.endTag(null, str7);
                        newSerializer.startTag(null, str6);
                        newSerializer.text(String.valueOf(CharEdit.this.mCharacter.getAgility()));
                        newSerializer.endTag(null, str6);
                        newSerializer.startTag(null, str5);
                        newSerializer.text(String.valueOf(CharEdit.this.mCharacter.getIntellect()));
                        newSerializer.endTag(null, str5);
                        newSerializer.startTag(null, str4);
                        newSerializer.text(String.valueOf(CharEdit.this.mCharacter.getCunning()));
                        newSerializer.endTag(null, str4);
                        newSerializer.startTag(null, str3);
                        newSerializer.text(String.valueOf(CharEdit.this.mCharacter.getWillpower()));
                        newSerializer.endTag(null, str3);
                        String str15 = str14;
                        newSerializer.startTag(null, str15);
                        newSerializer.text(String.valueOf(CharEdit.this.mCharacter.getPresence()));
                        newSerializer.endTag(null, str15);
                        String str16 = str13;
                        newSerializer.startTag(null, str16);
                        newSerializer.text(String.valueOf(CharEdit.this.mCharacter.getExperience()));
                        newSerializer.endTag(null, str16);
                        for (int i = 0; i < CharEdit.this.mCharacter.getSkillset().size(); i++) {
                            newSerializer.startTag(null, "skill");
                            newSerializer.startTag(null, "skillName");
                            newSerializer.text(((Skill) CharEdit.this.mCharacter.getSkillset().get(i)).getSkillName());
                            newSerializer.endTag(null, "skillName");
                            newSerializer.startTag(null, "isCareer");
                            if (((Skill) CharEdit.this.mCharacter.getSkillset().get(i)).getIsCareer().booleanValue()) {
                                newSerializer.text("y");
                            } else {
                                newSerializer.text("n");
                            }
                            newSerializer.endTag(null, "isCareer");
                            newSerializer.startTag(null, "rank");
                            newSerializer.text(String.valueOf(((Skill) CharEdit.this.mCharacter.getSkillset().get(i)).getSkillRank()));
                            newSerializer.endTag(null, "rank");
                            newSerializer.startTag(null, "attribute");
                            newSerializer.text(((Skill) CharEdit.this.mCharacter.getSkillset().get(i)).getTiedAttribute());
                            newSerializer.endTag(null, "attribute");
                            newSerializer.endTag(null, "skill");
                        }
                        for (int i2 = 0; i2 < CharEdit.this.mCharacter.getTalents().size(); i2++) {
                            newSerializer.startTag(null, "talent");
                            newSerializer.startTag(null, "talentName");
                            newSerializer.text(((Talent) CharEdit.this.mCharacter.getTalents().get(i2)).getTalentName());
                            newSerializer.endTag(null, "talentName");
                            newSerializer.startTag(null, "talentDescription");
                            newSerializer.text(((Talent) CharEdit.this.mCharacter.getTalents().get(i2)).getDescription());
                            newSerializer.endTag(null, "talentDescription");
                            newSerializer.endTag(null, "talent");
                        }
                        for (int i3 = 0; i3 < CharEdit.this.mCharacter.getGear().size(); i3++) {
                            newSerializer.startTag(null, "gear");
                            newSerializer.startTag(null, "gearName");
                            newSerializer.text(((Gear) CharEdit.this.mCharacter.getGear().get(i3)).getName());
                            newSerializer.endTag(null, "gearName");
                            newSerializer.startTag(null, "classification");
                            newSerializer.text(((Gear) CharEdit.this.mCharacter.getGear().get(i3)).getClassification());
                            newSerializer.endTag(null, "classification");
                            newSerializer.startTag(null, "gearDescription");
                            newSerializer.text(((Gear) CharEdit.this.mCharacter.getGear().get(i3)).getDescription());
                            newSerializer.endTag(null, "gearDescription");
                            newSerializer.endTag(null, "gear");
                        }
                        newSerializer.startTag(null, "strength");
                        newSerializer.text(CharEdit.this.mCharacter.getStrength());
                        newSerializer.endTag(null, "strength");
                        newSerializer.startTag(null, "strengthBody");
                        newSerializer.text(CharEdit.this.mCharacter.getStrengthBody());
                        newSerializer.endTag(null, "strengthBody");
                        newSerializer.startTag(null, "flaw");
                        newSerializer.text(CharEdit.this.mCharacter.getFlaw());
                        newSerializer.endTag(null, "flaw");
                        newSerializer.startTag(null, "flawBody");
                        newSerializer.text(CharEdit.this.mCharacter.getFlawBody());
                        newSerializer.endTag(null, "flawBody");
                        newSerializer.startTag(null, "desire");
                        newSerializer.text(CharEdit.this.mCharacter.getDes());
                        newSerializer.endTag(null, "desire");
                        newSerializer.startTag(null, "desireBody");
                        newSerializer.text(CharEdit.this.mCharacter.getDesBody());
                        newSerializer.endTag(null, "desireBody");
                        newSerializer.startTag(null, "fear");
                        newSerializer.text(CharEdit.this.mCharacter.getFear());
                        newSerializer.endTag(null, "fear");
                        newSerializer.startTag(null, "fearBody");
                        newSerializer.text(CharEdit.this.mCharacter.getFearBody());
                        newSerializer.endTag(null, "fearBody");
                        newSerializer.startTag(null, "wound");
                        newSerializer.text(String.valueOf(CharEdit.this.mCharacter.getWoundThreshold()));
                        newSerializer.endTag(null, "wound");
                        newSerializer.startTag(null, "curWound");
                        newSerializer.text(String.valueOf(CharEdit.this.mCharacter.getWoundCurrent()));
                        newSerializer.endTag(null, "curWound");
                        newSerializer.startTag(null, "strain");
                        newSerializer.text(String.valueOf(CharEdit.this.mCharacter.getStrainThreshold()));
                        newSerializer.endTag(null, "strain");
                        newSerializer.startTag(null, "curStrain");
                        newSerializer.text(String.valueOf(CharEdit.this.mCharacter.getStrainCurrent()));
                        newSerializer.endTag(null, "curStrain");
                        newSerializer.startTag(null, "uri");
                        newSerializer.text(String.valueOf(CharEdit.this.mCharacter.getUriString()));
                        newSerializer.endTag(null, "uri");
                        newSerializer.startTag(null, "notes");
                        newSerializer.text(CharEdit.this.mCharacter.getNotesText());
                        newSerializer.endTag(null, "notes");
                        newSerializer.endTag(null, str12);
                        newSerializer.endDocument();
                        newSerializer.flush();
                        fileOutputStream.write(stringWriter.toString().getBytes());
                        fileOutputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                    } catch (IllegalStateException e3) {
                        e3.printStackTrace();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                Intent intent = new Intent(".CharInfo");
                intent.putExtra(str12, CharEdit.this.mCharacter);
                CharEdit.this.startActivity(intent);
            }
        });
    }
}
