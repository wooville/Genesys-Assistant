package com.wooville.genassistant.adapter;

import com.wooville.genassistant.R;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.wooville.genassistant.BuildConfig;
import com.wooville.genassistant.model.Skill;

import java.util.ArrayList;

/* renamed from: com.wooville.genassistant.ui.main.SkillsAdapter */
public class SkillsAdapter extends Adapter<SkillsAdapter.SkillsViewHolder> {
    public Context mContext;
    /* access modifiers changed from: private */
    public ArrayList<Skill> mSkillsList;

    /* renamed from: com.wooville.genassistant.ui.main.SkillsAdapter$SkillsViewHolder */
    public static class SkillsViewHolder extends ViewHolder {
        public Spinner mAttributeInput;
        public CheckBox mCareerBox;
        public Button mDeleteSkillBtn;
        public Button mNewSkillBtn;
        public EditText mSkillNameInput;
        public Spinner mSkillRankInput;

        public SkillsViewHolder(View view) {
            super(view);
            this.mSkillNameInput = (EditText) view.findViewById(R.id.skillNameInput);
            this.mCareerBox = (CheckBox) view.findViewById(R.id.checkboxCareer);
            this.mSkillRankInput = (Spinner) view.findViewById(R.id.skillRankInput);
            this.mAttributeInput = (Spinner) view.findViewById(R.id.skillAttributeInput);
            this.mNewSkillBtn = (Button) view.findViewById(R.id.new_skill_btn);
            this.mDeleteSkillBtn = (Button) view.findViewById(R.id.delete_skill_btn);
        }
    }

    public SkillsAdapter(Context context, ArrayList<Skill> arrayList) {
        this.mContext = context;
        this.mSkillsList = arrayList;
    }

    public int getItemViewType(int i) {
        return i == this.mSkillsList.size() ? R.layout.new_skill_btn : R.layout.skill;
    }

    @NonNull
    public SkillsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == R.layout.skill) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.skill, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.new_skill_btn, viewGroup, false);
        }
        return new SkillsViewHolder(view);
    }

    public void onBindViewHolder(SkillsViewHolder skillsViewHolder, final int i) {
        String str;
        if (i == this.mSkillsList.size()) {
            skillsViewHolder.mNewSkillBtn.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    SkillsAdapter.this.mSkillsList.add(new Skill());
                    SkillsAdapter.this.notifyDataSetChanged();
                }
            });
            return;
        }
        skillsViewHolder.mCareerBox.setOnCheckedChangeListener(null);
        skillsViewHolder.mCareerBox.setChecked(((Skill) this.mSkillsList.get(i)).getIsCareer());
        skillsViewHolder.mCareerBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ((Skill) SkillsAdapter.this.mSkillsList.get(i)).setIsCareer(z);
            }
        });
        skillsViewHolder.mSkillNameInput.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                ((Skill) SkillsAdapter.this.mSkillsList.get(i)).setSkillName(editable.toString());
            }
        });
        ArrayAdapter createFromResource = ArrayAdapter.createFromResource(this.mContext, R.array.skill_rank_array, R.layout.spinner_item);
        ArrayAdapter createFromResource2 = ArrayAdapter.createFromResource(this.mContext, R.array.skill_attribute_array, R.layout.spinner_item);
        skillsViewHolder.mSkillRankInput.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long j) {
                ((Skill) SkillsAdapter.this.mSkillsList.get(i)).setSkillRank(pos);
            }
        });
        skillsViewHolder.mAttributeInput.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long j) {
                ((Skill) SkillsAdapter.this.mSkillsList.get(i)).setTiedAttribute(String.valueOf(adapterView.getItemAtPosition(pos)));
            }
        });
        skillsViewHolder.mDeleteSkillBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SkillsAdapter.this.mSkillsList.remove(i);
                SkillsAdapter.this.notifyDataSetChanged();
            }
        });
        skillsViewHolder.mSkillNameInput.setImeOptions(6);
        createFromResource.notifyDataSetChanged();
        createFromResource2.notifyDataSetChanged();
        skillsViewHolder.mSkillRankInput.setAdapter(createFromResource);
        skillsViewHolder.mAttributeInput.setAdapter(createFromResource2);
        skillsViewHolder.mSkillRankInput.setSelection(((Skill) this.mSkillsList.get(i)).getSkillRank());
        skillsViewHolder.mAttributeInput.setSelection(createFromResource2.getPosition(((Skill) this.mSkillsList.get(i)).getTiedAttribute()));
        if (((Skill) this.mSkillsList.get(i)).getSkillName().equals(BuildConfig.FLAVOR)) {
            str = "Skill Name";
        } else {
            str = ((Skill) this.mSkillsList.get(i)).getSkillName();
        }
        skillsViewHolder.mSkillNameInput.setText(str);
    }

    public int getItemCount() {
        return this.mSkillsList.size() + 1;
    }
}
