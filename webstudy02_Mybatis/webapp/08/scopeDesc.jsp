<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08/scopeDesc.jsp</title>
</head>
<body>
	<h4>영역과 속성(scope, attribute)</h4>
	<pre>
	Scope: jsp 어플리케이션에서 데이터를 공유하기 위한 저장 공간.
		 : 생명주기가 다른 네가지의 기본 객체가 소유하고 있는 Map.
	Attribute: scope를 통해 공유되고 있는 데이터(name/value).
	** 속성의 생명주기는 scope를 소유한 기본 객체와 동일함.
	1. page scope: 하나의 jsp페이지 내에서만 유효한 영역.
	2. request scope: 하나의 request 객체에 대해서만 유효한 영역.
	3. session scope: 하나의 session 객체에 대해서만 유효한 영역.
	4. application scope: 하나의 싱글톤 객체인 servletcontext 객체에 대해 유효한 영역
	
	<%
		pageContext.setAttribute("pageAttr", "페이지 영역 속성");
		request.setAttribute("requestAttr", "요청 영역 속성");
		session.setAttribute("sessionAttr", "세션 영역 속성");
		application.setAttribute("applicationAttr", "어플리케이션 영역 속성");
		
		pageContext.setAttribute("requestAttr2", "요청 영역 속성2", PageContext.REQUEST_SCOPE);
		
		String dest = "/06/destination.jsp";
// 		request.getRequestDispatcher(dest).forward(request, response);
// 		request.getRequestDispatcher(dest).include(request, response);
// 		pageContext.include(dest);

		String location =request.getContextPath() + dest;
		response.sendRedirect(location);
		
	%>
	
	<a href="../06/destination.jsp">Destination 이동</a>
	</pre>
	
	
	
	
	
	
	
</body>
</html>