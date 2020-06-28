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

import com.wooville.genassistant.adapter.GearAdapter;
import com.wooville.genassistant.model.PCCollect;
import com.wooville.genassistant.model.PlayerCharacter;

/* renamed from: com.wooville.genassistant.ui.main.Tab5GearEdit */
public class Tab5GearEdit extends Fragment {
    private PlayerCharacter dummyChar;
    private Adapter mAdapter;
    private LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    public static Tab5GearEdit newInstance(PlayerCharacter playerCharacter) {
        Tab5GearEdit tab5GearEdit = new Tab5GearEdit();
        Bundle bundle = new Bundle();
        bundle.putParcelable("character", playerCharacter);
        tab5GearEdit.setArguments(bundle);
        return tab5GearEdit;
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dummyChar = (PlayerCharacter) getArguments().getParcelable("character");
        this.mLayoutManager = new LinearLayoutManager(getContext());
        this.mAdapter = new GearAdapter(getContext(), this.dummyChar.getGear());
        return layoutInflater.inflate(R.layout.tab5gear_edit, viewGroup, false);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        this.mRecyclerView = (RecyclerView) getView().findViewById(R.id.gearView);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        ((PCCollect) getActivity()).collectPC(this.dummyChar);
    }
}
