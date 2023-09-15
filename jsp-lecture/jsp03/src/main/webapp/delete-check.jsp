<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String userPW = request.getParameter("userPW");
	String userID = request.getParameter("userID");

	

	//1. driver찾기...
	String driver = "oracle.jdbc.OracleDriver";
	Class.forName(driver);
	// 17  ojdbc11, 11 ojdbc9
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jjang051";
	String pw = "1234";
	
	Connection conn = DriverManager.getConnection(url, id, pw);
	System.out.println("db연결 성공");
	// 쿼리쓰고 결과값 받아오기....
	// 1. 쿼리문 처리 메서드
	// 2. 결과값 받아오기  select 를 제외하고 나머지는 정수
	PreparedStatement pstmt = null;
	String sql = "delete from test where id = ? and password = ? ";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,userID);
	pstmt.setString(2,userPW);
	int result = pstmt.executeUpdate();
	if(result>0) {
		ScriptWriter.alertAndNext(response, "탈퇴되었습니다.", "list.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "비번확인");
	}
%>    




