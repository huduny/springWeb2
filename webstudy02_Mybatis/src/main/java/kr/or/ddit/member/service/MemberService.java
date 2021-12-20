package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.commons.exception.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;

/**
 * 회원관리용(crud)용 비지니스 로직 레이어
 * @author PC22
 *
 */
public interface MemberService {
	
	/**
	 * 회원 가입
	 * @param member
	 * @return {@link ServiceResult.PKDUPLICATED}, {@link ServiceResult.OK}, {@link ServiceResult.FAIL}
	 */
	public ServiceResult createMember(MemberVO member);
	
	/**
	 * 목록조회
	 * @return 조건에 맞는 회우너이 없으면, size==0;
	 */ 
	public List<MemberVO> retrieveMemberList();
	
	/**
	 * 상세조회
	 * @return memId
	 * 존재하지 않는다면, {@link PKNotFoundException} 발생.
	 */
	public MemberVO retrieveMember(String memId);
	
	
	/**
	 * 회원정보 수정
	 * @param member
	 * @return {@link PKNotFoundException}, invalidpassword, ok , fail
	 */
	public ServiceResult modifyMember(MemberVO member);
	
	/**
	 * 회원탈퇴
	 * @param member
	 * @return{@link PKNotFoundException}, invalidpassword, ok , fail
	 */
	public ServiceResult removeMember(MemberVO member);
	
}
