package com.jjh.android.email;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EmailDemoActivity extends Activity {
	private EditText to;
	private EditText subject;
	private EditText body;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		to = (EditText)findViewById(R.id.to);
		subject = (EditText)findViewById(R.id.subject);
		body = (EditText)findViewById(R.id.body);
		
		Button button  = (Button) findViewById(R.id.button);
		button.setOnClickListener(new ButtonHandler());
	}
	
	private void sendEmail() {
		Intent intent = new Intent(Intent.ACTION_SEND); 
		intent.setType("text/plain");
		//intent.setType("message/rfc822"); // Will ensure only email clients listed
		intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to.getEditableText().toString()});  
		intent.putExtra(Intent.EXTRA_SUBJECT, subject.getEditableText().toString()); 
		intent.putExtra(Intent.EXTRA_TEXT, body.getEditableText().toString()); 
        intent.setData(Uri.parse("john.hunt10@googlemail.com"));
        startActivity(Intent.createChooser(intent, "Send email using"));
	}
	
    class ButtonHandler implements OnClickListener {
		public void onClick(View arg0) {
			sendEmail();
		}
    }
}
