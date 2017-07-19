package com.hazem.al3rosa.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hazem.al3rosa.R;
import com.hazem.al3rosa.adapter.NotificationAdapter_;
import com.hazem.al3rosa.model.NotificationModel;

import java.util.ArrayList;
import java.util.List;

public class dummyFragment extends BaseFragment implements View.OnClickListener {


    //initial views
    private RecyclerView.Adapter mAdapter;
    private List<NotificationModel> mContentItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dummy, container, false);
        initViews(view);
        attachListeners();
        return view;
    }

    @Override
    public void onLowMemory() {
    }

    @Override
    public void initViews(View view) {
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvCards);
        RecyclerView.LayoutManager
                layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new NotificationAdapter_(mContentItems, getActivity());
        recyclerView.setAdapter(mAdapter);
        dummy();
    }

    private void dummy(){
        mContentItems.clear();
        mContentItems.add(new NotificationModel("الأجهزة",R.drawable.fridge_filled,R.color.a3));
        mContentItems.add(new NotificationModel("المطبخ",R.drawable.pot_mix,R.color.a4));
        mContentItems.add(new NotificationModel("المفروشات",R.drawable.paper_cut_vertical,R.color.a9));
        mContentItems.add(new NotificationModel("الأثاث",R.drawable.readability,R.color.a6));
        mContentItems.add(new NotificationModel("الكماليات",R.drawable.lamp,R.color.a8));
        mContentItems.add(new NotificationModel("الملابس",R.drawable.hanger,R.color.a17));
    }


    @Override
    public void attachListeners() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        }
    }

}
