package kr.or.ddit.bts.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.commons.dao.MemberDAOimplInMemory;
import kr.or.ddit.vo.BtsVO;

public class BtsDAOImplInMemory implements BtsDAO {
	
	private static BtsDAOImplInMemory self;
	
	private BtsDAOImplInMemory() {}
	
	public static BtsDAOImplInMemory getInstance() {
		if(self == null)
		self = new BtsDAOImplInMemory();
		return self;
	}
	
	private static Map<String,BtsVO> btsTable;
	static {
		btsTable = new LinkedHashMap<String, BtsVO>();
		btsTable.put("B001", new BtsVO("B001","RM", "bts/rm"));
		btsTable.put("B002", new BtsVO("B002","bui", "bts/bui"));
		btsTable.put("B003", new BtsVO("B003","jhop", "bts/jhop"));
		btsTable.put("B004", new BtsVO("B004","jimin", "bts/jimin"));
		btsTable.put("B005", new BtsVO("B005","jin", "bts/jin"));
		btsTable.put("B006", new BtsVO("B006","jungkuk", "bts/jungkuk"));
		btsTable.put("B007", new BtsVO("B007","suga", "bts/suga"));
	}

	@Override
	public List<BtsVO> selectBtsLsit() {

		return new ArrayList<>(btsTable.values());
	}

	@Override
	public BtsVO selectBtsById(String id) {
		
		return btsTable.get(id);
	}

}
