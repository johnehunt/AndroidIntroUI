package com.jjh.android.dates;

import java.text.DateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class DatePickerDemoActivity extends Activity {
	private DateFormat dateFormat = DateFormat.getDateInstance();
	private TextView dateTextView;
	private Calendar calendar = Calendar.getInstance();
	private OnDateSetListener dateSetCallback;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);

		dateTextView = (TextView) findViewById(R.id.lblDateAndTime);
		dateSetCallback = new DateChangeCallback();

		Button btnDate = (Button) findViewById(R.id.btnDate);
		btnDate.setOnClickListener(new ButtonHandler());

		updateLabel();
	}

	private void updateLabel() {
		dateTextView.setText(dateFormat.format(calendar.getTime()));
	}

	class ButtonHandler implements OnClickListener {
		public void onClick(View v) {
			DatePickerDialog dateDialog = new DatePickerDialog(
					DatePickerDemoActivity.this, dateSetCallback,
					calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
					calendar.get(Calendar.DAY_OF_MONTH));
			dateDialog.show();
		}
	}

	class DateChangeCallback implements OnDateSetListener {
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, monthOfYear);
			calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			updateLabel();
		}
	}

}