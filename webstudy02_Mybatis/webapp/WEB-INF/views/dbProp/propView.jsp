<%@page import="kr.or.ddit.vo.DataBasePropertyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4> 데이터베이스 정보</h4>
<table>
	<thead>
		<tr>0
			<th>PROPERTY_NAME</th>
			<th>PROPERTY_VALUE</th>
			<th>DESCRIPTION</th>
		</tr>
	</thead>
	<tbody>
	<%
		List<DataBasePropertyVO> propList =(List) request.getAttribute("dbPropList");
		for(DataBasePropertyVO tmp : propList){
	%>
			<tr>
				<td><%=tmp.getPropertyName()%></td>
				<td><%=tmp.getPropertyValue()%></td>
				<td><%=tmp.getDescription()%></td>
			</tr>
	<%
		}
	%>

	</tbody>
</table>
</body>
</html>