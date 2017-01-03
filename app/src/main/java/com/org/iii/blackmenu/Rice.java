package com.org.iii.blackmenu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
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
import java.util.Timer;
import java.util.TimerTask;

import static com.org.iii.blackmenu.FireBase.food;
import static com.org.iii.blackmenu.FireBase.path;
import static com.org.iii.blackmenu.FireBase.price;
import static com.org.iii.blackmenu.R.id.snap;

public class Rice extends Fragment {
    private RecyclerView mRecyclerView;
    private Activity myContext;
    private F2 f2;
    private FireBase fireBase;
    private MyHandle myHandle;
    private int count;
    private Timer timer;
    private Adapter snapAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.myContext = (Activity) context;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        f2 = new F2();
        fireBase = new FireBase();
        startRead();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rice_f1, null);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
//        mRecyclerView.addItemDecoration(new MarginDecoration(this));
//        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(myContext, 2));
        snapAdapter = new Adapter(myContext, food, path ,price);
        mRecyclerView.setAdapter(snapAdapter);

        Log.v("will", "Rice onCreateView");
        snapAdapter.setOnItemClickListener(new Adapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String app) {
                Log.v("will", "APP data: "  + app);
            }
        });

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

    public void startRead (){
        timer = new Timer();
        myHandle = new MyHandle();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                myHandle.sendEmptyMessage(0);
            }
        }, 0, 2000);

    }


    public class MyHandle extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            snapAdapter.notifyDataSetChanged();
            if (count>2){
                timer.purge();
                timer.cancel();
                timer=null;
            }
            count++;
            Log.v("will" , "timerTask" );
        }
    }
}
