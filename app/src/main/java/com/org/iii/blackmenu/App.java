package com.org.iii.blackmenu;

/**
 * Created by user on 2016/12/27.
 */

public class App {

    private int mDrawable;
    private String mName;
    private int mPrice;

    public App(String name, int drawable) {
        mName = name;
        mDrawable = drawable;


    }



    public int getDrawable() {
        return mDrawable;
    }

    public String getName() {
        return mName;
    }


}