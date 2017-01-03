package com.org.iii.blackmenu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.org.iii.blackmenu.R.id.snap;

public class Rice extends Fragment {
    private RecyclerView mRecyclerView;
    private Activity myContext;
    private F2 f2;
    private Button button;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.myContext = (Activity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        f2 = new F2();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rice_f1, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        button = (Button) view.findViewById(R.id.test);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(myContext));
        mRecyclerView.setHasFixedSize(true);
        Log.v("will", "Rice onCreateView");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menupager fragment = new menupager();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

//        Adapter adapter = new Adapter();
//        adapter.setOnItemClickListener(new Adapter.OnRecyclerViewItemClickListener(){
//            @Override
//            public void onItemClick(View view , String app){
//                Log.v("will", "APP data: " + app);
//            }
//        });

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
        List<App> apps1 = getnoodle();

        SnapAdapter snapAdapter = new SnapAdapter(myContext);
        snapAdapter.addSnap(new Snap("定食", apps));
        snapAdapter.addSnap(new Snap("拉麵", apps1));
//        snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "濃湯", apps));
        mRecyclerView.setAdapter(snapAdapter);
    }

    private List<App> getApps() {
        List<App> apps = new ArrayList<>();
        apps.add(new App("玫瑰牛排定食", R.drawable.rice1, 100));
        apps.add(new App("多汁鯖魚定食", R.drawable.rice2, 200));
        apps.add(new App("酥脆豬排定食", R.drawable.rice3, 300));
        apps.add(new App("玫瑰牛排定食", R.drawable.rice1, 100));
        apps.add(new App("多汁鯖魚定食", R.drawable.rice2, 200));
        apps.add(new App("酥脆豬排定食", R.drawable.rice3, 300));
        apps.add(new App("玫瑰牛排定食", R.drawable.rice1, 100));
        apps.add(new App("多汁鯖魚定食", R.drawable.rice2, 200));
        apps.add(new App("酥脆豬排定食", R.drawable.rice3, 300));

        return apps;
    }

    private List<App> getnoodle() {
        List<App> apps = new ArrayList<>();
//        apps.add(new App("豚王", R.drawable.noodle1));
//        apps.add(new App("赤王", R.drawable.noodle2));
//        apps.add(new App("翠王", R.drawable.noodle3));
//        apps.add(new App("豚王", R.drawable.noodle1));
//        apps.add(new App("赤王", R.drawable.noodle2));
//        apps.add(new App("豚王", R.drawable.noodle1));
//        apps.add(new App("赤王", R.drawable.noodle2));
//        apps.add(new App("翠王", R.drawable.noodle3));

        return apps;
    }
}
