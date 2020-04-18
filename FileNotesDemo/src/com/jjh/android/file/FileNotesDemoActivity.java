package com.jjh.android.file;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FileNotesDemoActivity extends Activity {
	private final static String NOTES="notes.txt";
	private EditText txtUIData;
	
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		txtUIData=(EditText)findViewById(R.id.txtUIData);
		Button btn=(Button)findViewById(R.id.close);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	public void onResume() {
		super.onResume();
		try {
			InputStream in=openFileInput(NOTES);
			if (in!=null) {
				InputStreamReader tmp=new InputStreamReader(in);
				BufferedReader reader=new BufferedReader(tmp);
				String str;
				StringBuffer buf = new StringBuffer();
				while ((str = reader.readLine()) != null) {
					buf.append(str+"\n");
				}
				in.close();
				txtUIData.setText(buf.toString());
			}
		} catch (Exception e) {
			Toast.makeText(this, e.getMessage(), 2500).show();
		}
	}
	
	public void onPause() {
		super.onPause();
		try {
			OutputStreamWriter out=
					new OutputStreamWriter(openFileOutput(NOTES, 0));
			out.write(txtUIData.getText().toString());
			out.close();		
		} catch (Exception e) { 
			Toast.makeText(this, e.getMessage(), 2000).show();
		}
	}
}