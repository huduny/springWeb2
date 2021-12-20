package kr.or.ddit.bts.dao;

import java.util.List;

import kr.or.ddit.vo.BtsVO;

public interface BtsDAO {
   public List<BtsVO> selectBtsLsit();
   
   /**
    * 멤버 상세 조회
    * @param id
    * @return 존재하지 않는다면, null 반환.
    */
   public BtsVO selectBtsById(String id);
}