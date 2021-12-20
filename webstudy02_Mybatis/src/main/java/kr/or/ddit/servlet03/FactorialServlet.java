package kr.or.ddit.servlet03;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.vo.FactorialVO;

@WebServlet("/03/factorial.do")
public class FactorialServlet extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 파라미터 전달 방식
//		String operand = req.getParameter("operand");
//		if(operand==null||operand.isEmpty()|| !operand.matches("[1-9]")) {
//			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "연산 수행이 불가능한 피연산자임.");
//			return;
//		}
//		
//		
//		int operandNum = Integer.parseInt(operand);
//		FactorialVO factorialVO = new FactorialVO();
//		factorialVO.setOperand(operandNum);
		String accept = req.getHeader("Accept");
		
		
//		2. payload로 json 전달
		ObjectMapper mapper = new ObjectMapper();
		FactorialVO factorialVO = null; //지역변수화
		try(
				
				InputStream is = req.getInputStream();

				){
			//marshalling and serialization
			//역직렬화(stream-json), 언마샬링(json-java object)
				factorialVO = mapper.readValue(is, FactorialVO.class);
	
				}
		if(accept.contains("json")) {
			resp.setContentType(accept);//이렇게 넣어도 accept가 마임을 가지고 있다
			//마샬링과 직렬화
			try(
				PrintWriter out = resp.getWriter();//직렬화를 위햐서는 write가 필요하다
			){
				mapper.writeValue(out, factorialVO); //마샬링을 위해서는 자바 객체가 필요하다
			}
			
		}else {
			req.setAttribute("factorial", factorialVO);
			String destination = "/WEB-INF/views/factorialView.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(destination);
			rd.forward(req, resp);
//		String location = req.getContextPath()+ destination;
//		resp.sendRedirect(location);
			
		}
		

		
		
	}
}




//		for (int i = 1; i <= operandNum; i++) {
//			resultValue *= i;
//		}	
//		System.out.println(resultValue);
//		
//		Map<String, Object> target = new HashMap<>();
//		target.put("resultValue", resultValue);
