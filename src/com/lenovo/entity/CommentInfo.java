package com.lenovo.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 评论信息的实体类
 * @author Pecan-M
 *
 */
public class CommentInfo implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productID;
	private int brandID;
	private int seriesID;
	private int categoryID;
	private String advantage;
	private String buyTime;
	private String content;
	private String disadvantage;
	private String opposeNum;
	private String publishTime;
	private String service;
	private String summary;
	private String supportNum;
	private String title;
	private String userRank;
	private ArrayList<ReplayList> replyList;
	private CommentUser user;
	public CommentUser getUser() {
		return user;
	}

	public void setUser(CommentUser user) {
		this.user = user;
	}

	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getBrandID() {
		return brandID;
	}
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	public int getSeriesID() {
		return seriesID;
	}
	public void setSeriesID(int seriesID) {
		this.seriesID = seriesID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public ArrayList<ReplayList> getReplyList() {
		return replyList;
	}
	public void setReplyList(ArrayList<ReplayList> replyList) {
		this.replyList = replyList;
	}
	public int getModelID() {
		return productID;
	}
	public void setModelID(int modelID) {
		this.productID = modelID;
	}
	public String getAdvantage() {
		return advantage;
	}
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}
	public String getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDisadvantage() {
		return disadvantage;
	}
	public void setDisadvantage(String disadvantage) {
		this.disadvantage = disadvantage;
	}

	public String getOpposeNum() {
		return opposeNum;
	}

	public void setOpposeNum(String opposeNum) {
		this.opposeNum = opposeNum;
	}

	public String getSupportNum() {
		return supportNum;
	}

	public void setSupportNum(String supportNum) {
		this.supportNum = supportNum;
	}

	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserRank() {
		return userRank;
	}
	public void setUserRank(String userRank) {
		this.userRank = userRank;
	}
	public CommentInfo( String advantage, String buyTime, String content,
			String disadvantage, String opposeNum, String publishTime,
			ArrayList<ReplayList> replyList, CommentUser user, String service, String summary,
			String supportNum, String title, String userRank) {
		super();
		this.advantage = advantage;
		this.buyTime = buyTime;
		this.content = content;
		this.disadvantage = disadvantage;
		this.opposeNum = opposeNum;
		this.publishTime = publishTime.replace("  ", "");
		this.replyList = replyList;
		this.service = service;
		this.summary = summary;
		this.supportNum = supportNum;
		this.title = title;
		this.userRank = userRank;
		this.user=user;
	}
}
