<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
	<div class="container">
		<h2 class="mb-5 mt-5">WRITE</h2>
		<!-- write-process에 매핑되는 controller가 있어야함. -->
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
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3">${viewBoard.title }</td>
					</tr>
					<tr>
						<th>글쓴이</th>
						<td colspan="3">${viewBoard.name }</td>
					</tr>
					<tr>
						<th>날짜</th>
						<td>${viewBoard.regDate }</td>
						<th>조회수</th>
						<td>${viewBoard.hit }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3" class="content">${viewBoard.content }</td>
					</tr>
				</tbody>
			</table>
			
			<div>
				<span>이전글</span>
				<c:choose>
					<c:when test="${prevBoard.available > 0 }">
						<a href="../board/view?no=${prevBoard.no}&num=${prevBoard.num}">
							${prevBoard.title}
						</a>
					</c:when>
					<c:otherwise>
						<a href="../board/view?no=${prevBoard.no}&num=${prevBoard.num}">
							삭제된 글입니다.
						</a>
					</c:otherwise>
				</c:choose>
			</div>
			<div>
				<span>다음글</span>
				<a href="../board/view?no=${nextBoard.no}&num=${nextBoard.num}">
					${nextBoard.title}
				</a>
			</div>
			
			
			
			<div class="d-flex justify-content-center mt-5">
				<!-- loggedID null 이 아니고 loggedID 랑 board.id랑 같으면 -->
				<a href="../board/list" class="btn btn-primary">목록</a>
				<a href="../board/reply?regroup=${viewBoard.regroup }&relevel=${viewBoard.relevel}&restep=${viewBoard.restep}" class="btn btn-primary mx-1">답글달기</a>
				<a href="../board/delete?no=${viewBoard.no }" class="btn btn-danger mx-1">삭제</a>
			</div>

		</div>
	</div>
</div>
	</div>
<%@ include file="../include/footer.jsp" %>
    