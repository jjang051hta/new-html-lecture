<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String loggedID = (String)session.getAttribute("loggedID");
	//String loggedName = (String)session.getAttribute("loggedName");

	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String password = request.getParameter("password");
	String strNo = request.getParameter("no");
	int no = 0;
	if(strNo!=null) {
		no = Integer.parseInt(strNo);
	}
	System.out.println(no);
	System.out.println(loggedID);
	
	
	
	String sql = "update board set title = ?,content = ?, password = ? where id = ? and no = ?";
	JDBCConnect jdbcConn = new JDBCConnect();
	PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
	pstmt.setString(1,title);
	pstmt.setString(2,content);
	pstmt.setString(3,password);
	pstmt.setString(4,loggedID);
	pstmt.setInt(5,no);
	int result = pstmt.executeUpdate();
	if(result>0) {
		ScriptWriter.alertAndNext(response, "글이 수정되었습니다.", "../board/list.jsp");
	}
%>

















