<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	// db 집어넣기
	
	String driver = "oracle.jdbc.OracleDriver";
	Class.forName(driver);
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jjang051";
	String pw = "1234";
	Connection conn = DriverManager.getConnection(url, id, pw);
	PreparedStatement pstmt = null;
	String sql = "insert into test values(?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userID);
	pstmt.setString(2, userPW);
	int result = pstmt.executeUpdate();
	if(result > 0) {
		out.println("회원가입이 되었습니다.");
	} else {
		out.println("회원가입이 잘못되었습니다.");
	}
%>































