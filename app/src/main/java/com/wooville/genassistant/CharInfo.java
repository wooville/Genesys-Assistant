package com.wooville.genassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.wooville.genassistant.adapter.SectionsPagerAdapter;
import com.wooville.genassistant.model.PlayerCharacter;

import java.io.File;

public class CharInfo extends AppCompatActivity {
    private PlayerCharacter mCharacter;
    private Button start_edit_btn;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.mCharacter = (PlayerCharacter) getIntent().getExtras().getParcelable("character");
        super.onCreate(bundle);
        if (this.mCharacter.getCharacterName() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mCharacter.getCharacterName());
            sb.append(", ");
            sb.append(this.mCharacter.getArchetype());
            sb.append(" ");
            sb.append(this.mCharacter.getCareer());
            setTitle(sb.toString());
        } else {
            setTitle(BuildConfig.FLAVOR);
        }
        setContentView((int) R.layout.activity_char_info);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new SectionsPagerAdapter(this, getSupportFragmentManager(), false, this.mCharacter));
        ((TabLayout) findViewById(R.id.tabs)).setupWithViewPager(viewPager);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_edit) {
            Intent intent = new Intent(".CharEdit");
            intent.putExtra("character", this.mCharacter);
            startActivity(intent);
        } else if (itemId == R.id.action_delete) {
            StringBuilder sb = new StringBuilder();
            sb.append(getApplicationContext().getFilesDir().getAbsolutePath());
            sb.append(File.separator);
            sb.append("characters");
            new File(new File(sb.toString()), this.mCharacter.getFileName()).delete();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
