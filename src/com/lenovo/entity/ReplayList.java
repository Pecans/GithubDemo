package com.lenovo.entity;

import java.io.Serializable;

/** 
 * @author Pecan-M E-mail:wangtianzhen@foxmail.com 
 * @version 创建时间：2013-1-7 下午5:02:14 
 * 用户回复的类
 */
public class ReplayList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String author;
	private String content;
	private String publishTime;
	private String title;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ReplayList( String author, String content,
			String publishTime, String title) {
		super();
		this.author = author;
		this.content = content;
		this.publishTime = publishTime;
		this.title = title;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder();		
		stringBuilder=stringBuilder.append("{\"author\":\""+author+"\",").append("\"content\":\""+content+"\",")
				.append("\"publishTime\":\""+publishTime+"\",").append("\"title\":\""+title+"\"}");
		return stringBuilder.toString();
	}
	
}
