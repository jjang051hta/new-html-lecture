<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. driver찾기...
	String driver = "oracle.jdbc.OracleDriver";
	Class.forName(driver);
	// 17  ojdbc11, 11 ojdbc9
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jjang051";
	String pw = "1234";
	
	Connection conn = DriverManager.getConnection(url, id, pw);
	System.out.println("db연결 성공");
	// 쿼리쓰고 결과값 받아오기....
	// 1. 쿼리문 처리 메서드
	// 2. 결과값 받아오기  select 를 제외하고 나머지는 정수
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from test order by regdate desc";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	/*
	if(rs.next()) {
		System.out.println(rs.getString("id"));
		System.out.println(rs.getString("password"));
	}
	if(rs.next()) {
		System.out.println(rs.getString("id"));
		System.out.println(rs.getString("password"));
	}
	if(rs.next()) {
		System.out.println(rs.getString("id"));
		System.out.println(rs.getString("password"));
	}
	*/
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.7.1.min.js"></script>

</head>
<body>
	<form action="delete-all.jsp" id="listForm">
	<table border="1">
		<thead>
			<tr>
				<th>no</th>
				<th>id</th>
				<!-- <th>password</th>-->
				<th>age</th>
				<th>birth</th>
				
				<th>regdate</th>
				<th>삭제</th>
				<th><input type="checkbox" name="allCheck" id="allCheck"></th>
				
				
			</tr>
		</thead>
		<tbody>
		<%
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getInt("no")+"</td>");
				out.println("<td><a href='info.jsp?id="+rs.getString("id")+"'>"+rs.getString("id")+"</a></td>");
				//out.println("<td>"+rs.getString("password")+"</td>");
				out.println("<td>"+rs.getInt("age")+"</td>");
				out.println("<td>"+rs.getInt("birthyear")+"</td>");
				
				out.println("<td>"+rs.getString("regdate")+"</td>");
				out.println("<td><input type='checkbox' class='check' name='check' value='"+rs.getInt("no")+"'></td>");
				out.println("</tr>");
			}
		%>
		</tbody>
	</table>
	</form>
	<button class="btnAllDelete">전체 삭제</button>
	<script>
		$("#allCheck").on("click",function(){
			if($(this).is(":checked")) {
				$(".check").prop("checked",true);
			} else {
				$(".check").prop("checked",false);
			}
		});
		$(".btnAllDelete").on("click",function(){
			$("#listForm").submit();
		})
	</script>
</body>
</html>








