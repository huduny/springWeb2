package kr.or.ddit.bts.service;

import java.util.List;

import kr.or.ddit.vo.BtsVO;

public interface BtsService {
	/**
	 * bts 전체 멤버 조회
	 * @return
	 */
	public List<BtsVO> retrieveBtsList();
	
	/**
	 * 한명의 멤버 조회
	 * @param id 조회할 멤버의 식별자
	 * @return 존재하지 않는다면, custom exception 발생
	 */
	public BtsVO retrieveBtsById(String id);
}
