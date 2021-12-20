<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/factorial.jsp</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>

</head>
<body>
<input type="number" id="operand" placeholder="팩토리얼 피연산자 10미만"
	min="1" max="9"/>
<input type="button" id="opBtn" value="결과"/> 
<div id="resultArea"></div>

<script type="text/javascript">
	let operand = $("#operand");
	let resultArea = $("#resultArea");
	let opBtn = $("#opBtn").on("click", function () {
		let target = {
						operand: operand.val()
						}
		
		
		$.ajax({
			url : "<%=request.getContextPath()%>/03/factorial.do",
			method : "post",
			data : JSON.stringify(target),
			contentType: "application/json", //request header 중에서 content - type 헤더 결정
			dataType : "html",
			success : function(resp) {
/* 				const MSGPTRN = "<h4>결과는 %s입니다.";
				var msg = MSGPTRN.replace("%s", resp.resultValue)
				resultArea.html(msg); */
// 				opBtn.after(resp.expression); //응답데이터가 제이슨으로 올때
 //html소스 자체를 넣는다.
				opBtn.after(resp);
			},
			error : function(xhr, status, error) {
				console.log(xhr);
				console.log(status);
				console.log(error);
			}

		});
	});
	
</script>
</body>
</html>