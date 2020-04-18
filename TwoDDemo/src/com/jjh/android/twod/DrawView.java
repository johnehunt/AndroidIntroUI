package com.jjh.android.twod;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DrawView extends View implements OnTouchListener {
	List<Point> points = new ArrayList<Point>();
	Paint paint = new Paint();

	public DrawView(Context context) {
		super(context);
		setFocusable(true);
		setFocusableInTouchMode(true);
		this.setOnTouchListener(this);
		paint.setColor(Color.WHITE);
		paint.setAntiAlias(true);
	}

	public void onDraw(Canvas canvas) {
		for (Point point : points)
			canvas.drawCircle(point.x, point.y, 5, paint);
	}

	public boolean onTouch(View view, MotionEvent event) {
		Point point = new Point();
		point.x = event.getX();
		point.y = event.getY();
		points.add(point);
		this.invalidate(); // cause a redraw
		return true;
	}

	private class Point {
		float x, y;
	}
}
