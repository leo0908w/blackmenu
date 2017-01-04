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
import android.util.Log;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.BottomBarFragment;
import com.roughike.bottombar.OnMenuTabSelectedListener;
import com.roughike.bottombar.OnTabSelectedListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MainActivity extends AppCompatActivity {
    private F1 f1;
    private F2 f2;
    private FragmentManager fmr;
    private FragmentTransaction ftn;
    private FireBase fireBase;
    private BottomBar bottomBar;
    private menupager mu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fmr = getSupportFragmentManager();

        f1 = new F1();
        f2 = new F2();
        mu = new menupager();

        bottomBar = BottomBar.attach(this, savedInstanceState);

        bottomBar.setFragmentItems(getSupportFragmentManager(), R.id.container,
                new BottomBarFragment(f1, R.drawable.restaurantmenu, "菜單"),
                new BottomBarFragment(mu, R.drawable.shoppingcart, "點餐明細")
        );

        // Setting colors for different tabs when there's more than three of them.
        bottomBar.mapColorForTab(0, "#00796B");
        bottomBar.mapColorForTab(1, "#7B1FA2");

        bottomBar.setOnItemSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                switch (position) {
                    case 0:
                        // Item 1 Selected
                        ftn = fmr.beginTransaction();
                        ftn.replace(R.id.container, f1);
                        ftn.addToBackStack(null);
                        ftn.commit();
                        break;
                    case 1:
                        ftn = fmr.beginTransaction();
                        ftn.replace(R.id.container, f2);
                        ftn.addToBackStack(null);
                        ftn.commit();
                        break;
                }
            }
        });

        // Make a Badge for the first tab, with red background color and a value of "4".
        BottomBarBadge unreadMessages = bottomBar.makeBadgeForTabAt(1, "#E91E63", 5);

        // Control the badge's visibility
        unreadMessages.show();
        //unreadMessages.hide();

        // Change the displayed count for this badge.
        unreadMessages.setCount(2);

        // Change the show / hide animation duration.
//        unreadMessages.setAnimationDuration(9999999);

        // If you want the badge be shown always after unselecting the tab that contains it.
        unreadMessages.setAutoShowAfterUnSelection(true);

        fireBase = new FireBase();
        fireBase.ReadFoodBase("menuinfo");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
}
