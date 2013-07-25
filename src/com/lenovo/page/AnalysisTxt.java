package com.lenovo.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lenovo.db.propertites.Propertites;
import com.lenovo.entity.CommentInfo;
import com.lenovo.entity.CommentUser;
import com.lenovo.entity.PageAllParam;
import com.lenovo.entity.ReplayList;

/**
 *分析TXT中的json串
 * @author Pecan-M
 *
 */
public class AnalysisTxt {
	public static Propertites regexPropertites=Propertites.getInstance();
	/**
	 * 抓取文件中的属性到PageAllParam，再封装到一个ArrayList中
	 * @param list  从文本中拿过来的行数据
	 * @return  返回一个封装了实体类PageAllParam数据的ArrayList
	 */
	public ArrayList<PageAllParam> getPageTxt(ArrayList<String> list){
		   ArrayList<PageAllParam> arrayList=new ArrayList<PageAllParam>();
		   JSONObject jsonObject=null;
		   Iterator<String> iterator=list.iterator();
		   while (iterator.hasNext()) {
			   try {
				jsonObject=new JSONObject(iterator.next());
               PageAllParam pageAllParam=new PageAllParam(jsonObject.getString("brand"),jsonObject.getString("name"),jsonObject.getString("buyURL"),
						jsonObject.getString("amazonURL"),jsonObject.getString("amazonPrice"),jsonObject.getString("buyPrice"),
						jsonObject.getString("brandURL"),jsonObject.getString("category"),jsonObject.getString("categoryURL"),
						jsonObject.getString("imageURL"),jsonObject.getString("paramURL"),jsonObject.getString("priceUrl"),
						jsonObject.getString("series"),jsonObject.getString("seriesURL"),jsonObject.getString("URL"),
						jsonObject.getString("MD5"),jsonObject.getString("ScreenSize"),jsonObject.getString("Resolution"),
						jsonObject.getString("CpuModel"),jsonObject.getString("CpuFrequency"),jsonObject.getString("Memary"),
						jsonObject.getString("HardDisk"),jsonObject.getString("HardDiskType"),jsonObject.getString("Graphics"),
						jsonObject.getString("Weight"),jsonObject.getString("OS"),jsonObject.getString("Camera"));
                       arrayList.add(pageAllParam);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
		   arrayList.remove("");
		   return arrayList;
	   }

	public HashMap<String, ArrayList<PageAllParam>> getPageList(HashMap<String, ArrayList<String>> hashMap){
		HashMap<String, ArrayList<PageAllParam>> hashMap2=new HashMap<String, ArrayList<PageAllParam>>();
		Iterator<Entry<String, ArrayList<String>>> iterator = hashMap.entrySet().iterator();
		ArrayList<PageAllParam> allParams=null;
		while (iterator.hasNext()) {
			Entry<String, ArrayList<String>> entry = (Entry<String, ArrayList<String>>) iterator.next();
			allParams=getPageTxt(entry.getValue());
			hashMap2.put(entry.getKey(), allParams);
		}
		return hashMap2;
	}
	
	/**
	 * 使用json解析  封装在arrayList中
	 * @param list 评论文件中的行数据
	 * @return 封装好的 commentInfo对象
	 */
	public ArrayList<CommentInfo> getCommentTxt(ArrayList<String> list) {
		   ArrayList<CommentInfo> arrayList=new ArrayList<CommentInfo>();
		   JSONObject jsonObject=null;
		   JSONArray replayList=null;
		   JSONObject user=null;
		   JSONObject replay=null;
		   Iterator<String> iterator=list.iterator();
		   while (iterator.hasNext()) {
			   try {
				jsonObject=new JSONObject(iterator.next());
				   replayList=jsonObject.getJSONArray("replayList");
				   user=jsonObject.getJSONObject("user");
				   ArrayList<ReplayList> replayLists=new ArrayList<ReplayList>(replayList.length());
				   for (int i = 0; i < replayList.length(); i++) {
					   replay=replayList.getJSONObject(i);
					   ReplayList replays=new ReplayList(replay.getString("author"), replay.getString("content"), replay.getString("publishTime"), replay.getString("title"));
					   replayLists.add(replays);
				}
				  CommentUser commentUser=new CommentUser(user.getString("address"), user.getString("name"), user.getString("grade"), user.getString("ip"), user.getString("registerTime")); 
				  CommentInfo commentInfo=new CommentInfo(jsonObject.getString("advantage").trim(), jsonObject.getString("buyTime").trim(), jsonObject.getString("content").trim(), jsonObject.getString("disadvantage").trim(), jsonObject.getString("opposeNum"), jsonObject.getString("publishTime").trim(), replayLists, commentUser, jsonObject.getString("service").trim(), jsonObject.getString("summary").trim(), jsonObject.getString("supportNum"), jsonObject.getString("title").trim(), jsonObject.getString("userRank").trim());
				 arrayList.add(commentInfo);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   return arrayList;
	   }
	
}
