package kr.or.ddit.commons.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/logout.do")
public class LogOutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate(); //호출을 하면 강제로 만료를 시킨다.
		
		String viewName = "redirect:/";
		viewResolve(viewName, req, resp);
	}
	
	private void viewResolve(String viewName, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (viewName.startsWith("redirect:")) {
			int beginIndex = "redirect:".length();
			viewName = viewName.substring(beginIndex);
			resp.sendRedirect(req.getContextPath()+viewName);
		}else {
			req.getRequestDispatcher(viewName).forward(req, resp);;
		}
		
	}
	
	
}
