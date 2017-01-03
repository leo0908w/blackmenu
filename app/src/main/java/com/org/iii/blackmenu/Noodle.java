package com.org.iii.blackmenu;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/12/23.
 */

public class Noodle extends Fragment {
    public static final String ORIENTATION = "orientation";

    private RecyclerView mRecyclerView;
    private boolean mHorizontal;
    private FragmentActivity myContext;

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myContext = (FragmentActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.noodle_f2, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(myContext));
        mRecyclerView.setHasFixedSize(true);
        Log.v("will", "Noodle onCreateView");
        setupAdapter();
        return view;
    }

    private void setupAdapter() {
//        List<App> apps = getApps();

//        SnapAdapter snapAdapter = new SnapAdapter(myContext);
//        snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "定食", apps));
//        snapAdapter.addSnap(new Snap("拉麵", apps));
//        snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "拉麵", apps));
//        mRecyclerView.setAdapter(snapAdapter);
    }

//    private List<App> getApps() {
//        List<App> apps = new ArrayList<>();
//        apps.add(new App("豚王", R.drawable.noodle1));
//        apps.add(new App("赤王", R.drawable.noodle2));
//        apps.add(new App("翠王", R.drawable.noodle3));
//        apps.add(new App("豚王", R.drawable.noodle1));
//        apps.add(new App("赤王", R.drawable.noodle2));
//        apps.add(new App("豚王", R.drawable.noodle1));
//        apps.add(new App("赤王", R.drawable.noodle2));
//        apps.add(new App("翠王", R.drawable.noodle3));

//        return apps;
    }
//}

