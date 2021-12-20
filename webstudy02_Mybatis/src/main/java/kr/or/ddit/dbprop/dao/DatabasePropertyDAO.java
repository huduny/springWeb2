package kr.or.ddit.dbprop.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DataBasePropertyVO;

/**
 * 데이터베이스 환경정보 조회를 위한 퍼시스턴스 레이어
 * @author PC22
 *
 */
public interface DatabasePropertyDAO {
	/**
	 * 기본정보 조회, 추후 검색기능 추가 예정
	 * @return 조건에 맞는 정보가 없는 경우, size가 0인 리스트 반환
	 */

	public List<DataBasePropertyVO> selctDataBasePropertyList();
	
	
}
