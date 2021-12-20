<%@page import="kr.or.ddit.db.ConnectionFactory"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="kr.or.ddit.vo.DataBasePropertyVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10/performanceCheck.jsp</title>
</head>
<body>
<h4>웹어플리케이션에서 발생하는 소요 시간 체크</h4>
<h4>현재 쓰레드명: <%=Thread.currentThread().getName() %></h4>
<pre>
	하나의 요청이 처리되는 과정의 소요시간(response time)
	3-tier => latency time(T1) + processing time(T2) + latency time(T3)
	
	a001 사용자 조회(T3) => 해당 사용자의 이름을 이쁜이로 변경하고, 브라우저 출력(T2)
	
	(T3 * 1) + (T2 * 1) = 10ms 
	(T3 * 100) + (T2 * 100) = 800ms dbcp =>20ms
	(T3 * 1) + (T2 * 100) = 9ms
	대부분의 소요시간은 t3에서 발생한다. 
	(T3 * 100) + (T2 * 1) = ms 
	
<!-- 	1. a001 사용자 조회 -->
<!-- 	-db에서 데이터 가져오기 -->
<!-- 	-데이터를 가져온 후에 해당 사용자의 이름을 이쁜이로 변경 -->
<!-- 	-변경된 데이터를 출력 -->
	<%
		long start = System.currentTimeMillis();	
	
		StringBuffer sql3 = new StringBuffer();
		sql3.append(" select mem_name ");
		sql3.append(" from member ");
		sql3.append(" where mem_id = ? ");
		MemberVO member = null;
	
		for(int count=1; count<=100; count++){
			try(
					Connection conn = ConnectionFactory.getConnection();
					PreparedStatement stmt3 = conn.prepareStatement(sql3.toString());
				){
				 
				    
				    stmt3.setString(1, "a001");
					ResultSet rs = stmt3.executeQuery();
					
					if(rs.next()){
						member = MemberVO.builder()
								.memName(rs.getString("mem_name"))
								.build();
						
					}	

				}catch (SQLException e) {
					throw new RuntimeException(e);
				}
			
			member.setMemName("이쁜이");
			out.println(member);
		}// for end
		
		
		
		long end = System.currentTimeMillis();
		
		out.println(String.format("소요시간: %d ms", (end-start)));
	%>
	
</pre>
</body>
</html>