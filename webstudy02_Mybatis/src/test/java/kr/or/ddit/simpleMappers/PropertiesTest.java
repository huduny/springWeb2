package kr.or.ddit.simpleMappers;

import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.junit.Test;

import kr.or.ddit.member.dao.MemberDAOImpl;

public class PropertiesTest {
	
	@Test
	public void loadFromXml() throws InvalidPropertiesFormatException, IOException {
		Properties properties = new Properties();
		String xmlPath = "/kr/or/ddit/simpleMappers/Member.xml";
		try(
				InputStream in = MemberDAOImpl.class.getResourceAsStream(xmlPath);
		){
			properties.loadFromXML(in);
			System.out.println(properties.getProperty("selectMemberList").trim());
		}
		
	}
}
