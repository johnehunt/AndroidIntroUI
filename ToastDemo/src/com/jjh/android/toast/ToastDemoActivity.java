package com.jjh.android.toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ToastDemoActivity extends Activity {
	private int count = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new ButtonHandler());
        
    }
    
    class ButtonHandler implements OnClickListener {
		public void onClick(View view) {
			count++;
			Toast toast = Toast.makeText(
					              ToastDemoActivity.this, 
					              "Clicked " + count, 
					              Toast.LENGTH_LONG);
		    toast.setGravity(Gravity.CENTER, 
		    		         toast.getXOffset() / 2, 
		    		         toast.getYOffset() / 2);
		    toast.show();
		}
    }
}
