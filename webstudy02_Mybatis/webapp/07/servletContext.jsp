<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	private void copy(File src, File dest) throws IOException{
	try(
		FileInputStream fis = new FileInputStream(src);
		BufferedInputStream bis = new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream(dest);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
	){
		int readData = -1;
		while((readData = bis.read())!=-1){
			bos.write(readData);
		}
		
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>
<title>07/servletContext.jsp</title>
</head>
<body>
<h4>ServletContext application</h4>
<pre>
	:하나의 웹 어플리케이션(컨텍스트)와 서버에 대한 정보를 캡슐화한 객체
	하나의 컨테스트 내에서는 싱글턴의 형태로 존재함.
	- 서버나 컨텍스트의 정보를 확인할때 사용.
	
	1. 컨텍스트 파라미터 확보(web.xml의 context-param을 통해 전달됨.)
	<%=application.getInitParameter("contentPath")  %>
	
	2. MIME 타입 확보
	<%=application.getMimeType("test.jpg")%>
	
	3. 로그 기록
	<%
		application.log("기록 메세지");
	%>
	
	4. 서버의 정보를 확보
	<%=application.getServerInfo()%>
	<%=application.getMajorVersion()%>.<%=application.getMinorVersion()%>
	
	5.(***) 웹리소스 확보
	url: http://localhost:80/webStudy01/resources/images/cat1.jpg
	내입장: /resources/images/cat1.jpg(논리적인 경로)
	<%
		String imageURL = "/resources/images/cat1.jpg";
		String realPath = application.getRealPath(imageURL);
		out.println(realPath);
		File imageFile = new File(realPath);//논리적인 경로를 활용해서 물리적인 경로에 접근하기
		out.println(imageFile.exists()+", size: "+imageFile.length());
		
		String fodlerURL = "/07";
		File destFolder = new File(application.getRealPath(fodlerURL));
		File destFile = new File(destFolder, imageFile.getName());
		
		copy(imageFile, destFile);
		out.println("복사완료");
	%>
	
</pre>
<img src = "<%=request.getContextPath()+fodlerURL+"/"+imageFile.getName()%>">
</body>
</html>