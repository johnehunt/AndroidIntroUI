package com.jjh.android.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class WebServiceDemoActivity extends Activity {
	private static final String url = "http://www.webservicex.net/CurrencyConvertor.asmx/" +
        "ConversionRate?FromCurrency=GBP&ToCurrency=USD";
	private EditText text;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text = (EditText)findViewById(R.id.amount);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new ButtonHandler());
    }
	
	private void getExchangeRate() {
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			URI uri = new URI(url);
			HttpGet methodGet = new HttpGet(uri);
			HttpResponse response = client.execute(methodGet);
			String strResponseData = generateString(response.getEntity().getContent());
			text.setText(strResponseData);
		} catch (Exception e) {
			Log.e("<<ERROR_VERSION2>>", e.getMessage());
		}
	}
	
	private String generateString(InputStream stream) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
		StringBuilder builder = new StringBuilder();
		try {
			String currentLine = "";
			while ((currentLine = buffer.readLine()) != null) {
				builder.append(currentLine + "\n");
			}
			stream.close();
		} catch (IOException e) {
			Log.e("<<ERROR2_1>>", e.getMessage());
		}
		return builder.toString();
	}
    
    class ButtonHandler implements OnClickListener {
		public void onClick(View view) {
			getExchangeRate();
		}
    }
}