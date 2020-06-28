package com.wooville.genassistant.adapter;

import com.wooville.genassistant.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.wooville.genassistant.model.Gear;

import java.util.ArrayList;

/* renamed from: com.wooville.genassistant.ui.main.GearDispAdapter */
public class GearDispAdapter extends Adapter<GearDispAdapter.GearDispViewHolder> {
    private ArrayList<Gear> mGear;

    /* renamed from: com.wooville.genassistant.ui.main.GearDispAdapter$GearDispViewHolder */
    public static class GearDispViewHolder extends ViewHolder {
        public TextView mGearDescriptionDisp;
        public TextView mGearNameDispView;
        public TextView mGearTypeDisp;

        public GearDispViewHolder(View view) {
            super(view);
            this.mGearNameDispView = (TextView) view.findViewById(R.id.gearNameView);
            this.mGearTypeDisp = (TextView) view.findViewById(R.id.gearTypeView);
            this.mGearDescriptionDisp = (TextView) view.findViewById(R.id.gearDescription);
        }
    }

    public GearDispAdapter(ArrayList arrayList) {
        this.mGear = arrayList;
    }

    @NonNull
    public GearDispViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new GearDispViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gear_disp, viewGroup, false));
    }

    public void onBindViewHolder(GearDispViewHolder gearDispViewHolder, int i) {
        if (((Gear) this.mGear.get(i)).getName() != null) {
            gearDispViewHolder.mGearNameDispView.setText(((Gear) this.mGear.get(i)).getName());
        }
        if (((Gear) this.mGear.get(i)).getClassification() != null) {
            gearDispViewHolder.mGearTypeDisp.setText(((Gear) this.mGear.get(i)).getClassification());
        }
        if (((Gear) this.mGear.get(i)).getDescription() != null) {
            gearDispViewHolder.mGearDescriptionDisp.setText(((Gear) this.mGear.get(i)).getDescription());
        }
    }

    public int getItemCount() {
        return this.mGear.size();
    }
}
