<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
	<div class="container">
		<h2 class="mb-5 mt-5">WRITE</h2>
		<table class="table list">
		  <thead>
		    <tr>
		      <th scope="col">no</th>
		      <th scope="col">title</th>
		      <th scope="col">writer</th>
		      <th scope="col">date</th>
		      <th scope="col">hit</th>
		      <th scope="col">group</th>
		      <th scope="col">level</th>
		      <th scope="col">step</th>
		      
		      
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${boardList }" var="board" varStatus="status">
		    <tr>
		      <td>${status.index }</td>
		      <td>
		      	<c:choose>
			      	<c:when test="${board.available > 0 }">
				      	<c:choose>
					      	<c:when test="${board.restep > 1 }">
					      		<a href="../board/view?no=${board.no}&num=${board.num}" class="step step${board.restep }">
					      			<c:forEach begin="1" end="${board.restep - 1}">[re]</c:forEach>
					      			${board.title }
					      		</a>
					      	</c:when>
					      	<c:otherwise>
					      		<a href="../board/view?no=${board.no}&num=${board.num}" >${board.title }</a>
					      	</c:otherwise>
				      	</c:choose>
			      	</c:when>
			      	<c:otherwise>
			      		<c:choose>
					      	<c:when test="${board.restep > 1 }">
					      		<span href="../board/view?no=${board.no}" class="step step${board.restep }">
					      			<c:forEach begin="1" end="${board.restep - 1}">[re]</c:forEach>
					      			삭제된 글입니다.
					      		</a>
					      	</c:when>
					      	<c:otherwise>
					      		<span>삭제된 글입니다.</span>
					      	</c:otherwise>
				      	</c:choose>
			      	</c:otherwise>
		      	</c:choose>
		      </td>
		      <td>${board.name }</td>
		      <td>${board.regDate }</td>
		      <td>${board.hit }</td>
		      <td>${board.regroup }</td>
		      <td>${board.relevel }</td>
		      <td>${board.restep }</td>
		      
		    </tr>
		    </c:forEach>
		    
		  </tbody>
		</table>
		
		<!-- <div>
			여기다가 이전 글  다음 글 출력
		</div> -->
		
		<div class="d-flex justify-content-center mt-3 mb-3">
			<a href="../board/write" class="btn btn-primary">글쓰기</a>
		</div>
	</div>
<%@ include file="../include/footer.jsp" %>







    