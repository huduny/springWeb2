package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/myPage.do")
public class MyPageServlet extends HttpServlet{
	private MemberServiceImpl service = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO authMember = (MemberVO) req.getSession().getAttribute("authMember");
		
		MemberVO detail = service.retrieveMember(authMember.getMemId());
		
		System.out.println(detail);
		req.setAttribute("member", detail);
		String viewName = "member/MyPage";
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
