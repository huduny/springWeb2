package kr.or.ddit.servlet01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image.do")
public class ImageStreamingServlet extends HttpServlet {
//	private File folder = new File("d:/contents");
	
	private File folder;
	ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		 application = getServletContext();
		
		String contentPath = application.getInitParameter("contentPath");
		folder = new File(contentPath);
		System.out.printf("content폴더: %s\n", folder.getAbsolutePath());
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String imageRe = req.getAttribute();
		
		
		 //파일 경로 설정
		
		String imageName = req.getParameter("image"); //클라이언트가 만든 객체, 데이터가 변형될수도 있다
//		서버사이드에서는 클라이언트가 보낸 모든 데이터에 대한 검증이 필요하다
		
		if (imageName==null||imageName.isEmpty()) {
			resp.sendError(400);
			
			return;
		}
		
		File imageFile = new File(folder,imageName); //파일경로, 서비스할 파일 설정
		if (!imageFile.exists()) {
			resp.sendError(404);
			return;
		}
		
		String mime = application.getMimeType(imageFile.getName()); //톰캣은 멍청하다 어디를 볼지 class path를 지정해 준다.
		resp.setContentType(mime); //콘텐트 타입을 지정해준다.
		int cnt = -1; // 안에 아예 바이트가 없으면 실행이 안되게 -1을 기본값으로 선언해준다.
		byte[] buffer = new byte[1024]; //1024바이트의 버퍼를 만든다. 1바티이트씩 일하기에는 비효율적이다

		//이미지 카피
//		FileInputStream is = new FileInputStream(imageFile); //통로를 열어주고
//		
//		OutputStream out = resp.getOutputStream(); //작은빨대(바이트단위인) 이미지는 2진수 이므로 stream중에서 fileinputStream을 활용한다. 
//		// 문자로 전송하는 getWriter는 너무 큰 빨대 이다.
//		while((cnt=is.read(buffer)) != -1) {//eof 전까지 반복 즉 -1이 나오기 전까지, 버퍼에 누적해서 1024가 되면 통으로 돌려준다.
//			//read()는 the next byte of data, or -1 if the end of thefile is reached.
//			out.write(buffer,0,cnt); //버퍼를 쓰면 1kb읽을려면 1024 반복을 하는데 한번에 쓸수있게 된다., cnt가 읽어 들일 만큼
//			// 총 담겨져 있는 버퍼, 시작위치(0=처음부터), cnt까지?
//			//write(b,.off,.len)
//			//b the data
//			//.off the start offset in the data
//			//.len the number of bytes to write.
//			//즉 바이트가 존재하면 그 값이 cnt에 담기고 그걸 write해서 출력하고 다 끝난다면 -1이 반환되서 while문이 종료
//		}
//		is.close();//사용이 끝난 입구 닫고
//		out.flush();//사용이 끝난 빨대 비워주고
//		out.close();//사용이 끝난 빨대 닫고
		
		try(
			FileInputStream is = new FileInputStream(imageFile); 
			OutputStream out = resp.getOutputStream();
//			auto close가 된다.
		){
			while((cnt=is.read(buffer)) != -1) {
				out.write(buffer,0,cnt); 
			}
			out.flush();
		}

//		try with resource 문법
//		try(
//				closable 객체 생성.//finally에서 안 닫아도 auto close가 된다.
//		) {
//			
//		}catch(e) {
//			
//		}
		
	}
}
