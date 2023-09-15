<%@page import="common.JDBCConnect"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JDBCConnect jdbcConn = new JDBCConnect();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from test order by regdate desc";
	pstmt = jdbcConn.conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
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
			jdbcConn.close();
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








