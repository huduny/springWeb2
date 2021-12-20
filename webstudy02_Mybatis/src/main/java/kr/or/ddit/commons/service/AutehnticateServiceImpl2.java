package kr.or.ddit.commons.service;

import kr.or.ddit.commons.dao.MemberDAOimplInMemory;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.vo.MemberVO;

public class AutehnticateServiceImpl2 implements AuthenticateService {
	private MemberDAO memberDAO = MemberDAOimplInMemory.getInstance();
	
	private static AutehnticateServiceImpl2 self;
	private AutehnticateServiceImpl2() {}
	public static AutehnticateServiceImpl2 getInstance() {
		if(self == null)
		self = new AutehnticateServiceImpl2();
		return self;
	}
	
	
	@Override //내가 처음 만든 메소드가 아니라 부모로부터 상속받은 메소드를 재정의한거다
	public ServiceResult authenticate(MemberVO inputData) {
		ServiceResult result = null;
		MemberVO saved = memberDAO.selectMemberForAuth(inputData.getMemId());
		if (saved==null) {
			result = ServiceResult.NOTEXIST;
		}else {
			String inputPass = inputData.getMemPass();
			String savedPass = saved.getMemPass();
			if (savedPass.equals(inputPass)) {
				result = ServiceResult.OK;
				inputData.setMemName(saved.getMemName());
			}else {
				result = ServiceResult.INVALIDPASSWORD;
			}
 		}
		return result;
	}

}
