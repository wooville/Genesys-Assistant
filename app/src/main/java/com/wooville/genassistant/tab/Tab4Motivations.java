package com.wooville.genassistant.tab;

import com.wooville.genassistant.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wooville.genassistant.model.PlayerCharacter;

/* renamed from: com.wooville.genassistant.ui.main.Tab4Motivations */
public class Tab4Motivations extends Fragment {
    private TextView desBody;
    private TextView desHead;
    private PlayerCharacter dummyChar;
    private TextView fearBody;
    private TextView fearHead;
    private TextView flawBody;
    private TextView flawHead;
    private TextView strBody;
    private TextView strHead;

    public static Tab4Motivations newInstance(PlayerCharacter playerCharacter) {
        Tab4Motivations tab4Motivations = new Tab4Motivations();
        Bundle bundle = new Bundle();
        bundle.putParcelable("character", playerCharacter);
        tab4Motivations.setArguments(bundle);
        return tab4Motivations;
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dummyChar = (PlayerCharacter) getArguments().getParcelable("character");
        return layoutInflater.inflate(R.layout.tab4motivations, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.strHead = (TextView) getView().findViewById(R.id.str_head_disp);
        this.strBody = (TextView) getView().findViewById(R.id.str_body_disp);
        this.flawHead = (TextView) getView().findViewById(R.id.flaw_head_disp);
        this.flawBody = (TextView) getView().findViewById(R.id.flaw_body_disp);
        this.desHead = (TextView) getView().findViewById(R.id.des_head_disp);
        this.desBody = (TextView) getView().findViewById(R.id.des_body_disp);
        this.fearHead = (TextView) getView().findViewById(R.id.fear_head_disp);
        this.fearBody = (TextView) getView().findViewById(R.id.fear_body_disp);
        TextView textView = this.strHead;
        StringBuilder sb = new StringBuilder();
        sb.append("Strength: ");
        sb.append(this.dummyChar.getStrength());
        textView.setText(sb.toString());
        this.strBody.setText(this.dummyChar.getStrengthBody());
        TextView textView2 = this.flawHead;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Flaw: ");
        sb2.append(this.dummyChar.getFlaw());
        textView2.setText(sb2.toString());
        this.flawBody.setText(this.dummyChar.getFlawBody());
        TextView textView3 = this.desHead;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Desire: ");
        sb3.append(this.dummyChar.getDes());
        textView3.setText(sb3.toString());
        this.desBody.setText(this.dummyChar.getDesBody());
        TextView textView4 = this.fearHead;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Fear: ");
        sb4.append(this.dummyChar.getFear());
        textView4.setText(sb4.toString());
        this.fearBody.setText(this.dummyChar.getFearBody());
    }
}
