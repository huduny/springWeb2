<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/findBrowserView.jsp</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function () {
		let msgArea = $("#msgArea"); // 한번만 호출, 트레이버싱 한번만 실행
		$("[name=opBtn]").on("click", function() {
			$.ajax({
				url : "<%=request.getContextPath()%>/03/userAgent.do", 
				method : "get",
				dataType : "json", 
				success : function(resp) {
					const MSGPTRN = "<h4>당신의 브라우저는 %s입니다.";
					var msg = MSGPTRN.replace("%s", resp.browserName)
					msgArea.html(msg);
				},
				error : function(xhr, status, error) {
					console.log(xhr);
					console.log(status);
					console.log(error);
				}

			});
			
			
		});
	});

</script>
</head>
<body>
	<input type="button" value="브라우져 이름을 받아오자!" name="opBtn"/>
	<div id="msgArea"></div>
</body>
</html>