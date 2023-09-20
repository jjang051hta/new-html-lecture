<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JDBCConnect jdbcConn = new JDBCConnect();
	String sql = "select id,name,postcode,address, addressdetail, regdate from member";
	PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	
%>
<%@ include file = "../include/header.jsp" %>

<%@ include file = "../include/footer.jsp" %>
