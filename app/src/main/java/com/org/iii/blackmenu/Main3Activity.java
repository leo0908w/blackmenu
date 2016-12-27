package com.org.iii.blackmenu;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView myTextView = (TextView) findViewById(R.id.textView);
        Typeface typeface=Typeface.createFromAsset(getAssets(), "fonts/gloriahalleiujah.ttf");
        myTextView.setTypeface(typeface);

    }
}
