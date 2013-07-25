package com.lenovo.dao;
/** 
 * @author Pecan-M E-mail:wangtianzhen@foxmail.com 
 * @version 创建时间：2013-2-26 下午2:28:25 
 * 类说明 
 */
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.Map.Entry;

	import com.lenovo.entity.PageAllParam;

	/** 
	 * @author Pecan-M E-mail:wangtianzhen@foxmail.com 
	 * @version 创建时间：2013-1-7 下午4:09:20 
	 * 向评论表和回复表中写入数据
	 */
	public class UpdateImagePath { 

		private SQLOperation sqlOperation=new SQLOperation();
		private String commentFilePath;
		private String filePath;
		private String URL; 
		private String MD5;
		private int[] ID;
		/**
		 * 对外的入口方法
		 * @param hashMap 传入的是一个HashMap<String, ArrayList<PageAllParam>>类型的数据
		 */
		public void inputImagePath(HashMap<String, ArrayList<PageAllParam>> hashMap){
			Iterator<Entry<String, ArrayList<PageAllParam>>> iterator = hashMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, ArrayList<PageAllParam>> entry = (Entry<String, ArrayList<PageAllParam>>) iterator.next();
				System.out.println(entry.getKey().replaceAll("-.*", ""));
				int statement=subInputComment(entry.getValue(),entry.getKey());
				if (statement==0) {
					System.out.println("websiteID 为 0, 请核对数据库后再次录入。当前为的短串为 "+entry.getKey());
				}else {
					System.out.println("此短串的录入完成！当前为的短串为 "+entry.getKey());
				}
			}
		}

		/**
		 * 向数据库写入评论数据
		 * @param pageAllParams
		 * @param website
		 */
		private int subInputComment(ArrayList<PageAllParam> pageAllParams, String website){
		//	commentFilePath=AnalysisTxt.regexPropertites.getProperty("sourcePath");
			System.out.println(website);
//			commentFilePath=commentFilePath+"/"+website.replaceAll(".*-", "")+"/"+website.replaceAll("-.*", "");
			commentFilePath=website.replaceAll(".*-", "")+"/"+website.replaceAll("-.*", "");
			System.out.println(commentFilePath);
			website=website.replaceAll("-.*", "");
			sqlOperation.openConn(); //打开连接
			int websiteID=sqlOperation.getWebsiteIDByName(website.replaceAll("-.*", ""));
			if (websiteID==0) {
				return 0;
			}
			for (PageAllParam pageAllParam : pageAllParams) {
				URL=pageAllParam.getURL();
				MD5=pageAllParam.getMD5();
				ID=sqlOperation.getProductIDByURL(URL, website);
				if (ID!=null) {
					filePath=commentFilePath+"/"+MD5;
					sqlOperation.updateProductinfoImagePath(filePath, ID[0]);
				}
			}
			sqlOperation.closeConn(); //关闭连接
			return 1;
		}

	}

