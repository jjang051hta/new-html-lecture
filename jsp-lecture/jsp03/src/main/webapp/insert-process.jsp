<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	int userAge =  Integer.parseInt( request.getParameter("userAge"));
	int birthYear =  Integer.parseInt( request.getParameter("birthYear"));
	
	
	// db 집어넣기
	
	String driver = "oracle.jdbc.OracleDriver";
	Class.forName(driver);
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jjang051";
	String pw = "1234";
	Connection conn = DriverManager.getConnection(url, id, pw);
	PreparedStatement pstmt = null;
	String sql = "insert into test values(seq_test.nextval,?,?,?,?,sysdate)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userID);
	pstmt.setString(2, userPW);
	pstmt.setInt(3, userAge);
	pstmt.setInt(4, birthYear);
	
	int result = pstmt.executeUpdate();
	if(result > 0) {
		//out.println("<script>alert();</script>");
		ScriptWriter.alertAndNext(response, "회원가입이 되었습니다.", "list.jsp");
	} else {
		//out.println("회원가입이 잘못되었습니다.");
		ScriptWriter.alertAndBack(response, "서버 오류로 회원가입이 되지않았습니다.");
	}
%>































