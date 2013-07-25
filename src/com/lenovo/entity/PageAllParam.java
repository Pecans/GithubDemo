package com.lenovo.entity;

import java.io.Serializable;
/**
 * 从TXT中的获取的行数据，封装在此
 * @author Pecan-M
 *
 */
public class PageAllParam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ScreenSize;
	private String Resolution;
	private String CpuModel;
	private String CpuFrequency;
	private String Memary;
	private String HardDisk;
	private String HardDiskType;
	private String Graphics;
	private String Weight;
	private String OS;
	private String Camera;
	private String brand;
	private String name;
	private String brandURL;
	private String seriesURL;
	private String buyURL;
	private String amazonURL;
	private String series;
	private String amazonPrice;
	private String buyPrice;
	private String category;
	private String categoryURL; 
	private String imageURL;
	private String paramURL; 
	private String priceUrl; 
	private String URL; 
	private String MD5;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategoryURL() {
		return categoryURL;
	}
	public void setCategoryURL(String categoryURL) {
		this.categoryURL = categoryURL;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getParamURL() {
		return paramURL;
	}
	public void setParamURL(String paramURL) {
		this.paramURL = paramURL;
	}
	public String getPriceUrl() {
		return priceUrl;
	}
	public void setPriceUrl(String priceUrl) {
		this.priceUrl = priceUrl;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getMD5() {
		return MD5;
	}
	public void setMD5(String mD5) {
		MD5 = mD5;
	}
	public String getBrandURL() {
		return brandURL;
	}
	public void setBrandURL(String brandURL) {
		this.brandURL = brandURL;
	}
	public String getSeriesURL() {
		return seriesURL;
	}
	public void setSeriesURL(String seriesURL) {
		this.seriesURL = seriesURL;
	}
	public String getAmazonPrice() {
		return amazonPrice;
	}
	public void setAmazonPrice(String amazonPrice) {
		this.amazonPrice = amazonPrice;
	}
	public String getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBuyURL() {
		return buyURL;
	}
	public void setBuyURL(String buyURL) {
		this.buyURL = buyURL;
	}
	public String getAmazonURL() {
		return amazonURL;
	}
	public void setAmazonURL(String amazonURL) {
		this.amazonURL = amazonURL;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	
	public String getCamera() {
		return Camera;
	}
	public void setCamera(String camera) {
		Camera = camera;
	}
	public String getOS() {
		return OS;
	}
	public void setOS(String oS) {
		OS = oS;
	}
	public String getScreenSize() {
		return ScreenSize;
	}
	public void setScreenSize(String screenSize) {
		ScreenSize = screenSize;
	}
	public String getResolution() {
		return Resolution;
	}
	public void setResolution(String resolution) {
		Resolution = resolution;
	}
	public String getCpuModel() {
		return CpuModel;
	}
	public void setCpuModel(String cpuModel) {
		CpuModel = cpuModel;
	}
	public String getCpuFrequency() {
		return CpuFrequency;
	}
	public void setCpuFrequency(String cpuFrequency) {
		CpuFrequency = cpuFrequency;
	}
	public String getMemary() {
		return Memary;
	}
	public void setMemary(String memary) {
		Memary = memary;
	}
	public String getHardDisk() {
		return HardDisk;
	}
	public void setHardDisk(String hardDisk) {
		HardDisk = hardDisk;
	}
	public String getHardDiskType() {
		return HardDiskType;
	}
	public void setHardDiskType(String hardDiskType) {
		HardDiskType = hardDiskType;
	}
	public String getGraphics() {
		return Graphics;
	}
	public void setGraphics(String graphics) {
		Graphics = graphics;
	}
	public String getWeight() {
		return Weight;
	}
	public void setWeight(String weight) {
		Weight = weight;
	}
	/*
	 * 构造方法
	 */
	public PageAllParam(String brand, String name,String buyURL, String amazonURL, String amazonPrice,
			                        String buyPrice, String brandURL, String category, String categoryURL, String imageURL,
			                        String paramURL, String priceUrl, String series, String seriesURL, String URL, String MD5,
			                        String screenSize, String resolution, String cpuModel,String cpuFrequency, 
			                        String memary, String hardDisk, String hardDiskType, String graphics, String weight,
			                        String os, String camera) {
		super();
		this.brand = brand;
		this.name = name;
		this.seriesURL=seriesURL;
		this.brandURL=brandURL;
		this.buyURL = buyURL;
		this.amazonURL = amazonURL;
		this.series = series;
		this.buyPrice = buyPrice;
		this.amazonPrice = amazonPrice;
		ScreenSize = screenSize;
		Resolution = resolution;
		CpuModel = cpuModel;
		CpuFrequency = cpuFrequency;
		Memary = memary;
		HardDisk = hardDisk;
		HardDiskType = hardDiskType;
		Graphics = graphics;
		Weight = weight;
		OS=os;
		Camera=camera;
		this.category=category;
		this.categoryURL=categoryURL; 
		this.imageURL=imageURL;
		this.paramURL=paramURL; 
		this.priceUrl=priceUrl; 
		this.URL=URL; 
		this.MD5=MD5;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder();		
		stringBuilder=stringBuilder.append("{\"brand\":\""+brand+"\",").append("\"name\":\""+name+"\",")
				.append("\"buyURL\":\""+buyURL+"\",").append("\"amazonURL\":\""+amazonURL+"\",")
				.append("\"amazonPrice\":\""+amazonPrice+"\",").append("\"buyPrice\":\""+buyPrice+"\",")
				.append("\"brandURL\":\""+brandURL+"\",").append("\"category\":\""+category+"\",").append("\"categoryURL\":\""+categoryURL+"\",").append("\"imageURL\":\""+imageURL+"\",")
				.append("\"paramURL\":\""+paramURL+"\",").append("\"priceUrl\":\""+priceUrl+"\",").append("\"series\":\""+series+"\",")
				.append("\"seriesURL\":\""+seriesURL+"\",").append("\"URL\":\""+URL+"\",").append("\"MD5\":\""+MD5+"\",").append("\"ScreenSize\":\""+ScreenSize+"\",").append("\"Resolution\":\""+Resolution+"\",").append("\"CpuModel\":\""+CpuModel+"\",")
				.append("\"CpuFrequency\":\""+CpuFrequency+"\",").append("\"Memary\":\""+Memary+"\",").append("\"HardDisk\":\""+HardDisk+"\",")
				.append("\"HardDiskType\":\""+HardDiskType+"\",").append("\"Graphics\":\""+Graphics+"\",").append("\"Weight\":\""+Weight+"\",")
				.append("\"OS\":\""+OS+"\",").append("\"Camera\":\""+Camera+"\"}");
		return stringBuilder.toString();
	}
	/**
	 * 带有制表符的toString
	 * @return
	 */
	public String toStrings() {
		StringBuilder stringBuilder=new StringBuilder();	
		stringBuilder=stringBuilder.append("{\"brand\":\""+brand+"\",\t").append("\"name\":\""+name+"\",\t")
                .append("\"buyURL\":\""+buyURL+"\",\t").append("\"amazonURL\":\""+amazonURL+"\",\t")
                .append("\"amazonPrice\":\""+amazonPrice+"\",\t").append("\"buyPrice\":\""+buyPrice+"\",\t")
                .append("\"brandURL\":\""+brandURL+"\",\t").append("\"category\":\""+category+"\",\t").append("\"categoryURL\":\""+categoryURL+"\",\t").append("\"imageURL\":\""+imageURL+"\",\t")
				.append("\"paramURL\":\""+paramURL+"\",\t").append("\"priceUrl\":\""+priceUrl+"\",\t").append("\"series\":\""+series+"\",\t")
				.append("\"seriesURL\":\""+seriesURL+"\",\t").append("\"URL\":\""+URL+"\",\t").append("\"MD5\":\""+MD5+"\",\t").append("\"ScreenSize\":\""+ScreenSize+"\",\t").append("\"Resolution\":\""+Resolution+"\",\t").append("\"CpuModel\":\""+CpuModel+"\",\t")
                .append("\"CpuFrequency\":\""+CpuFrequency+"\",\t").append("\"Memary\":\""+Memary+"\",\t").append("\"HardDisk\":\""+HardDisk+"\",\t")
                .append("\"HardDiskType\":\""+HardDiskType+"\",\t").append("\"Graphics\":\""+Graphics+"\",\t").append("\"Weight\":\""+Weight+"\",\t")
                .append("\"OS\":\""+OS+"\",\t").append("\"Camera\":\""+Camera+"\"}");
		return stringBuilder.toString();
	}
}
