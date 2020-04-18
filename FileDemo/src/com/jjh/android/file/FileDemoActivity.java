package com.jjh.android.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class FileDemoActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		try {
			String str = "";
			StringBuffer buf = new StringBuffer();
			InputStream is = this.getResources().openRawResource(
					R.drawable.my_base_data);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
			if (is != null) {
				while ((str = reader.readLine()) != null) {
					buf.append(str + "\n");
				}
			}
			is.close();
			Toast.makeText(this, buf.toString(), Toast.LENGTH_LONG).show();
		} catch (IOException e) {
			Toast.makeText(this, e.getMessage(), 1).show();
		}
	}

}
