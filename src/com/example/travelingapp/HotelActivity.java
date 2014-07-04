package com.example.travelingapp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class HotelActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hotel);
		//Instantiate widget
		ImageView img11=(ImageView) findViewById(R.id.img11);
		ImageView img12=(ImageView) findViewById(R.id.img12);
		ImageView img13=(ImageView) findViewById(R.id.img13);
		ImageView img14=(ImageView) findViewById(R.id.img14);
		ImageView img15=(ImageView) findViewById(R.id.img15);
	
	
		
		
		TextView txt11=(TextView) findViewById(R.id.txt11);
		TextView txt12=(TextView) findViewById(R.id.txt12);
		TextView txt13=(TextView) findViewById(R.id.txt13);
		TextView txt14=(TextView) findViewById(R.id.txt14);
		TextView txt15=(TextView) findViewById(R.id.txt15);

		
		//Set intent to widget
		img11.setOnClickListener(new MyOnClickListener(HotelActivity.this, HotelDetailActivity.class,R.raw.laurier,10));
		txt11.setOnClickListener(new MyOnClickListener(HotelActivity.this, HotelDetailActivity.class,R.raw.laurier,10));
		
		img12.setOnClickListener(new MyOnClickListener(HotelActivity.this, HotelDetailActivity.class,R.drawable.courtyard01,11));
		txt12.setOnClickListener(new MyOnClickListener(HotelActivity.this, HotelDetailActivity.class,R.drawable.courtyard01,11));
		
		img13.setOnClickListener(new MyOnClickListener(HotelActivity.this, HotelDetailActivity.class,R.raw.indigo,12));
		txt13.setOnClickListener(new MyOnClickListener(HotelActivity.this, HotelDetailActivity.class,R.raw.indigo,12));
		
		img14.setOnClickListener(new MyOnClickListener(HotelActivity.this, HotelDetailActivity.class,R.drawable.westin01,13));
		txt14.setOnClickListener(new MyOnClickListener(HotelActivity.this, HotelDetailActivity.class,R.drawable.westin01,13));
		
		img15.setOnClickListener(new MyOnClickListener(HotelActivity.this, HotelDetailActivity.class,R.drawable.westin01,14));
		txt15.setOnClickListener(new MyOnClickListener(HotelActivity.this, HotelDetailActivity.class,R.drawable.westin01,14));
		
		
		
	}

	class MyOnClickListener implements OnClickListener {
		private Class <?> cls;
		private Context con;
		private int mediaId;
		private int id;
		public MyOnClickListener(Context con,Class <?> cls,int mediaId,int id)
		{
			this.cls=cls;
			this.con=con;
			this.mediaId=mediaId;
			this.id=id;
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent();
			//Put mediaId and detailId into intent and activite next activity 
			i.putExtra("mediaid", mediaId);
			i.putExtra("detailinfoid", id);
			i.setClass(con, cls);
			i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			con.startActivity(i);
		}
	}
	
}
 
