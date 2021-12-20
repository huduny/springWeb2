package kr.or.ddit.bts.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.bts.service.BtsService;
import kr.or.ddit.bts.service.BtsServiceImpl;
import kr.or.ddit.commons.exception.PKNotFoundException;
import kr.or.ddit.utils.CookieUtils;
import kr.or.ddit.vo.BtsVO;

@WebServlet("/bts2")
public class BtsServlet2 extends HttpServlet{
	private BtsService service = BtsServiceImpl.getInstance();
	private BtsVO vo = new BtsVO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		전체bts멤버 조회. scope 공유. 이동, 여기서도 비지니스 로직을 활용
		List<BtsVO> list = service.retrieveBtsList();
		System.out.println(list);
		req.setAttribute("btsList", list);
		
		String viewName = "bts/btsForm";
		viewResolve(viewName, req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//		1. 파라미터 확보
		req.setCharacterEncoding("UTF-8");
		
		Date accessTime = new Date();
		
		
		String id = req.getParameter("member");
		System.out.println(id);
//		2. 검증
		int status = HttpServletResponse.SC_OK;
		String viewName = null;
		
		if (StringUtils.isBlank(id)) {
			status = HttpServletResponse.SC_BAD_REQUEST;
		}else {
//			필수파라미터는 정상적으로 넘어옴
//			3-2. 통과
//			비지니스 로직 사용(retrieveBtsById) 사용
			try {
				BtsVO selectedMember = service.retrieveBtsById(id);
//				/bts/re.jsp
				
				req.setAttribute("accessTime", accessTime);
				
				viewName = selectedMember.getContentPage();
				System.out.println(viewName);
				
			}catch (PKNotFoundException e) {
				status = HttpServletResponse.SC_NOT_FOUND;
			}
			
		}
		
		if (status == 200) {
			
			Cookie btsCookie = new Cookie("btsCookie", id); //1번
			resp.addCookie(btsCookie); //2번
			String reservedValue =  new CookieUtils(req).getCookieValue("btsCookie");
			btsCookie.setPath(req.getContextPath()+"/");
			btsCookie.setMaxAge(60*60*24*10);
			resp.addCookie(btsCookie);
			
			viewResolve(viewName, req, resp);
			
		}else {
//			3-1. 불통
//			필수파라미터 누락 400에러 발생
			resp.sendError(status);
		}
		

	}
	
	
	
	/**
	 * 뷰로 이동하기 위한 코드의 모듈화
	 * "redirect:"접두어로 이동 방식을 결정함.
	 * @param viewName
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void viewResolve(String viewName, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (viewName.startsWith("redirect:")) {
			int beginIndex = "redirect:".length();
			viewName = viewName.substring(beginIndex);
			resp.sendRedirect(req.getContextPath()+viewName);
		}else {
			String prefix="/WEB-INF/views/";
			String suffix=".jsp";
//			/bts/rm
			req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);
		}
		
	}
}
