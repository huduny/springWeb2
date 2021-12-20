<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="8kb" autoFlush="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>
<title>06/bufferDesc.jsp</title>
</head>
<body>
<h4>출력 버퍼</h4>
<pre>
JspWriter 타입의 out 객체를 통해 버퍼를 관리할 수 있다.
버퍼크기: <%=out.getBufferSize() %>
자동방출 지원여부: <%=out.isAutoFlush() %>
버퍼 잔여 용량: <%= out.getRemaining() %>
버퍼 제어시 사용
	-out.flush()
	-out.clear()/out.clearBuffer()
버퍼에 응답 기록시사용
	-out.write()
	-out.append()
	-out.print()	

<%--
	for(int i = 1; i<=1000; i++){
		if(i==100){
			out.flush();	
			System.out.println("버퍼 방출");
		}
		out.print(i+"번째 기록\n");
		if(i==900){
			String dest = "/06/destination.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(dest);
// 			rd.forward(request, response);
			rd.include(request, response);
			
		}
	}
--%>

</pre>
</body>
</html>