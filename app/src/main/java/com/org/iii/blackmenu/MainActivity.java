package com.org.iii.blackmenu;


import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;


public class MainActivity extends AppCompatActivity {
    private CoordinatorLayout coordinatorLayout;
    private F1 f1;
    private F2 f2;
    private FragmentManager fmr;
    private FragmentTransaction ftn;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f1 = new F1();
        f2 = new F2();
        fmr = getSupportFragmentManager();
//        ftn = fmr.beginTransaction();
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.three_buttons_activity);

        BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.three_buttons_menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(int itemId) {
                switch (itemId) {
                    case R.id.recent_item:
//                        Snackbar.make(coordinatorLayout, "Recent Item Selected", Snackbar.LENGTH_LONG).show();
                        ftn = fmr.beginTransaction();
                        ftn.replace(R.id.container, f1);
                        ftn.commit();
                        break;
                    case R.id.location_item:
//                        Snackbar.make(coordinatorLayout, "Location Item Selected", Snackbar.LENGTH_LONG).show();
                        ftn = fmr.beginTransaction();
                        ftn.replace(R.id.container, f2);
                        ftn.commit();
                        break;
                }
            }
        });

        ftn = fmr.beginTransaction();
        ftn.add(R.id.container, f1);
        ftn.commit();

        // Set the color for the active tab. Ignored on mobile when there are more than three tabs.
//        bottomBar.setActiveTabColor("#C2185B");

        // Use the dark theme. Ignored on mobile when there are more than three tabs.
//        bottomBar.useDarkTheme(true);

        // Use custom text appearance in tab titles.
//        bottomBar.setTextAppearance(R.style.MyTextAppearance);

        // Use custom typeface that's located at the "/src/main/assets" directory. If using with
        // custom text appearance, set the text appearance first.
//        bottomBar.setTypeFace("MyFont.ttf");



    }
}
