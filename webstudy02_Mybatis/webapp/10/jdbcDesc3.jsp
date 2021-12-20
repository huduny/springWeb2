<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.vo.ColumnSchemaVO"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10/jdbcDesc.jsp</title>
</head>
<body>
<h4>JDBC(JavaDataBaseConnetivity)</h4>
<pre>
	JDBC 프로그래밍 단계(facade pattern)
	1. 벤더가 제공해주는 드라이버(ojdbc6.jar)를 필드패스(%catalina_home%\lib)에 추가
	2. 드라이버를 로딩(classloader-클래스를 메모리 공간에 적재)
	3. 커넥션 생성(한세션의 역할)
	4. 쿼리객체, 쿼리문을 sql로 전송할 수 있는, 3번단계에서 만든 connection으로 부터 쿼리 객체 생성
		- statement: 동적쿼리가 가능한 쿼리 객체
		- preparedstatement: 정적 쿼리를 생성, 미리 컴파일된 객체, 쿼리 파라미터(?)로 리터럴 치환
		- callablestatement: 절차적인 코드를 실행할때 사용(프로시져, 펑션)
	5. 쿼리 실행(어떤 쿼리문을 실행하냐에 따라서)
		- ResultSet executeQuery : select
		- int executeUpdate: Insert update delete
	6. ResultSet 핸들링 (next)
	7. release(서버의 가용자원 복귀): close
</pre>

<%
//2. 드라이버 로딩
Class.forName("oracle.jdbc.driver.OracleDriver");
String url ="jdbc:oracle:thin:@localhost:1521:xe";
String user = "OYK93";
String password = "java";

try(
	Connection conn = DriverManager.getConnection(url, user, password);
	Statement stmt = conn.createStatement();
){
// out.println(conn);
	StringBuffer sql = new StringBuffer();
	sql.append(" select table_name, column_name, data_type ");
	sql.append(" ,data_length, nullable, data_default ");
	sql.append(" from cols ");
	ResultSet rs = stmt.executeQuery(sql.toString());
	
	ResultSetMetaData rsmd = rs.getMetaData();
	int cols = rsmd.getColumnCount();
	String[] headers = new String[cols];
	
	pageContext.setAttribute("headers", headers);

	for(int i =1; i<=cols; i++){
		headers[i-1]=rsmd.getColumnName(i);
	}
	
	List<ColumnSchemaVO> list = new ArrayList();
	pageContext.setAttribute("list", list);
	while(rs.next()){
		ColumnSchemaVO vo = new ColumnSchemaVO();
		list.add(vo);
		vo.setTableName(rs.getString("TABLE_NAME"));
		vo.setColumName(rs.getString("COLUMN_NAME"));
		vo.setDataType(rs.getString("DATA_TYPE"));
		vo.setDataLength(rs.getString("DATA_LENGTH"));
		vo.setDataDefault(rs.getString("DATA_DEFAULT"));
	}
	
	
	
}
%>
<table>
	<thead>
		<tr>
			<%
				String[] headers = (String[]) pageContext.getAttribute("headers");
				for(String header : headers){
					%>
					<th><%=header%></th>
					<%
				}
			%>
		</tr>
	</thead>
	<tbody>
	<%
		List<ColumnSchemaVO> list = (List) pageContext.getAttribute("list");
		for(ColumnSchemaVO tmp : list){
	%>
			<tr>
				<td><%=tmp.getTableName()%></td>
				<td><%=tmp.getColumName()%></td>
				<td><%=tmp.getDataType()%></td>
				<td><%=tmp.getDataLength()%></td>
				<td><%=tmp.getDataDefault()%></td>
			</tr>
	<%
		}
	%>
	</tbody>
</table>
</body>
</html>