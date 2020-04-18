package com.jjh.android.twod;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;

public class DrawableWrapperWidget extends View {
	private Drawable drawable;

	public DrawableWrapperWidget(Context context, Drawable drawable) {
		super(context);
		this.drawable = drawable;
	}
	
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.RED);
		canvas.save();
		drawable.draw(canvas);
		canvas.restore();
	}
	
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		this.setMeasuredDimension(drawable.getMinimumWidth(),
				drawable.getMinimumHeight());
	}
}
