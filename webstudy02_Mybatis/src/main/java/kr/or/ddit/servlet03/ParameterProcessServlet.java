package kr.or.ddit.servlet03;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 요청 파라미터 처리 방법
 * Map<String,String[]> request.getParameterMap(제일 근간이됨 나머지는 이걸 어떻게 가공하는지)
 * String request.getParameter(name)
 * String[] request.getParameterValues(name)
 * Enumeration<String> request.getParameterNames
 * 
 * 요청 파라미터 내의 특수문자 처리 방법
 * -get 방식과 post 방식의 전달 방식
 * 
 * 	인코딩이 %로 시작했다. (%ED%95%9C%EA%B8%80) 이걸 퍼센트인코딩(url인코딩방식)
 * 	특수문자가 네트워크를 통해 전송될때, url 인코딩 방식에 따라서 %ed와 같은 형태로 인코딩되어 전달됨.
 * 	전달된것의 디코딩이 필요한데 뎅터를 읽기 전에 디코딩이 필요하다
 * 	즉, ***파라미터를 읽기 전에 디코딩 설정이 필요함.
 * 	1. get방식은 line의 url을 통해 queryString의 형태로 전달: 서버의 설정 필요
 * 	톰캣ex) uriencoding을 이용 but useBody를 이용 이것을 이용하면 바디의 캐릭터셋을 적용할 수 있어서 공통적으로 setCharacterEncoding이 가능
 * 
 * 	2. post방식은 body영역의 payload 형태로 전달: req가 가지고 있는 setCharacterEncoding을 이용했다. but 이것은 바디가 있어야 동작하지만
 * usebody를 이용하면 req.set이 동작된다. 
 * 	
 * queryString의 구성형태 URL?queryString
 * 전부 section으로 구성되어 있다. section1~sectionN 구분자는 &이다. section1&section2 ...
 * 한section은 한쌍의 파라미터로 구성, parametername=parameterValue로 구성
 * 
 * 
 * 
 */


@WebServlet("/03/parameterProcess.do")
public class ParameterProcessServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("UTF-8");
		super.service(arg0, arg1);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String textParam = req.getParameter("textParam");
		String numParam = req.getParameter("numParam");
		String radioParam = req.getParameter("radioParam");
		String[] chkParam = req.getParameterValues("chkParam");
		String sltParam = req.getParameter("sltParam");
		String[] multiParam = req.getParameterValues("multiParam");
		
		Map<String, String[]> parameterMap = req.getParameterMap();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			String paramName = entry.getKey();
//			String[] paramValues = req.getParameterValues(paramName);
			String[] paramValues = entry.getValue();
			System.out.printf("%s : %s\n", paramName, Arrays.toString(paramValues));
		}
		System.out.println("------------------------------------------------------");
		Enumeration<String> paramNames = req.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] paramValues = req.getParameterValues(paramName);
			System.out.printf("%s : %s\n", paramName, Arrays.toString(paramValues));
		}
		
		
	}

}
