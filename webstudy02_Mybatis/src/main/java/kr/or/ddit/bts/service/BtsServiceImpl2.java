package kr.or.ddit.bts.service;

import java.util.List;

import kr.or.ddit.bts.dao.BtsDAO;
import kr.or.ddit.bts.dao.BtsDAOImplInMemory;
import kr.or.ddit.commons.exception.PKNotFoundException;
import kr.or.ddit.vo.BtsVO;

public class BtsServiceImpl2 implements BtsService {
	
	private static BtsServiceImpl2 self;
	
	private BtsServiceImpl2() {}
	
	public static BtsServiceImpl2 getInstance() {
		if(self == null)
		self = new BtsServiceImpl2();
		return self;
	}
	
	private BtsDAO dao = BtsDAOImplInMemory.getInstance();

	@Override
	public List<BtsVO> retrieveBtsList() {
		
		return dao.selectBtsLsit();
	}

	@Override
	public BtsVO retrieveBtsById(String id) {
		BtsVO bts = dao.selectBtsById(id);
		if (bts == null) {
			throw new PKNotFoundException(id+"에 해당하는 멤버가 없음.");
		}
		
		
		
		
		return bts;
	}

}
