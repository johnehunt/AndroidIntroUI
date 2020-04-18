package com.jjh.android.twod;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class TextWidget extends View {
    private String text;
	public TextWidget(Context context, String text) {
		super(context);
		this.text = text;
		this.setMinimumWidth(300);
		this.setMinimumHeight(100);
	}
	
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.WHITE);
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		canvas.drawText(text, 25, 30, paint);
	}
	
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		this.setMeasuredDimension(this.getSuggestedMinimumWidth(),
				                  this.getSuggestedMinimumHeight());
	}

}
