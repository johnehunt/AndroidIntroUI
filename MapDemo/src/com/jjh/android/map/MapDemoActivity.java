package com.jjh.android.map;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapDemoActivity extends MapActivity {
	MapView  mapview;
	MyOverlayGroup myoverlay;	
	Drawable drawable;
	List<Overlay> overlayList;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mapview = (MapView)findViewById(R.id.map);        
        mapview.setBuiltInZoomControls(true);
        overlayList = mapview.getOverlays();
        
        drawable = this.getResources().getDrawable(R.drawable.ic_little_android);
        myoverlay = new MyOverlayGroup(drawable, this);
        
        OverlayItem item1 = new OverlayItem(new GeoPoint(41501719, -81675140), 
        						"Hello from Cleveland", 
        						"Greetings...");
        myoverlay.addItem(item1);
        
        
        OverlayItem item2 = new OverlayItem(new GeoPoint(9933056, -84083056), 
								"Hola desde San Jose", 
								"Pura Vida!");
        myoverlay.addItem(item2);
        
        overlayList.add(myoverlay);
    }

	@Override
	protected boolean isRouteDisplayed() {
		// needed by interface, not used here
		return false;
	}

}