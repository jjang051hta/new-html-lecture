<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	JDBCConnect jdbcConn = new JDBCConnect();
	String sql ="select * from board order by regdate desc"; 
	PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<div class="row  d-flex justify-content-center">
		<div class="col-10">
			<h2>글 목록</h2>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">no</th>
						<th scope="col">title</th>
						<th scope="col">name</th>
						<th scope="col">date</th>
						<th scope="col">hit</th>
					</tr>
				</thead>
				<tbody>
					<%while(rs.next()) { %>
						<tr>
							<td><%= rs.getInt("no") %></td>
							<td><a href="../board/view.jsp?no=<%= rs.getInt("no") %>"><%= rs.getString("title") %></a></td>
							<td><%= rs.getString("name") %></td>
							<td><%= rs.getString("regdate") %></td>
							<td><%= rs.getInt("hit") %></td>
						</tr>
					<%} %>
				</tbody>
			</table>
			<div class="d-flex justify-content-center mt-5">
				<a href="../board/write.jsp" class="btn btn-primary">글쓰기</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>



