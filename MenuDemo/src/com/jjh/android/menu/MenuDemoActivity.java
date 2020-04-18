package com.jjh.android.menu;

import android.R.color;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MenuDemoActivity extends Activity {
	private EditText text;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		text = (EditText) findViewById(R.id.text);
		// you may register an individual context menu for each view
		registerForContextMenu(text);
	}
	
	private void populateMenu(Menu menu) {
		int groupId = 0;
		int order = 0;
		// arguments: groupId, optionId, order, title
		menu.add(groupId, 1, 1, "Red text");
		menu.add(groupId, 2, 2, "Green Text");
		menu.add(groupId, 3, 3, "Blue text");
	}

	// set the option menu for the current activity
	public boolean onCreateOptionsMenu(Menu menu) {
		// only one Option menu per activity
		populateMenu(menu);
		return super.onCreateOptionsMenu(menu);
	}

	// detect what view is calling and create its context menu
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		// decide what context menu needs to be made
		if (v.getId() == text.getId())
			// create a menu for text box
			populateMenu(menu);
	} 

	// called whenever an item in your context menu is selected
	public boolean onContextItemSelected(MenuItem item) {
		return (applyMenuOption(item) || super.onContextItemSelected(item));
	}

	// called whenever an item in your options menu is selected.
	public boolean onOptionsItemSelected(MenuItem item) {
		return (applyMenuOption(item) || super.onOptionsItemSelected(item));
	}

	// apply the action associated to selected item
	private boolean applyMenuOption(MenuItem item) {
		int menuItemId = item.getItemId(); // 1, 2, 3
		// either change color on text1 or style on text2
		if (menuItemId == 1)
			text.setTextColor(color.background_dark | Color.RED); // red
		else if (menuItemId == 2)
			text.setTextColor(0xff00ff00); // green
		else if (menuItemId == 3)
			text.setTextColor(0xff0000ff); // blue
		return false;
	} 

}