<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>errors/errorProcessPerPage.jsp</title>
</head>
<body>
<pre>
		<%
		ErrorData ed = pageContext.getErrorData();
// 		out.println(ed.getThrowable());
// 		out.println(exception);
		
		%>
		<%=ed.getThrowable().getClass().getName()%> : <%=ed.getThrowable().getMessage() %>
		<%=ed.getStatusCode() %>, <%=ed.getRequestURI()%>
</pre>
</body>
</html>