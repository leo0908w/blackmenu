package com.org.iii.blackmenu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rice extends Fragment {
    private RecyclerView mRecyclerView;
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
        View view = inflater.inflate(R.layout.rice_f1, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(myContext));
        mRecyclerView.setHasFixedSize(true);
        Log.v("will", "Rice onCreateView");

        setupAdapter();
        return view;
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void onStart() {
        super.onStart();
//        Log.v("will", "Rice onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
//        Log.v("will", "Rice onResume");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Log.v("will", "Rice onActivityCreated");
    }

    private void setupAdapter() {
        List<App> apps = getApps();

        SnapAdapter snapAdapter = new SnapAdapter();
        snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "定食", apps));
//        snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "拉麵", apps));
//        snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "濃湯", apps));
        mRecyclerView.setAdapter(snapAdapter);
    }

    private List<App> getApps() {
        List<App> apps = new ArrayList<>();
        apps.add(new App("玫瑰牛排定食", R.drawable.rice1));
        apps.add(new App("多汁鯖魚定食", R.drawable.rice2));
        apps.add(new App("酥脆豬排定食", R.drawable.rice3));
        apps.add(new App("玫瑰牛排定食", R.drawable.rice1));
        apps.add(new App("多汁鯖魚定食", R.drawable.rice2));
        apps.add(new App("酥脆豬排定食", R.drawable.rice3));
        apps.add(new App("玫瑰牛排定食", R.drawable.rice1));
        apps.add(new App("多汁鯖魚定食", R.drawable.rice2));
        apps.add(new App("酥脆豬排定食", R.drawable.rice3));

        return apps;
    }


}
