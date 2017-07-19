package com.hazem.al3rosa.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hazem.al3rosa.R;
import com.hazem.al3rosa.model.AymaModel;

import java.util.List;

/**
 * Created by hazem on 12/8/2016.
 */

public class AymaAdapter extends RecyclerView.Adapter<AymaAdapter.ViewHolder> {

    List<AymaModel> contents;
    Context mContext;


    public AymaAdapter(List<AymaModel> contents, Context mContext) {
        this.contents = contents;
        this.mContext = mContext;
    }


    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;


        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ayma, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


//        holder.back.setBackgroundColor(mContext.getColor(contents.get(position).getColorBack()));
//        holder.back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mContext.startActivity(new Intent(mContext, Products.class));
//            }
//        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
//
//        ImageView image;
//        TextView text;
//        FrameLayout back;
        ViewHolder(View view) {
            super(view);
//            image= (ImageView) view.findViewById(R.id.image);
//            text = (TextView) view.findViewById(R.id.text);
//            back = (FrameLayout) view.findViewById(R.id.back);
        }
    }

}