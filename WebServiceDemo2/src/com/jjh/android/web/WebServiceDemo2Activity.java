package com.jjh.android.web;

import java.io.InputStream;
import java.net.URI;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class WebServiceDemo2Activity extends Activity {
	private static final String url = "http://www.webservicex.net/CurrencyConvertor.asmx/"
			+ "ConversionRate?FromCurrency=GBP&ToCurrency=USD";
	private EditText text;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		text = (EditText) findViewById(R.id.amount);
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new ButtonHandler());
	}

	private String getExchangeRate() {
		String strResponseData = "";
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			URI uri = new URI(url);
			HttpGet methodGet = new HttpGet(uri);
			HttpResponse response = client.execute(methodGet);
			strResponseData = generateString(response.getEntity().getContent());	
		} catch (NullPointerException e) {
			Log.e("<<WebServiceDemo2Activity>>", e.getStackTrace().toString());
		} catch (Exception e) {
			Log.e("<<WebServiceDemo2Activity>>", e.getClass().getCanonicalName());
		}
		return strResponseData;
	}

	private String generateString(InputStream stream) throws Exception {
		// define a document builder to act on incoming stream
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		// make XML parse tree for incoming stream
		Document dom = db.parse(stream);
		// define access nodes in the parse tree
		Element docEle = dom.getDocumentElement();
		String result = docEle.getFirstChild().getNodeValue();
		return result;
	}
	
	private class GetDataTask extends AsyncTask<Void, Void, Void> {
	      private String response = "";
	      protected void onPreExecute() { }

	      protected Void doInBackground(Void ... args) {
	    	 response = getExchangeRate();
	         return null;
	      }

	      protected void onPostExecute(final Void unused) {
	    	  text.setText(response);
			  Log.d("<<GetDataTask>>","6");
	      }
	   }

	class ButtonHandler implements OnClickListener {
		public void onClick(View view) {
			new GetDataTask().execute();
		}
	}
}