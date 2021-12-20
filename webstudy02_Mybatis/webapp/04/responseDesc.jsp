<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/responseDesc.jsp</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<h4>HttpServletResponse</h4>
<pre>
	: 서버에서 클라이언트로 전송되는 응답과 관련된 모든 정보를 가진 객체
	Http의 응답 패키징 방식을 보면
	1. response line: 상태코드(status code), protocol/version
		status code: 서비스 처리 결과를 표현하는 세자리의 숫자 즉 서비스 결과도 5가지 표현
		Http: connectless, stateless
		1) 100번대- ing...(http1.1부터 사용되는 하위 프로토콜인 websocket 에서 사용됨.)
		2) 200번대- ok(처리성공)
		3) 300번대- 성공을 위해서 클라이언트의 추가 액션이 필요한 경우의 상태 코드, (response body가 없는 형태의 응답 전송)
			304(not modified) - 클라이언트의 캐시 데이터를 사용하라.
			302/307(moved)
		4) 400번대- 실패, client side error
			404 class not found, 자원이 없다(url 잘못)
			400 bad request(요청이 잘못됐다. 데이터의 검증과 연관)
			401(unauthorized) 접근제어시 사용(보호자원)
			403(forbidden) 접근제어시 사용(보호자원)
			405(method not allowed)
			415(unsupported media type)
		5) 500번대- 실패, server side error, 500(internal server error), 클라이언트에
		굳이 알려줄 필요없이 500으로 묶어서 보낸다.
	2. response header: meta data, 
		1) mime 관련 header: content-type, page 지시자, resp.setcontentType...
		2) cache controler 관련 header: cache-control, expires, pragma
			<a href="cacheControl.jsp">캐시제어</a>
		3) auto request 관련 header: refresh
			<a href="autoRequest.jsp">자동요청을 통한 갱시</a>
		4) location을 이용한 redirect: location
			<a href="../05/flowControl.jsp">흐름제어</a>
	
	3. response(content/message) body: service contents
</pre>
</body>
</html>