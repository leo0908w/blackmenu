package com.org.iii.blackmenu;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.R.attr.typeface;

public class Main2Activity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    public static final String ORIENTATION = "orientation";

    private RecyclerView mRecyclerView;
    private boolean mHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        if (savedInstanceState == null) {
            mHorizontal = true;
        } else {
            mHorizontal = savedInstanceState.getBoolean(ORIENTATION);
        }

        setupAdapter();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ORIENTATION, mHorizontal);
    }

    private void setupAdapter() {
        List<App> apps = getApps();

        SnapAdapter snapAdapter = new SnapAdapter();
        if (mHorizontal) {
            snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "Snap center", apps));
//            snapAdapter.addSnap(new Snap(Gravity.START, "Snap start", apps));
//            snapAdapter.addSnap(new Snap(Gravity.END, "Snap end", apps));
//            snapAdapter.addSnap(new Snap(Gravity.CENTER, "Pager snap", apps));
        } else {
            snapAdapter.addSnap(new Snap(Gravity.CENTER_VERTICAL, "Snap center", apps));
//            snapAdapter.addSnap(new Snap(Gravity.TOP, "Snap top", apps));
//            snapAdapter.addSnap(new Snap(Gravity.BOTTOM, "Snap bottom", apps));
        }

        mRecyclerView.setAdapter(snapAdapter);
    }

    private List<App> getApps() {
        List<App> apps = new ArrayList<>();
        apps.add(new App("Google+", R.drawable.rice2));
        apps.add(new App("Gmail", R.drawable.rice2));
        apps.add(new App("Inbox", R.drawable.rice2));
        apps.add(new App("Google Keep", R.drawable.rice2));
        apps.add(new App("Google Drive", R.drawable.rice2));
        apps.add(new App("Hangouts", R.drawable.rice2));
        apps.add(new App("Google Photos", R.drawable.rice2));
        apps.add(new App("Messenger", R.drawable.rice2));
        apps.add(new App("Sheets", R.drawable.rice2));
        apps.add(new App("Slides", R.drawable.rice2));
        apps.add(new App("Docs", R.drawable.rice2));
        return apps;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.layoutType) {
            mHorizontal = !mHorizontal;
            setupAdapter();
            item.setTitle(mHorizontal ? "Vertical" : "Horizontal");
        }
        return false;
    }
}
