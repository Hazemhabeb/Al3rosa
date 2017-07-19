package com.hazem.al3rosa.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hazem.al3rosa.R;
import com.hazem.al3rosa.adapter.AymaAdapter;
import com.hazem.al3rosa.model.AymaModel;

import java.util.ArrayList;
import java.util.List;

public class ElaymaActivity extends AppCompatActivity {



    //initial views
    private RecyclerView.Adapter mAdapter;
    private List<AymaModel> mContentItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elayma);


        //initial views
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvCards);
        RecyclerView.LayoutManager
                layoutManager = new LinearLayoutManager(ElaymaActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new AymaAdapter(mContentItems, ElaymaActivity.this);
        recyclerView.setAdapter(mAdapter);
        dummy();
    }

    /**
     * here the dummy data to create the initial design
     */
    private void dummy(){
        mContentItems.add(new AymaModel());mContentItems.add(new AymaModel());
        mContentItems.add(new AymaModel());mContentItems.add(new AymaModel());
        mContentItems.add(new AymaModel());mContentItems.add(new AymaModel());
        mContentItems.add(new AymaModel());mContentItems.add(new AymaModel());
        mContentItems.add(new AymaModel());mContentItems.add(new AymaModel());
    }
}
