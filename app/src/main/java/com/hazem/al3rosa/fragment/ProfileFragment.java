package com.hazem.al3rosa.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hazem.al3rosa.R;
import com.hazem.al3rosa.activity.ElaymaActivity;

public class ProfileFragment extends BaseFragment implements View.OnClickListener {

    //init the views
    Button aymaBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initViews(view);
        attachListeners();
        return view;
    }

    @Override
    public void onLowMemory() {
    }

    @Override
    public void initViews(View view) {
        aymaBtn= (Button) view.findViewById(R.id.aymaBtn);
    }




    @Override
    public void attachListeners() {
        aymaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ElaymaActivity.class));
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        }
    }

}
