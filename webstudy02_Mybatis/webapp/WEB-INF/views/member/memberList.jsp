<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>회원 목록 조회</h4>
<%


%>
<table>
	<thead>
		<tr>
			<th>회원아이디</th>
			<th>회원명</th>
			<th>휴대폰</th>
			<th>주소1</th>
			<th>이메일</th>
			<th>마일리지</th>
			<th>생일</th>
		</tr>
	</thead>
	<tbody>
	<%
		List<MemberVO> memberList =(List) request.getAttribute("memberList");
		for(MemberVO tmp : memberList){
	%>
			<tr>
				<td><%=tmp.getMemId()%></td>
				<td><%=tmp.getMemName()%></td>
				<td><%=tmp.getMemHp()%></td>
				<td><%=tmp.getMemAdd1()%></td>
				<td><%=tmp.getMemMail()%></td>
				<td><%=tmp.getMemMileage()%></td>
				<td><%=tmp.getMemBir()%></td>
			</tr>
	<%
		}
	%>
	</tbody>
</table>
</body>
</html>