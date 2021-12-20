package kr.or.ddit.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 쿠키 사용에 필요한 유틸리티 메소드 집합
 * @author PC22
 *
 */
public class CookieUtils {
	private Map<String, Cookie> cookieMap;
	
	
	
	public CookieUtils(HttpServletRequest req) {
		cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = req.getCookies();
		if (cookies!=null) {
			for(Cookie tmp: cookies) {
				cookieMap.put(tmp.getName(), tmp);
			}
		}
		
	}
	/**
	 * 
	 * @param name
	 * @param plain
	 * @return 특수문자가 utf-8 문자셋으로 url encoding 방식으로 인코딩된 쿠키 생성.
	 * @throws IOException
	 */
	public static Cookie getnerateCookie(String name, String plain) throws IOException {
		//특수문자 포함 상황 가정
		String encoded = URLEncoder.encode(plain,"UTF-8");
		
		return new Cookie(name, encoded);
	}
	/**
	 * 
	 * @param name
	 * @return 존재하지 않을때, null 반환
	 */
	public Cookie getCookie(String name){
		return cookieMap.get(name);
	}
	
	public String getCookieValue(String name) throws IOException{
		Cookie searched = getCookie(name);
		String value="";
		if(searched!=null) {
			value = URLDecoder.decode(searched.getValue(),"UTF-8");
		}
		return value;
	}
}

