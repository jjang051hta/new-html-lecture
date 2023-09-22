<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 넘어오는 값 받기
	// 연결
	// sql
	// pstmt.setInt(1,no);
	// 코드 줘요... 제발...
	int no = 0;
	String strNo = request.getParameter("no");
	String password = request.getParameter("password");
	
	if(strNo!=null) {
		no = Integer.parseInt(strNo);
	}
	JDBCConnect jdbcConn = new JDBCConnect();
	String sql = "select * from board where no = ? and password = ?";
	PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
	pstmt.setInt(1,no);
	pstmt.setString(2,password);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) {
		
		//response.sendRedirect("../board/modify-form.jsp");
		request.setAttribute("title", rs.getString("title"));
		request.setAttribute("content", rs.getString("content"));
		request.setAttribute("no", no);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("../board/modify-form.jsp");
		dispatcher.forward(request, response);
	} else {
		ScriptWriter.alertAndBack(response, "비밀번호 확인해 주세요");
	}
%>


















