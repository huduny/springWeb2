package kr.or.ddit.commons.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOimplInMemory implements MemberDAO {
	private static Map<String, MemberVO> memberTable;
	static {
		memberTable = new LinkedHashMap<>();
		memberTable.put("a001", MemberVO.builder()
				.memId("a001")
				.memPass("asdasd")
				.memName("김은대")
				.build());
		memberTable.put("b001", MemberVO.builder()
				.memId("b001")
				.memPass("1004")
				.memName("이쁜이")
				.build());
	}
	
	private static MemberDAOimplInMemory self;
	private MemberDAOimplInMemory() {}
	public static MemberDAOimplInMemory getInstance() {
		if(self == null)
		self = new MemberDAOimplInMemory();
		return self;
	}
	
	
	
	@Override
	public MemberVO selectMemberForAuth(String memId) {
		// TODO Auto-generated method stub
		return memberTable.get(memId);
	}
	@Override
	public int insertMember(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<MemberVO> selectMemberList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberVO selectMember(String memId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
