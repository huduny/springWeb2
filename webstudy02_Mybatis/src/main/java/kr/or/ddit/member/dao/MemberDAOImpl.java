package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private static MemberDAOImpl self;

	private MemberDAOImpl() {
	}

	public static MemberDAOImpl getInstance() {
		if (self == null)
			self = new MemberDAOImpl();
		return self;
	}

	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public MemberVO selectMemberForAuth(String memId) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMemberForAuth", memId);
		}
	}

	@Override
	public int insertMember(MemberVO member) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			int rowcnt =  sqlSession.insert("kr.or.ddit.member.dao.MemberDAO.insertMember", member);
			sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public List<MemberVO> selectMemberList() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
			return mapper.selectMemberList();
		}
	}

	@Override
	public MemberVO selectMember(String memId) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
			System.out.println(mapper);
			return mapper.selectMember(memId);
		}
	}

	@Override
	public int updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
