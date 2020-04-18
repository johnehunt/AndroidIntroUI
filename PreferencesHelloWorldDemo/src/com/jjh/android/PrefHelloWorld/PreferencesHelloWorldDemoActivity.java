package com.jjh.android.PrefHelloWorld;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PreferencesHelloWorldDemoActivity extends Activity {
	private int count = 0;
	private EditText text;
	private String msg;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		text = (EditText) findViewById(R.id.editText1);
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new ButtonHandler());

		loadPreferences();
	}
	private void savePreferences() {
	    SharedPreferences prefs = getPreferences(MODE_PRIVATE);
	    SharedPreferences.Editor editor = prefs.edit();
	    editor.putString("message", text.getText().toString());
	    editor.commit();
	}
	private void loadPreferences() {
	    SharedPreferences prefs = getPreferences(MODE_PRIVATE);
	    msg = prefs.getString("message", "Prefs Hello");
	    text.setText(msg);
	}
	
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	    if(savedInstanceState != null && savedInstanceState.containsKey("message")) {
	    	msg = savedInstanceState.getString("message");
	    	text.setText(msg);
	    }
	}

	protected void onSaveInstanceState(Bundle outState) {
		outState.putString("message", text.getText().toString());
        super.onSaveInstanceState(outState);
	}

	class ButtonHandler implements OnClickListener {
		public void onClick(View view) {
			count++;
			text.setText(msg + String.valueOf(count));
			savePreferences();
		}
	}
}
