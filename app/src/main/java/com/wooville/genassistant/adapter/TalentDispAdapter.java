package com.wooville.genassistant.adapter;

import com.wooville.genassistant.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.wooville.genassistant.model.Talent;

import java.util.ArrayList;

/* renamed from: com.wooville.genassistant.ui.main.TalentDispAdapter */
public class TalentDispAdapter extends Adapter<TalentDispAdapter.TalentDispViewHolder> {
    private ArrayList<Talent> mTalents;

    /* renamed from: com.wooville.genassistant.ui.main.TalentDispAdapter$TalentDispViewHolder */
    public static class TalentDispViewHolder extends ViewHolder {
        public TextView mTalentDescriptionDisp;
        public TextView mTalentNameDispView;

        public TalentDispViewHolder(View view) {
            super(view);
            this.mTalentNameDispView = (TextView) view.findViewById(R.id.talentNameView);
            this.mTalentDescriptionDisp = (TextView) view.findViewById(R.id.talentDescription);
        }
    }

    public TalentDispAdapter(ArrayList arrayList) {
        this.mTalents = arrayList;
    }

    @NonNull
    public TalentDispViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TalentDispViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.talent_disp, viewGroup, false));
    }

    public void onBindViewHolder(TalentDispViewHolder talentDispViewHolder, int i) {
        if (((Talent) this.mTalents.get(i)).getTalentName() != null) {
            talentDispViewHolder.mTalentNameDispView.setText(((Talent) this.mTalents.get(i)).getTalentName());
        }
        if (((Talent) this.mTalents.get(i)).getDescription() != null) {
            talentDispViewHolder.mTalentDescriptionDisp.setText(((Talent) this.mTalents.get(i)).getDescription());
        }
    }

    public int getItemCount() {
        return this.mTalents.size();
    }
}
