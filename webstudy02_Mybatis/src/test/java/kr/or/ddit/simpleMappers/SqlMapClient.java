package kr.or.ddit.simpleMappers;

import java.util.List;

public interface SqlMapClient {
	public List queryForList(String queryId, Class resultType);
	public List queryForList(String queryId, Class resultType, Object paramObj);
	public Object queryForObject(String queryId, Class resultType);
	public Object queryForObject(String queryId, Class resultType, Object paramObj);
	public int insert(String queryId, Object paramObj);
}
