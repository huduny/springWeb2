<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.Objects"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberVO member = (MemberVO) request.getAttribute("member"); // 기존의 입력 데이터를 가진 명령 객체
		out.println(member);
		if(member == null){
			member = new MemberVO();
			request.setAttribute("member", member);
		}
		Map<String, String> errors = (Map) request.getAttribute("errors"); //검증결과 메세지, 통과하지 못한 데이터
		if(errors==null){
			errors = new LinkedHashMap<>();
			request.setAttribute("errors", errors);
		}
		out.println(errors);
		String message = (String) request.getAttribute("message");
		if(StringUtils.isNotBlank(message)){
			%>
				<div class="errors"><%=message %></div> 
			<%
		
		}
		out.println(message);
	%>
	<form method="post">
		<table>
			<tr>
				<th>회원아이디</th>
				<td><input type="text" name="memId" required
					value="<%=Objects.toString(member.getMemId(), "")%>" /><span class="error"><%=errors.get("memId")%></span></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="memPass" required
					value="<%=member.getMemPass()%>" /><span class="error"><%=errors.get("memPass")%></span></td>
			</tr>
			<tr>
				<th>회원명</th>
				<td><input type="text" name="memName" required
					value="<%=member.getMemName()%>" /><span class="error"><%=errors.get("memName")%></span></td>
			</tr>
			<tr>
				<th>주민번호1</th>
				<td><input type="text" name="memRegno1"
					value="<%=member.getMemRegno1()%>" /><span class="error"><%=errors.get("memRegno1")%></span></td>
			</tr>
			<tr>
				<th>주민번호2</th>
				<td><input type="text" name="memRegno2"
					value="<%=member.getMemRegno2()%>" /><span class="error"><%=errors.get("memRegno2")%></span></td>
			</tr>
			<tr>
				<th>생일</th>
				<td><input type="text" name="memBir"
					value="<%=member.getMemBir()%>" /><span class="error"><%=errors.get("memBir")%></span></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input type="text" name="memZip" required
					value="<%=member.getMemZip()%>" /><span class="error"><%=errors.get("memZip")%></span></td>
			</tr>
			<tr>
				<th>주소1</th>
				<td><input type="text" name="memAdd1" required
					value="<%=member.getMemAdd1()%>" /><span class="error"><%=errors.get("memAdd1")%></span></td>
			</tr>
			<tr>
				<th>주소2</th>
				<td><input type="text" name="memAdd2" required
					value="<%=member.getMemAdd2()%>" /><span class="error"><%=errors.get("memAdd2")%></span></td>
			</tr>
			<tr>
				<th>집전번</th>
				<td><input type="text" name="memHometel"
					value="<%=member.getMemHometel()%>" /><span class="error"><%=errors.get("memHometel")%></span></td>
			</tr>
			<tr>
				<th>회전번</th>
				<td><input type="text" name="memComtel"
					value="<%=member.getMemComtel()%>" /><span class="error"><%=errors.get("memComtel")%></span></td>
			</tr>
			<tr>
				<th>전번</th>
				<td><input type="text" name="memHp"
					value="<%=member.getMemHp()%>" /><span class="error"><%=errors.get("memHp")%></span></td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="text" name="memMail" required
					value="<%=member.getMemMail()%>" /><span class="error"><%=errors.get("memMail")%></span></td>
			</tr>
			<tr>
				<th>직업</th>
				<td><input type="text" name="memJob"
					value="<%=member.getMemJob()%>" /><span class="error"><%=errors.get("memJob")%></span></td>
			</tr>
			<tr>
				<th>취미</th>
				<td><input type="text" name="memLike"
					value="<%=member.getMemLike()%>" /><span class="error"><%=errors.get("memLike")%></span></td>
			</tr>
			<tr>
				<th>기념일</th>
				<td><input type="text" name="memMemorial"
					value="<%=member.getMemMemorial()%>" /><span class="error"><%=errors.get("memMemorial")%></span></td>
			</tr>
			<tr>
				<th>기념일자</th>
				<td><input type="text" name="memMemorialday"
					value="<%=member.getMemMemorialday()%>" /><span class="error"><%=errors.get("memMemorialday")%></span></td>
			</tr>
			<tr>
				<th>마일리지</th>
				<td><input type="number" name="memMileage"
					value="<%=member.getMemMileage() %>" /><span class="error"><%=errors.get("memMileage") %></span></td>
			</tr>
			<tr>
				<th>탈퇴여부</th>
				<td><input type="text" name="memDelete"
					value="<%=member.getMemDelete() %>" /><span class="error"><%=errors.get("memDelete") %></span></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="저장"> <input
					type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>