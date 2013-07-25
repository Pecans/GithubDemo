package com.lenovo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lenovo.page.AnalysisTxt;
/**
 * 连接数据库的类
 * @author Pecan-M
 *
 */
public class DBConnect {
	Connection conn=null;
	static{
		try {
			Class.forName(AnalysisTxt.regexPropertites.getProperty("driverClass"));
		//	System.out.println("Properties:----Registration drive success!    OK!");
		} catch (ClassNotFoundException e) {
			System.out.println("Properties:----Registration drive failure!"+e.getMessage());
		}
	}
	/**
	 * 获取连接
	 * @return  connection连接
	 */
	public Connection getConn() {
		try {
			conn=DriverManager.getConnection(AnalysisTxt.regexPropertites.getProperty("url"),AnalysisTxt.regexPropertites.getProperty("user"),AnalysisTxt.regexPropertites.getProperty("pwd"));
	//		System.out.println("Properties:----Connection success!    OK!");
		} catch (SQLException e) {
			System.out.println("Properties:----Connection failure!："+e.getMessage());
		}
		return conn;
	}
	/**
	 * 关闭工具方法
	 * @param con
	 * @param preparedStatement
	 * @param rs
	 */
	public void close(Connection con,PreparedStatement preparedStatement,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
				rs = null;
			}if(preparedStatement!=null){
				preparedStatement.close();
				preparedStatement = null;
			}if(con!=null&&!con.isClosed()){
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
