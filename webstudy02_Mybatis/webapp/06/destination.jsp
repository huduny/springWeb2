<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
흐름 제어의 목적지
<pre>
param1: <%=request.getParameter("param1") %>
param2: <%=request.getParameter("param2") %>
=============================================
<%= pageContext.getAttribute("pageAttr")%>
<%= request.getAttribute("requestAttr")%>
<%= pageContext.getAttribute("requestAttr2",PageContext.REQUEST_SCOPE)%>
<%= session.getAttribute("sessionAttr")%>
<%= application.getAttribute("applicationAttr")%>
</pre>
</body>
</html>