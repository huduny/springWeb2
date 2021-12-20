<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="5, url=https://www.naver.com">
<title>04/autoRequest.jsp</title>

</head>
<body>
	<h4>서버사이드 갱신 데이터 확보</h4>
	<pre>
	Long polling 방식: 주기적으로 요청을 발생시켜서 데이터를 갱신함.
	1. client side: html(meta, http-equiv), js(scheduling, ajax)
	2. server side: response header(refresh)
	
	</pre>
	<h4> 현재 서버의 시간: <span id="timeArea"></span></h4>
	<script type="text/javascript">
	//1. 비동기 요청을 발생시키기 (ajax를 활용하기-getservertime.jsp로)
	//2. 비동기 요청을 발생시킨 데이터를 가져오기(단 한번이라도)(가져온 데이터를 span에 집어 넣기)
	//3. 발생시킨 데이터를 refresh 하기	
	/* $.ajax({
		url : "",
		method : "",
		data : {

		},
		dataType : "",
		success : function(resp) {

		},
		error : function(xhr, status, error) {
			console.log(xhr);
			console.log(status);
			console.log(error);
		}

	}); */
	
		let timeArea = $("#timeArea");
		setInterval(function () {
			$.ajax({
				url : "getServerTime.jsp", 
				method : "get",
				dataType : "text", //plain=text
				success : function(resp) {
					timeArea.text(resp);
				},
				error : function(xhr, status, error) {
					console.log(xhr);
					console.log(status);
					console.log(error);
				}
			})
			
		}, 1000);
	
	
	
	
	
	
	</script>
</body>
</html>