package com.wooville.genassistant.adapter;

import com.wooville.genassistant.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.wooville.genassistant.model.PlayerCharacter;

import java.util.ArrayList;

/* renamed from: com.wooville.genassistant.ui.main.CharacterSelectAdapter */
public class CharacterSelectAdapter extends Adapter<CharacterSelectAdapter.CharacterViewHolder> {
    private ArrayList<PlayerCharacter> mCharacterList;
    private OnItemClickListener mListener;

    /* renamed from: com.wooville.genassistant.ui.main.CharacterSelectAdapter$CharacterViewHolder */
    public static class CharacterViewHolder extends ViewHolder {
        public TextView mArchetypeView;
        public TextView mCareerView;
        public TextView mCharNameView;

        public CharacterViewHolder(View view, final OnItemClickListener onItemClickListener) {
            super(view);
            this.mCharNameView = (TextView) view.findViewById(R.id.charNameView);
            this.mArchetypeView = (TextView) view.findViewById(R.id.archetypeView);
            this.mCareerView = (TextView) view.findViewById(R.id.careerView);
            view.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        int adapterPosition = CharacterViewHolder.this.getAdapterPosition();
                        if (adapterPosition != -1) {
                            onItemClickListener.onItemClick(adapterPosition);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: com.wooville.genassistant.ui.main.CharacterSelectAdapter$OnItemClickListener */
    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mListener = onItemClickListener;
    }

    public ArrayList<PlayerCharacter> getCharacterList() {
        return this.mCharacterList;
    }

    public void setCharacterList(ArrayList<PlayerCharacter> arrayList) {
        this.mCharacterList = arrayList;
    }

    public CharacterSelectAdapter(ArrayList arrayList) {
        this.mCharacterList = arrayList;
    }

    @NonNull
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CharacterViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.character, viewGroup, false), this.mListener);
    }

    public void onBindViewHolder(CharacterViewHolder characterViewHolder, int i) {
        characterViewHolder.mCharNameView.setText(((PlayerCharacter) this.mCharacterList.get(i)).getCharacterName());
        characterViewHolder.mArchetypeView.setText(((PlayerCharacter) this.mCharacterList.get(i)).getArchetype());
        characterViewHolder.mCareerView.setText(((PlayerCharacter) this.mCharacterList.get(i)).getCareer());
    }

    public int getItemCount() {
        return this.mCharacterList.size();
    }
}
