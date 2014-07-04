package com.example.travelingapp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class EatShopActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eatshop);
		//Instantiate
		ImageView img20=(ImageView) findViewById(R.id.img20);
		ImageView img21=(ImageView) findViewById(R.id.img21);
		ImageView img22=(ImageView) findViewById(R.id.img22);
		ImageView img23=(ImageView) findViewById(R.id.img23);
		ImageView img24=(ImageView) findViewById(R.id.img24);
		ImageView img25=(ImageView) findViewById(R.id.img25);
		
		TextView txt20=(TextView) findViewById(R.id.txt20);
		TextView txt21=(TextView) findViewById(R.id.txt21);
		TextView txt22=(TextView) findViewById(R.id.txt22);
		TextView txt23=(TextView) findViewById(R.id.txt23);
		TextView txt24=(TextView) findViewById(R.id.txt24);
		TextView txt25=(TextView) findViewById(R.id.txt25);
		
		//Set intent to widget
		img20.setOnClickListener(new MyOnClickListener(EatShopActivity.this, EatShopDetailActivity.class,R.drawable.play,15));
		txt20.setOnClickListener(new MyOnClickListener(EatShopActivity.this, EatShopDetailActivity.class,R.drawable.play,15));
		
		img21.setOnClickListener(new MyOnClickListener(EatShopActivity.this, EatShopDetailActivity.class,R.drawable.beckta,16));
		txt21.setOnClickListener(new MyOnClickListener(EatShopActivity.this, EatShopDetailActivity.class,R.drawable.beckta,16));
		
		img22.setOnClickListener(new MyOnClickListener(EatShopActivity.this, EatShopDetailActivity.class,R.raw.pelican,17));
		txt22.setOnClickListener(new MyOnClickListener(EatShopActivity.this, EatShopDetailActivity.class,R.raw.pelican,17));
		
		img23.setOnClickListener(new MyOnClickListener(EatShopActivity.this, EatShopDetailActivity.class,R.raw.beavertails,18));
		txt23.setOnClickListener(new MyOnClickListener(EatShopActivity.this, EatShopDetailActivity.class,R.raw.beavertails,18));
		
		img24.setOnClickListener(new MyOnClickListener(EatShopActivity.this, EatShopDetailActivity.class,R.drawable.stella,19));
		txt24.setOnClickListener(new MyOnClickListener(EatShopActivity.this, EatShopDetailActivity.class,R.drawable.stella,19));
		
		img25.setOnClickListener(new MyOnClickListener(EatShopActivity.this, EatShopDetailActivity.class,R.drawable.coconut,20));
		txt25.setOnClickListener(new MyOnClickListener(EatShopActivity.this, EatShopDetailActivity.class,R.drawable.coconut,20));
		
		
		
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
 
