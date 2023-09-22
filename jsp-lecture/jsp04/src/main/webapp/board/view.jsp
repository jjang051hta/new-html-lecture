<%@page import="util.CookieManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
JDBCConnect jdbcConn = new JDBCConnect();
PreparedStatement pstmt = null;
int no = 0;
String strNo = request.getParameter("no");
if (strNo != null) {
	no = Integer.parseInt(strNo);
}

String visitedCookieValue = CookieManager.readCookie(request, "visitedCookie");
boolean isUpdate = true;
if(visitedCookieValue.isEmpty()) {
	//System.out.println("비어있습니다.");
	//cookie 생성
	CookieManager.createCookie(response, "visitedCookie", strNo, 60*60*24);
} else {
	//System.out.println("한번 왔었어요.");
	if(visitedCookieValue.contains(strNo)) {
		isUpdate=false;
	} else {
		isUpdate=true;
		CookieManager.deleteCookie(response, "visitedCookie");
		CookieManager.createCookie(response, "visitedCookie", 
								   visitedCookieValue+"/"+strNo, 60*60*24);
	}
}
if(isUpdate){
	String updateSql = "update board set hit = hit + 1 where no = ?";
	pstmt = jdbcConn.conn.prepareStatement(updateSql);
	pstmt.setInt(1, no);
	pstmt.executeUpdate();
}

String sql = "select * from board where no = ?";
pstmt = jdbcConn.conn.prepareStatement(sql);
pstmt.setInt(1, no);
ResultSet rs = pstmt.executeQuery();
%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<div class="row d-flex justify-content-center">
		<div class="col-10">
			<h2 class="mb-5 mt-5">글보기</h2>
			<table class="table">
				<colgroup>
					<col style="width: 15%">
					<col style="width: 35%">
					<col style="width: 15%">
					<col style="width: 35%">
				</colgroup>
				<%
				if (rs.next()) {
				%>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3"><%=rs.getString("title")%></td>
					</tr>
					<tr>
						<th>글쓴이</th>
						<td colspan="3"><%=rs.getString("name")%></td>
					</tr>
					<tr>
						<th>날짜</th>
						<td><%=rs.getString("regdate")%></td>
						<th>조회수</th>
						<td><%=rs.getInt("hit")%></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3" class="content"><%=rs.getString("content")%></td>
					</tr>
				</tbody>
			</table>
			<div class="d-flex justify-content-center mt-5">
				<a href="../board/list.jsp" class="btn btn-primary">목록</a> <a
					href="../board/write.jsp" class="btn btn-primary mx-1">글쓰기</a>
				<%
				if (loggedID != null) {
					if (loggedID.equals(rs.getString("id"))) {
				%>
				<a href="../board/delete.jsp?no=<%=rs.getInt("no")%>"
					class="btn btn-danger mx-1">지우기</a> <a
					href="../board/modify.jsp?no=<%=rs.getInt("no")%>"
					class="btn btn-danger mx-1">수정하기</a>
				<%
				}
				}
				%>
			</div>

		</div>
	</div>
</div>
<%
}
jdbcConn.close();
%>
<%@ include file="../include/footer.jsp"%>






