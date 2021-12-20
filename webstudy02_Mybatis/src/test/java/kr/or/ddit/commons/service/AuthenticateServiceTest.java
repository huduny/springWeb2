package kr.or.ddit.commons.service;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;

public class AuthenticateServiceTest {
	private AuthenticateService service = 
			AutehnticateServiceImpl.getInstance();

	@Test
	public void testAuthenticateNotExist() {
		MemberVO inputData = MemberVO.builder()
				.memId("d001")
				.memPass(null)
				.build();
		ServiceResult result =  service.authenticate(inputData);
		assertEquals(ServiceResult.NOTEXIST, result);
	}
	
	@Test
	public void testAuthenticateInvalidPassword() {
		MemberVO inputData = MemberVO.builder()
				.memId("a001")
				.memPass("123123")
				.build();
		ServiceResult result = service.authenticate(inputData);
		assertEquals(ServiceResult.INVALIDPASSWORD, result);
		
	}
	
	@Test
	public void testAuthenticateOk() {
		MemberVO inputData = MemberVO.builder()
				.memId("b001")
				.memPass("1004")
				.build();
		ServiceResult result = service.authenticate(inputData);
		assertEquals(ServiceResult.OK, result);
		
	}

}
