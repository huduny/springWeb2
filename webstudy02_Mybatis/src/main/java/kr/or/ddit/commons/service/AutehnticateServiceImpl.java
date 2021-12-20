package kr.or.ddit.commons.service;

import kr.or.ddit.commons.dao.MemberDAOimplInMemory;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class AutehnticateServiceImpl implements AuthenticateService {
	private MemberDAO memberDAO = MemberDAOImpl.getInstance();
	
	private static AutehnticateServiceImpl self;
	private AutehnticateServiceImpl() {}
	public static AutehnticateServiceImpl getInstance() {
		if(self == null)
		self = new AutehnticateServiceImpl();
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
