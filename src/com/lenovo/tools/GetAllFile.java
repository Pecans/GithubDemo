package com.lenovo.tools;

import java.io.File;
import java.util.ArrayList;

import com.lenovo.page.AnalysisTxt;

/**
 * 获取目录下所有文件的内容
 * @author Pecan-M
 *
 */
public class GetAllFile {
	private ArrayList<String> list=new ArrayList<String>();
	   /**
	    * 获取目录下的每个文件
	    * @param file  输入目录
	    * @return 文件目录的list
	    */	
	public ArrayList<String> getTxts(File file){
		File[] files=file.listFiles();                 //获取当前目录下深度为1的文件
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()&&files[i].getAbsolutePath().matches(AnalysisTxt.regexPropertites.getProperty("regexTxt"))) {
				System.out.println(files[i].getAbsolutePath());
				list.add(files[i].getAbsolutePath());
			}
			if (files[i].isDirectory()) {
				this.getTxts(files[i]);					//迭代
			}
		}
		return list;
	}
	
	public static void main(String args[]){
		GetAllFile getAllFile=new GetAllFile();
		getAllFile.getTxts(new File(AnalysisTxt.regexPropertites.getProperty("filePath")));
	}
}
