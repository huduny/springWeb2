package kr.or.ddit.cols.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.cols.dao.ColumnSchemaDAO;
import kr.or.ddit.cols.dao.ColumnSchemaDAOImpl;
import kr.or.ddit.vo.ColumnSchemaVO;

public class ColumnSchemaServiceImpl implements ColumnSchemaService {
	private ColumnSchemaDAO dao = new ColumnSchemaDAOImpl();
	
	@Override
	public List<ColumnSchemaVO> retrieveColumnSchemaList(Map<String, Object> pMap) {
		
		return dao.selectColumnSchemaList(pMap);
	}

}
