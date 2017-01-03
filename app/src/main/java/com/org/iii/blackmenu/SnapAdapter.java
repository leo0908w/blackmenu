package com.org.iii.blackmenu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class SnapAdapter extends RecyclerView.Adapter<SnapAdapter.ViewHolder>{
    private Context mContext;
    private ArrayList<Snap> mSnaps;

    public SnapAdapter(Context context) {
        mSnaps = new ArrayList<>();
        this.mContext = context;
    }

    public void addSnap(Snap snap) {
        mSnaps.add(snap);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_snap, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Snap snap = mSnaps.get(position);
        holder.snapTextView.setText(snap.getText());

        holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder
                .recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setOnFlingListener(null);

        new LinearSnapHelper().attachToRecyclerView(holder.recyclerView);
        Adapter adapter = new Adapter(snap.getApps());

        holder.recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new Adapter.OnRecyclerViewItemClickListener(){
            @Override
            public void onItemClick(View view ,String app){

                menupager fragment = new menupager();
                ToMsg us = new ToMsg();

                FragmentManager fragmentManager = ((MainActivity)mContext).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);
                us.setUserName(app);
                EventBus.getDefault().post(us);
                fragmentTransaction.commit();
                Log.v("will", "APP data: "  + app);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSnaps.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView snapTextView;
        public RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            snapTextView = (TextView) itemView.findViewById(R.id.snapTextView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }

    }
}
