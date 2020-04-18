package com.jjh.android.lists;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListsDemoActivity extends ListActivity {
	
	private final String[] testValues = new String[] {
			"Test1", "Test2", "Test3", "Test4",
			"Test5", "Test6", "Test7", "Test8"
	};
	
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String selecteditem = testValues[position];
		Toast.makeText(getBaseContext(), "Selected: " + selecteditem, Toast.LENGTH_LONG).show();
	}
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ListAdapter adapter = new ArrayAdapter<String>(
                this, 
                android.R.layout.simple_list_item_1, 
                testValues);
        setListAdapter(adapter);
    }
    
}
