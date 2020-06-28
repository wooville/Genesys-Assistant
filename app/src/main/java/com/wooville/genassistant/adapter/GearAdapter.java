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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.wooville.genassistant.model.Gear;

import java.util.ArrayList;

/* renamed from: com.wooville.genassistant.ui.main.GearAdapter */
public class GearAdapter extends Adapter<GearAdapter.GearViewHolder> {
    private Context mContext;
    /* access modifiers changed from: private */
    public ArrayList<Gear> mGear;

    /* renamed from: com.wooville.genassistant.ui.main.GearAdapter$GearViewHolder */
    public static class GearViewHolder extends ViewHolder {
        public Spinner mClassificationInput;
        public Button mDeleteGearBtn;
        public TextView mDescriptionHeadView;
        public EditText mGearDescriptionInput;
        public EditText mGearNameInput;
        public Button mNewGearBtn;

        public GearViewHolder(View view) {
            super(view);
            this.mGearNameInput = (EditText) view.findViewById(R.id.gearNameInput);
            this.mGearDescriptionInput = (EditText) view.findViewById(R.id.gearDescriptionInput);
            this.mDescriptionHeadView = (TextView) view.findViewById(R.id.gearDescriptionHead);
            this.mClassificationInput = (Spinner) view.findViewById(R.id.gearTypeInput);
            this.mNewGearBtn = (Button) view.findViewById(R.id.new_gear_btn);
            this.mDeleteGearBtn = (Button) view.findViewById(R.id.delete_gear_btn);
        }
    }

    public GearAdapter(Context context, ArrayList arrayList) {
        this.mContext = context;
        this.mGear = arrayList;
    }

    @NonNull
    public GearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == R.layout.gear) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gear, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.new_gear_btn, viewGroup, false);
        }
        return new GearViewHolder(view);
    }

    public int getItemViewType(int i) {
        return i == this.mGear.size() ? R.layout.new_gear_btn : R.layout.gear;
    }

    public void onBindViewHolder(final GearViewHolder gearViewHolder, final int i) {
        if (i == this.mGear.size()) {
            gearViewHolder.mNewGearBtn.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    GearAdapter.this.mGear.add(new Gear());
                    GearAdapter.this.notifyDataSetChanged();
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
                if (editable == gearViewHolder.mGearNameInput.getEditableText()) {
                    ((Gear) GearAdapter.this.mGear.get(i)).setName(editable.toString());
                } else if (editable == gearViewHolder.mGearDescriptionInput.getEditableText()) {
                    ((Gear) GearAdapter.this.mGear.get(i)).setDescription(editable.toString());
                }
            }
        };
        gearViewHolder.mGearNameInput.addTextChangedListener(textWatcher);
        gearViewHolder.mGearDescriptionInput.addTextChangedListener(textWatcher);
        ArrayAdapter createFromResource = ArrayAdapter.createFromResource(this.mContext, R.array.gear_array, R.layout.spinner_item);
        gearViewHolder.mClassificationInput.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                ((Gear) GearAdapter.this.mGear.get(i)).setClassification(String.valueOf(adapterView.getItemAtPosition(i)));
            }
        });
        gearViewHolder.mDeleteGearBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                GearAdapter.this.mGear.remove(i);
                GearAdapter.this.notifyDataSetChanged();
            }
        });
        gearViewHolder.mGearNameInput.setText(((Gear) this.mGear.get(i)).getName());
        gearViewHolder.mGearDescriptionInput.setText(((Gear) this.mGear.get(i)).getDescription());
        createFromResource.notifyDataSetChanged();
        gearViewHolder.mClassificationInput.setAdapter(createFromResource);
        gearViewHolder.mClassificationInput.setSelection(createFromResource.getPosition(((Gear) this.mGear.get(i)).getClassification()));
    }

    public int getItemCount() {
        return this.mGear.size() + 1;
    }
}
