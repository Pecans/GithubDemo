package com.lenovo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.lenovo.db.DBConnect;
import com.lenovo.entity.BatchBean;

/**
 * 执行SQL语句的类
 * @author Pecan-M
 *
 */
public class SQLOperation {
	private DBConnect dbConnect=new DBConnect();
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	private ResultSet rs=null;
	private String sql=null;

	/**
	 * 打开连接	
	 */
	public void openConn(){
		connection=dbConnect.getConn();
	}
	
	/**
	 * 关闭连接
	 */
	public void closeConn(){
		dbConnect.close(connection, preparedStatement, rs);
	}
	/**
	 * 用URL获取产品ID
	 * @param URL 某网站下产品的URL
	 * @param website 网站名
	 * @return 产品ID
	 */
	public int[] getProductIDByURL(String URL, String website){
		sql="SELECT productID,seriesID,brandID,categoryID FROM productinfo WHERE "+website+"_productURL=? ";
		int[] ID=new int[4];
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, URL);
			rs=preparedStatement.executeQuery();
			while (rs.next()) {
				 ID[0]=rs.getInt(1);
				 ID[1]=rs.getInt(2);
				 ID[2]=rs.getInt(3);
				 ID[3]=rs.getInt(4);
				 return ID;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	/**
	 * 向评论表中插入数据
	 * @param productID 产品ID
	 * @param brandID 品牌ID
	 * @param seriesID 系列ID
	 * @param categoryID 类别ID
	 * @param product_commentID 此产品在评论中的ID
	 * @param advantage 优点
	 * @param buyTime 购买时间
	 * @param content 内容
	 * @param disadvantage 缺点
	 * @param opposeNum  反对数量
	 * @param publishTime 发表时间
	 * @param replyList 回复列表
	 * @param service 服务
	 * @param summary  评论摘要
	 * @param supportNum 支持数量
	 * @param title 评论标题
	 * @param user 用户
	 * @param userRank 用户支持
	 * @param address 地址
	 * @param grade 级别
	 * @param ip 
	 * @param registerTime
	 */
	public void setCommentID(int productID, int brandID, int seriesID, int categoryID, int websiteID, int product_commentID,
			                                 String advantage, String buyTime, String content, String disadvantage, String opposeNum,
			                                 String publishTime, String replyList, String service, String summary,String supportNum, String title, 
			                                 String user, String userRank, String address, String grade, String ip, String registerTime){
		sql="INSERT INTO comment1(productID, brandID,seriesID,categoryID,product_commentID,advantage, buyTime, content, disadvantage,opposeNum,publishTime, replyList, service," +
				"                                  summary,supportNum, title,user, userRank, address, grade, ip, registerTime, websiteID) " +
				"                                  VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, productID);
			preparedStatement.setInt(2, brandID);
			preparedStatement.setInt(3, seriesID);
			preparedStatement.setInt(4, categoryID);
			preparedStatement.setInt(5, product_commentID);
			preparedStatement.setString(6, advantage);
			preparedStatement.setString(7, buyTime);
			preparedStatement.setString(8, content);
			preparedStatement.setString(9, disadvantage);
			preparedStatement.setString(10, opposeNum);
			preparedStatement.setString(11, publishTime);
			preparedStatement.setString(12, replyList);
			preparedStatement.setString(13, service);
			preparedStatement.setString(14, summary);
			preparedStatement.setString(15, supportNum);
			preparedStatement.setString(16, title);
			preparedStatement.setString(17, user);
			preparedStatement.setString(18, userRank);
			preparedStatement.setString(19, address);
			preparedStatement.setString(20, grade);
			preparedStatement.setString(21, ip);
			preparedStatement.setString(22, registerTime);
			preparedStatement.setInt(23, websiteID);
			if (preparedStatement.executeUpdate()==1) {
				System.out.println(">>>>插入评论表："+productID+"  成功！Title为"+title);
			}else {
				System.out.println("><<<<<<<<<<>插入产品表："+productID+"   失败！！网站为"+title+"<<<<Title");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setCommentIDBatch(ArrayList<BatchBean> batchBeans){
		sql="INSERT INTO comment1(productID, brandID,seriesID,categoryID,product_commentID,advantage, buyTime, content, disadvantage,opposeNum,publishTime, replyList, service," +
				"                                  summary,supportNum, title,user, userRank, address, grade, ip, registerTime, websiteID) " +
				"                                  VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			preparedStatement=connection.prepareStatement(sql);
			for (BatchBean batchBean : batchBeans) {
				preparedStatement.setInt(1, batchBean.getProductID());
				preparedStatement.setInt(2, batchBean.getBrandID());
				preparedStatement.setInt(3, batchBean.getSeriesID());
				preparedStatement.setInt(4, batchBean.getCategoryID());
				preparedStatement.setInt(5, batchBean.getProduct_commentID());
				preparedStatement.setString(6, batchBean.getAdvantage());
				preparedStatement.setString(7, batchBean.getBuyTime());
				preparedStatement.setString(8, batchBean.getContent());
				preparedStatement.setString(9, batchBean.getDisadvantage());
				preparedStatement.setString(10, batchBean.getOpposeNum());
				String publishTime=batchBean.getPublishTime();
				if (publishTime.equals("")||publishTime==null) {
					preparedStatement.setNull(11, Types.TIMESTAMP);
				}else {
					preparedStatement.setString(11, publishTime);
				}
				preparedStatement.setString(12, batchBean.getReplyList());
				preparedStatement.setString(13, batchBean.getService());
				preparedStatement.setString(14, batchBean.getSummary());
				preparedStatement.setString(15, batchBean.getSupportNum());
				preparedStatement.setString(16, batchBean.getTitle());
				preparedStatement.setString(17, batchBean.getUser());
				preparedStatement.setString(18, batchBean.getUserRank());
				preparedStatement.setString(19, batchBean.getAddress());
				preparedStatement.setString(20, batchBean.getGrade());
				preparedStatement.setString(21, batchBean.getIp());
				preparedStatement.setString(22, batchBean.getRegisterTime());
				preparedStatement.setInt(23, batchBean.getWebsiteID());
				preparedStatement.addBatch();
			}
			int a[]=preparedStatement.executeBatch();
			System.out.println("成功插入"+a.length+"条评论！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	/**
	 * 获取评论ID
	 * @param productID 产品ID
	 * @param product_commentID 产品ID排行
	 * @return 唯一评论ID
	 */
	public int getCommentID(int productID, int product_commentID){
		sql="SELECT commentID FROM comment1 WHERE productID=? AND product_commentID=?";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, productID);
			preparedStatement.setInt(2, product_commentID);
			rs=preparedStatement.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 插入回复表
	 * @param commentID 产品ID
	 * @param comment_replyID 回复数量
	 * @param author 回复作者
	 * @param publishTime 发表时间
	 * @param title 题目
	 * @param replyConent 回复内容
	 */
	public void setReplyID(int commentID,int comment_replyID, String author, String publishTime, String title, String replyConent){
		sql="INSERT INTO reply1(commentID,comment_replyID,author,publishTime,title,replyContent) VALUES ( ?, ?, ?, ?, ?, ?)";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, commentID);
			preparedStatement.setInt(2, comment_replyID);
			preparedStatement.setString(3, author);
			preparedStatement.setString(4, publishTime);
			preparedStatement.setString(5, title);
			preparedStatement.setString(6, replyConent);
			if (preparedStatement.executeUpdate()==1) {
				System.out.println(">>>>插入回复表 评论ID为："+commentID+"  成功！Title为"+title);
			}else {
				System.out.println("><<<<<<<<<<>插入产品表 评论ID为："+commentID+"   失败！！网站为"+title+"<<<<Title");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取评论数量
	 * @param productID
	 * @return  COUNT（*）
	 */
	public int getCommentIDCount(int productID){
		sql="SELECT COUNT(*) FROM comment1 WHERE productID=?";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, productID);
			rs=preparedStatement.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 获取网站ID
	 * @param websiteName
	 * @return
	 */
	public int getWebsiteIDByName(String websiteName){
		sql="SELECT websiteID FROM website WHERE websiteName=?";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, websiteName);
			rs=preparedStatement.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 更新图片地址
	 * @param path
	 * @param productID
	 * @return
	 */
	public int updateProductinfoImagePath(String path,int productID){
		sql="UPDATE productinfo SET imagePath=? WHERE productID=?";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, path);
			preparedStatement.setInt(2, productID);
			System.out.println(path+"     ID:"+productID+"    "+preparedStatement.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
