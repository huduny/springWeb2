package kr.or.ddit.dbprop.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DataBasePropertyVO;

/**
 * 데이터베이스 환경정보 조회를 위한 비지니스 로직 레이어
 * @author PC22
 *
 */
public interface DataBasePropertyService {
	/**
	 * 데이터베이스 기본정보 조회, 차후 검색 예정
	 * @return 조건에 맞는 정보가 없는 경우, size가 0인 list 반환
	 */
	public List<DataBasePropertyVO> retrieveDBPropertyList();
}
