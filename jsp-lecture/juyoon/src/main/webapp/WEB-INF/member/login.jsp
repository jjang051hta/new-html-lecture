<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="form-signin w-100 m-auto">
	<form action="../member/login-process" method="post">

		<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

		<div class="form-floating">
			<input type="text" name="userID" class="form-control" id="userID"
				value="${cookie.saveIDCookie.value }" placeholder="user id"> <label for="userID">user
				ID</label>
		</div>
		<div class="form-floating">
			<input type="password" name="userPW" class="form-control" id="userPW"
				placeholder="user pw"> <label for="userPW">user PW</label>
		</div>

		<div class="form-check text-start my-3">
			<input class="form-check-input" type="checkbox" value="rememberMe"
				id="flexCheckDefault" name="saveID"
					<c:if test="${not empty cookie.saveIDCookie }">checked</c:if>>
				<label
				class="form-check-label" for="flexCheckDefault"> Remember me
				
			</label>
		</div>
		<button class="btn btn-primary w-100 py-2" type="submit">Sign
			in</button>
		<!-- <p class="mt-5 mb-3 text-body-secondary">© 2017–2023</p> -->
	</form>
</div>


<%@ include file="../include/footer.jsp"%>
