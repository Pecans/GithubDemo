package com.lenovo.test;

import com.lenovo.page.AnalysisTxt;

/** 
 * @author Pecan-M E-mail:wangtianzhen@foxmail.com 
 * @version 创建时间：2013-1-8 下午2:59:00 
 * 评论的录入
 */
public class TestInputComment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(AnalysisTxt.regexPropertites.getProperty("user"));
		InfoWriteIn infoWriteIn=new InfoWriteIn();
		infoWriteIn.inputComment();
		System.out.println("程序正常结束...");
	}

}
