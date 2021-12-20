package kr.or.ddit.dbprop.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.dbprop.dao.DatabasePropertyDAOImpl;
import kr.or.ddit.vo.DataBasePropertyVO;

public class DataBasePropertyServiceImpl implements DataBasePropertyService {
	private DatabasePropertyDAOImpl dbDAO = new DatabasePropertyDAOImpl();
	@Override
	public List<DataBasePropertyVO> retrieveDBPropertyList() {
		
		return dbDAO.selctDataBasePropertyList();
	}

}
