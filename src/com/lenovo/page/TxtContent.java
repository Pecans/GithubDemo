package com.lenovo.page;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lenovo.tools.GetAllFile;

/**
 * 提取txt文本行的tools
 * @author Pecan-M
 *
 */
public class TxtContent {
	private GetAllFile getAllFile=new GetAllFile();
	private FileInputStream inputStream=null;
	private BufferedReader bufferedReader=null;
	
	/**
	 * 读取目录下匹配的txt文件中的内容
	 * @param file
	 * @return
	 */
	public HashMap<String, ArrayList<String>> getTxtContent(File file){
		ArrayList<String> fileList=getAllFile.getTxts(file);
		HashMap<String, ArrayList<String>> hashMap=new HashMap<String, ArrayList<String>>();
		String line=null;
		for (String path: fileList) {
			ArrayList<String> txtList=new ArrayList<String>();
			try {
				inputStream=new FileInputStream(new File(path));
				bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
				while ((line = bufferedReader.readLine()) != null) {
					txtList.add(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Matcher matcher=Pattern.compile(".*/(.*?)-Products.*").matcher(path);
			String key=null;
			while (matcher.find()) {
				key=matcher.group(1);
			}
			if (hashMap.containsKey(key)) {
				txtList.addAll(hashMap.get(key));
				hashMap.put(key, txtList);
			}else {
				hashMap.put(key, txtList);
			}
		}
		return hashMap;
	}
}
