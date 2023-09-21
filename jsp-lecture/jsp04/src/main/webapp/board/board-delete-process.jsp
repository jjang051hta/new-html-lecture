<%@page import="util.ScriptWriter"%>
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
	String sql = "delete from board where no = ? and password = ?";
	PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
	pstmt.setInt(1,no);
	pstmt.setString(2,password);
	int result = pstmt.executeUpdate();
	if(result>0) {
		ScriptWriter.alertAndNext(response, "글이 삭제되었습니다.", "../board/list.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "비밀번호 확인해 주세요.");
	}
%>










