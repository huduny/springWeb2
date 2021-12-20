package kr.or.ddit.commons.service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;

public interface AuthenticateService {
	/**
	 * 아이디와 비밀번호 기반의 인증 로직
	 * @param inputData, 인증에 필요한 아이디와 비밀번호를 가진 객체
	 * @return 존재하지 않는 사용자(NOTEXIST), 비밀번호 오류(INVALIDPASSWORD), 인증 성공(OK)
	 */
	public ServiceResult authenticate(MemberVO inputData);

}
