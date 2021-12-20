package kr.or.ddit.dbprop.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dbprop.service.DataBasePropertyServiceImpl;
import kr.or.ddit.vo.DataBasePropertyVO;

@WebServlet("/dbProp/propertyList.do")
public class DataBasePropertyServlet extends HttpServlet{
	private DataBasePropertyServiceImpl dbService = new DataBasePropertyServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 1. 요청을 분석
		 * 2. 파라미터 헤더 모든것, 검증
		 * 3. 모델을 생성, 컨트롤러가 직접 생성하는 것이 아닌, 비지니스 로직으로 부터 모델데이터 받아오기
		 * 4. 스코프를 이용해서 전달(뷰로 어떤 방식으로 이동하나)
		 * 5. 논리적인 뷰네임 결정, 뷰로 이동
		 * 6. 
		 * 
		 */
		List<DataBasePropertyVO> list = dbService.retrieveDBPropertyList();
		System.out.println(list);
		req.setAttribute("dbPropList", list);
		
		String viewName = "dbProp/propView";
		viewResolve(viewName, req, resp);
	}
	
	private void viewResolve(String viewName, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (viewName.startsWith("redirect:")) {
			int beginIndex = "redirect:".length();
			viewName = viewName.substring(beginIndex);
			resp.sendRedirect(req.getContextPath()+viewName);
		}else {
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);;
		}
		
	}
}
