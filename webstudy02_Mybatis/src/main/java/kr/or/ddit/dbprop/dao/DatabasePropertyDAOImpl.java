package kr.or.ddit.dbprop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.ColumnSchemaVO;
import kr.or.ddit.vo.DataBasePropertyVO;

public class DatabasePropertyDAOImpl implements DatabasePropertyDAO {
	@Override
	public List<DataBasePropertyVO> selctDataBasePropertyList() {
		List<DataBasePropertyVO> list = new ArrayList<>();
		/*
		 * SELECT *
			FROM DATABASE_PROPERTIES;
		 */
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * ");
		sql.append(" FROM DATABASE_PROPERTIES ");
		try(
				Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql.toString());
			){
			// out.println(conn);
				ResultSet rs = stmt.executeQuery();

				System.out.println(rs);
				System.out.println();
				int cnt = 0;
				while(rs.next()){
					DataBasePropertyVO vo = new DataBasePropertyVO();
					list.add(vo);
					vo.setPropertyName(rs.getString(1));
					vo.setPropertyValue(rs.getString(2));
					vo.setDescription(rs.getString(3));
					cnt++;
				}	
				System.out.println(list);
				System.out.println(cnt);
			return list;
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
	
		
	}

}
