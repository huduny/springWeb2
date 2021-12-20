package kr.or.ddit.servlet03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.enumpkg.BrowserType;

/**
 * User-Agent 헤더를 통해서 사용자의 브라우저를 식별하고,
 * 다음과 같은 메세지를 응답으로 전송함.
 * <ht>당신의 브라우저는 크롬(엣지,익스플로러)입니다.
 * 
 * 
 */

@WebServlet("/03/userAgent.do")
public class UserAgentIdentifier extends HttpServlet{
	final String MSGPTRN = "<h4>당신의 브라우저는 %1$s 입니다";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String agent = req.getHeader("user-agent");
		agent = agent.toUpperCase();
		String accept = req.getHeader("Accept");
		
		String browserName = BrowserType.findBrowserName(agent); //브라우져를 갖고놀 코드가 들어갈 필요가 없다.
		
		if(accept.contains("json")) {//비동기요청은 여기서 처리?
//			서버사이드는 동기인지 비동기인지 중요하지 않고 응답데이터를 뭘로 내보낼지가 중요하다
			
			Map<String, Object> target = new HashMap<>();
			target.put("browserName", browserName); //타겟에 의해 브라우저네임이 객체화 되었다. 이넘의 인스턴스와 같이
			resp.setContentType("application/json; charset=UTF-8"); 
			try(
			PrintWriter out = resp.getWriter();
			){
			//marshalling and serialization
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(out, target);
			}
			
		}else {
			StringBuffer html = new StringBuffer();
			html.append(
					String.format(MSGPTRN, browserName)
					);
			
			String mine = "text/html; charset=UTF-8";
			resp.setContentType(mine);
			try(
				PrintWriter out = resp.getWriter();//1,2단계 여기서 완료
			){
				out.print(html);
			}
			
		}
		}
			
		}
		
		
		
		
		
//		String browserName = BrowserType.OTHERS.getBrowserName();
//		BrowserType[] values = BrowserType.values();
//		for (BrowserType tmp : values) {
//			if(agent.contains(tmp.name())) {
//				browserName = tmp.getBrowserName();
//			}
//		}
		
//		Map<String, String> browserData = new LinkedHashMap<>();
//		browserData.put("EDG", "엣지");
//		browserData.put("CHROME", "크롬");
//		browserData.put("TRIDENT", "익스플로러");
//		browserData.put("OTHERS", "기타타");
		
//		BrowserType[] values = BrowserType.values();
//		
//		String browserType = browserData.get("OTHERS"); 
//		Set<String> keySet = browserData.keySet();
//		Iterator<String> it = keySet.iterator();
//		while (it.hasNext()) {
//			String keyWord = (String) it.next();
//			if (agent.contains(keyWord)) {
//				browserType = browserData.get(keyWord);
//				break;
//			}
//		}
		
//		if(accept.contains("EDG")) {
//			browserType = "엣지";
//		}else if(accept.contains("CHROME")) {
//			browserType = "크롬";
//		}else if(accept.contains("TRIDENT")) {
//			browserType = "익스플로러";
//		}else {
//			browserType = "기타타";
//		}
//		맵(키와 밸류)
		
		
		

	
	
	
	

