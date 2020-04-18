package com.jjh.android.db;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

public class HelloWorldDAO {

	private SQLiteDatabase db;
	private Activity activity;

	public HelloWorldDAO(Activity activity) {
		this.activity = activity;

	}

	public void close() {
		db.close();
	}

	public void open() {
		try {
			db = activity.openOrCreateDatabase("friendsDB",
					Activity.MODE_PRIVATE, null);
			db.beginTransaction();
			db.execSQL("create table friends ("
					+ " id integer PRIMARY KEY autoincrement, " 
			        + " name  text, " 
			        + " age integer );  ");
			db.execSQL( "insert into friends(name, age) "
			         + " values ('John', 47 );" );
			//commit your changes
    		db.setTransactionSuccessful();
    		this.getTotalFriends();
			Toast.makeText(activity, "All done!", 1).show();
		} catch (SQLiteException e) {
			Toast.makeText(activity, e.getMessage(), 1).show();
		} finally {
    		db.endTransaction();
    	}
	}

	public long insertFriend(String name, int age) {
		ContentValues newValues = new ContentValues();
		newValues.put("name", name);
		newValues.put("age", age);
		if (db == null) {
			open();
		}
		return db.insert("friends", null, newValues);
	}

	private void getTotalFriends() {
    	try {
    		//hard-coded SQL select with no arguments
			String mySQL ="select count(*) as Total from friends";
			Cursor c1 = db.rawQuery(mySQL, null);
			int index = c1.getColumnIndex("Total");
			//advance to the next record (first rec. if necessary)
			c1.moveToNext();
			int theTotal = c1.getInt(index);
			Toast.makeText(activity, "Total: " + theTotal, 1).show();
		} catch (Exception e) {
			Toast.makeText(activity, e.getMessage(), 1).show();
		}    	
    }
	
	public List<Friend> getFriends() {
		Cursor cursor = db.query("friends", null, null, null, null, null, null);
		List<Friend> list = new ArrayList<Friend>();
		while (cursor.moveToNext()) {
			String name = cursor.getString(1);
			int age = cursor.getInt(2);
			Friend friend = new Friend();
			friend.name = name;
			friend.age = age;
			list.add(friend);
		}
		return list;
	}

}
