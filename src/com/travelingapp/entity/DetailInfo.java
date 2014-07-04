package com.travelingapp.entity;
/*
 * 详细信息表的实体类
 * info就是视频或图片下面的那段文字
 * mediaType是媒体类型，pic图片或者vid视频
 * */
public class DetailInfo {
	private int id;
	private String info;
	private String mediaType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
}
