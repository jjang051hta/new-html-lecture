<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String userID = request.getParameter("userID");
JDBCConnect jdbcConn = new JDBCConnect();
String sql = "select * from member where id = ?";
/*
String sql = "select "+
			    "rpad(substr(id,1,3),length(id),'*') AS id,"+
			    "password,"+
			    "substr(name,1,1) || lpad('*',length(name)-2,'*') || substr(name, length(name), 1) AS name,"+
				"rpad(substr(postcode,1,2),5,'*') AS postCode,"+
				"rpad(substr(address,1,4),length(address),'*') AS address,"+
				"regdate "+
"from member where id = ?";
*/
PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
pstmt.setString(1, userID);
ResultSet rs = pstmt.executeQuery();
String userPW = null;
String userName = null;
String postCode = null;
String address = null;
String regDate = null;

if (rs.next()) {
	userPW = rs.getString("password");
	userName = rs.getString("name");
	postCode = rs.getString("postCode");
	address = rs.getString("address");
	regDate = rs.getString("regDate");
} else {
	ScriptWriter.alertAndBack(response, "서버 오류입니다. 잠시 후 다시 시도해주세요.");
}
jdbcConn.close();
%>
<%@ include file="../include/header.jsp"%>
<div class="info w-100 m-auto">
	<table class="table striped">
		<tbody>
			<tr>
				<th scope="row">ID</th>
				<td><%=userID%></td>
			</tr>
			<tr>
				<th scope="row">password</th>
				<td><%=userPW%></td>
			</tr>
			<tr>
				<th scope="row">name</th>
				<td><%=userName%></td>
			</tr>
			<tr>
				<th scope="row">post code</th>
				<td><%=postCode%></td>
			</tr>
			<tr>
				<th scope="row">address</th>
				<td><%=address%></td>
			</tr>
			<tr>
				<th scope="row">regdate</th>
				<td><%=regDate%></td>
			</tr>
		</tbody>
	</table>
	
	<div class="d-flex justify-content-center">
		<a href="../member/delete.jsp" class="btn btn-primary">회원탈퇴</a>
		<a href="../member/modify.jsp" class="btn btn-secondary mx-1">정보수정</a>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>















