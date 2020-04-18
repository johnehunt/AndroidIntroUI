package com.jjh.android.twod;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class TwoDDemoActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		layout.setLayoutParams(layoutParams);

		TextView textView = new TextView(this);
		textView.setText("Custom Widget Example");
		layout.addView(textView);
		// BasicWidget widget = new BasicWidget(this);
		// layout.addView(widget);
		// TextWidget textWidget = new TextWidget(this, "Hello World");
		// layout.addView(textWidget);
		//TextDrawable drawable = new TextDrawable("Drawable");
		//DrawableWrapperWidget wrapper = new DrawableWrapperWidget(this, drawable);
		//layout.addView(wrapper);
		DrawView drawView = new DrawView(this);
		layout.addView(drawView);
		setContentView(layout);
	}
}
