<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	
	

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
	if(result>0) {
		System.out.println("입력 되었음");
	} else  {
		System.out.println("입력 어류");
	}
	
	//db접속
	
%>









