package com.jjh.android.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class LocationDemoActivity extends MapActivity {
	private MapView mapView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mapView = (MapView) findViewById(R.id.map);
		mapView.setBuiltInZoomControls(true);

		// Need to set up location listener
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		LocationListener listener = new MyLocationListener();
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
				0, listener);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	class MyLocationListener implements LocationListener {
		public void onLocationChanged(Location loc) {
			float latitude = (float) loc.getLatitude();
			float longitude = (float) loc.getLongitude();
			MapController mapController = mapView.getController();
			GeoPoint point = new GeoPoint((int) (latitude * 1E6), (int) (longitude * 1E6));
			mapController.animateTo(point); // smooth transition to point
		}
		public void onProviderDisabled(String arg0) {
			Toast.makeText(getApplicationContext(), "GPS Disabled", Toast.LENGTH_SHORT).show();
		}
		public void onProviderEnabled(String arg0) {
			Toast.makeText(getApplicationContext(), "GPS Enabled", Toast.LENGTH_SHORT).show();
		}
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {}
	}
}
