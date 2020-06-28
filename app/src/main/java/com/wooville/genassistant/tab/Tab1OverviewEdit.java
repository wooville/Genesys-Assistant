package com.wooville.genassistant.tab;

import com.wooville.genassistant.R;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wooville.genassistant.model.PCCollect;
import com.wooville.genassistant.model.PlayerCharacter;
import java.io.FileNotFoundException;

/* renamed from: com.wooville.genassistant.ui.main.Tab1OverviewEdit */
public class Tab1OverviewEdit extends Fragment {
    private static final int PERMISSION_REQUEST = 0;
    private static final int RESULT_LOAD_IMAGE = 1;
    /* access modifiers changed from: private */
    public Spinner agInput;
    /* access modifiers changed from: private */
    public EditText archetypeInput;
    /* access modifiers changed from: private */
    public Spinner brInput;
    /* access modifiers changed from: private */
    public EditText careerInput;
    /* access modifiers changed from: private */
    public EditText charNameInput;
    private ImageButton char_img_btn;
    /* access modifiers changed from: private */
    public Spinner cunInput;
    /* access modifiers changed from: private */
    public EditText curStrainInput;
    /* access modifiers changed from: private */
    public EditText curWoundInput;
    /* access modifiers changed from: private */
    public PlayerCharacter dummyChar;
    /* access modifiers changed from: private */
    public Spinner intInput;
    /* access modifiers changed from: private */
    public EditText notesInput;
    /* access modifiers changed from: private */
    public Spinner prInput;
    private Uri selectedImage;
    /* access modifiers changed from: private */
    public EditText strainInput;
    /* access modifiers changed from: private */
    public Spinner willInput;
    /* access modifiers changed from: private */
    public EditText woundInput;
    /* access modifiers changed from: private */
    public EditText xpInput;

