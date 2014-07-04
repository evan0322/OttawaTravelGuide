package com.example.travelingapp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class TopAttractionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topattraction);
		//Instantiate widget
		ImageView img1=(ImageView) findViewById(R.id.img1);
		ImageView img2=(ImageView) findViewById(R.id.img2);
		ImageView img3=(ImageView) findViewById(R.id.img3);
		ImageView img4=(ImageView) findViewById(R.id.img4);
		ImageView img5=(ImageView) findViewById(R.id.img5);
		ImageView img6=(ImageView) findViewById(R.id.img6);
		ImageView img7=(ImageView) findViewById(R.id.img7);
		ImageView img8=(ImageView) findViewById(R.id.img8);
		ImageView img9=(ImageView) findViewById(R.id.img9);
		
		TextView txt1=(TextView) findViewById(R.id.txt1);
		TextView txt2=(TextView) findViewById(R.id.txt2);
		TextView txt3=(TextView) findViewById(R.id.txt3);
		TextView txt4=(TextView) findViewById(R.id.txt4);
		TextView txt5=(TextView) findViewById(R.id.txt5);
		TextView txt6=(TextView) findViewById(R.id.txt6);
		TextView txt7=(TextView) findViewById(R.id.txt7);
		TextView txt8=(TextView) findViewById(R.id.txt8);
		TextView txt9=(TextView) findViewById(R.id.txt9);
		
		//Set intent to widget
		img1.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.drawable.parliament23,1));
		txt1.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.drawable.parliament23,1));
		
		img2.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.drawable.rideauhall11,2));
		txt2.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.drawable.rideauhall11,2));
		
		img3.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.drawable.canalrideau30,3));
		txt3.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.drawable.canalrideau30,3));
		
		img4.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.raw.by_ward_market,4));
		txt4.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.raw.by_ward_market,4));
		
		img5.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.raw.national_gallery_of_canada,5));
		txt5.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.raw.national_gallery_of_canada,5));
		
		img6.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.raw.canadian_museum_of_civilization,6));
		txt6.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.raw.canadian_museum_of_civilization,6));
		
		img7.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.drawable.royalmint,7));
		txt7.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.drawable.royalmint,7));
		
		img8.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.raw.canadian_war_museum,8));
		txt8.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.raw.canadian_war_museum,8));
		
		img9.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.drawable.national_arts_centre02,9));
		txt9.setOnClickListener(new MyOnClickListener(TopAttractionActivity.this, TopAttractionDetailActivity.class,R.drawable.national_arts_centre02,9));
		
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
			con.startActivity(i);
		}
	}
	
}
 
