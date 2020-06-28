package com.wooville.genassistant.adapter;

import com.wooville.genassistant.R;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.wooville.genassistant.model.Skill;

import java.util.ArrayList;

/* renamed from: com.wooville.genassistant.ui.main.SkillsDispAdapter */
public class SkillsDispAdapter extends Adapter<SkillsDispAdapter.SkillsDispViewHolder> {
    public Context mContext;
    private ArrayList<Skill> mSkillsList;

    /* renamed from: com.wooville.genassistant.ui.main.SkillsDispAdapter$SkillsDispViewHolder */
    public static class SkillsDispViewHolder extends ViewHolder {
        public TextView mSkillNameDispView;
        public TextView mSkillRankDisp;

        public SkillsDispViewHolder(View view) {
            super(view);
            this.mSkillNameDispView = (TextView) view.findViewById(R.id.skillNameDispView);
            this.mSkillRankDisp = (TextView) view.findViewById(R.id.skillRankDisp);
        }
    }

    public SkillsDispAdapter(Context context, ArrayList arrayList) {
        this.mContext = context;
        this.mSkillsList = arrayList;
    }

    @NonNull
    public SkillsDispViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SkillsDispViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.skill_disp, viewGroup, false));
    }

    public void onBindViewHolder(SkillsDispViewHolder skillsDispViewHolder, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(((Skill) this.mSkillsList.get(i)).getSkillName());
        sb.append(" (");
        sb.append(((Skill) this.mSkillsList.get(i)).getTiedAttribute());
        sb.append(")");
        String sb2 = sb.toString();
        if (((Skill) this.mSkillsList.get(i)).getIsCareer().booleanValue()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(" [C]");
            sb2 = sb3.toString();
            skillsDispViewHolder.mSkillNameDispView.setTextColor(Color.parseColor("#0E588B"));
            skillsDispViewHolder.mSkillNameDispView.setTypeface(null, 3);
        } else {
            skillsDispViewHolder.mSkillNameDispView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            skillsDispViewHolder.mSkillNameDispView.setTypeface(null, 1);
        }
        skillsDispViewHolder.mSkillNameDispView.setText(sb2);
        skillsDispViewHolder.mSkillRankDisp.setText(String.valueOf(((Skill) this.mSkillsList.get(i)).getSkillRank()));
    }

    public int getItemCount() {
        return this.mSkillsList.size();
    }
}
