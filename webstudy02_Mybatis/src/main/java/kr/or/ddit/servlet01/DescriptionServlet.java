package kr.or.ddit.servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	서블릿
 * 	? Was에 의해 운영되면서 웹상의 요청을 처리할 수있는 객체의 요건들의 집합체(명세, spec)
 * 	was == servlet container  -> tomcat 
 * 	역할: 서블릿에 관한 모든 관리 권한을 가지고 있다.
 * 	container란? 컨테이너 내부에서 관리되는 객체의 생명주기관리자.
 *	was는 내부에서 관리되는 모든 서블릿의 생명주기 관리자.
 *	
 *	개발 단계
 *	1. HttpServlet의 구현체 정의: 필요한 callback 메소드 재정의(overriding)
 *	$("#id").on("click", function(){alert("msg")}); 익명함수를 제이쿼리가 주시하고 있다가 이벤트가 발생하면 바로 실행
 *	콜백함수는 시스템에 의해 자동으로 호출되는 함수이면서 동시에 연관되어 있는 이벤트 발생시 호출되는 구조를가지고 있다.
 *	HttpServlet이 가지고 있는 대부분의 메소드는 톰캣이 호출한다.
 *
 *	2. 컴파일 -> /WEB-INF/classes(class path)에 배포.
 *	3. servlet container 등록 
 *		-wbe.xml (sevelet, servlet-name, servlet-class) - ver 2.5까지. -ver 3.0부터는 annotation적극 활용
 *	4. client가 사용할 수 있는 주소 체계 설정
 *		-web.xml (servlet-mapping, servlet-name, url-pattern)
 *	5. 서버 재구동
 *
 * 	서불릿위 callback 메소드 종류
 *	- lifecycle callback
 *	- request callback
 *
 *	coc(convention over configuration) 구체적인 설정이 없으면 관행을 사용한다.
 *	mime(multi-purposed internet mail extension): 서로 주고받고 있는 데이터의 종류를 표현하는 문자열
 *	일정한 문법을 가지고 있고 main_type/sub_type;charset=encoding
 *	마임텍스트
 *	ex) text/javascript 자바스크립트라고 표현하는 마임 text/css 문자열이지만 css언어이다.
 *	text/plain은 문자열에 아무런 의미도 부여하지 말라는 의미 
 *	image/jpeg 이미지인데 jpeg 엔코딩, 표현되고 있다
 *	application/json 이 어플리케이션은 제이슨으로 표현된다.
 *	ajax(json,html,text,script,xml 전부 문자열 기반이다.)
 *	jquery ajax dataType : html(text/html), text(text/plain), json(application/json), script(text/javascript) 전부다 상수이다.
 *	원래는 마임텍스트로 써야되는데 편리하게 쓰기 위해 상수로 만들었다.
 *	백그라운드에서 제대로된 서비스를 제공하기 위해서는 지금 서비스하는 content가 무엇이다라는 것을 명확히 전달해 줘야 한다.
 *	
 *	우리가 가지고 놀 자원들 filesystem resource, classpath resource, web resource(webapp밑에)(클라이언트에게 공개 가능)
 *	was밖에 존재하는게 filesystem resource, was가 관리하는 공간이 아니여서 was 안에는 cp와 wr이고 wr은 url을 가지고 있어서 접근이 가능하지만
 * 	cp는 url을 가지고 있지 않아서 접근이 불가능해서 그래서 servlet에 등록해서 url을 부여해주면 가능하다.
 * 
 * 	하지만, ...
 *
 *	2021-11-19-자습
 *	StringBuffer는 문자열을 추가하거나 변경 할 때 주로 사용하는 자료형이다.
 *	StringBuffer 자료형은 append 라는 메소드를 이용하여 계속해서 문자열을 추가해 나갈 수 있다.
 *	StringBuffer 객체는 단 한번만 생성된다. 
 *	그러나 String 자료형에 + 연산이 있을 때마다 새로운 String 객체가 생성된다
 *	String 자료형은 한번 값이 생성되면 그 값을 변경할 수가 없다. 이렇게 값을 변경할 수 없는 것을 immutable 하다고 한다.
 *	StringBuffer 는 이와 반대로 값을 변경할 수 있다(mutable 하다). 즉 한번 생성된 값을 언제든지 수정할 수 있다.
 *	일반 String을 사용하는 것보다 메모리 사용량도 많고 속도도 느리다. 
 *	따라서 문자열 추가나 변경등의 작업이 많을 경우에는 StringBuffer를, 문자열 변경 작업이 거의 없는 경우에는 그냥 String을 사용하는 것이 유리하다.
 *
 *	2021-11-22
 * 	서불릿은(singleton) callback 메소드 종류
 *	- lifecycle callback: init, destroy 
 *	생명주기 내에서 단 한번씩만 실행, 객체가 생성될때 한번 소멸될때 한번
 *	- request callback: do... 메소드들
 *	크게보면 service라는 callback이있다.(프로토콜을 이해하면 알 수 있다)
 *	새로운 요청이 들어올때마다 반복적으로 처리 ex) do-get
 *	
 *	doGet은 get메소드 일때만 발생한다.
 *
 *
 */
@WebServlet(loadOnStartup=1, value="/desc", initParams= {
		@WebInitParam(name="param1", value="paramValue1")
		, @WebInitParam(name="param2", value="paramValue2")
})
public class DescriptionServlet extends HttpServlet{
	
	
	public DescriptionServlet() {
		super();
		System.out.printf("%s 의 생성자 호출 \n", this.getClass().getName());
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String value1 =  config.getInitParameter("param1");
		String value2 =  config.getInitParameter("param2");
		System.out.printf("%s 의 init 메소드 호출 param1: %s, param2: %s\n", this.getClass().getName(), value1, value2);
	}
	@Override
	public void destroy() {
		System.out.printf("%s 의 destroy 메소드 호출 \n", this.getClass().getName());
	}
	
	@Override
		protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

//			super.service(arg0, arg1);
		}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mime = "text/plain;charset=UTF-8";
	    resp.setContentType(mime);
		String data = "서비스 데이터, 현재 쓰레드 네임: " + Thread.currentThread().getName();
		StringBuffer html = new StringBuffer("<html>");
		html.append("<body>");
		html.append(String.format("<h4>%s</h4>",data));
		html.append("</body>");
		html.append("</html>");
		
		PrintWriter out = resp.getWriter();
		out.print(html);
		out.close();
	}
	
	

	
	
	
	
	
	private static final long serialVersionUID = 1L;

}
