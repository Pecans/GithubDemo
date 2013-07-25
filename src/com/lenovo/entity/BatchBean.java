package com.lenovo.entity;
/** 
 * @author Pecan-M E-mail:wangtianzhen@foxmail.com 
 * @version 创建时间：2012-12-1 下午4:58:16 
 * 批量插入数据时的临时bean
 */
public class BatchBean {
	
	private int productID; 
	private int brandID;
	private int seriesID;
	private int categoryID;
	private int websiteID; 
	private int product_commentID;
	private String advantage; 
	private String buyTime; 
	private String content; 
	private String disadvantage; 
	private String opposeNum;
	private String publishTime; 
	private String replyList; 
	private String service; 
	private String summary;
	private String supportNum; 
	private String title; 
	private String user; 
	private String userRank; 
	private String address; 
	private String grade; 
	private String ip; 
	private String registerTime;
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
	public int getWebsiteID() {
		return websiteID;
	}
	public void setWebsiteID(int websiteID) {
		this.websiteID = websiteID;
	}
	public int getProduct_commentID() {
		return product_commentID;
	}
	public void setProduct_commentID(int product_commentID) {
		this.product_commentID = product_commentID;
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
	public String getPublishTime() {
		if (publishTime.equals("")) {
			
		}
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getReplyList() {
		return replyList;
	}
	public void setReplyList(String replyList) {
		this.replyList = replyList;
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
	public String getSupportNum() {
		return supportNum;
	}
	public void setSupportNum(String supportNum) {
		this.supportNum = supportNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUserRank() {
		return userRank;
	}
	public void setUserRank(String userRank) {
		this.userRank = userRank;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public BatchBean(int productID, int brandID, int seriesID, int categoryID, int websiteID, int product_commentID,
            String advantage, String buyTime, String content, String disadvantage, String opposeNum,
            String publishTime, String replyList, String service, String summary,String supportNum, String title, 
            String user, String userRank, String address, String grade, String ip, String registerTime) {
		super();
		this.productID = productID;
		this.brandID = brandID;
		this.seriesID = seriesID;
		this.categoryID = categoryID;
		this.websiteID = websiteID;
		this.product_commentID = product_commentID;
		this.advantage = advantage;
		this.buyTime = buyTime;
		this.content = content;
		this.disadvantage = disadvantage;
		this.opposeNum = opposeNum;
		this.publishTime = publishTime;
		this.replyList = replyList;
		this.service = service;
		this.summary = summary;
		this.supportNum = supportNum;
		this.title = title;
		this.user = user;
		this.userRank = userRank;
		this.address = address;
		this.grade = grade;
		this.ip = ip;
		this.registerTime = registerTime;
	}
	
}
