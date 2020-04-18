package com.jjh.android.fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DateTime extends Fragment {
	private String time;

	public void onCreate(Bundle state) {
		super.onCreate(state);
		if (time == null) {
			time = new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(new Date());
		}
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		TextView view = new TextView(this.getActivity());
		view.setText(time);
		return view;
	}
	
}

