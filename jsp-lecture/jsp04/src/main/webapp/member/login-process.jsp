<%@page import="org.mindrot.jbcrypt.BCrypt"%>
<%@page import="util.CookieManager"%>
<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String userID = request.getParameter("userID");
String userPW = request.getParameter("userPW");
String saveID = request.getParameter("saveID");
System.out.println(saveID);

JDBCConnect jdbcConn = new JDBCConnect();




/* String sql02 = "select password from member where id = ?";

PreparedStatement pstmt02 = jdbcConn.conn.prepareStatement(sql02);
pstmt02.setString(1, userID);
String hashPassword = "";
ResultSet rs02 = pstmt02.executeQuery();
if (rs02.next()) {
	hashPassword = rs02.getString("password");
} */

//System.out.println(BCrypt.checkpw(userPW, hashPassword));

String sql = "select * from member where id = ? and password = ?";
PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
pstmt.setString(1, userID);
pstmt.setString(2, userPW);
ResultSet rs = pstmt.executeQuery();
if (rs.next()) {
	session.setAttribute("loggedID", rs.getString("id"));
	session.setAttribute("loggedName", rs.getString("name"));
	//쿠키 설정
	if(saveID!=null){
		if(saveID.equals("rememberMe")) {
			CookieManager.createCookie(response, "saveIDCookie", userID, 60*60*24*365);
		} else {
			CookieManager.deleteCookie(response, "saveIDCookie");
		}
	} else {
		CookieManager.deleteCookie(response, "saveIDCookie");
	}
	response.sendRedirect("../index/index.jsp");
} else {
	//CookieManager.deleteCookie(response, "saveIDCookie");
	ScriptWriter.alertAndBack(response, "아이디 패스워드 확인해 주세요.");
}

/* if (BCrypt.checkpw(userPW, hashPassword)) {
	String sql = "select * from member where id = ?";
	PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
	pstmt.setString(1, userID);
	//pstmt.setString(2, userPW);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		//pageContext> request > session > application		
		session.setAttribute("loggedID", rs.getString("id"));
		session.setAttribute("loggedName", rs.getString("name"));
		if (saveID != null && saveID.equals("remember-me")) {
	CookieManager.createCookie(response, "saveIDCookie", rs.getString("id"), 60 * 60 * 24 * 365);
		} else {
	CookieManager.deleteCookie(response, "saveIDCookie");
		}
		response.sendRedirect("../index/index.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "아이디 패스워드 확인해 주세요.");
	}
} */
jdbcConn.close();
%>









