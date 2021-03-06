package com.jjh.android.views;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class ViewsHelloWorldActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Resources res = getResources();
		// Resource object to get Drawables
		TabHost tabHost = getTabHost();
		// The activity TabHost
		TabHost.TabSpec spec;
		// Resusable TabSpec for each tab
		Intent intent;
		// Reusable Intent for each tab
		// Create an Intent to launch an Activity for the tab (to be reused)
		intent = new Intent().setClass(this, TableActivity.class);
		// Initialize a TabSpec for each tab and add it to the TabHost
		spec = tabHost
				.newTabSpec("table")
				.setIndicator("table",
						res.getDrawable(R.drawable.ic_tab_artists))
				.setContent(intent);
		tabHost.addTab(spec);
		// Do the same for the other tabs

		tabHost.setCurrentTab(2);
	}
}