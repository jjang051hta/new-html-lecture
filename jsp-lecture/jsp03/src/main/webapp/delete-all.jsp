<%@page import="util.ScriptWriter"%>
<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	request.setCharacterEncoding("UTF-8");
	// 넘어온 데이터 받기
	String idxs[] = request.getParameterValues("check");
	for(int i=0;i<idxs.length;i++) {
		System.out.println(idxs[i]);
	}
	
	// db연결
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jjang051";
	String pw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql =  "DELETE FROM test WHERE NO = ?";
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pw);
		pstmt = conn.prepareStatement(sql);
		conn.setAutoCommit(false);
		for(int i=0;i<idxs.length;i++) {
			pstmt.setInt(1,Integer.parseInt(idxs[i]));
			pstmt.addBatch();
		}
		int result [] = pstmt.executeBatch();
		System.out.println(result.length);
		conn.commit();
		if(result.length>0) {
			ScriptWriter.alertAndNext(response, "글이 삭제되었습니다.", "list.jsp");
		} else {
			ScriptWriter.alertAndBack(response, "서버 오류 입니다. 잠시후 다시 시도해 주시기 바랍니다.");
		}
	} catch (Exception e) {
		conn.rollback();
		e.printStackTrace();
	} finally {
		conn.setAutoCommit(true);
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
	
%>