    public static Tab1OverviewEdit newInstance(PlayerCharacter playerCharacter) {
        Tab1OverviewEdit tab1OverviewEdit = new Tab1OverviewEdit();
        Bundle bundle = new Bundle();
        bundle.putParcelable("character", playerCharacter);
        tab1OverviewEdit.setArguments(bundle);
        return tab1OverviewEdit;
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dummyChar = (PlayerCharacter) getArguments().getParcelable("character");
        if (VERSION.SDK_INT >= 23) {
            String str = "android.permission.READ_EXTERNAL_STORAGE";
            if (getContext().checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{str}, 0);
            }
        }
        return layoutInflater.inflate(R.layout.tab1overview_edit, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.char_img_btn = (ImageButton) getView().findViewById(R.id.select_char_img);
        this.char_img_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Tab1OverviewEdit.this.startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT", Media.EXTERNAL_CONTENT_URI), 1);
            }
        });
        ArrayAdapter createFromResource = ArrayAdapter.createFromResource(this.getContext(), R.array.characteristic_array, R.layout.spinner_item);
        this.brInput = (Spinner) getView().findViewById(R.id.br_spin);
        this.agInput = (Spinner) getView().findViewById(R.id.ag_spin);
        this.intInput = (Spinner) getView().findViewById(R.id.int_spin);
        this.cunInput = (Spinner) getView().findViewById(R.id.cun_spin);
        this.willInput = (Spinner) getView().findViewById(R.id.will_spin);
        this.prInput = (Spinner) getView().findViewById(R.id.pr_spin);
        OnItemSelectedListener listener = new OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (view != null) {
                    Tab1OverviewEdit.this.dummyChar.setBrawn(Integer.parseInt((String) Tab1OverviewEdit.this.brInput.getSelectedItem()));
                    Tab1OverviewEdit.this.dummyChar.setAgility(Integer.parseInt((String) Tab1OverviewEdit.this.agInput.getSelectedItem()));
                    Tab1OverviewEdit.this.dummyChar.setIntellect(Integer.parseInt((String) Tab1OverviewEdit.this.intInput.getSelectedItem()));
                    Tab1OverviewEdit.this.dummyChar.setCunning(Integer.parseInt((String) Tab1OverviewEdit.this.cunInput.getSelectedItem()));
                    Tab1OverviewEdit.this.dummyChar.setWillpower(Integer.parseInt((String) Tab1OverviewEdit.this.willInput.getSelectedItem()));
                    Tab1OverviewEdit.this.dummyChar.setPresence(Integer.parseInt((String) Tab1OverviewEdit.this.prInput.getSelectedItem()));
                }
            }
        };
        this.brInput.setOnItemSelectedListener(listener);
        this.agInput.setOnItemSelectedListener(listener);
        this.intInput.setOnItemSelectedListener(listener);
        this.cunInput.setOnItemSelectedListener(listener);
        this.willInput.setOnItemSelectedListener(listener);
        this.prInput.setOnItemSelectedListener(listener);
        createFromResource.notifyDataSetChanged();
        this.brInput.setAdapter(createFromResource);
        this.agInput.setAdapter(createFromResource);
        this.intInput.setAdapter(createFromResource);
        this.cunInput.setAdapter(createFromResource);
        this.willInput.setAdapter(createFromResource);
        this.prInput.setAdapter(createFromResource);
        this.brInput.setSelection(this.dummyChar.getBrawn() - 1);
        this.agInput.setSelection(this.dummyChar.getAgility() - 1);
        this.intInput.setSelection(this.dummyChar.getIntellect() - 1);
        this.cunInput.setSelection(this.dummyChar.getCunning() - 1);
        this.willInput.setSelection(this.dummyChar.getWillpower() - 1);
        this.prInput.setSelection(this.dummyChar.getPresence() - 1);
        this.charNameInput = (EditText) getView().findViewById(R.id.char_name_input);
        this.archetypeInput = (EditText) getView().findViewById(R.id.archetype_input);
        this.careerInput = (EditText) getView().findViewById(R.id.career_input);
        this.notesInput = (EditText) getView().findViewById(R.id.notes_input);
        this.xpInput = (EditText) getView().findViewById(R.id.xp_input);
        this.woundInput = (EditText) getView().findViewById(R.id.wound_input);
        this.curWoundInput = (EditText) getView().findViewById(R.id.wound_current_input);
        this.strainInput = (EditText) getView().findViewById(R.id.strain_input);
        this.curStrainInput = (EditText) getView().findViewById(R.id.strain_current_input);
        TextWatcher textWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable == null) {
                    return;
                }
                if (editable == Tab1OverviewEdit.this.charNameInput.getEditableText()) {
                    Tab1OverviewEdit.this.dummyChar.setCharacterName(editable.toString());
                } else if (editable == Tab1OverviewEdit.this.archetypeInput.getEditableText()) {
                    Tab1OverviewEdit.this.dummyChar.setArchetype(editable.toString());
                } else if (editable == Tab1OverviewEdit.this.careerInput.getEditableText()) {
                    Tab1OverviewEdit.this.dummyChar.setCareer(editable.toString());
                } else if (editable == Tab1OverviewEdit.this.notesInput.getEditableText()) {
                    Tab1OverviewEdit.this.dummyChar.setNotesText(editable.toString());
                } else if (editable == Tab1OverviewEdit.this.xpInput.getEditableText()) {
                    try {
                        Tab1OverviewEdit.this.dummyChar.setExperience(Integer.parseInt(editable.toString()));
                    } catch (NumberFormatException unused) {
                    }
                } else if (editable == Tab1OverviewEdit.this.woundInput.getEditableText()) {
                    Tab1OverviewEdit.this.dummyChar.setWoundThreshold(Integer.parseInt(editable.toString()));
                } else if (editable == Tab1OverviewEdit.this.curWoundInput.getEditableText()) {
                    Tab1OverviewEdit.this.dummyChar.setWoundCurrent(Integer.parseInt(editable.toString()));
                } else if (editable == Tab1OverviewEdit.this.strainInput.getEditableText()) {
                    Tab1OverviewEdit.this.dummyChar.setStrainThreshold(Integer.parseInt(editable.toString()));
                } else if (editable == Tab1OverviewEdit.this.curStrainInput.getEditableText()) {
                    Tab1OverviewEdit.this.dummyChar.setStrainCurrent(Integer.parseInt(editable.toString()));
                }
            }
        };
        this.charNameInput.addTextChangedListener(textWatcher);
        this.archetypeInput.addTextChangedListener(textWatcher);
        this.careerInput.addTextChangedListener(textWatcher);
        this.notesInput.addTextChangedListener(textWatcher);
        this.xpInput.addTextChangedListener(textWatcher);
        this.woundInput.addTextChangedListener(textWatcher);
        this.curWoundInput.addTextChangedListener(textWatcher);
        this.strainInput.addTextChangedListener(textWatcher);
        this.curStrainInput.addTextChangedListener(textWatcher);
        this.charNameInput.setText(this.dummyChar.getCharacterName());
        this.archetypeInput.setText(this.dummyChar.getArchetype());
        this.careerInput.setText(this.dummyChar.getCareer());
        this.notesInput.setText(this.dummyChar.getNotesText());
        this.xpInput.setText(String.valueOf(this.dummyChar.getExperience()));
        this.woundInput.setText(String.valueOf(this.dummyChar.getWoundThreshold()));
        this.curWoundInput.setText(String.valueOf(this.dummyChar.getWoundCurrent()));
        this.strainInput.setText(String.valueOf(this.dummyChar.getWoundThreshold()));
        this.curStrainInput.setText(String.valueOf(this.dummyChar.getWoundCurrent()));
        try {
            this.char_img_btn.setImageBitmap(BitmapFactory.decodeStream(getContext().getContentResolver().openInputStream(Uri.parse(this.dummyChar.getUriString()))));
        } catch (FileNotFoundException unused) {
        }
        ((PCCollect) getActivity()).collectPC(this.dummyChar);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            this.selectedImage = intent.getData();
            this.dummyChar.setUriString(this.selectedImage.toString());
            try {
                this.char_img_btn.setImageBitmap(BitmapFactory.decodeStream(getContext().getContentResolver().openInputStream(this.selectedImage)));
            } catch (FileNotFoundException unused) {
            }
        }
    }
}
