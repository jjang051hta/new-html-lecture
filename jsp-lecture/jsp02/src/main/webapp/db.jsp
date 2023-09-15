<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.ConnectionBuilder"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	try{
		Connection con = null;
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";  
        String id = "jjang051";
        String pwd = "1234"; 
        con = DriverManager.getConnection(url, id, pwd);
        //DataSource dadatSource= null;
        //System.out.println("DB 연결 성공(기본 생성자)");
	} catch (Exception e){
		e.printStackTrace();
	}


	//Class.forName("oracle.jdbc.OracleDriver");	

%>