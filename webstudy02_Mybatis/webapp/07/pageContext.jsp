<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="false" %>
<!--     errorPage="/errors/errorProcessPerPage.jsp" -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07/pageContext.jsp</title>
</head>
<body>
<h4>PageContext</h4>
<pre>
	: 하나의 jsp 페이지에 대한 모든 정보를 가진 객체.
	
	1. 나머지 기본객체의 확보: EL ${pageContext.session.id}, <%=session.getId() %>
		<%=request == pageContext.getRequest()%>
		<%=response == pageContext.getResponse()%>
	2. 흐름 제어에 활용: request dispatch 방식, 페이지 모듈화에서 활용됨.
 	<%-- 
 	String dest = "/06/destination.jsp";
		//pageContext.forward(dest);
		//request.getRequestDispatcher("").forward(request, response);
		pageContext.include(dest);
		//request.getRequestDispatcher(dest).include(request, response);
		
--%>
<!-- 	이 텍스트가 어디서 출력되는지 확인하세욤. -->
	3. 에러데이터 확보: 에러 처리 페이지에서 활용, exception 기본 객체와 함께 사용.
	<%--
		Object tmp = null;
		if(1==1)
// 			out.println(tmp.toString());
			out.println(1/0);
	--%>
	
	4. 속성확보(scope): <a href="${pageContext.request.contextPath}/08/scopeDesc.jsp">Scope desc</a>
	
</pre>
	
	
	
	
	
	
</body>
</html>