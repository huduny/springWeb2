package kr.or.ddit.servlet02;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	1. 구구단의 출력 형태는 table 태그 사용
 * 	2. 한행에 한단씩 출력
 * 	3. 2*2=4 와 같은 형식으로 출력
 * 	4. client 맵핑 url은 contextPath/gugudan.do
 * 	5. (1번째 리펙토링)client 가 요구하는 범위 안에서 출력
 * 	6. (2번째 리펙토링)비동기 요청구조 추가
 * 
 * 	formatting: 특정 타입의 데이터를 일정한 형식의 문자열로 만드는 작업
 * 	parsing: 문자열을 특정타입의 데이터로 변환하는 작업
 *	"a"는 숫자로 파싱불가 "2.1"숫자 파싱 가능, 파싱의 대상이 일정한 형식으로 되어 있어야 된다
 *
 */

@WebServlet("/gugudan.do")
public class GugudanServlet extends HttpServlet{
	private final String PTRN = "<td>%1$d*%2$d=%3$s</td>";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String minStr = req.getParameter("minDan");
		String maxStr = req.getParameter("maxDan");
		int minDan =2;
		int maxDan =9;
		
		if(minStr!=null && !minStr.isEmpty()&&minStr.matches("[2-9]")) {
			minDan = Integer.parseInt(minStr);	
		}
		if(maxStr!=null && !maxStr.isEmpty()&&maxStr.matches("[2-9]")) {
			maxDan = Integer.parseInt(maxStr);	
		}
		
		
		
		String mime = "text/html;charset=UTF-8";
		resp.setContentType(mime);
		StringBuffer html = new StringBuffer() ;
//		String optPtrn = "<td>%1$d*%2$d=%3$s</td>";
		
//		html.append("<html>");
//		html.append("<body>"); 전체 문서에 일부로 들어가기 위해서
		html.append("<table border='1'>");
		for (int dan=minDan; dan<=maxDan; dan++) {
			html.append("<tr>");
			for(int mul =1; mul<10; mul++) {
				html.append(
				String.format(PTRN,dan,mul,(dan*mul))
				);
			}
			html.append("</tr>");
		}
		html.append("</table>");
//		html.append("</body>");
//		html.append("</html>");
		
		
		try(
			PrintWriter out = resp.getWriter();
		){
			out.print(html);
		}
		
		
		
		
		
	}//doget end
	
}//end
