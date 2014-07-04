package com.travelingapp.service;

import java.util.ArrayList;
import java.util.List;

import com.travelingapp.entity.DetailInfo;
import com.travelingapp.entity.EventCalendarInfo;
import com.travelingapp.entity.FastFactsInfo;
import com.travelingapp.entity.LinkInfo;
import com.travelingapp.entity.ScoreInfo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBService {
	private DBOpenHelper helper;
	public DBService(Context context)
	{
		this.helper=new DBOpenHelper(context);
	}
	
	// DetailInfo (Read only)
	public DetailInfo find(Integer id)
	{
		SQLiteDatabase db= helper.getReadableDatabase();
		Cursor cursor= db.rawQuery("select * from detailinfo where id=?",new String[]{id.toString()});
		DetailInfo info=null;
		if(cursor.moveToFirst())
		{
			info=new DetailInfo();
			info.setId(cursor.getInt(cursor.getColumnIndex("id")));
			info.setInfo(cursor.getString(cursor.getColumnIndex("info")));
			info.setMediaType(cursor.getString(cursor.getColumnIndex("mediatype")));
			
		}
		cursor.close();
		db.close();
		return info;
	}
	// LinkInfo (Read only)
	public List<LinkInfo> selectAllLinksById(Integer infoid)
	{
		List<LinkInfo> list=new ArrayList<LinkInfo>();
		SQLiteDatabase db= helper.getReadableDatabase();
		Cursor cursor= db.rawQuery("select * from linkinfo where infoid=?",new String[]{infoid.toString()});
		while(cursor.moveToNext())
		{
			LinkInfo info=new LinkInfo();
			info.setId(cursor.getInt(cursor.getColumnIndex("id")));
			info.setInfoId(cursor.getInt(cursor.getColumnIndex("infoid")));
			info.setText(cursor.getString(cursor.getColumnIndex("text")));
			info.setUrl(cursor.getString(cursor.getColumnIndex("url")));
			list.add(info);
		}
		cursor.close();
		db.close();
		return list;
	}
	// Fastfacts (Read only)
	public List<FastFactsInfo> selectAllFactsById(Integer infoid)
	{
		List<FastFactsInfo> list=new ArrayList<FastFactsInfo>();
		SQLiteDatabase db= helper.getReadableDatabase();
		Cursor cursor= db.rawQuery("select * from fastfactsinfo where infoid=?",new String[]{infoid.toString()});
		while(cursor.moveToNext())
		{
			FastFactsInfo info=new FastFactsInfo();
			info.setId(cursor.getInt(cursor.getColumnIndex("id")));
			info.setInfoid(cursor.getInt(cursor.getColumnIndex("infoid")));
			info.setFastFacts(cursor.getString(cursor.getColumnIndex("fastfacts")));
			list.add(info);
		}
		cursor.close();
		db.close();
		return list;
	}
	// EventCalendar(Read only)
	public List<EventCalendarInfo> selectAllEventCalendar()
	{
		List<EventCalendarInfo> list=new ArrayList<EventCalendarInfo>();
		SQLiteDatabase db= helper.getReadableDatabase();
		Cursor cursor= db.rawQuery("select * from eventcalendarinfo",new String[]{});
		while(cursor.moveToNext())
		{
			EventCalendarInfo info=new EventCalendarInfo();
			info.setContent(cursor.getString(cursor.getColumnIndex("content")));
			info.setDataInfo(cursor.getString(cursor.getColumnIndex("datainfo")));
			info.setDay(cursor.getString(cursor.getColumnIndex("day")));
			info.setMonth(cursor.getString(cursor.getColumnIndex("month")));
			info.setText(cursor.getString(cursor.getColumnIndex("text")));
			info.setTitle(cursor.getString(cursor.getColumnIndex("title")));
			info.setId(cursor.getInt(cursor.getColumnIndex("id")));
			list.add(info);
		}
		cursor.close();
		db.close();
		return list;
	}
	// EventCalendar(Read only)
	public EventCalendarInfo selectEventCalendarById(Integer id)
	{
		EventCalendarInfo info=new EventCalendarInfo();
		SQLiteDatabase db= helper.getReadableDatabase();
		Cursor cursor= db.rawQuery("select * from eventcalendarinfo where id=?",new String[]{id.toString()});
		while(cursor.moveToNext())
		{
			info.setContent(cursor.getString(cursor.getColumnIndex("content")));
			info.setDataInfo(cursor.getString(cursor.getColumnIndex("datainfo")));
			info.setDay(cursor.getString(cursor.getColumnIndex("day")));
			info.setMonth(cursor.getString(cursor.getColumnIndex("month")));
			info.setText(cursor.getString(cursor.getColumnIndex("text")));
			info.setTitle(cursor.getString(cursor.getColumnIndex("title")));
			info.setId(cursor.getInt(cursor.getColumnIndex("id")));
		}
		cursor.close();
		db.close();
		return info;
	}
	
	public List<ScoreInfo> selectAllComments(Integer id)
	{
		List<ScoreInfo> list=new ArrayList<ScoreInfo>();
		SQLiteDatabase db= helper.getReadableDatabase();
		Cursor cursor= db.rawQuery("select * from scoreinfo where infoid=?",new String[]{id.toString()});
		while(cursor.moveToNext())
		{
			ScoreInfo info=new ScoreInfo();
			info.setId(cursor.getInt(cursor.getColumnIndex("id")));
			info.setComment(cursor.getString(cursor.getColumnIndex("comment")));
			info.setSocre(cursor.getInt(cursor.getColumnIndex("score")));
			list.add(info);
		}
		cursor.close();
		db.close();
		return list;
	}
	//comment(R&W DataBase)
	public boolean addComment(ScoreInfo info)
	{
		boolean b=true;
		try {
			SQLiteDatabase db= helper.getWritableDatabase();
			db.execSQL("insert into scoreinfo (score,comment,infoid) values(?,?,?)",new Object[]{info.getSocre(),info.getComment(),info.getInfoid()});
			db.close();
		} catch (Exception e) {
			// TODO: handle exception
			b=false;
		}
		return b;
	}
}
