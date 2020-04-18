package com.jjh.android.tel;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TelephonyDemoActivity extends Activity {
	public static final String NUMBER = "555-123-1234";

    private Button dialintent;
    private Button callintent;
    private Button gotoTelMgrExample;
    private Button gotoSmsExample;
    private Button gotoPnUtilsExample;

    @Override
    public void onCreate(final Bundle icicle) {
        super.onCreate(icicle);
        this.setContentView(R.layout.main);

        this.gotoTelMgrExample = (Button) findViewById(R.id.gototelmgr_button);
        this.gotoTelMgrExample.setOnClickListener(new OnClickListener() {

            public void onClick(final View v) {
                Intent intent = new Intent(TelephonyDemoActivity.this, TelephonyManagerExample.class);
                startActivity(intent);
            }
        });

        this.gotoSmsExample = (Button) findViewById(R.id.gotosms_button);
        this.gotoSmsExample.setOnClickListener(new OnClickListener() {

            public void onClick(final View v) {
                Intent intent = new Intent(TelephonyDemoActivity.this, SmsExample.class);
                startActivity(intent);
            }
        });

        this.gotoPnUtilsExample = (Button) findViewById(R.id.gotopnutils_button);
        this.gotoPnUtilsExample.setOnClickListener(new OnClickListener() {

            public void onClick(final View v) {
                Intent intent = new Intent(TelephonyDemoActivity.this, PhoneNumberUtilsExample.class);
                startActivity(intent);
            }
        });

        this.dialintent = (Button) findViewById(R.id.dialintent_button);
        this.dialintent.setOnClickListener(new OnClickListener() {

            public void onClick(final View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + TelephonyDemoActivity.NUMBER));
                startActivity(intent);
            }
        });

        this.callintent = (Button) findViewById(R.id.callintent_button);
        this.callintent.setOnClickListener(new OnClickListener() {

            public void onClick(final View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + TelephonyDemoActivity.NUMBER));
                startActivity(intent);
            }
        });
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