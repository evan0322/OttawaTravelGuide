package com.example.travelingapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	//Declare metric
	 DisplayMetrics metric = new DisplayMetrics();
    @Override
   
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
      
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        
        ImageView topAttraction=(ImageView) findViewById(R.id.TopAttraction);
        ImageView eventCalendar=(ImageView) findViewById(R.id.EventCalendar);
        ImageView hotel=(ImageView) findViewById(R.id.Hotel);
        ImageView eatShop=(ImageView) findViewById(R.id.EatShop);
        TextView head=(TextView) findViewById(R.id.head);
        TextView toptext=(TextView) findViewById(R.id.topAttractionText);
        TextView caltext=(TextView) findViewById(R.id.calendarText);
        TextView hottext=(TextView) findViewById(R.id.hotelText);
        TextView restext=(TextView) findViewById(R.id.restaurantText);

        
        //set hight and width
        setWidth(topAttraction);
        setWidth(eventCalendar);
        setWidth(hotel);
        setWidth(eatShop);
        setWidth(toptext);
        setWidth(caltext);
        setWidth(hottext);
        setWidth(restext);

        
        setHeight(topAttraction);
        setHeight(eventCalendar);
        setHeight(hotel);
        setHeight(eatShop);
        
        //Set padding
        topAttraction.setPadding((metric.widthPixels/20), metric.widthPixels/15, metric.widthPixels/20, metric.widthPixels/15);
        eventCalendar.setPadding(metric.widthPixels/20,metric.widthPixels/15, metric.widthPixels/20, metric.widthPixels/15);
        hotel.setPadding(metric.widthPixels/20, metric.widthPixels/15, metric.widthPixels/20, metric.widthPixels/15);
        eatShop.setPadding(metric.widthPixels/20, metric.widthPixels/15, metric.widthPixels/20, metric.widthPixels/15);
        head.setPadding(0, metric.heightPixels/30, 0, 0);
        toptext.setPadding((metric.widthPixels/20), 0, metric.widthPixels/20, 0);
        caltext.setPadding(metric.widthPixels/20,0, metric.widthPixels/20, 0);
        hottext.setPadding(metric.widthPixels/20, 0, metric.widthPixels/20, 0);
        restext.setPadding(metric.widthPixels/20,0, metric.widthPixels/20, 0);

        
        //topattraction intent
        topAttraction.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Create the intent
				Intent i =new Intent();
				i.setClass(MainActivity.this, TopAttractionActivity.class);
				startActivity(i);
			}
		});
        //eventCalendar intent
        eventCalendar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i =new Intent();
				i.setClass(MainActivity.this, EventCalendarActivity.class);
				startActivity(i);
			}
		});
        //hotel intent
        hotel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i =new Intent();
				i.setClass(MainActivity.this, HotelActivity.class);
				startActivity(i);
			}
		});
        //eatShop intent
        eatShop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i =new Intent();
				i.setClass(MainActivity.this, EatShopActivity.class);
				startActivity(i);
			}
		});
    }
    /*
     * set width
     * 
     * */
    public void setWidth(View view)
    {
    	 LayoutParams linearParams = (LayoutParams) view.getLayoutParams();
    	 getWindowManager().getDefaultDisplay().getMetrics(metric);
         linearParams.width=(int)(metric.widthPixels*0.5);
    }
    /*
     * set height
     * 
     * */
    public void setHeight(View view)
    {
    	 LayoutParams linearParams = (LayoutParams) view.getLayoutParams();
    	 getWindowManager().getDefaultDisplay().getMetrics(metric);
         linearParams.height=(int)(metric.widthPixels*0.47);
    }
    
}