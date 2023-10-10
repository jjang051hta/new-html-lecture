<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3">${board.title }</td>
					</tr>
					<tr>
						<th>글쓴이</th>
						<td colspan="3">${board.name }</td>
					</tr>
					<tr>
						<th>날짜</th>
						<td>${board.regDate }</td>
						<th>조회수</th>
						<td>${board.hit }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3" class="content">${board.content }</td>
					</tr>
				</tbody>
			</table>
			<div class="d-flex justify-content-center mt-5">
				<a href="../board/list" class="btn btn-primary">목록</a> <a
					href="../board/write" class="btn btn-primary mx-1">글쓰기</a>
				
				<a href="../board/delete?no=${board.no }"
					class="btn btn-danger mx-1">삭제</a> <a
					href="../board/modify?no=${board.no }"
					class="btn btn-danger mx-1">수정</a>
				
			</div>

		</div>
	</div>
</div>
<script charset="utf-8" src="//cdn.iframe.ly/embed.js?api_key=1a6a2b507f0ab1405d9cad"></script>

<script>
    document.querySelectorAll( 'oembed[url]' ).forEach( element => {
        iframely.load( element, element.attributes.url.value );
    } );
</script>

<%@ include file="../include/footer.jsp"%>