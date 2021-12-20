<%@page import="kr.or.ddit.enumpkg.OperatorType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05/calculateForm.jsp</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>

<form id="calculator" action="<%=request.getContextPath() %>/04/calculate.do" method="post">
<input type="number" name="leftOp" required>
<select name="operator" required>
	<option value="">연산자선택</option>
	<%
		OperatorType[] values = OperatorType.values();
		for(OperatorType tmp:values){
			%>
		<option value="<%=tmp.name()%>"><%=tmp.getSign()%></option>
			<%
		}
	%>
	
</select>
<input type="number" name="rightOp" required/>
<button type="submit">=</button>
</form>
<div id="resultArea"></div>

<script type="text/javascript">
	let resultArea = $("#resultArea");
	
	$("#calculator").on("submit", function (event) {
		event.preventDefault();
		
		let url = this.action;
		let method = this.method;
// 		let data = $(this).serialize();//파라미터 전송
		let leftOp = this.leftOp.value;
		let rightOp = $(this).find("[name='rightOp']").val();
		let operator = $(this).find("[name='operator']").val();
		let data = {
			leftOp: leftOp,
			rightOp: rightOp,
			operator: operator
		}
		//마샬링을 진행해야 한다. 
		console.log(data);
		let jsonData = JSON.stringify(data);
		console.log(jsonData);
		data = JSON.parse(jsonData);
		console.log(data);
		
		$.ajax({
			url : url,
			method : method,
			data : jsonData,
			contentType: "application/json;charset=UTF-8",
			dataType : "json",
			success : function(resp) {
				resultArea.html(resp.expression);
			},
			error : function(xhr, status, error) {
				console.log(xhr);
				console.log(status);
				console.log(error);
			}

		});
		return false;
	});
</script>

</body>
</html>