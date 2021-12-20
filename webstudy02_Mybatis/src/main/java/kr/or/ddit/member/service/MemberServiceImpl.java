package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.commons.exception.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAOImpl dao = MemberDAOImpl.getInstance();
	
	private static MemberServiceImpl self;
	private MemberServiceImpl() {}
	public static MemberServiceImpl getInstance() {
		if(self == null)
		self = new MemberServiceImpl();
		return self;
	}

	@Override
	public ServiceResult createMember(MemberVO member) {
		ServiceResult result =null;
		
		if(dao.selectMember(member.getMemId())==null) {
			int rowcnt = dao.insertMember(member);
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}else {
			result = ServiceResult.PKDUPLICATED;
		}

		return result;
	}

	@Override
	public List<MemberVO> retrieveMemberList() {
		
		return dao.selectMemberList();
	}

	@Override
	public MemberVO retrieveMember(String memId) {
		MemberVO member = dao.selectMember(memId);
		if (member == null) {
			throw new PKNotFoundException(memId+"해당 회원이 없음");
		}
		
		return member;
	}

	@Override
	public ServiceResult modifyMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

}
