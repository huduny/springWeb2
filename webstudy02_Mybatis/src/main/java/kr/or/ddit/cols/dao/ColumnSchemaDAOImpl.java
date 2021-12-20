package kr.or.ddit.cols.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.ColumnSchemaVO;

public class ColumnSchemaDAOImpl implements ColumnSchemaDAO {

	@Override
	public List<ColumnSchemaVO> selectColumnSchemaList(Map<String, Object> pMap) {
		List<ColumnSchemaVO> list = new ArrayList<>();
		try(
				Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement();
			){
			// out.println(conn);
				StringBuffer sql = new StringBuffer();
				sql.append(" select table_name, column_name, data_type ");
				sql.append(" ,data_length, nullable, data_default ");
				sql.append(" from cols ");
				ResultSet rs = stmt.executeQuery(sql.toString());
				System.out.println(rs);
				
				ResultSetMetaData rsmd = rs.getMetaData();
				int cols = rsmd.getColumnCount();
				String[] headers = new String[cols];
				pMap.put("headers",headers);

				for(int i =1; i<=cols; i++){
					headers[i-1]=rsmd.getColumnName(i);
				}
				

				while(rs.next()){
					ColumnSchemaVO vo = new ColumnSchemaVO();
					list.add(vo);
					vo.setTableName(rs.getString("TABLE_NAME"));
					vo.setColumName(rs.getString("COLUMN_NAME"));
					vo.setDataType(rs.getString("DATA_TYPE"));
					vo.setDataLength(rs.getString("DATA_LENGTH"));
					vo.setDataDefault(rs.getString("DATA_DEFAULT"));
					
				}	
				System.out.println(list);
				return list;
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}

}
