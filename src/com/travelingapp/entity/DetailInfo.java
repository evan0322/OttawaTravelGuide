package com.travelingapp.entity;
/*
 * ��ϸ��Ϣ���ʵ����
 * info������Ƶ��ͼƬ������Ƕ�����
 * mediaType��ý�����ͣ�picͼƬ����vid��Ƶ
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
