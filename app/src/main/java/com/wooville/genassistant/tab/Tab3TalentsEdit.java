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

import com.wooville.genassistant.adapter.TalentAdapter;
import com.wooville.genassistant.model.PCCollect;
import com.wooville.genassistant.model.PlayerCharacter;

/* renamed from: com.wooville.genassistant.ui.main.Tab3TalentsEdit */
public class Tab3TalentsEdit extends Fragment {
    private PlayerCharacter dummyChar;
    private Adapter mAdapter;
    private LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    public static Tab3TalentsEdit newInstance(PlayerCharacter playerCharacter) {
        Tab3TalentsEdit tab3TalentsEdit = new Tab3TalentsEdit();
        Bundle bundle = new Bundle();
        bundle.putParcelable("character", playerCharacter);
        tab3TalentsEdit.setArguments(bundle);
        return tab3TalentsEdit;
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dummyChar = (PlayerCharacter) getArguments().getParcelable("character");
        this.mLayoutManager = new LinearLayoutManager(getContext());
        this.mAdapter = new TalentAdapter(this.dummyChar.getTalents());
        return layoutInflater.inflate(R.layout.tab3talents_edit, viewGroup, false);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        this.mRecyclerView = (RecyclerView) getView().findViewById(R.id.talentsView);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        ((PCCollect) getActivity()).collectPC(this.dummyChar);
    }
}
