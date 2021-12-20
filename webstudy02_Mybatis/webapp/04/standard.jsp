<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/standard.jsp</title>
</head>
<body>
<h4>jsp(java server page)</h4>
<pre>
	jsp의 문법적인 구조, 표준 구성 요소
	1. 정적 텍스트: 형태가 바뀌지 않는 문자열, HTML, JAVASCRIPT, CSS, PLAIN....
	2. 스크립트(동적 요소): 일반적인 요소들과 구분하기 위해서 이다.
	1) scriptlet: 
	<%
	//일반적인 자바 코드: server side code, 지역코드(_jspservice)
		String str = "텍스트";
		Date now = new Date(); //브라우져에 출력할때 사용하는게 익스프레션
	%>
	2) directive: <%--@ 지시자명 속성들(name=value)  --%>: 하나의 jsp 페이지에 대한 설정 정보
		-page: 기본지시자, 반드시 사용
		-include: 옵션
		-taglib: 옵션
	3) expression: <%=str %>, <%=now %>
	4) delcaration: (선언부), <%! //java code 블럭변수-지역변수-전역변수 instance-전역변수 static변수 %>
	<%!
	// 전역코드, 새로운 메소드 선언
		String external = "전역 텍스트";
		public void test(){
			//오류가 생기지 않는다.
		}
	%>
	
	5) comment:<%-- --%><!--  -->코멘트 여ㄹ개
		-client side comment: html, css, js
<!-- 		<span>HTML 주석</span> -->ctrl+shift+c
			<script type="text/javascript">
// 			js 주석
			</script>
			<style type="text/css">
/* 			div */
			</style>
			
		-server side comment: java, jsp
<%-- 			<%=str %> --%>
			<% 
// 			str.toString();
/* 			adasdasd
 			asdsasad */ //ctrl+shift+/
			%>
		3. 기본 객체: <%  %>
		4. jsp 액션 태그: 
		5. el(표현 언어)
		6. jstl(custom tag library)
		
		
		
</pre>



</body>
</html>