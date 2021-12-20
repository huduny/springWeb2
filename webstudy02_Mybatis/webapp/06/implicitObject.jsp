<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/implicitObject.jsp</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/sessionTimer.js"></script>
</head>
<body>
<h4>기본객체(내장 객체)</h4>
<pre>
	: JSP 컨테이너가 하나의 jsp페이지를 대상으로 서블릿 소스를 파싱할때,
	자동으로 선언되고, 생성되어 제공되는 객체들.
	
	1. HttpServletRequest request
	2. HttpServletResponse response
	3. JSPWriter out: 캐릭터 스트림, printwriter도 여기 포함, 
	<a href="${pageContext.request.contextPath }/06/bufferDesc.jsp">out 객체를 활용한 버퍼 관리</a>

	4. HttpSession session; 서버와 클라이언트 사이의 통로를 세션이라고 한다. 유일한 통로 하나 but 웹에서는 시간의 의미로 사용
		한 클라이언트가 서버를 대상으로 해서 어플리케이션을 사용하고 더이상 사용하지 않는 순간까지
		웹에서는 클라이언트가 어플리케이션을 소유하고 있지 않아서 언제 종료할지 몰라서 4가지 경우를 가정한다.	
	<a href="${pageContext.request.contextPath }/06/sessionDesc.jsp">세션 desc</a>	
	5. ServletContext application: 서버와 통신을 할때, 서버에 대한 정보, 하나의 어플리케이션에서 하나만 존재
		싱글톤 객체, 
	<a href="${pageContext.request.contextPath }/07/servletContext.jsp">세션 desc</a>		
	6. ServletConfig config: jsp는 곧 서블릿, 이미지스트리밍서비스 할때. contentPath를 넘길때 사용, 서블릿을 개발할때
	서블릿에 등록할때 만들어진 정보들을 캡슐화해서 만들어진것 servlet1:config1개가 만들어진다. context는 하나의 어플리케이션 안에서
	한개만 존재한다.
	서블릿을 컨테이너에 등록하고, 맵핑할때 발생하는 정보들의 캡슐화
	7. Object page (==this): 현재 싱글톤 객체의 REFERENCE를 가지고 있다.
	현재 JSP 페이지를 대상으로 생성된 싱글턴 객체. 타입이 최상위인 object여서 사용할 일이 있으면 this를 쓰는게 좋음
	나중에 개발의 급이 높으면 custom tag를 개발할때는 필요하다.
	8. Throwable exception; 발생한 예외에 대한 정보를 가지고 있다. 일반적으로는 눈에 보이지 않고 에러페이지에서 사용
	9. PageConext pageContext(***가장중요)
	<a href="${pageContext.request.contextPath}/07/pageContext.jsp">PageContext desc</a>
	
	<%
	%>
</pre>
<span id="sadad"></span>

<script type="text/javascript">
	$("#sadad").sessionTimer(<%=session.getMaxInactiveInterval()%>); 
	//세션의 기본객체를 파라미터로 넘겨준다.
</script>

</body>
</html>