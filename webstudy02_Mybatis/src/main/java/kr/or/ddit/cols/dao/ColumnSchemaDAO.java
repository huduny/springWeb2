package kr.or.ddit.cols.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ColumnSchemaVO;

public interface ColumnSchemaDAO {
	/**
	 * 전체 컬럼 스키마 목록 조회
	 * @param pMap
	 * @return
	 */
	public List<ColumnSchemaVO> selectColumnSchemaList(Map<String, Object> pMap);
		
	
	
}
