<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp"%>
<div class="info w-100 m-auto">
	<table class="table table-striped">
		<tbody>
			<c:choose>
				<c:when test="${empty infoMember.profile}">
					<tr>
						<th scope="row">Profile</th>
						<td><img
							src="../images/user.png"
							class="profile"></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<th scope="row">Profile</th>
						<td><img
							src="${pageContext.request.contextPath }/upload/${infoMember.profile}"
							class="profile"></td>
					</tr>
				</c:otherwise>
			</c:choose>

			<tr>
				<th scope="row">ID</th>
				<td>${loggedID}</td>
			</tr>
			<tr>
				<th scope="row">password</th>
				<td>${infoMember.password }</td>

			</tr>
			<tr>
				<th scope="row">name</th>
				<td>${sessionScope.loggedName}</td>
			</tr>
			<tr>
				<th scope="row">zipCode</th>
				<td>${infoMember.zipCode }</td>
			</tr>
			<tr>
				<th scope="row">address</th>
				<td>${infoMember.address }</td>
			</tr>
			<tr>
				<th scope="row">detail address</th>
				<td>${infoMember.addressDetail }</td>
			</tr>
			<tr>
				<th scope="row">regdate</th>
				<td>${infoMember.regDate}</td>
			</tr>
		</tbody>
	</table>
	<div class="d-flex justify-content-center">
		<a href="../member/delete" class="btn btn-primary">회원탈퇴</a> <a
			href="../member/modify" class="btn btn-secondary mx-1">정보수정</a>

	</div>
</div>
<%@ include file="../include/footer.jsp"%>