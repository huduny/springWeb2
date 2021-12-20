package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import kr.or.ddit.vo.MemberVO;

public class MemberDAOImplTest {
	private MemberDAO memberDAO = MemberDAOImpl.getInstance();
//	
	@Test
	public void testSelectMemberForAuth() {
		
		MemberVO member = memberDAO.selectMemberForAuth("a001");
		System.out.println(member);
	}

	// EDD(event driven development), TDD(test driven development)
	@Test
	public void testInsertMember() {
		MemberVO member = MemberVO.builder()
				.memId("b002")
				.memPass("java")
				.memName("insoo")
				.memRegno1("111111")
				.memRegno2("1111111")
				.memZip("12345")
				.memAdd1("서대전")
				.memAdd2("1234")
				.memHp("000-000-000")
				.memHometel("000-000-000")
				.memComtel("000-000-000")
				.memMail("aa@naver.com")
				.build();
		
		int rowcnt = memberDAO.insertMember(member);
		System.out.println(rowcnt);
		
	}


	@Test
	public void testSelectMemberList() {
		System.out.println(memberDAO.selectMemberList());
	}

	@Test
	public void testSelectMember() {
		MemberVO member = memberDAO.selectMember("a002");
		System.out.println(member);
	}

//	@Test
//	public void testUpdateMember() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteMember() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testObject() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetClass() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testHashCode() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testEquals() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testClone() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testToString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testNotify() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testNotifyAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testWaitLong() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testWaitLongInt() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testWait() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFinalize() {
//		fail("Not yet implemented");
//	}

}
