<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

String strPage = request.getParameter("page");
int intPage = 1;
if(strPage==null || strPage.isEmpty()) {
	intPage=1;
} else {
	intPage = Integer.parseInt(strPage);
}

JDBCConnect jdbcConn = new JDBCConnect();
PreparedStatement pstmt = null;
String countSql = "select count(*) as total from board";  
pstmt = jdbcConn.conn.prepareStatement(countSql);
ResultSet countRs = pstmt.executeQuery();
int total = 0;
if(countRs.next()) {
	total = countRs.getInt("total"); 
}
int listPerPage = 10; // 한번에 보여지는 list 갯수
System.out.println("total==="+total+"(double)total/listPerPage"+(double)total/listPerPage+"total/listPerPage"+total/listPerPage);
int pageTotal = (int)Math.ceil((double)total/listPerPage);   // 바닥에 뿌려질 pagination의 갯수
System.out.println("pageTotal==="+pageTotal);
String sql = "SELECT * FROM " + "(SELECT rownum AS num, b01.* from " + "(SELECT * FROM board ORDER BY NO DESC) b01"
		+ ")" + "WHERE num >= ? AND num <= ?";
pstmt = jdbcConn.conn.prepareStatement(sql);
pstmt.setInt(1,(intPage-1)*listPerPage+1);
pstmt.setInt(2,intPage*listPerPage);

ResultSet rs = pstmt.executeQuery();
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
					<%
					while (rs.next()) {
					%>
					<tr>
						<td><%=rs.getInt("no")%></td>
						<td><a href="../board/view.jsp?no=<%=rs.getInt("no")%>"><%=rs.getString("title")%></a></td>
						<td><%=rs.getString("name")%></td>
						<td><%=rs.getString("regdate")%></td>
						<td><%=rs.getInt("hit")%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>

			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<%for(int i=1;i<=pageTotal;i++){ %>
					
					<li class="page-item"><a class="page-link" href="../board/list.jsp?page=<%=i%>"><%=i %></a></li>
					<%} %>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>


			<div class="d-flex justify-content-center mt-5">
				<a href="../board/write.jsp" class="btn btn-primary">글쓰기</a>
			</div>


			<form action="../board/board-search-process.jsp">
				<select name="searchItem">
					<option value="title">제목</option>
					<option value="name">글쓴이</option>
					<option value="content">내용</option>
					<option value="all">싹다</option>

				</select> <input type="text" name="searchWord">
				<button>검색</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>



