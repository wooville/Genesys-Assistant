package com.wooville.genassistant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.OnMenuItemClickListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import com.wooville.genassistant.adapter.CharacterSelectAdapter;
import com.wooville.genassistant.adapter.CharacterSelectAdapter.OnItemClickListener;
import com.wooville.genassistant.model.Gear;
import com.wooville.genassistant.model.PlayerCharacter;
import com.wooville.genassistant.model.Skill;
import com.wooville.genassistant.model.Talent;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public CharacterSelectAdapter mAdapter;
    private LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                MainActivity.this.startActivity(new Intent(".About"));
                return true;
            }
        });
        ArrayList parsePCXML = parsePCXML();
        this.mLayoutManager = new LinearLayoutManager(this);
        this.mAdapter = new CharacterSelectAdapter(parsePCXML);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.char_select_view);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(int i) {
                Intent intent = new Intent(".CharInfo");
                intent.putExtra("character", (Parcelable) MainActivity.this.mAdapter.getCharacterList().get(i));
                MainActivity.this.startActivity(intent);
            }
        });
        createCharacterButton();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mAdapter.getCharacterList();
        this.mAdapter.setCharacterList(parsePCXML());
        this.mAdapter.notifyDataSetChanged();
    }

    private ArrayList<PlayerCharacter> parsePCXML() {
        ArrayList<PlayerCharacter> arrayList = new ArrayList<>();
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            Context applicationContext = getApplicationContext();
            StringBuilder sb = new StringBuilder();
            sb.append(applicationContext.getFilesDir().getAbsolutePath());
            sb.append(File.separator);
            sb.append("characters");
            File file = new File(sb.toString());
            String[] list = file.list();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            FileInputStream fileInputStream = null;
            if (list != null) {
                FileInputStream fileInputStream2 = null;
                for (int i = 0; i < list.length; i++) {
                    fileInputStream2 = new FileInputStream(new File(file, list[i]));
                    newPullParser.setInput(fileInputStream2, null);
                    arrayList.add(processPCParsing(newPullParser, list[i]));
                }
                fileInputStream = fileInputStream2;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (IOException | XmlPullParserException unused) {
        }
        return arrayList;
    }

    private PlayerCharacter processPCParsing(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        int eventType = xmlPullParser.getEventType();
        Skill skill = new Skill();
        Talent talent = new Talent();
        Gear gear = new Gear();
        PlayerCharacter playerCharacter = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("character")) {
                    PlayerCharacter playerCharacter2 = new PlayerCharacter();
                    playerCharacter2.setFileName(str);
                    playerCharacter = playerCharacter2;
                } else if (playerCharacter != null) {
                    if (name.equals("name")) {
                        playerCharacter.setCharacterName(xmlPullParser.nextText());
                    } else if (name.equals("archetype")) {
                        playerCharacter.setArchetype(xmlPullParser.nextText());
                    } else if (name.equals("career")) {
                        playerCharacter.setCareer(xmlPullParser.nextText());
                    } else if (name.equals("brawn")) {
                        playerCharacter.setBrawn(Integer.parseInt(xmlPullParser.nextText()));
                    } else if (name.equals("agility")) {
                        playerCharacter.setAgility(Integer.parseInt(xmlPullParser.nextText()));
                    } else if (name.equals("intellect")) {
                        playerCharacter.setIntellect(Integer.parseInt(xmlPullParser.nextText()));
                    } else if (name.equals("cunning")) {
                        playerCharacter.setCunning(Integer.parseInt(xmlPullParser.nextText()));
                    } else if (name.equals("willpower")) {
                        playerCharacter.setWillpower(Integer.parseInt(xmlPullParser.nextText()));
                    } else if (name.equals("presence")) {
                        playerCharacter.setPresence(Integer.parseInt(xmlPullParser.nextText()));
                    } else if (name.equals("xp")) {
                        playerCharacter.setExperience(Integer.parseInt(xmlPullParser.nextText()));
                    } else if (name.equals("attribute")) {
                        skill.setTiedAttribute(xmlPullParser.nextText());
                    } else if (name.equals("skillName")) {
                        skill.setSkillName(xmlPullParser.nextText());
                    } else if (name.equals("isCareer")) {
                        String nextText = xmlPullParser.nextText();
                        if (nextText.equals("y")) {
                            skill.setIsCareer(true);
                        } else if (nextText.equals("n")) {
                            skill.setIsCareer(false);
                        }
                    } else if (name.equals("rank")) {
                        skill.setSkillRank(Integer.parseInt(xmlPullParser.nextText()));
                    } else if (name.equals("talentName")) {
                        talent.setTalentName(xmlPullParser.nextText());
                    } else if (name.equals("talentDescription")) {
                        talent.setDescription(xmlPullParser.nextText());
                    } else if (name.equals("strength")) {
                        playerCharacter.setStrength(xmlPullParser.nextText());
                    } else if (name.equals("strengthBody")) {
                        playerCharacter.setStrengthBody(xmlPullParser.nextText());
                    } else if (name.equals("flaw")) {
                        playerCharacter.setFlaw(xmlPullParser.nextText());
                    } else if (name.equals("flawBody")) {
                        playerCharacter.setFlawBody(xmlPullParser.nextText());
                    } else if (name.equals("desire")) {
                        playerCharacter.setDes(xmlPullParser.nextText());
                    } else if (name.equals("desireBody")) {
                        playerCharacter.setDesBody(xmlPullParser.nextText());
                    } else if (name.equals("fear")) {
                        playerCharacter.setFear(xmlPullParser.nextText());
                    } else if (name.equals("fearBody")) {
                        playerCharacter.setFearBody(xmlPullParser.nextText());
                    } else if (name.equals("wound")) {
                        playerCharacter.setWoundThreshold(Integer.parseInt(xmlPullParser.nextText()));
                    } else if (name.equals("curWound")) {
                        playerCharacter.setWoundCurrent(Integer.parseInt(xmlPullParser.nextText()));
                    } else if (name.equals("strain")) {
                        playerCharacter.setStrainThreshold(Integer.parseInt(xmlPullParser.nextText()));
                    } else if (name.equals("curStrain")) {
                        playerCharacter.setStrainCurrent(Integer.parseInt(xmlPullParser.nextText()));
                    } else if (name.equals("uri")) {
                        playerCharacter.setUriString(xmlPullParser.nextText());
                    } else if (name.equals("gearName")) {
                        gear.setName(xmlPullParser.nextText());
                    } else if (name.equals("gearDescription")) {
                        gear.setDescription(xmlPullParser.nextText());
                    } else if (name.equals("classification")) {
                        gear.setClassification(xmlPullParser.nextText());
                    } else if (name.equals("notes")) {
                        playerCharacter.setNotesText(xmlPullParser.nextText());
                    }
                }
            } else if (eventType == 3) {
                String name2 = xmlPullParser.getName();
                if (name2.equals("skill")) {
                    playerCharacter.addSkill(skill);
                    skill = new Skill();
                } else if (name2.equals("talent")) {
                    playerCharacter.addTalent(talent);
                    talent = new Talent();
                } else if (name2.equals("gear")) {
                    playerCharacter.addGear(gear);
                    gear = new Gear();
                }
            }
            eventType = xmlPullParser.next();
        }
        return playerCharacter;
    }

    private void createCharacterButton() {
        ((Button) findViewById(R.id.create_button)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(".CharEdit");
                intent.putExtra("character", new PlayerCharacter());
                MainActivity.this.startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_about) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
