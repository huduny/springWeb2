package kr.or.ddit.vo;

import java.io.Serializable;

/*
 * DataBase Column Schema 정보를 담기 위한 domain layer
 * 
 */
public class ColumnSchemaVO implements Serializable{
	private String tableName;
	private String columName;
	private String dataType;
	private String dataLength;
	private String dataDefault;
	
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColumName() {
		return columName;
	}
	public void setColumName(String columName) {
		this.columName = columName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getDataLength() {
		return dataLength;
	}
	public void setDataLength(String dataLength) {
		this.dataLength = dataLength;
	}
	public String getDataDefault() {
		return dataDefault;
	}
	public void setDataDefault(String dataDefault) {
		this.dataDefault = dataDefault;
	}
	@Override
	public String toString() {
		return "ColumnSchemaVO [tableName=" + tableName + ", columName=" + columName + ", dataType=" + dataType
				+ ", dataLength=" + dataLength + ", dataDefault=" + dataDefault + "]";
	}
	
	
}
