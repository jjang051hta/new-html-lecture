<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#popup {
		width:300px;
		height:300px;
		position:absolute;
		left:200px;
		top:200px;
		background:#fff;
		padding:10px;
		border:1px solid #ccc;
	}	
</style>
<script src="js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<aside id="popup">
		<h2>지하철 태업!!! 집에 갑시다.</h2>
		<label>
			<input type="checkbox" id="today" value="1">
			<span>오늘 하루 열지 않기</span>
		</label>
		<button id="closeBtn">닫기</button>
	</aside>
<script>
	//jQuery = $
	//document.querySelector("#closeBtn").add;
	$("#closeBtn").on("click",function(){
		$("#popup").hide();
	});
</script>
</body>
</html>



