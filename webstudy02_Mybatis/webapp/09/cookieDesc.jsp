<%@page import="kr.or.ddit.utils.CookieUtils"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie</title>
</head>
<body>
	<h4>Cookie</h4>
	<pre>
: Http Stateless 의 단점을 보완하기 위해 최소한의 상태 정보를 클라이언트쪽에 저장하는 개념
   
   쿠키 사용 단계
   1. 쿠기 생성(name, value 필수 속성)
   2. response(set-cookie 헤더) 에 쿠키를 포함하여 클아이언트로 전송.
   
   3. response 에 포함된 쿠키를 자기 쿠키 저장소에 저장
   4. 다음번 request(cookie 헤더)에 해당 쿠키를 서버로 재전송 (핵심)
   
   --서버에서 할일--
   5. request로부터 재전송된 쿠키 확보 후 상태 복원
   <%
      Cookie firstCookie = new Cookie("firstCookie", "FIRST_VALUE"); //1번
	  response.addCookie(firstCookie); //2번
	  String searchedValue =  new CookieUtils(request).getCookieValue("firstCookie");
		out.println("찾은 쿠키: firstCookie");
		out.println("찾은 쿠키값: "+searchedValue);
   %>
   쿠키의 속성들
   1.name(required): String, 영문자와 숫자 _
   2.value(required): String, 특수문자가 포함된 경우, url인코딩 방식으로 인코딩/디코딩 과정 필요.
   
   옵션
   3.domain(host): 쿠키의 재전송 여부를 결정하는 기준. 다음번 요청의 서버와 쿠키의 도메인이 패턴 매칭이 되는 경우에만 재전송.
   domain구조(tld-top level donmain 에 따른 분류)
   www.naver.com: 3level 구조(gtld-global 구조)
   www.naver.co.kr: 4level 구조 (ntld-nation 구조)(server-기관명-company-korea)
   mail.naver.co.kr: 메일서버
   cafe.naver.com: 카페서버
   하위레벨잇 상위레벨에 포함이된다. 메일 블로그 카페가 네이버에 포함된다.
   
   4.path: 쿠키의 재전송 여부를 결정하는 기준, path이하의 주소 체계로 발생한 요청에만 재전송.
   		: 생략시 쿠키를 생성할때의 경로가 반영.
   <a href="../09/viewCookie.jsp">동일경로에서 쿠키 확인하기</a>
   <a href="../10/viewCookie.jsp">다른경로에서 쿠키 확인하기</a>
   5.maxAge: 쿠키의 유효기간, 기본값으로 세션의 생명주기를따름.
   -시간은 초단위,
   -0으로 셋팅하면 쿠키 삭제 가능 단, 모든 속성이 동일한 경우에만 삭제
   --1로하면 브라우져가 종료가될때 자동으로 지워달라고 하는 요청이다.(단발성+강제로지울때) 단, 모든 속성이 동일한 경우에만 삭제
   -
   
   <%
//    String koreanValue = URLEncoder.encode("한글값", "UTF-8");
//    	Cookie koreanCookie = new Cookie("koreanCookie", koreanValue);
//    response.addCookie(koreanCookie);
   	
//    Cookie allDomainCookie = new Cookie("allDomain","ALL~DOMAIN");
//    allDomainCookie.setDomain(".naver.com"); //네이버를 대상으로 네이버의 모든 호스트 방향으로 재전송.
//    response.addCookie(allDomainCookie);
   
		Cookie allPath = new Cookie("allPath", "ALL_PATH");
		allPath.setPath("/");
		response.addCookie(allPath);
		
		Cookie longLive = new Cookie("longLive", "LONG_LIVE");
		longLive.setPath(request.getContextPath()+"/");
		longLive.setMaxAge(0);
		response.addCookie(longLive);
   %>
   
</pre>
</body>
</html>