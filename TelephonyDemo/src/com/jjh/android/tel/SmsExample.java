package com.jjh.android.tel;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Demonstrate sending SMS messages.
 */
public class SmsExample extends Activity {

    private EditText smsInputText;
    private EditText smsInputDest;
    private Button smsSend;

    @Override
    public void onCreate(final Bundle icicle) {
        Log.d(Constants.LOGTAG, "SmsExample onCreate");

        super.onCreate(icicle);
        this.setContentView(R.layout.smsexample);

        this.smsInputDest = (EditText) findViewById(R.id.smsinputdest);
        this.smsInputText = (EditText) findViewById(R.id.smsinputtext);
        this.smsSend = (Button) findViewById(R.id.smssend_button);

        this.smsSend.setOnClickListener(new OnClickListener() {

            public void onClick(final View v) {
                Log.d(Constants.LOGTAG, "SmsExample sending SMS message via manager");
                sendSMSMessage();
            }
        });
    }
    
    private void sendSMSMessage() {
    	String destination = smsInputDest.getText().toString();
        if (PhoneNumberUtils.isWellFormedSmsAddress(destination)) {
            final PendingIntent sentIntent = 
            	PendingIntent.getActivity(
            		            this, 0, new Intent(this, SmsExample.class), 0);
        	SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(destination, 
            		                   null, 
            		                   smsInputText.getText().toString(), 
            		                   sentIntent, 
            		                   null);
            Toast.makeText(SmsExample.this, "SMS message sent", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(SmsExample.this, "SMS destination invalid", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
