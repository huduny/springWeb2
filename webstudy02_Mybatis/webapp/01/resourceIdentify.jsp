<%@page import="java.net.URL"%>
<%@page import="kr.or.ddit.servlet02.GugudanServlet"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01/resourceIdentify.jsp</title>
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<h4>자원 식별</h4>
<pre>
	** 자원의 종류: 해당 자원을 식별하기 위한 주소 체계에 따라 분류
	cat1.jpg
	1. file system resource(파일 시스템 절대 경로): d:\contents\cat1.jpg
	<%=new File("d:/contents/cat1.jpg").length() %>
	2. class path resource(클래스 패스 이후에 절대 경로): /kr/or/ddit/images/cat1.jpg
	<% 
		String qualifiedName = "/kr/or/ddit/images/cat1.jpg";
		URL resURL =  GugudanServlet.class.getResource(qualifiedName);
		String fsPath = resURL.getFile();//file system path
		File resFile = new File(fsPath);
		out.println(resFile.getAbsolutePath());
	%>
	3. web resource(url구조를 통해): localhost/webStudy01/resources/images/cat1.jpg
	
	**웹 리소스 식별 방법
	URI(uniform resouce Identifier)(자원을 식별하기 위한 식별자)
	URL(uniform resouce locator)(자원을 식별하기 위한 방법)
	두개의 목적은 자원 식별로 같다. 지금은 같은 의미로 사용 but uri가 더 포괄적인 의미
	URN(naming)
	URC(content)등이 존재, 식별방법 세분화
	/*단점*/
	urn은 중복 이름, 내가이름을 알아야 된다. (결국 폐기)
	urc은 식별성이 떨어진다. content는 너무 광범위 하다. urc는 책에서 사용이 된다.(저자, 제목 등을 사용해서)
	isvn넘버가 urc로 만들어짐
	
	시작점이 되는게 ip address domainname이다.
	
	**url 표기 방법
	http://localhost/webStudy01/resources/images/cat1.jpg
	protocol://ip[domain]:port/contextName(application)/자원의 계층구조/자원의 이름
	depth는 파일시스템의 계층구조에 따라서 달라진다.
	http://localhost 해당 물리주소를 따라가기 위한 논리주소가 된다.
	
	대한민국 대전 중구 대흥동 영민 빌딩 4층
	최초의 시작점 부터 전체를 다 표현
	절대 경로: 전체경로 http://localhost/webStudy01/resources/images/cat1.jpg
	
	인지하고 있는 경로의 범위는 현재 주소를 누가 사용하냐에 따라서 달라진다.
	클라이언트 사이드 방식의 절대 경로와 서버사이드 방식의 절대 경로는 다르다.
	클라이언트 사이드는 브라우져가 알고있는 주소체계 이후에 전부
	
	상대 경로: 
		client side:contextpath를 포함한 경로
		server side:contextpath 이후의 경로
		<%
			String logicalPath = "/resources/images/cat1.jpg";
			String realPath = application.getRealPath(logicalPath);
			out.println(realPath);
		%>
	<!--자바는 서버사이드 랭귀지 webstudy01이 없다,  -->
	상대 경로: 서버사이드에서는 상대 경로 사용하지 않음.
	현재 자원의 주소를 기준으로 삼는다. 앞의 /가 없어야된다.
	../resources/images/cat1.jpg
	
	
</pre>
<img src="http://localhost/webStudy01/resources/images/cat1.jpg"/> <!--절대경로-->
<img src="//localhost/webStudy01/resources/images/cat1.jpg"/> <!--https와http를 구분하기 위해서-->
<img src="/webStudy01/resources/images/cat1.jpg"/> <!--배포 이후에 문제 해결을 위해서 도메인네임이 바뀌어도-->
<img src="<%=request.getContextPath()%>/resources/images/cat1.jpg"/> <!--배포 이후에 context path가 바뀌면-->
<img src="../resources/images/cat1.jpg"/> <!--html에서 쓰는 상대경로-->
<!--클라이언트 사이드 브라우져가 이용  -->
</body>
</html>