<%@page import="util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%

	String isChecked = "";

	String cookieID = CookieManager.readCookie(request, "saveIDCookie");
	if(cookieID.equals("") || cookieID==null) {
		isChecked = "";
	} else {
		isChecked = "checked";
	}


	/* String cookieID = CookieManager.readCookie(request, "saveIDCookie");
	System.out.println(cookieID); */
	/* String isChecked = ""; */
	/* if(cookieID.equals("")) {
		isChecked = "";
	} else {
		isChecked = "checked";
	}
	System.out.println(isChecked);
	System.out.println(isChecked.equals("")); */
	
	
	
	
%>

<div class="form-signin w-100 m-auto">
	<form action="login-process.jsp" method="post">
		<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

		<div class="form-floating">
			<input type="text" name="userID" class="form-control" id="userID" value="<%=cookieID %>"
				placeholder="user id"> <label for="userID">userID</label>
		</div>
		<div class="form-floating">
			<input type="password" name="userPW" class="form-control" id="userPW"
				placeholder="Password"> <label for="userPW">Password</label>
		</div>

		<div class="form-check text-start my-3">
			<input class="form-check-input" type="checkbox" value="rememberMe"
				id="flexCheckDefault" name="saveID" <%= isChecked %>> <label class="form-check-label"
				for="flexCheckDefault"> Remember me </label>
		</div>
		<button class="btn btn-primary w-100 py-2" type="submit">Sign
			in</button>
		<p class="mt-5 mb-3 text-body-secondary">© 2017–2023</p>
	</form>
</div>
<%@ include file="../include/footer.jsp"%>