package com.example.travelingapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.travelingapp.entity.EventCalendarInfo;
import com.travelingapp.service.DBService;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class EventCalendarActivity extends Activity {
	DisplayMetrics metric = new DisplayMetrics();
	private DBService service;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.eventcalendar);
	    getWindowManager().getDefaultDisplay().getMetrics(metric);
	    
	    service=new DBService(EventCalendarActivity.this);
	    List<EventCalendarInfo> list=service.selectAllEventCalendar();
	    
	    ListView listView=(ListView) findViewById(R.id.list);
	    List<HashMap<String, Object>> data=new ArrayList<HashMap<String, Object>>();
	    for(EventCalendarInfo info : list)
        {
        	HashMap<String, Object> item=new HashMap<String, Object>();
        	item.put("day", info.getDay());
        	item.put("month", info.getMonth());
        	item.put("title", info.getTitle());
        	item.put("datainfo", info.getDataInfo());
        	data.add(item);
        }
	    MySimpleAdapter adapter=new MySimpleAdapter(EventCalendarActivity.this, list, R.layout.list_item, metric.widthPixels);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long arg3) {
				// TODO Auto-generated method stub
				ListView listView=(ListView) parent;
				EventCalendarInfo info=(EventCalendarInfo) listView.getItemAtPosition(position);
				Intent i=new Intent();
				i.putExtra("id", info.getId());
				i.setClass(EventCalendarActivity.this,EventCalendarDetailActivity.class );
				startActivity(i);
			}
		});
	}
	public void setWidth(View view)
    {
    	 LayoutParams linearParams = (LayoutParams) view.getLayoutParams();
    	 getWindowManager().getDefaultDisplay().getMetrics(metric);
         linearParams.width=(int)(metric.widthPixels*0.3);
    }
	 public void setHeight(View view)
	 {
		 LayoutParams linearParams = (LayoutParams) view.getLayoutParams();
		 getWindowManager().getDefaultDisplay().getMetrics(metric);
	     linearParams.height=(int)(metric.widthPixels*0.5);
	 }
	 class MySimpleAdapter extends BaseAdapter
	 {
		 private int width;
		 private int layout;
		 private List<EventCalendarInfo> list;
		 private LayoutInflater inflater;
		public MySimpleAdapter(Context context,
				List<EventCalendarInfo> list, int layout,int width) {
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
	            cache.datainfo=(TextView)convertView.findViewById(R.id.datainfo);
	            cache.day=(TextView)convertView.findViewById(R.id.day);
	            cache.month=(TextView)convertView.findViewById(R.id.month);
	            cache.title=(TextView)convertView.findViewById(R.id.title);
	            convertView.setTag(cache);
	            
	        }
	        else
	        {
	            cache=(ViewCache)convertView.getTag();        
	        }
	        
	        EventCalendarInfo info=list.get(position);
	        cache.datainfo.setText(info.getDataInfo());
	        cache.day.setText(info.getDay());
	        cache.month.setText(info.getMonth());
	        cache.title.setText(Html.fromHtml("<u>"+info.getTitle()+"</u>"));
	        
	        View day=convertView.findViewById(R.id.day);
			LinearLayout.LayoutParams linearParams0 = (LinearLayout.LayoutParams)day.getLayoutParams();  
		    linearParams0.width = (int) (width*0.3);  
		    day.setLayoutParams(linearParams0);  
		    
		    View month=convertView.findViewById(R.id.month);
			LinearLayout.LayoutParams linearParams1 = (LinearLayout.LayoutParams)month.getLayoutParams();  
		    linearParams1.width = (int) (width*0.3);  
		    month.setLayoutParams(linearParams1);  
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
	        public TextView day;
	        public TextView month;
	        public TextView title;
	        public TextView datainfo;
	    }
		 
	 }
}

