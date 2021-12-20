<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/cacheControl.jsp</title>
</head>
<body>
<h4>캐시 제어</h4>
<pre>
	cache-control (http 1.1)
	expires (공통)
	pragma (http 1.0)
	<%
// 	response.setHeader("Pragma", "no-cache");
// 	response.setHeader("Cache-Control", "no-cache");
// 	response.addHeader("Cache-Control", "no-store");
// 	response.setDateHeader("Expires", 0);
	response.setHeader("Cache-Control", "public; maxAge="+(60*60*24*7));
	%>
</pre>
</body>
</html>