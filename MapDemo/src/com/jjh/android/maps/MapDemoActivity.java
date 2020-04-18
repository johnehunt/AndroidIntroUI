package com.jjh.android.maps;

import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MapDemoActivity extends MapActivity {
	
	private MapView mapView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mapView = (MapView) findViewById(R.id.map);
        mapView.setBuiltInZoomControls(true);
    }
    
    @Override
    protected boolean isRouteDisplayed() {
    	// needed by interface, not used here
        return false;
    }
}
