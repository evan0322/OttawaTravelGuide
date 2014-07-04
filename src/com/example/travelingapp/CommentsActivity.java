package com.example.travelingapp;

import java.util.ArrayList;
import java.util.List;

import com.travelingapp.entity.ScoreInfo;
import com.travelingapp.service.DBService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class CommentsActivity extends Activity {
	private TextView score;
	private List<Button> btnList;
	private EditText comment;
	private DBService service;
	DisplayMetrics metric = new DisplayMetrics();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comments);
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		
		Intent i=getIntent();
		final int mediaid=i.getIntExtra("mediaid", R.drawable.ic_launcher);
		final int detailinfoId=i.getIntExtra("detailinfoid", 1);
		
		service=new DBService(CommentsActivity.this);
		//Instantiate buttons
		Button btn1=(Button) findViewById(R.id.score1);
		Button btn2=(Button) findViewById(R.id.score2);
		Button btn3=(Button) findViewById(R.id.score3);
		Button btn4=(Button) findViewById(R.id.score4);
		Button btn5=(Button) findViewById(R.id.score5);
		Button ok=(Button) findViewById(R.id.ok);
		Button cancle=(Button) findViewById(R.id.cancle);
		LinearLayout okleft=(LinearLayout) findViewById(R.id.okleft);
		LinearLayout cancleright=(LinearLayout) findViewById(R.id.cancleright);
		//Instantiate widget
		score=(TextView) findViewById(R.id.score);
		
	    btnList=new ArrayList<Button>();
		btnList.add(btn1);
		btnList.add(btn2);
		btnList.add(btn3);
		btnList.add(btn4);
		btnList.add(btn5);
		
		setWidth(btn1, 0.15);
		setWidth(btn2, 0.15);
		setWidth(btn3, 0.15);
		setWidth(btn4, 0.15);
		setWidth(btn5, 0.15);
		setWidth(okleft, 0.5);
		setWidth(cancleright, 0.5);
		setWidth(ok, 0.3);
		setWidth(cancle, 0.3);
				
		setHeight(btn1, 0.15);
		setHeight(btn2, 0.15);
		setHeight(btn3, 0.15);
		setHeight(btn4, 0.15);
		setHeight(btn5, 0.15);
		//Set intent to buttons
		btn1.setOnClickListener(new ScoreButtonOnClickListener(btn1));
		btn2.setOnClickListener(new ScoreButtonOnClickListener(btn2));
		btn3.setOnClickListener(new ScoreButtonOnClickListener(btn3));
		btn4.setOnClickListener(new ScoreButtonOnClickListener(btn4));
		btn5.setOnClickListener(new ScoreButtonOnClickListener(btn5));
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ScoreInfo info=new ScoreInfo();
				comment=(EditText) findViewById(R.id.connent);
				info.setComment(comment.getText().toString());
				info.setSocre(Integer.parseInt(score.getText().toString()));
				info.setInfoid(detailinfoId);
				boolean b=service.addComment(info);
				if(b)
				{
					Toast.makeText(CommentsActivity.this, R.string.success, 10).show();
				}else
				{
					Toast.makeText(CommentsActivity.this, R.string.failed, 10).show();
				}
				Intent i=new Intent();
				i.setClass(CommentsActivity.this, TopAttractionDetailActivity.class);
				i.putExtra("mediaid", mediaid);
				i.putExtra("detailinfoid", detailinfoId);
				startActivity(i);
			}
		});
		cancle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent();
				i.setClass(CommentsActivity.this, TopAttractionDetailActivity.class);
				startActivity(i);
			}
		});
		
	}
	public void setWidth(View view, double w)
    {
    	 LayoutParams linearParams = (LayoutParams) view.getLayoutParams();
    	 getWindowManager().getDefaultDisplay().getMetrics(metric);
         linearParams.width=(int)(metric.widthPixels*w);
    }
	public void setHeight(View view, double w)
    {
    	 LayoutParams linearParams = (LayoutParams) view.getLayoutParams();
    	 getWindowManager().getDefaultDisplay().getMetrics(metric);
         linearParams.height=(int)(metric.widthPixels*w);
    }
	class ScoreButtonOnClickListener implements OnClickListener
	{

		private Button btn;
		
		public ScoreButtonOnClickListener(Button btn)
		{
			this.btn=btn;
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int index=btnList.indexOf(btn);
			int count=0;
			for(int i=0;i<btnList.size();i++)
			{
				if(i<index)
				{
					btnList.get(i).setBackgroundResource(R.drawable.onclickcircle);
					btnList.get(i).setTag("1");
					count++;
				}else if(i==index)
				{
					if("1".equals(btnList.get(i).getTag()))
					{
						btnList.get(i).setBackgroundResource(R.drawable.circle);
						btnList.get(i).setTag("0");
					}else
					{
						btnList.get(i).setBackgroundResource(R.drawable.onclickcircle);
						btnList.get(i).setTag("1");
						count++;
					}
				}
				else
				{
					btnList.get(i).setBackgroundResource(R.drawable.circle);
					btnList.get(i).setTag("0");
				}
				
			}
			score.setText(count+"");
		}
		
	}

}
