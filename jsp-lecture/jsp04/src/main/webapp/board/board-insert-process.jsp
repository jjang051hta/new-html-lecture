<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String password = request.getParameter("password");
	
	String sql = "insert into board values(seq_board.nextval,?,?,?,?,?,sysdate,0)";
	JDBCConnect jdbcConn = new JDBCConnect();
	PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
	pstmt.setString(1,"jjang051");
	pstmt.setString(2,password);
	pstmt.setString(3,"장성호");
	pstmt.setString(4,title);
	pstmt.setString(5,content);
	
	int result = pstmt.executeUpdate();
	if(result>0) {
		ScriptWriter.alertAndNext(response, "글이 등록되었습니다.", "../board/list.jsp");
	}


%>

















