package com.jjh.android.twod;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class BasicWidget extends View {

	public BasicWidget(Context context) {
		super(context);
		this.setMinimumWidth(300);
		this.setMinimumHeight(100);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.WHITE);
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		paint.setStrokeWidth(10);
		canvas.drawLine(145, 0, 145, 100, paint);
	    paint.setColor(Color.GREEN);
	    paint.setStrokeWidth(10);
	    canvas.drawLine(0, 45, 300, 45, paint);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		this.setMeasuredDimension(this.getSuggestedMinimumWidth(),
				                  this.getSuggestedMinimumHeight());
	}

}
