package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.vo.MemberVO;

/**
 * 회원관리용(crud) persistence layer
 * 
 * @author PC22
 *
 */
public interface MemberDAO {
	/**
	 * 식별자로 한사람의 사용자를 조회
	 * @author memid 조회할 사람의 아이디
	 * @return 존재하지 않는 경우, null 반환.
		 */
	public MemberVO selectMemberForAuth(String memId);
	
	/**
	 * 신규회원 등록
	 * @param member
	 * @return 0보다 크면 성공
	 */
	public int insertMember(MemberVO member);
	
	/**
	 * 회원 목록 조회, 차후에 페이징과 검색 기능 추가 예정
	 * @return 조건에 맞는 회원이 없는 경우, size == 0 반환.
	 */
	public List<MemberVO> selectMemberList();
	
	/**
	 * 회원 한명의 상세 정보 조회
	 * @param memId
	 * @return 존재하지 않는 다면, null 반환
	 */
	public MemberVO selectMember(String memId);
	
	/**
	 * 회원정보 수정
	 * @param member
	 * @return 0보다 크면 성공
	 */
	public int updateMember(MemberVO member);
	
	/**
	 * 회원정보 삭제(?)
	 * @param memId
	 * @return 0보다 크면 성공
	 */
	public int deleteMember(String memId);
	
}
