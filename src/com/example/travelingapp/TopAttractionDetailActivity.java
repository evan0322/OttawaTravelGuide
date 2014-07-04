package com.example.travelingapp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.travelingapp.entity.DetailInfo;
import com.travelingapp.entity.FastFactsInfo;
import com.travelingapp.entity.LinkInfo;
import com.travelingapp.service.DBService;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.LinearLayout.LayoutParams;

public class TopAttractionDetailActivity extends Activity {
	List<HashMap<String, Object>> data=new ArrayList<HashMap<String, Object>>();
	//Object of SQlite server
	private DBService service;
	private VideoView video;
	DisplayMetrics metric = new DisplayMetrics();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topattractiondetail);
		
		//Get intent and parameters from intent
		Intent i=getIntent();
		int mediaid=i.getIntExtra("mediaid", R.drawable.ic_launcher);
		int detailinfoId=i.getIntExtra("detailinfoid", 1);
		
		//Instantiate DataBase service
		service=new DBService(TopAttractionDetailActivity.this);
		//Get LinkInfo from DataBase
		List<LinkInfo> links=service.selectAllLinksById(detailinfoId);
		//Get DetailInfo from DataBase
		DetailInfo info=service.find(detailinfoId);
		//Get Fastfacts from DataBase
		List<FastFactsInfo> facts=service.selectAllFactsById(detailinfoId);
		
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		
//		SpannableString content = new SpannableString("Content");
//		content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
		
		//Get VideoPlayer
		video=(VideoView) findViewById(R.id.video);
		setHeight(video);
		//Get picture widget
		ImageView img1=(ImageView) findViewById(R.id.img);

		//Decide display video or picture
		//If DetailInfo shows that it is pic
		if("pic".equals(info.getMediaType()))
		{
			img1.setImageResource(mediaid);
			img1.setPadding((metric.widthPixels/10), metric.widthPixels/20, metric.widthPixels/10, metric.widthPixels/20);
			setHeight(img1);
			//Set video hide
			video.setVisibility(View.GONE);
		}
		//If DetailInfo shows that it is vid
		else if("vid".equals(info.getMediaType()))
		{
			String uri = "android.resource://" + getPackageName() + "/" + mediaid;
			MediaController controller=new MediaController(this);
			video.setVideoURI(Uri.parse(uri));
			video.setMediaController(controller);
			controller.setMediaPlayer(video);
			video.requestFocus();
			video.setPadding((metric.widthPixels/20), metric.widthPixels/20, metric.widthPixels/20, metric.widthPixels/20);
			//Set Picture hide
			img1.setVisibility(View.GONE);
			//Play video
			video.start();
		}
		
		TextView text=(TextView) findViewById(R.id.text);
		text.setPadding((metric.widthPixels/20), metric.widthPixels/20, metric.widthPixels/20, metric.widthPixels/20);
		text.setText(info.getInfo());
		
		LinearLayout layout=(LinearLayout) findViewById(R.id.linear);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);  // , 1是可选写的
		lp.setMargins((metric.widthPixels/20), metric.widthPixels/20, metric.widthPixels/20, metric.widthPixels/20); 
		layout.setLayoutParams(lp);
		
		//Creat overview for each link
		for(LinkInfo link:links)
        {
			TextView textView=new TextView(this);
	        textView.setText(Html.fromHtml("<u>"+link.getText()+"</u>"));
	        textView.setPadding(10, 10, 10, 10);
	        textView.setTextColor(0x7f00BFFF);
	        textView.setOnClickListener(new MyOnClickListener(this, link.getUrl()));
	        LinearLayout.LayoutParams textParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
	        layout.addView(textView, textParams);
        }
		
		TextView fastfacts=(TextView) findViewById(R.id.facts);
		fastfacts.setPadding((metric.widthPixels/20), 0, metric.widthPixels/20, 0);
		
		LinearLayout out=(LinearLayout) findViewById(R.id.out);
		//Creat overview for each fast facts

		for(FastFactsInfo fact:facts)
        {
			TextView textView=new TextView(this);
	        textView.setText(fact.getFastFacts());
	        textView.setTextColor(0x7f000000);
	        textView.setPadding(metric.widthPixels/10, 0, metric.widthPixels/20, metric.widthPixels/40);
	        LinearLayout.LayoutParams textParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
	        out.addView(textView, textParams);
        }
		//Get ScrollView
		ScrollView scroll=(ScrollView) findViewById(R.id.scroll);

		scroll.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction()== MotionEvent.ACTION_MOVE)
				{
					if(v.getScrollY()>0)
					{
						
						video.setPadding(0, 0, 0, v.getScrollY());
					}
					
				}
				return false;
				
			}
		});
	}
	 public void setHeight(View view)
	    {
	    	 LayoutParams linearParams = (LayoutParams) view.getLayoutParams();
	    	 getWindowManager().getDefaultDisplay().getMetrics(metric);
	         linearParams.height=(int)(metric.heightPixels*0.4);
	    }
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(video!=null)
		{
			video.start();
		}
	}

}
//Hyperlink intent
class MyOnClickListener implements OnClickListener
{

	private Context con;
	private String url;
	public MyOnClickListener(Context con,String url)
	{
		this.con=con;
		this.url=url;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        i.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
        con.startActivity(i);
	}
	
}