package com.org.iii.blackmenu;

/**
 * Created by user on 2016/12/27.
 */

public class App {

    private int mDrawable;
    private String mName;
    private int mPrice;

    public App(String name, int drawable, int price) {
        mName = name;
        mDrawable = drawable;
        mPrice = price;

    }

    public int getPrice() {
        return mPrice;
    }

    public int getDrawable() {
        return mDrawable;
    }

    public String getName() {
        return mName;
    }


}