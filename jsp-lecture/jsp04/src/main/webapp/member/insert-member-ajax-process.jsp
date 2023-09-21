<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.mindrot.jbcrypt.BCrypt"%>
<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	
	//response.setContentType("application/json")
	try {
		JDBCConnect jdbcConn =  new JDBCConnect();
		
	
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		int postCode = 0;
		if(request.getParameter("postCode")!=null) {
			postCode = Integer.parseInt(request.getParameter("postCode"));
		}
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
	
		System.out.println(userID);
		System.out.println(userPW);
		System.out.println(userName);
		
		System.out.println(postCode);
		System.out.println(address);
		System.out.println(detailAddress);
		
		String sql = 
				"insert into member values(seq_member.nextval,?,?,?,?,?,?,sysdate)";
		PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,userID);
		pstmt.setString(2,userPW);
		pstmt.setString(3,userName);
		pstmt.setInt(4,postCode);
		pstmt.setString(5,address);
		pstmt.setString(6,detailAddress);
		
		
		
		int result = pstmt.executeUpdate();
		Map<String, String> map = new HashMap<>();
		if(result>0) {
			map.put("isMemberInsert","success");
		} else  {
			map.put("isMemberInsert","fail");
		}
		Gson gson = new Gson();
		String json = gson.toJson(map);
		out.println(json);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	//db접속
	
%>









