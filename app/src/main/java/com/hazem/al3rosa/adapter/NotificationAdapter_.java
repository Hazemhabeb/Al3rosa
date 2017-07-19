package com.hazem.al3rosa.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hazem.al3rosa.R;
import com.hazem.al3rosa.activity.Products;
import com.hazem.al3rosa.model.NotificationModel;

import java.util.List;

/**
 * Created by hazem on 12/8/2016.
 */

public class NotificationAdapter_ extends RecyclerView.Adapter<NotificationAdapter_.ViewHolder> {

    List<NotificationModel> contents;
    Context mContext;


    public NotificationAdapter_(List<NotificationModel> contents, Context mContext) {
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
                .inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.image.setImageDrawable(mContext.getResources().getDrawable(contents.get(position).getImageDummy()));
        holder.text.setText(contents.get(position).getText());
        holder.back.setBackgroundColor(mContext.getColor(contents.get(position).getColorBack()));
        holder.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, Products.class));
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text;
        FrameLayout back;
        ViewHolder(View view) {
            super(view);
            image= (ImageView) view.findViewById(R.id.image);
            text = (TextView) view.findViewById(R.id.text);
            back = (FrameLayout) view.findViewById(R.id.back);
        }
    }

}