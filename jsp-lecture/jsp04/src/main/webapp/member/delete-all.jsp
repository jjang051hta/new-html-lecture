<%@page import="util.ScriptWriter"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String idx[] = request.getParameterValues("check");
	/* for(int i=0;i<idx.length;i++) {
		System.out.println(idx[i]);
	} */
	JDBCConnect jdbcConn = new JDBCConnect();
	String sql = "delete from member where no = ?";
	try {
		PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
		int count= 0;
		jdbcConn.conn.setAutoCommit(false);
		for(int i=0;i<idx.length;i++) {
			pstmt.setInt(1,Integer.parseInt(idx[i]));
			pstmt.addBatch();
		}
		int result[] = pstmt.executeBatch();
		System.out.println(result.length);
		System.out.println(Arrays.toString(result));
		jdbcConn.conn.commit();		
		ScriptWriter.alertAndNext(response, "삭제가 되었습니다.","../member/list.jsp");
	} catch (Exception e) {
		jdbcConn.conn.rollback();
		e.printStackTrace();
		ScriptWriter.alertAndBack(response, "서버 오류 입니다. 잠시 후 다시 시도해 주세요.");
	} finally {
		jdbcConn.conn.setAutoCommit(true);
	}
	
	/*
	for(int i=0;i<idx.length;i++) {
		pstmt.setInt(1,Integer.parseInt(idx[i]));
		int result = pstmt.executeUpdate();
		if(result>0) {
			count++;
		}
		System.out.println(result);
	}
	if(count>=idx.length) {
		jdbcConn.conn.commit();
		System.out.println("같다");
	} else {
		jdbcConn.conn.rollback();
		System.out.println("다르다");
	}
	*/
%>


