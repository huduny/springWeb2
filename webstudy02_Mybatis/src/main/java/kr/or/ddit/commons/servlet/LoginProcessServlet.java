package kr.or.ddit.commons.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.commons.service.AutehnticateServiceImpl;
import kr.or.ddit.commons.service.AuthenticateService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/login/loginProcess.do")
public class LoginProcessServlet extends HttpServlet{
	private AuthenticateService service = AutehnticateServiceImpl.getInstance();
	
	private boolean validate(MemberVO target, Map<String, String> errors) {
		boolean valid = true;
		if (StringUtils.isBlank(target.getMemId())) {
			valid = false;
			errors.put("memId", "아이디 누락");
		}
		if (StringUtils.isBlank(target.getMemPass())) {
			valid = false;
			errors.put("memPass", "비밀번호 누락");
		}
		
		return valid;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		1. 파라미터 확보
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		MemberVO inputData = MemberVO.builder()
				.memId(memId)
				.memPass(memPass)
				.build();
//		2. 검증(필수 파라미터)
		Map<String, String> errors = new HashMap<>(); //맵에대한 주소값을 가지고 있다.
		HttpSession session = req.getSession();
		session.setAttribute("errors", errors);
		boolean valid = validate(inputData,errors); //주소가 복사가 된다.
		String viewName = null; //destination
		if (valid) {
//		3-1. 통과
//			4. 인증
			ServiceResult result = service.authenticate(inputData);
			switch (result) {
			case NOTEXIST:
//				4-1. 존재하지 않는 사용자
//					message 공유
//					loginForm 으로 이동.
				
				session.setAttribute("message", "존재하지 않는 사용자");
				
				viewName = "redirect:/login/loginForm.do";
				
				break;
			case INVALIDPASSWORD:
//				4-2. 비밀번호 오류
//					message 공유
//					loginForm 으로 이동.
				session.setAttribute("message", "비밀번호 오류");
				
				viewName = "redirect:/login/loginForm.do";
				
				break;

			default:
//				4-3. 인증 통과 (redirect)
//					웰컴 페이지로 이동.
				viewName ="redirect:/";

				session.setAttribute("authMember", inputData);
				//id,pass,name 3가지 정보가 들어있다.
				
				break;
			}	
		}else {		
//				3-2. 불통
//				message 공유
//				loginForm 으로 이동.
			session.setAttribute("message", "필수 데이터 누락");
			
			viewName = "redirect:/login/loginForm.do"; //forward방식
			
		}
		viewResolve(viewName, req, resp);
		
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
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);;
		}
		
	}
}














