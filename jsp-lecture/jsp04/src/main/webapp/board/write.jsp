<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<script src="../js/ckeditor.js"></script>
</head>
<body>
<form action="write-process.jsp">
	<textarea id="board" name="board">
	
	</textarea>
	<button>글쓰기</button>
</form>
<script>
        ClassicEditor
            .create( document.querySelector( '#board' ), {
                language: 'ko' //언어설정
            })
            .catch( error => {
                console.error( error );
            } );
    </script>
</body>
</html>
