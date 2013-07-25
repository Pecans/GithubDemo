package com.lenovo.entity;

import java.io.Serializable;

/** 
 * @author Pecan-M E-mail:wangtianzhen@foxmail.com 
 * @version 创建时间：2013-1-8 上午10:26:26 
 * comment中的USER
 */
public class CommentUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String adress;
	private String name;
	private String grade;
	private String ip;
	private String registerTime;
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public CommentUser(String adress, String name, String grade, String ip,
			String registerTime) {
		super();
		this.adress = adress;
		this.name = name;
		this.grade = grade;
		this.ip = ip;
		this.registerTime = registerTime;
	}
}
