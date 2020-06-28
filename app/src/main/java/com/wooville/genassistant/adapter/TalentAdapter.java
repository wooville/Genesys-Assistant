package com.wooville.genassistant.adapter;

import com.wooville.genassistant.R;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.wooville.genassistant.model.Talent;

import java.util.ArrayList;

/* renamed from: com.wooville.genassistant.ui.main.TalentAdapter */
public class TalentAdapter extends Adapter<TalentAdapter.TalentViewHolder> {
    /* access modifiers changed from: private */
    public ArrayList<Talent> mTalents;

    /* renamed from: com.wooville.genassistant.ui.main.TalentAdapter$TalentViewHolder */
    public static class TalentViewHolder extends ViewHolder {
        public Button mDeleteTalentBtn;
        public TextView mDescriptionHeadView;
        public Button mNewTalentBtn;
        public EditText mTalentDescriptionInput;
        public EditText mTalentNameInput;

        public TalentViewHolder(View view) {
            super(view);
            this.mTalentNameInput = (EditText) view.findViewById(R.id.talentNameView);
            this.mTalentDescriptionInput = (EditText) view.findViewById(R.id.talentDescriptionInput);
            this.mDescriptionHeadView = (TextView) view.findViewById(R.id.talentDescriptionHead);
            this.mNewTalentBtn = (Button) view.findViewById(R.id.new_talent_btn);
            this.mDeleteTalentBtn = (Button) view.findViewById(R.id.delete_talent_btn);
        }
    }

    public TalentAdapter(ArrayList arrayList) {
        this.mTalents = arrayList;
    }

    @NonNull
    public TalentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == R.layout.talent) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.talent, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.new_talent_btn, viewGroup, false);
        }
        return new TalentViewHolder(view);
    }

    public int getItemViewType(int i) {
        return i == this.mTalents.size() ? R.layout.new_talent_btn : R.layout.talent;
    }

    public void onBindViewHolder(final TalentViewHolder talentViewHolder, final int i) {
        if (i == this.mTalents.size()) {
            talentViewHolder.mNewTalentBtn.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    TalentAdapter.this.mTalents.add(new Talent());
                    TalentAdapter.this.notifyDataSetChanged();
                }
            });
            return;
        }
        TextWatcher textWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable == null) {
                    return;
                }
                if (editable == talentViewHolder.mTalentNameInput.getEditableText()) {
                    ((Talent) TalentAdapter.this.mTalents.get(i)).setTalentName(editable.toString());
                } else if (editable == talentViewHolder.mTalentDescriptionInput.getEditableText()) {
                    ((Talent) TalentAdapter.this.mTalents.get(i)).setDescription(editable.toString());
                }
            }
        };
        talentViewHolder.mTalentNameInput.addTextChangedListener(textWatcher);
        talentViewHolder.mTalentDescriptionInput.addTextChangedListener(textWatcher);
        talentViewHolder.mDeleteTalentBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                TalentAdapter.this.mTalents.remove(i);
                TalentAdapter.this.notifyDataSetChanged();
            }
        });
        talentViewHolder.mTalentNameInput.setText(((Talent) this.mTalents.get(i)).getTalentName());
        talentViewHolder.mTalentDescriptionInput.setText(((Talent) this.mTalents.get(i)).getDescription());
    }

    public int getItemCount() {
        return this.mTalents.size() + 1;
    }
}
