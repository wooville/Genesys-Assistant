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

import com.wooville.genassistant.adapter.SkillsDispAdapter;
import com.wooville.genassistant.model.PlayerCharacter;

/* renamed from: com.wooville.genassistant.ui.main.Tab2Skills */
public class Tab2Skills extends Fragment {
    private PlayerCharacter dummyChar;
    private Adapter mAdapter;
    private LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    public static Tab2Skills newInstance(PlayerCharacter playerCharacter) {
        Tab2Skills tab2Skills = new Tab2Skills();
        Bundle bundle = new Bundle();
        bundle.putParcelable("character", playerCharacter);
        tab2Skills.setArguments(bundle);
        return tab2Skills;
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dummyChar = (PlayerCharacter) getArguments().getParcelable("character");
        this.mLayoutManager = new LinearLayoutManager(getContext());
        this.mAdapter = new SkillsDispAdapter(getContext(), this.dummyChar.getSkillset());
        return layoutInflater.inflate(R.layout.tab2skills, viewGroup, false);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        this.mRecyclerView = (RecyclerView) getView().findViewById(R.id.skillsDispView);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
    }
}
