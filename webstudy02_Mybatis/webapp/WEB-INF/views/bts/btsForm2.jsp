<%@page import="kr.or.ddit.utils.CookieUtils"%>
<%@page import="kr.or.ddit.vo.BtsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	확인
	<form method="post" id="bts">
		<select name="member">
			<option value>멤버 선택</option>
			<%
				String selectedMember = new CookieUtils(request).getCookieValue("btsCookie");
				List<BtsVO> list = (List) request.getAttribute("btsList");

				for (BtsVO btsVO : list) {
					String id = btsVO.getId();
					String name = btsVO.getName();
			%>
			<option selected value="<%=id%>"><%=name%></option>
			<%
				}
			%>
		</select> <input type="submit" value="전송" />
	</form>
	<div id="resultArea"></div>

	<script type="text/javascript">
// 	selected="selected"
<%-- 	<%  String btsCookie =  new CookieUtils(request).getCookieValue("btsCookie");  	 --%>
// 	request.getCookies();
<%-- 	%> --%>
<%-- 	console.log(<%=btsCookie%>) --%>
// 	let resultArea = $("#resultArea");
	
	
// 		let resultArea = $("#resultArea");

// 		$("#bts").on("submit", function(event) {
// 			event.preventDefault();

// 			let url = this.action;
// 			let method = this.method;
// 			// 		let data = $(this).serialize();//파라미터 전송
// 			let memValue = $(this).find("[name='member']").val();
// 			console.log(memValue)
// 			let data = {
// 					memValue: memValue
// 				}

// 			$.ajax({
// 				url : url,
// 				method : method,
// 				data : data,
// 				dataType : "html",
// 				success : function(resp) {
// 					console.log(resp)
// 					resultArea.html(resp);
// 				},
// 				error : function(xhr, status, error) {
// 					console.log(xhr);
// 					console.log(status);
// 					console.log(error);
// 				}

// 			});
// 			return false;
// 		});
	</script>
</body>
</html>