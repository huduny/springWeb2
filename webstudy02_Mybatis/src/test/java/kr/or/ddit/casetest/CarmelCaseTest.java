package kr.or.ddit.casetest;

import org.apache.commons.text.CaseUtils;
import org.junit.Test;

public class CarmelCaseTest {
	
	@Test
	public void caseUtilsTest() {
		String snake = "MEM_ID";
		String propName = CaseUtils.toCamelCase(snake, false, '_');
		System.out.println(propName);
	}
}
