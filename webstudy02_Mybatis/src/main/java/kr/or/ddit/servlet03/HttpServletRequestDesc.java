package kr.or.ddit.servlet03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	HTTP 요청 패키징 방식
 * 	1.request line: URL, method(http method, request method), protocol/version
 * 	request method의미는 요청의 목적(의도)+포장방식을 결정(body 영역의 유무 결정)
 * 	클라이언트의 역할은 기본적으로 데이터를 가져가는 역할
 * 	1)Get(r)select: 대부분의 요청은 기본적으로 get 방식, scr, href 속성
 * 	나머지를 사용하기 위해서는 form이나  api를 활용해야 한다.
 * 	2)post(c)insert
 * 	-----모든 서버 지원
 * 	3)put/patch (u)update
 * 	put과 patch의 차이는 여러 컬럼으로 구성되어 있으면 10개컬럼중에서 
 * 	딱 2개만 수정은 patch방식 수정할데이터+나머지데이터를 모두 보내는건 put/ 수정할것만 보내는건 patch
 * 	4)delete(d)delete
 * 	5)options: 지원여부확인 preFlight 요청에 사용. 
 * 	6)head: 응답 데이터의 body가 없는 응답을 요청.
 * 	7)trace: 서버를 대상으로 디버깅시에 사용
 * 	crud표현	
 * 	2.request header
 * 	3.request body(content body, message body): 서버로 전송한 컨텐츠 영역, 존재 여부가 메소드에 따라 달라진다
 * 	
 * 
 *
 */


@WebServlet("/requestDesc.do")
public class HttpServletRequestDesc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
