package com.jjh.android.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ProgrammaticActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("Programmatic Display!");
        setContentView(tv);
    }
}
