<%@page import="common.JDBCConnect"%>
<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String userPW = request.getParameter("userPW");
	String userID = request.getParameter("userID");
	
	JDBCConnect jdbcConn = new JDBCConnect();
	
	PreparedStatement pstmt = null;
	String sql = "delete from test where id = ? and password = ? ";
	pstmt = jdbcConn.conn.prepareStatement(sql);
	pstmt.setString(1,userID);
	pstmt.setString(2,userPW);
	int result = pstmt.executeUpdate();
	if(result>0) {
		ScriptWriter.alertAndNext(response, "탈퇴되었습니다.", "list.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "비번확인");
	}
	jdbcConn.close();
%>    




