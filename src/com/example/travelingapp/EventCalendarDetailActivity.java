package com.example.travelingapp;

import com.travelingapp.entity.EventCalendarInfo;
import com.travelingapp.service.DBService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EventCalendarDetailActivity extends Activity {
	private DBService service;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eventcalendardetail);
		
		Intent i=getIntent();
		int id=i.getIntExtra("id", 1);
		
		service =new DBService(EventCalendarDetailActivity.this);
		EventCalendarInfo info=service.selectEventCalendarById(id);
		
		//Instantiate widget
		TextView title=(TextView) findViewById(R.id.detailTitle);
		TextView text=(TextView) findViewById(R.id.detailText);
		TextView content=(TextView) findViewById(R.id.detailContent);
		
		title.setText(info.getTitle());
		text.setText(info.getText());
		content.setText(info.getContent());
	}

}
