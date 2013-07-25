package com.lenovo.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.lenovo.entity.BatchBean;
import com.lenovo.entity.CommentInfo;
import com.lenovo.entity.CommentUser;
import com.lenovo.entity.PageAllParam;
import com.lenovo.entity.ReplayList;
import com.lenovo.page.AnalysisTxt;
import com.lenovo.page.CommentContent;

/** 
 * @author Pecan-M E-mail:wangtianzhen@foxmail.com 
 * @version 创建时间：2013-1-7 下午4:09:20 
 * 向评论表和回复表中写入数据
 */
public class InputComment {

	private SQLOperation sqlOperation=new SQLOperation();
	private CommentContent commentContent=new CommentContent();
	private AnalysisTxt analysisTxt=new AnalysisTxt();
	private String commentFilePath;
	private String commentPath;
	private String URL; 
	private String MD5;
	private int[] ID;
	/**
	 * 对外的入口方法
	 * @param hashMap 传入的是一个HashMap<String, ArrayList<PageAllParam>>类型的数据
	 */
	public void inputComment(HashMap<String, ArrayList<PageAllParam>> hashMap){
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
		commentFilePath=AnalysisTxt.regexPropertites.getProperty("sourcePath");
		System.out.println(website);
		commentFilePath=commentFilePath+"/"+website.replaceAll(".*-", "")+"/"+website.replaceAll("-.*", "");
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
				commentPath=commentFilePath+"/"+MD5+"/comments";
				ArrayList<CommentInfo> arrayList=analysisTxt.getCommentTxt(commentContent.getTxtContent(new File(commentPath)));
				if (arrayList.size()==0) {
					continue;
				}else {
					int commentCount=0;
					int commentID=0;
					commentCount=sqlOperation.getCommentIDCount(ID[0]);
					CommentUser user=null;
					ArrayList<BatchBean> batchBeans=new ArrayList<BatchBean>();
					for (CommentInfo commentInfo : arrayList) {
						ArrayList<ReplayList> replayLists=commentInfo.getReplyList();
						commentCount++;
						user=commentInfo.getUser();
						batchBeans.add(new BatchBean(ID[0], ID[2], ID[1], ID[3], websiteID, commentCount, commentInfo.getAdvantage(), commentInfo.getBuyTime(), commentInfo.getContent(),
								commentInfo.getDisadvantage(), commentInfo.getOpposeNum(), commentInfo.getPublishTime(), commentInfo.getReplyList().toString()
								, commentInfo.getService(), commentInfo.getSummary(), commentInfo.getSupportNum(), commentInfo.getTitle(), user.getName(), 
								commentInfo.getUserRank(), user.getAdress(), user.getGrade(), user.getIp(), user.getRegisterTime()));
						if (replayLists.size()!=0) {
							sqlOperation.setCommentIDBatch(batchBeans);
							batchBeans.clear();
						//	commentID=sqlOperation.getCommentID(ID[0], commentCount);
							if (commentID!=0) {
						//		inputReply(commentInfo.getReplyList(), commentID);
							}
						}
					}
					sqlOperation.setCommentIDBatch(batchBeans);
					System.out.println("当前评论文件结束……");
				}
			}
		}
		sqlOperation.closeConn(); //关闭连接
		return 1;
	}

	/**
	 * 向回复表中插入数据
	 * @param replayLists
	 * @return
	 */
	public int inputReply(ArrayList<ReplayList> replayLists, int commentID){
		if (replayLists.size()==0||replayLists==null) {
			return 0;
		}
		int replyCount=0;
		for (ReplayList replayList : replayLists) {
			replyCount++;
			sqlOperation.setReplyID(commentID, replyCount, replayList.getAuthor(), replayList.getPublishTime(), replayList.getTitle(), replayList.getContent());
		}
		return 1;
	}
}
