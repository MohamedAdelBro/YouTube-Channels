package com.example.internshipsegytask.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.internshipsegytask.Models.ChanelsModel;
import com.example.internshipsegytask.Models.modelClass;
import com.example.internshipsegytask.R;

import java.util.ArrayList;

public class channelsVerticalAdapter extends RecyclerView.Adapter<channelsVerticalAdapter.MoAdapter> {
    ArrayList<ChanelsModel> mChannels;
    onclick mOnclick;
    Context mContext;

    public channelsVerticalAdapter(ArrayList<ChanelsModel> mChannels, onclick mOnclick, Context mContext) {
        this.mChannels = mChannels;
        this.mOnclick = mOnclick;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MoAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.channelsview, parent, false);
        MoAdapter MoAdapter = new MoAdapter(view);
        return MoAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull MoAdapter holder, final int position) {
        holder.mName.setText(mChannels.get(position).getmName());
        Glide.with(mContext).load(mChannels.get(position).getmImage()).into(holder.mImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mChannels.get(position).getmName().equalsIgnoreCase("Trailers")) {
                    mOnclick.on_click("Trailers");
                } else if (mChannels.get(position).getmName().equalsIgnoreCase("Sia Furler")) {
                    mOnclick.on_click("Sia Furler");
                } else if (mChannels.get(position).getmName().equalsIgnoreCase("Lost Leblanc")) {
                    mOnclick.on_click("Lost Leblanc");
                } else if (mChannels.get(position).getmName().equalsIgnoreCase("Storror Blog")) {
                    mOnclick.on_click("Storror Blog");
                } else if (mChannels.get(position).getmName().equalsIgnoreCase("Space")) {
                    mOnclick.on_click("Space");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mChannels.size();
    }

    class MoAdapter extends RecyclerView.ViewHolder {

        TextView mName;
        ImageView mImage;

        public MoAdapter(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.mChannelImg);
            mName = itemView.findViewById(R.id.mChannelTxt);
        }
    }

    public interface onclick {
        void on_click(String Name);
    }
}