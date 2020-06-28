package com.wooville.genassistant.tab;

import com.wooville.genassistant.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import com.wooville.genassistant.adapter.TalentDispAdapter;
import com.wooville.genassistant.model.PlayerCharacter;

/* renamed from: com.wooville.genassistant.ui.main.Tab3Talents */
public class Tab3Talents extends Fragment {
    private PlayerCharacter dummyChar;
    private Adapter mAdapter;
    private LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    public static Tab3Talents newInstance(PlayerCharacter playerCharacter) {
        Tab3Talents tab3Talents = new Tab3Talents();
        Bundle bundle = new Bundle();
        bundle.putParcelable("character", playerCharacter);
        tab3Talents.setArguments(bundle);
        return tab3Talents;
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dummyChar = (PlayerCharacter) getArguments().getParcelable("character");
        this.mLayoutManager = new LinearLayoutManager(getContext());
        this.mAdapter = new TalentDispAdapter(this.dummyChar.getTalents());
        return layoutInflater.inflate(R.layout.tab3talents, viewGroup, false);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        this.mRecyclerView = (RecyclerView) getView().findViewById(R.id.talentsDispView);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
    }
}
