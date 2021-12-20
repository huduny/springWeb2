<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10/viewCookie.jsp</title>
<style type="text/css">
th, td {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
}
</style>
</head>
<body>
	<h4>다른 경로로 재전송된 쿠키들</h4>
	<table>
		<thead>
			<tr>
				<th>쿠키이름</th>
				<th>쿠키값</th>
			</tr>
		</thead>
		<tbody>
			<%
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie tmp : cookies) {
			%>
			<tr>
				<td><%=tmp.getName()%></td>
				<td><%=tmp.getValue()%></td>
			</tr>
			<%
				}
				}
			%>
		</tbody>
	</table>
</body>
</html>