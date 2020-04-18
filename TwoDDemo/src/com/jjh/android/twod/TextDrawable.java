package com.jjh.android.twod;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

public class TextDrawable extends Drawable {
	private String text;
    public TextDrawable(String text) {
		super();
		this.text = text;
	}
	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		canvas.drawText(text, 25, 25, paint);
	}
	public int getOpacity() {
		return PixelFormat.OPAQUE;
	}
	public void setAlpha(int alpha) {}
	public void setColorFilter(ColorFilter filter) {}

    
	public int getMinimumHeight() {
		return 50;
	}

	public int getMinimumWidth() {
		return 150;
	}
}

