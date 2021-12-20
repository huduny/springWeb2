package kr.or.ddit.servlet01;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 	1. contents 폴더를 핸들링할 수 있는 file 객체로 캡슐화.
 * 	2. form 태그 구성/ form action="/image.do"
 * 	3. select 태그 구성, name(parameter name 결정) 속성 결정/ name="image"
 * 	4. 처리자에 의한 정보 필요(from 태그의 action으로 설정=요청이 imageStreamingServclet으로 /image.do)
 *	4. 1번에서 생성된 file 객체로 부터 폴더내의 이미지 파일 목록을 조회하고, 동적으로 option 구성.
 *	5. 응답 스트림 확보 후 결과 전송.
 *
 */

@WebServlet("/imageForm.do")
public class ImageFormServlet extends HttpServlet{
	private File folder;
	ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
		application.getInitParameter("contentPath");
		String contentPath = application.getInitParameter("contentPath");
		folder = new File(contentPath);
		System.out.printf("content폴더: %s\n", folder.getAbsolutePath());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
		
		//마임셋팅
		String mine = "text/html; charset=UTF-8";
		resp.setContentType(mine);
		//모든 파라미터는 이름이 있어야된다(name)
		//contents 안에 갯수 만큼 동적으로 구성
		
		//파일로 캡슐화
		File[] list =  folder.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				name = name.toLowerCase();
				String mime = application.getMimeType(name);
				boolean result = false;
				result = mime!=null && mime.startsWith("image/");
				return result;
			}
		});
		//옵션에 value를 부여하면 클라이언트 눈에는 옵션사이에 값 실제 서버에 넘겨지는 값은 벨류, 문자열 포맷팅
		String optPtrn = "<option value='%1$s'>%1$s</option>";
		
		//버퍼로 힙메모리
		StringBuffer buffer = new StringBuffer("<html>");
		buffer.append("<body>");
		buffer.append("<form action='image.do'>");
		buffer.append("<select name='image'>");
//		for(요소하나에 접근하는 블럭 요소:반복문대상)
		for (File child : list) {
			buffer.append(
			String.format(optPtrn, child.getName())
			);
		}
		buffer.append("</select>");
		buffer.append("<input type ='submit' value='전송'>");
		buffer.append("</form>");
		buffer.append("</body>");
		buffer.append("</html>");
		
		//지역변수화, 초기화를 위해서 null값 부여, nullpoint exception이 발생할 여지가 있다.
		
		//출력 스트림
		//try resource 구문
		try(
			PrintWriter out = resp.getWriter();
		) {
			out.print(buffer);
		}
		
	}
	
	
	
}
