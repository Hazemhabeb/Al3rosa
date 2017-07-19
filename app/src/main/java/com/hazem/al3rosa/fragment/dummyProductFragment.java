package com.hazem.al3rosa.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hazem.al3rosa.R;
import com.hazem.al3rosa.adapter.dummyProductAdapter;
import com.hazem.al3rosa.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class dummyProductFragment extends BaseFragment implements View.OnClickListener {


    //initial views
    private RecyclerView.Adapter mAdapter;
    private List<ProductModel> mContentItems = new ArrayList<>();

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
//        RecyclerView.LayoutManager
//                layoutManager = new GridLayoutManager(getActivity(),3);
//        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));



        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new dummyProductAdapter(mContentItems, getActivity());
        recyclerView.setAdapter(mAdapter);
        dummy();
    }

    private void  dummy(){
        mContentItems.add(new ProductModel("Fridges & Freezers",R.drawable.product_dummy));
        mContentItems.add(new ProductModel("Commercial Deep Fryers ",R.drawable.test1));
        mContentItems.add(new ProductModel("Charbroilers and Grills kitchen",R.drawable.test2));

        mContentItems.add(new ProductModel("Fridges & Freezers",R.drawable.product_dummy));
        mContentItems.add(new ProductModel("Commercial Deep Fryers",R.drawable.test1));
        mContentItems.add(new ProductModel("Charbroilers and Grills",R.drawable.test2));

        mContentItems.add(new ProductModel("Fridges & Freezers",R.drawable.product_dummy));
        mContentItems.add(new ProductModel("Commercial Deep Fryers",R.drawable.test1));
        mContentItems.add(new ProductModel("Charbroilers and Grills",R.drawable.test2));

        mContentItems.add(new ProductModel("Fridges & Freezers",R.drawable.product_dummy));
        mContentItems.add(new ProductModel("Commercial Deep Fryers",R.drawable.test1));
        mContentItems.add(new ProductModel("Charbroilers and Grills",R.drawable.test2));

        mContentItems.add(new ProductModel("Fridges & Freezers",R.drawable.product_dummy));
        mContentItems.add(new ProductModel("Commercial Deep Fryers",R.drawable.test1));
        mContentItems.add(new ProductModel("Charbroilers and Grills",R.drawable.test2));

        mContentItems.add(new ProductModel("Fridges & Freezers",R.drawable.product_dummy));
        mContentItems.add(new ProductModel("Commercial Deep Fryers",R.drawable.test1));
        mContentItems.add(new ProductModel("Charbroilers and Grills",R.drawable.test2));

        mContentItems.add(new ProductModel("Fridges & Freezers",R.drawable.product_dummy));
        mContentItems.add(new ProductModel("Commercial Deep Fryers",R.drawable.test1));
        mContentItems.add(new ProductModel("Charbroilers and Grills",R.drawable.test2));
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
