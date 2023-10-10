package com.juju.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBCConnect {	
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	public JDBCConnect() {
		try {
			String driver = "oracle.jdbc.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userID = "jjang051";
			String userPW = "1234";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userID, userPW);
			
			System.out.println("DB연결됨");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public JDBCConnect(String driver, String url, String userID, String userPW) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userID, userPW);
			
			System.out.println("DB연결됨");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
