<%@page import="kr.or.ddit.vo.CalculateVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	CalculateVO calculateVO = (CalculateVO)request.getAttribute("calculateVO");
// 	long result =  calculateVO.getResult();
	String expression = calculateVO.getExpression();
	%>
	<%=expression %>
</body>
</html>