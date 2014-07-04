package com.example.travelingapp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.travelingapp.entity.DetailInfo;
import com.travelingapp.entity.FastFactsInfo;
import com.travelingapp.entity.LinkInfo;
import com.travelingapp.entity.ScoreInfo;
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
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.LinearLayout.LayoutParams;

public class HotelDetailActivity extends Activity {
	List<HashMap<String, Object>> data=new ArrayList<HashMap<String, Object>>();
	//Object of SQlite server
	private DBService service;
	private VideoView video;
	DisplayMetrics metric = new DisplayMetrics();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hoteldetail);
		
		//Get intent and parameters from intent
		Intent i=getIntent();
		final int mediaid=i.getIntExtra("mediaid", R.drawable.ic_launcher);
		final int detailinfoId=i.getIntExtra("detailinfoid", 1);
		
		//Instantiate DataBase service
		service=new DBService(HotelDetailActivity.this);
		//Get LinkInfo from DataBase
		List<LinkInfo> links=service.selectAllLinksById(detailinfoId);
		//Get DetailInfo from DataBase
		DetailInfo info=service.find(detailinfoId);
		//Get Fastfacts from DataBase
		List<FastFactsInfo> facts=service.selectAllFactsById(detailinfoId);
		List<ScoreInfo> list=service.selectAllComments(detailinfoId);
		
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
		
		LinearLayout out=(LinearLayout) findViewById(R.id.fastlayout);
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
		
		LinearLayout commentlayout=(LinearLayout) findViewById(R.id.commentlayout);
		commentlayout.setPadding((metric.widthPixels/20), 10, metric.widthPixels/20, 0);
		ListView scoreList=(ListView) findViewById(R.id.commentslist);
		scoreList.setPadding((metric.widthPixels/20), 10, metric.widthPixels/20, 0);
		MySimpleAdapter adapter=new MySimpleAdapter(HotelDetailActivity.this, list, R.layout.score_list_item, metric.widthPixels);
		scoreList.setAdapter(adapter);
		int totalHeight=0;
		for(int j=0;j<list.size();j++)
		{
			View item=adapter.getView(j,null, scoreList);
			item.measure(0, 0);
			totalHeight+=item.getMeasuredHeight();
		}
		 ViewGroup.LayoutParams params = scoreList.getLayoutParams();
		 params.height = totalHeight + (scoreList.getDividerHeight() * (adapter.getCount() - 1))+scoreList.getPaddingTop();
		 scoreList.setLayoutParams(params);
		
		Button btn=(Button) findViewById(R.id.button);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent();
				i.setClass(HotelDetailActivity.this, CommentsActivity.class);
				i.putExtra("mediaid", mediaid);
				i.putExtra("detailinfoid", detailinfoId);
				i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(i);
			}
		});
		
		TextView commenttext=(TextView) findViewById(R.id.commenttextview);
		setWidth(commenttext);
	}
	 public void setHeight(View view)
	    {
	    	 LayoutParams linearParams = (LayoutParams) view.getLayoutParams();
	    	 getWindowManager().getDefaultDisplay().getMetrics(metric);
	         linearParams.height=(int)(metric.heightPixels*0.4);
	    }
	 public void setWidth(View view)
	    {
	    	 LayoutParams linearParams = (LayoutParams) view.getLayoutParams();
	    	 getWindowManager().getDefaultDisplay().getMetrics(metric);
	         linearParams.width=(int)(metric.widthPixels*0.65);
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

	class MySimpleAdapter extends BaseAdapter
	 {
		 private int width;
		 private int layout;
		 private List<ScoreInfo> list;
		 private LayoutInflater inflater;
		public MySimpleAdapter(Context context,
				List<ScoreInfo> list, int layout,int width) {
			this.width=width;
			this.layout=layout;
			this.list=list;
			inflater =(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
		    ViewCache cache;
	        if(convertView==null)
	        {
	            convertView = inflater.inflate(layout, null);
	            cache=new ViewCache();
	            cache.score=(TextView)convertView.findViewById(R.id.scoretext);
	            cache.comment=(TextView)convertView.findViewById(R.id.commenttext);
	            convertView.setTag(cache);
	            
	        }
	        else
	        {
	            cache=(ViewCache)convertView.getTag();        
	        }
	        
	        ScoreInfo info=list.get(position);
	        cache.score.setText(info.getSocre()+"");
	        cache.comment.setText(info.getComment());
	        
	        View score=convertView.findViewById(R.id.scoretext);
			LinearLayout.LayoutParams linearParams0 = (LinearLayout.LayoutParams)score.getLayoutParams();  
		    linearParams0.width = (int) (width*0.3);  
		    score.setLayoutParams(linearParams0);  
		    
		    View comment=convertView.findViewById(R.id.commenttext);
			LinearLayout.LayoutParams linearParams1 = (LinearLayout.LayoutParams)comment.getLayoutParams();  
		    linearParams1.width = (int) (width*0.6);  
		    comment.setLayoutParams(linearParams1);  
			return convertView;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			 return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		public final class ViewCache
	    {
	        public TextView score;
	        public TextView comment;
	    }
		 
	 }
}
//Hyperlink intent
class MyOnClickListenerHotel implements OnClickListener
{

	private Context con;
	private String url;
	public MyOnClickListenerHotel(Context con,String url)
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