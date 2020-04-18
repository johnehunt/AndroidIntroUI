package com.jjh.android.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DialogDemoActivity extends Activity {
	private EditText txtMsg;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		txtMsg = (EditText) findViewById(R.id.txtMsg);

		Button button = (Button) findViewById(R.id.btnGo);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				Builder builder = new AlertDialog.Builder(DialogDemoActivity.this);
				builder.setTitle("Exit");
				builder.setMessage("Do you wish to Exit?");
				// set three option buttons
				builder.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								String msg = "YES " + Integer.toString(whichButton);
								txtMsg.setText(msg);
							}
						});
				builder.setNeutralButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								String msg = "CANCEL " + Integer.toString(whichButton);
								txtMsg.setText(msg);
							}
						});
				builder.setNegativeButton("NO",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								String msg = "NO " + Integer.toString(whichButton);
								txtMsg.setText(msg);
							}
						});
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
	}
}
