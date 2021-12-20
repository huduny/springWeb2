package kr.or.ddit.servlet04;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.enumpkg.OperatorType;
import kr.or.ddit.vo.CalculateVO;
import kr.or.ddit.vo.FactorialVO;

/**
 * 모델2 구조를 이용한 사칙연산처리
 * 요청에 대한 처리자: servlet - controller
 * 1.요청의 값을 꺼내는데
 * 2.검증을 하고 파싱을 한다.
 * 3.통과하는 케이스 통과 못하는 케이스 상태코드(적절하지 못하거나 누락시킨것)
 * 4.연산을 수행(vo)은 값을 넘기기
 * 5.ui는 jsp로 이동하기 위해서 서블릿에서 jsp로 이동 리다이렉트는 안되서 디스패치로
 * 6.데이터 넘겨주기위해서 셋어트리뷰트를 해서 전달해준다.
 * 응답에 대한 처리자: jsp - view
 * --> mvc 패턴으로 확장
 * model: 컨트롤러가 뷰로 전달하고 있는 데이터(컨텐츠) -> java bean 규약에 따라 작성.
 *
 *
 *1. 동기요청, 파라미터 전송, 응답으로 html 전송
 *2. 비동기요청, 파라미터 전송, 응답으로 html 전송
 *3. 비동기요청, 요청 페이로드(json), 응답으로 html 전송
 *4. 비동기요청, 요청 페이로드(json), 응답으로 json 전송
 */

@WebServlet("/04/calculate.do")
public class CalculateServlet extends HttpServlet {
	private CalculateVO makeVOFromParameter(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String leftStr = req.getParameter("leftOp");
		String rightStr = req.getParameter("rightOp");
		String operator = req.getParameter("operator");
		
		if(StringUtils.isBlank(leftStr)|| !StringUtils.isNumeric(leftStr)
			||StringUtils.isBlank(rightStr)|| !StringUtils.isNumeric(rightStr)
			||StringUtils.isBlank(operator)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "파라미터 검증 통과하지 못함");
			return null;
		}
		
		long leftOp = Long.parseLong(leftStr);
		long rightOp = Long.parseLong(rightStr);
		
		CalculateVO calculateVO = new CalculateVO();
		calculateVO.setLeftOp(leftOp);
		calculateVO.setRightOp(rightOp);
		
		OperatorType opType = OperatorType.valueOf(operator);
		calculateVO.setOperator(opType);
		return calculateVO;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 값 꺼내기
		 * 검증-맞으면 그다음 아니면 에러메세지 400내보내고 검증은 vo에서
		 * 값 보내주기vo에
		 * 값 디스패치 해주기
		 * 
		 * 
		 */
		
		String requestBodyContentType = req.getContentType();
		String accept = req.getHeader("Accept");
		
		CalculateVO calculateVO = null;
		if (StringUtils.containsIgnoreCase(requestBodyContentType, "json")) {
			calculateVO = makeVOFromJsonPayload(req, resp); //모델 데이터를 만들어야 한다.
			
			
		}else {
			calculateVO = makeVOFromParameter(req, resp);
			
		}
		
		if (calculateVO == null) {return;}
		
		if(StringUtils.containsIgnoreCase(accept, "json")) {
			resp.setContentType("application/json;charset=UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			PrintWriter out = resp.getWriter();//실어서 보내기 위해서
			mapper.writeValue(out, calculateVO);
		}else {
			req.setAttribute("calculateVO", calculateVO);
			String dest = "/WEB-INF/views/calculateView.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(dest);
			rd.forward(req, resp);
		}
		

	}

	private CalculateVO makeVOFromJsonPayload(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 역직렬화 언마샬링
		ObjectMapper mapper = new ObjectMapper();
		InputStream is = req.getInputStream(); // 1차스트림, 리퀘스트라는 매체에 바로 빨대로	
		return mapper.readValue(is, CalculateVO.class);
	}
}
