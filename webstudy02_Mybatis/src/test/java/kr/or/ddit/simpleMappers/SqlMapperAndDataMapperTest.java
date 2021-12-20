package kr.or.ddit.simpleMappers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;import oracle.net.aso.i;

public class SqlMapperAndDataMapperTest {

	@Test
	public void testParseRealQuery() {
		StringBuffer query  = new StringBuffer();
		query.append(" INSERT INTO MEMBER(MEM_ID, MEM_NAME)");
		
		query.append(" VALUES(#memId#, #memName#)");
		List<String> inLineParameterNames = SqlMapperAndDataMapper.parseRealQuery(query);
		System.out.println(inLineParameterNames);
		System.out.println(query);
		
	}

}
