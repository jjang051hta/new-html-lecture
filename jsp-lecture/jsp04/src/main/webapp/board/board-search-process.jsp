<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String searchItem = request.getParameter("searchItem");
	String searchWord = request.getParameter("searchWord");
	
	System.out.println(searchItem);
	System.out.println(searchWord);
	
	String sql = "";
	JDBCConnect jdbcConn = new JDBCConnect();
	PreparedStatement pstmt = null;
	if(searchItem.equals("title")) {
		sql = "SELECT * FROM BOARD WHERE title like '%'||?||'%'";
		pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,searchWord);
	} else if(searchItem.equals("name")) {
		sql = "SELECT * FROM BOARD WHERE name like '%'||?||'%'";
		pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,searchWord);
	} else if(searchItem.equals("content")) {
		sql = "SELECT * FROM BOARD WHERE content like '%'||?||'%'";
		pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,searchWord);
	} else {
		sql = "SELECT * FROM BOARD WHERE content like '%'||?||'%' or name like '%'||?||'%' or title like '%'||?||'%'";
		pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,searchWord);
		pstmt.setString(2,searchWord);
		pstmt.setString(3,searchWord);
	}
	// column은 ? 처리 안됨 ?는 값만 처리... mybatis 에서는 #{}츠로 처리 가능
	ResultSet  rs = pstmt.executeQuery();
%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<div class="row  d-flex justify-content-center">
		<div class="col-10">
			<h2 class="mb-5 mt-5">글 목록</h2>
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
			<form action="../board/board-search-process.jsp">
				<select name="searchItem">
					<option value="title">제목</option>
					<option value="name">글쓴이</option>
					<option value="content">내용</option>
				</select>
				<input type="text" name="searchWord">
				<button>검색</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>