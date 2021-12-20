<%@page import="java.util.Map"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<%
	Map<String, String> errors = (Map) session.getAttribute("errors");
	String message = (String) session.getAttribute("message");
	if(StringUtils.isNotBlank(message)){
		%>
		<div class="error"><%=message %></div>
<%
session.removeAttribute("message");
	}
	if(errors!=null && !errors.isEmpty()){
		%>
		<div class="error"><%=errors %></div>
<%		
session.removeAttribute("errors");
	}

%>

<form action="${pageContext.request.contextPath}/login/loginProcess.do" method="post">
	<ul>
		<li>
			<input type="text" name="memId" placeholder="아이디">
			<label></label><input type="checkbox" name="saveId"/>아이디 저장하기</label>
		</li>
		<li>
			<input type="password" name="memPass" placeholder="비밀번호">
			<input type="submit" value="로그인"/>
		</li>
	</ul>
</form>

<%-- <%  --%>
<!-- // String a =(String) session.getAttribute("session"); -->
<!-- // String b = null; -->
<!-- // if(a==null){ -->
<!-- // 	b=""; -->
<!-- // }else{ -->
<!-- // 	b=a; -->
<!-- // } -->
<%-- %> --%>
<%-- <%-- <%=session.getAttribute("session") %> --%>
<%-- <%=b %> --%>

<script type="text/javascript">

</script>
</body>
</html>