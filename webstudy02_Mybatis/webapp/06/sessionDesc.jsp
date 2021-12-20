<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/sessionTimer.js"></script>
<title>06/sessionDesc.jsp</title>
</head>
<body>
<h4>세션</h4>
<pre>
:(통로, 시간)
통로의 의미는 데이터베이스: client/server 사이의 유일한 통로, connection-close 이 한번이 한 세션이다.
Web: 웹은 클라이언트와 서버 사이에서는 언제 생기고 끊어질지 예측할 수 없다. 지금은 connectless가 있다고 할 수 없다
요새는 connection을 재활용하는 추세이다. 
시간의 의미가 지배적이다. 한명의 클라이언트가 하나의 브라우저를 이용해서 어플리케이션을 사용 시자간 시점부터 사용 종료 시점까지의 시간.
클라이언트와 서버가 네트워크를 두고 떨어져 있어서 사용시간을 특정지을수 없다. 그래서 정의된게 만료시점이다.
불명확한 종료 상황을 정의하기 위한 timeout을 설정함.
톰캣은 기본적으로 30분으로 설정됨. 즉, 마지막 요청 이후에 다음 요청이 오는 간격을 timeout.
1. 세션 아이디 쿠키(jsessionid)가 삭제된 경우.
2. 브라우저가 종료된 경우.
3. timeout 이후에 새로운 요청이 발생한 경우.
1-3은 같은 경우다
4. 명시적으로 로그아웃을 한 경우

세션의 생명주기 유지 과정에서 식별자로 세션 아이디가 사용됨.
session id: <%=session.getId() %>
생성 시점: <%=new Date(session.getCreationTime()) %>
마지막 요청(접속) 시점: <%=new Date(session.getLastAccessedTime()) %>
timeout: <%=session.getMaxInactiveInterval() %>s
<%--
	session.invalidate();
--%>


</pre>
<div id="timeArea"></div>

<script type="text/javascript">
	$("timeArea").sessionTimer(<%=session.getMaxInactiveInterval()%>); 
</script>
</body>
</html>