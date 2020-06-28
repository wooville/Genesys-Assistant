package com.wooville.genassistant.tab;

import com.wooville.genassistant.R;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wooville.genassistant.model.PCCollect;
import com.wooville.genassistant.model.PlayerCharacter;

/* renamed from: com.wooville.genassistant.ui.main.Tab4MotivationsEdit */
public class Tab4MotivationsEdit extends Fragment {
    /* access modifiers changed from: private */
    public EditText desInput;
    /* access modifiers changed from: private */
    public EditText desInputBody;
    /* access modifiers changed from: private */
    public PlayerCharacter dummyChar;
    /* access modifiers changed from: private */
    public EditText fearInput;
    /* access modifiers changed from: private */
    public EditText fearInputBody;
    /* access modifiers changed from: private */
    public EditText flawInput;
    /* access modifiers changed from: private */
    public EditText flawInputBody;
    /* access modifiers changed from: private */
    public EditText strInput;
    /* access modifiers changed from: private */
    public EditText strInputBody;

    public static Tab4MotivationsEdit newInstance(PlayerCharacter playerCharacter) {
        Tab4MotivationsEdit tab4MotivationsEdit = new Tab4MotivationsEdit();
        Bundle bundle = new Bundle();
        bundle.putParcelable("character", playerCharacter);
        tab4MotivationsEdit.setArguments(bundle);
        return tab4MotivationsEdit;
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dummyChar = (PlayerCharacter) getArguments().getParcelable("character");
        return layoutInflater.inflate(R.layout.tab4motivations_edit, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((PCCollect) getActivity()).collectPC(this.dummyChar);
        this.strInput = (EditText) getView().findViewById(R.id.text_input_mot_str_head);
        this.strInputBody = (EditText) getView().findViewById(R.id.text_input_mot_str_field);
        this.flawInput = (EditText) getView().findViewById(R.id.text_input_mot_flaw_head);
        this.flawInputBody = (EditText) getView().findViewById(R.id.text_input_mot_flaw_field);
        this.desInput = (EditText) getView().findViewById(R.id.text_input_mot_des_head);
        this.desInputBody = (EditText) getView().findViewById(R.id.text_input_mot_des_field);
        this.fearInput = (EditText) getView().findViewById(R.id.text_input_mot_fear_head);
        this.fearInputBody = (EditText) getView().findViewById(R.id.text_input_mot_fear_field);
        TextWatcher textWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable == null) {
                    return;
                }
                if (editable == Tab4MotivationsEdit.this.strInput.getEditableText()) {
                    Tab4MotivationsEdit.this.dummyChar.setStrength(editable.toString());
                } else if (editable == Tab4MotivationsEdit.this.strInputBody.getEditableText()) {
                    Tab4MotivationsEdit.this.dummyChar.setStrengthBody(editable.toString());
                } else if (editable == Tab4MotivationsEdit.this.flawInput.getEditableText()) {
                    Tab4MotivationsEdit.this.dummyChar.setFlaw(editable.toString());
                } else if (editable == Tab4MotivationsEdit.this.flawInputBody.getEditableText()) {
                    Tab4MotivationsEdit.this.dummyChar.setFlawBody(editable.toString());
                } else if (editable == Tab4MotivationsEdit.this.desInput.getEditableText()) {
                    Tab4MotivationsEdit.this.dummyChar.setDes(editable.toString());
                } else if (editable == Tab4MotivationsEdit.this.desInputBody.getEditableText()) {
                    Tab4MotivationsEdit.this.dummyChar.setDesBody(editable.toString());
                } else if (editable == Tab4MotivationsEdit.this.fearInput.getEditableText()) {
                    Tab4MotivationsEdit.this.dummyChar.setFear(editable.toString());
                } else if (editable == Tab4MotivationsEdit.this.fearInputBody.getEditableText()) {
                    Tab4MotivationsEdit.this.dummyChar.setFearBody(editable.toString());
                }
            }
        };
        this.strInput.addTextChangedListener(textWatcher);
        this.strInputBody.addTextChangedListener(textWatcher);
        this.flawInput.addTextChangedListener(textWatcher);
        this.flawInputBody.addTextChangedListener(textWatcher);
        this.desInput.addTextChangedListener(textWatcher);
        this.desInputBody.addTextChangedListener(textWatcher);
        this.fearInput.addTextChangedListener(textWatcher);
        this.fearInputBody.addTextChangedListener(textWatcher);
    }
}
