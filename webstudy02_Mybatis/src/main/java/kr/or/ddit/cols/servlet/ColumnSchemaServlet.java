package kr.or.ddit.cols.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.cols.service.ColumnSchemaService;
import kr.or.ddit.cols.service.ColumnSchemaServiceImpl;
import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.ColumnSchemaVO;

@WebServlet("/cols/jdbcDesc.do")
public class ColumnSchemaServlet extends HttpServlet {
	private ColumnSchemaService service = new ColumnSchemaServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 요청을 받기
//		2. 분석(파라미터,헤더->검증)
//		3. 모델 생성(mvc패턴, layered arche -logic layer로 부터 모델 생성.)
		Map<String, Object> pMap = new HashMap<>();
		List<ColumnSchemaVO> list = service.retrieveColumnSchemaList(pMap);
		
		String[] headers =(String[]) pMap.get("headers");
//		4. scope를 통해 모델 전달
		req.setAttribute("headers", headers);
		req.setAttribute("list", list);
		
//		5. 뷰 선택
		String viewName = "jdbcDesc";
//		6. 뷰로 이동
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
