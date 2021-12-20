package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myInsert.do")
public class MyInsertServlet2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> names = req.getParameterNames();
		System.out.println(names);
		
		String viewName = "member/MyInsert2";
		viewResolve(viewName, req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String a = req.getParameter("memId");
		String b = req.getParameter("memPass");
		String c = req.getParameter("memName");
		String d = req.getParameter("memHp");
		String e = req.getParameter("memAdd1");
		String f = req.getParameter("memMail");
		String g = req.getParameter("memBir");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		
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
