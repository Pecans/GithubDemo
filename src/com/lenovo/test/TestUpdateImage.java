package com.lenovo.test;

import com.lenovo.page.AnalysisTxt;

/** 
 * @author Pecan-M E-mail:wangtianzhen@foxmail.com 
 * @version 创建时间：2013-2-26 下午2:34:08 
 * 类说明 
 */
public class TestUpdateImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(AnalysisTxt.regexPropertites.getProperty("user"));
		InfoWriteIn infoWriteIn=new InfoWriteIn();
		infoWriteIn.updateImage();
		System.out.println("程序正常结束...");
	}

}
