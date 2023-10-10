<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="container">
	<div class= "row d-flex justify-content-center">
		<div class= "col-8">
			<form action="../board/modify-process" method="post">
				<input type="hidden" name="no" value="${param.no}">
				<div class="mb-3">
  					<label for="password" class="form-label">password</label>
  					<input type="password" class="form-control" id="password" name="password" placeholder="비번">
				</div>
				<div class="mt-5 mb-5 d-flex justify-content-center">
					<button class="btn btn-primary mx-1">수정</button>           
         		    <button type="reset" class="btn btn-secondary mx-1">취소</button>
				</div>
			
			</form>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp" %>