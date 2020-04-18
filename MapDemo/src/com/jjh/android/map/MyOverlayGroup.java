package com.jjh.android.map;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class MyOverlayGroup	extends ItemizedOverlay {
    private ArrayList<OverlayItem> items = new ArrayList<OverlayItem>();
    Context  mapcontext;
           
	public MyOverlayGroup(Drawable defaultMarker, Context appContext) {
		super(boundCenterBottom(defaultMarker));
		mapcontext = appContext;	
	}

	public void addItem( OverlayItem item){
		items.add(item);
		populate();
	}
		
	@Override
	protected OverlayItem createItem(int i) {
		return items.get(i);
	}

	@Override
	public int size() {		
		return items.size();
	}

	@Override
	protected boolean onTap(int index) {
		String text = items.get(index).getTitle() + "\n" + items.get(index).getSnippet();
		Toast.makeText(mapcontext, text, 1).show();
		return super.onTap(index);
	}

	
}

