package com.jjh.android.db;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HelloFriendsDbDemoActivity extends Activity {

	private HelloWorldDAO dao = new HelloWorldDAO(this);
	private EditText name;
	private EditText age;
	private EditText friendsView;

	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        
	        name = (EditText)findViewById(R.id.name);
	        age = (EditText)findViewById(R.id.age);
	        Button button = (Button) findViewById(R.id.button1);
	        button.setOnClickListener(new ButtonHandler());
	        friendsView = (EditText)findViewById(R.id.friends);
            
	        dao.open();
	}

	protected void onStop() {
		super.onStop();
		dao.close();
	}

	private void refreshFriends() {
		StringBuilder builder = new StringBuilder();
		List<Friend> friends = dao.getFriends();
		for (Friend f : friends) {
			builder.append(f.name + " : " + f.age + "\n");
		}
		friendsView.setText(builder.toString());
	}

	class ButtonHandler implements OnClickListener {
		public void onClick(View view) {
			String friend = name.getText().toString();
			int years = Integer.parseInt(age.getText().toString());
			dao.insertFriend(friend, years);
			refreshFriends();
		}
	}
}

class Friend {
	String name;
	int age;
}