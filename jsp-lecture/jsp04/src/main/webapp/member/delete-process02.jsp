<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	response.setContentType("application/json; charset=utf-8");
		JDBCConnect jdbcConn = new JDBCConnect();
		String userPW = request.getParameter("userPW");
		String userID = request.getParameter("userID");
		
		String sql = "delete from member where id = ? and password = ?";
		PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,userID);
		pstmt.setString(2,userPW);
		int result = pstmt.executeUpdate();
		System.out.println(userPW);
		
		Map<String,String> map = new HashMap<>();
		
		if(result>0) {
			map.put("isDelete","success");		
		} else {
			map.put("isDelete","fail");
		}
		Gson gson = new Gson();
		String json = gson.toJson(map);
		out.println(json);
		jdbcConn.close();
	 %>
	 
	 
	 
	 
	 
	 
	 