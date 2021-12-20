package kr.or.ddit.cols.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ColumnSchemaVO;

public interface ColumnSchemaService {
	public List<ColumnSchemaVO> retrieveColumnSchemaList(Map<String, Object> pMap);
}
