<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<% 
	MemberVO authMember = (MemberVO) session.getAttribute("authMember");

	if(authMember!=null){
		%>
		<a href="<%=request.getContextPath() %>/myPage.do"><%=authMember.getMemName() %>님 로그인상태
		<a href="<%=request.getContextPath() %>/login/logout.do">로그아웃</a>
		<% 
	}else{
		%>
		<a href="<%=request.getContextPath() %>/login/loginForm.do">로그인</a>
		<a href="<%=request.getContextPath() %>/member/memberInsert.do">회원가입</a>
		<% 
	}
%>
<h4>웰컴 페이지~</h4>
</body>
</html>