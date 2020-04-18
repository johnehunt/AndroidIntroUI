package com.jjh.android.submenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;

public class SubMenuDemoActivity extends Activity {
	private EditText text;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		text = (EditText) findViewById(R.id.etMessage1);
		// you may register an individual context menu for each view
		registerForContextMenu(text);
	}

	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		// create a menu for text box
		// .addSubMenu(int groupId, int itemId, int order, CharSequence title)
		int smGroupId = 0; // don't care, same as Menu.NONE
		SubMenu mySubMenu5 = menu.addSubMenu(0, 1, 1, "Sub-Menu");
		// .add(int groupId, int itemId, int order, CharSequence title)
		mySubMenu5.add(smGroupId, 1, 1, "Sub Menu-1");
		mySubMenu5.add(smGroupId, 1, 2, "Sub Menu-2");
		mySubMenu5.add(smGroupId, 1, 3, "Sub Menu-3");
	}

	public boolean onContextItemSelected(MenuItem item) {
		return (applyMenuOption(item));
	}

	private boolean applyMenuOption(MenuItem item) {
		int menuItemId = item.getItemId();
		text.setText("You have selected: \n" + item.getTitle() + "\nId: "
				+ menuItemId + " order: " + item.getOrder());
		return false;
	}

}