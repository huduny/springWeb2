package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberInsert.do")
public class MemberInsertServlet extends HttpServlet {
	private MemberService service = MemberServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName = "member/memberForm"; // 로지컬 뷰네임(일부경로만 가지고 있어서)

		viewResolve(viewName, req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Map<String, String[]> parameterMap = req.getParameterMap();

		MemberVO member = new MemberVO();
		req.setAttribute("member", member);
//		String memId = req.getParameter("memId");
//		member.setMemId(memId);
//		command object : 검증대상
		try {
			BeanUtils.populate(member, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}

		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = validate(member, errors);
		String viewName = null;

		if (valid) {
			ServiceResult result = service.createMember(member);
			switch (result) {
			case OK:
				viewName = "redirect:/";
				break;
			case PKDUPLICATED:
				viewName = "member/memberForm";
				req.setAttribute("message", "아이디 중복");
				break;
			default:
				viewName = "member/memberForm";
				req.setAttribute("message", "서버 오류, 복구중, 좀따 다시하쇼");
				break;
			}
		} else {
			viewName = "member/memberForm";
		}

		viewResolve(viewName, req, resp);
	}

	private boolean validate(MemberVO member, Map<String, String> errors) {
		boolean valid = true;
		if (StringUtils.isBlank(member.getMemId())) {
			valid = false;
			errors.put("memId", "회원아이디 누락");
		}
		//yyyy-mm-dd
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		if (StringUtils.isNotBlank(member.getMemBir())) {
			try {
				formatter.parse(member.getMemBir());
			} catch (ParseException e) {
				valid = false; //검증에 실패했기 때문에
				errors.put("memBir", "날짜 형식 확인");
			}
		}
		
		return valid;
	}

	private void viewResolve(String viewName, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (viewName.startsWith("redirect:")) {
			int beginIndex = "redirect:".length();
			viewName = viewName.substring(beginIndex);
			resp.sendRedirect(req.getContextPath() + viewName);
		} else {
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			req.getRequestDispatcher(prefix + viewName + suffix).forward(req, resp);
			;
		}

	}
}
