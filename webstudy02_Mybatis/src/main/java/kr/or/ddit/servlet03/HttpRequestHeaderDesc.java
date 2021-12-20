package kr.or.ddit.servlet03;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/03/headerDesc.do")
public class HttpRequestHeaderDesc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		헤더 이름 헤더값
		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String name = (String) headerNames.nextElement();
			String value = req.getHeader(name);
			System.out.printf("%s : %s \n",name, value);
		}

		
		
//		String mime = null;
//		if(accept.contains("Google Chrome")) {
//			System.out.println("Google Chrome");
//		}else if(accept.contains("Microsoft Edge")) {
//			System.out.println("Microsoft Edge");
//		}

		
		
		
		//		String accept = req.getHeader("Accept");
//		String accept1 = req.getHeader("Accept-Language");
//		System.out.printf("accept: %s\n", accept);
//		System.out.printf("accept: %s\n", accept1);
//		
//		String mime = null;
//		if(accept.contains("json")) {
//			mime = "application/json";
//		}else if(accept.contains("xml")) {
//			mime = "application/xml";
//		}else {
//			mime = "text/html";
//		}
//		resp.setContentType(mime);
		
		
		
//		Enumeration<String> head = req.getHeaders("Accept");
//		Enumeration<String> headers = req.getHeaderNames();
//		System.out.println(names);
//		while(head.hasMoreElements()) {
//			String paramName = (String) head.nextElement();
//			String[] paramValue = req.getParameterValues(paramName);
//			System.out.printf("%s : %s \n",paramName, Arrays.toString(paramValue));
//		}
//		while(headers.hasMoreElements()) {
//			String paramNames = (String) headers.nextElement();
//			String[] paramValue = req.getParameterValues(paramNames);
//			System.out.printf("%s : %s \n",paramNames, Arrays.toString(paramValue));
//		}
		
		
	}
}
