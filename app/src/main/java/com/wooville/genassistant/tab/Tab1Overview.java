package com.wooville.genassistant.tab;

import com.wooville.genassistant.R;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wooville.genassistant.model.PlayerCharacter;
import java.io.FileNotFoundException;

/* renamed from: com.wooville.genassistant.ui.main.Tab1Overview */
public class Tab1Overview extends Fragment {
    private TextView agText;
    private TextView brText;
    private ImageView char_img;
    private TextView cunText;
    private TextView curStrainText;
    private TextView curWoundText;
    private PlayerCharacter dummyChar;
    private TextView intText;
    private TextView notesText;
    private TextView prText;
    private TextView strainText;
    private TextView willText;
    private TextView woundText;
    private TextView xpText;

    public static Tab1Overview newInstance(PlayerCharacter playerCharacter) {
        Tab1Overview tab1Overview = new Tab1Overview();
        Bundle bundle = new Bundle();
        bundle.putParcelable("character", playerCharacter);
        tab1Overview.setArguments(bundle);
        return tab1Overview;
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dummyChar = (PlayerCharacter) getArguments().getParcelable("character");
        return layoutInflater.inflate(R.layout.tab1overview, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.char_img = (ImageView) getView().findViewById(R.id.disp_char_img);
        this.brText = (TextView) getView().findViewById(R.id.br_text);
        this.agText = (TextView) getView().findViewById(R.id.ag_text);
        this.intText = (TextView) getView().findViewById(R.id.int_text);
        this.cunText = (TextView) getView().findViewById(R.id.cun_text);
        this.willText = (TextView) getView().findViewById(R.id.will_text);
        this.prText = (TextView) getView().findViewById(R.id.pr_text);
        this.notesText = (TextView) getView().findViewById(R.id.notes_disp_body);
        this.xpText = (TextView) getView().findViewById(R.id.xp_disp);
        this.woundText = (TextView) getView().findViewById(R.id.wound_disp);
        this.curWoundText = (TextView) getView().findViewById(R.id.wound_current_disp);
        this.strainText = (TextView) getView().findViewById(R.id.strain_disp);
        this.curStrainText = (TextView) getView().findViewById(R.id.strain_current_disp);
        this.brText.setText(String.valueOf(this.dummyChar.getBrawn()));
        this.agText.setText(String.valueOf(this.dummyChar.getAgility()));
        this.intText.setText(String.valueOf(this.dummyChar.getIntellect()));
        this.cunText.setText(String.valueOf(this.dummyChar.getCunning()));
        this.willText.setText(String.valueOf(this.dummyChar.getWillpower()));
        this.prText.setText(String.valueOf(this.dummyChar.getPresence()));
        this.notesText.setText(this.dummyChar.getNotesText());
        this.woundText.setText(String.valueOf(this.dummyChar.getWoundThreshold()));
        this.curWoundText.setText(String.valueOf(this.dummyChar.getWoundCurrent()));
        this.strainText.setText(String.valueOf(this.dummyChar.getStrainThreshold()));
        this.curStrainText.setText(String.valueOf(this.dummyChar.getStrainCurrent()));
        StringBuilder sb = new StringBuilder();
        sb.append("XP: ");
        sb.append(String.valueOf(this.dummyChar.getExperience()));
        this.xpText.setText(sb.toString());
        try {
            this.char_img.setImageBitmap(BitmapFactory.decodeStream(getContext().getContentResolver().openInputStream(Uri.parse(this.dummyChar.getUriString()))));
        } catch (FileNotFoundException | NullPointerException unused) {
        }
    }
}
