<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05/flowControl.jsp</title>
</head>
<body>
<h4>jsp 웹어플리케이션의 흐름 제어</h4>
<pre>
	Http: connectless -> stateless
	1. 요청 분기(request dispatch)
	:출발지를 대상으로 발생한 원본 요청이 도착지로 이동시 동일하게 전달되는 이동 구조
	1) forward: 이동 후 최종 도착지에서 응답이 전송됨(***)
	-요청은 a에서 응답은 b에서 책임의 분리(model2)
	2) include: 이동 후 일정 처리가 이루어지면, 그 결과를 가지고 다시 출발지로 복귀하는 구조.
	<%--
		
		String dest = "/06/destination.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(dest);
// 		rd.forward(request, response);
		rd.include(request, response);
	--%>
	2. redirect: sateless 특성과 맥락이 이어짐
	원본 요청이 출발지를 대상으로 발생 
	-> 해당 요청에 대한 응답으로 body가 없고, 302(location) 헤더로만 구성된 응답이 전송(connectless, stateless)
	-> location 헤더의 방향으로 새로운 요청이 발생
	-> 도착지에서 새로운 요청에 대한 최종 응답이 전송.
	-> 요청과 응답이 2번씩 발생하고 마지막 응답에만 바디가 포함
	<%
		String location = request.getContextPath()+
				"/06/destination.jsp/param2="+request.getParameter("param1");
		response.sendRedirect(location);
	%>

</pre>






</body>
</html>