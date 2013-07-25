package com.lenovo.page;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/** 
 * @author Pecan-M E-mail:wangtianzhen@foxmail.com 
 * @version 创建时间：2013-1-7 下午4:40:27 
 * comment文件的读取
 */
public class CommentContent {
	private FileInputStream inputStream=null;
	private BufferedReader bufferedReader=null;
	
	/**
	 * 读取目录下匹配的txt文件中的内容
	 * @param file comment文件
	 * @return comment文件的行内容
	 */
	public ArrayList<String> getTxtContent(File file){
		ArrayList<String> txtList=new ArrayList<String>();
		if ((!file.exists())||file==null) {
			return txtList;
		}
		String line=null;
		System.out.println(file);
		File[] files=file.listFiles();
		if (files==null||files.length==0) {
			return txtList;
		}
			for (int i = 0; i < files.length; i++) {
				try {
					inputStream=new FileInputStream(files[i]);
					bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
					while ((line = bufferedReader.readLine()) != null) {
						txtList.add(line);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		return txtList;
	}

}
