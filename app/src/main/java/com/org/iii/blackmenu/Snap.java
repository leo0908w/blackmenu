package com.org.iii.blackmenu;

import java.util.List;


public class Snap {

    private String mText;
    private List<App> mApps;

    public Snap(String text, List<App> apps) {
        mText = text;
        mApps = apps;
    }

    public String getText(){
        return mText;
    }

    public List<App> getApps(){
        return mApps;
    }

}
