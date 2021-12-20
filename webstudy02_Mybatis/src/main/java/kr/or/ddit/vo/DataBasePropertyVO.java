package kr.or.ddit.vo;

import java.io.Serializable;

public class DataBasePropertyVO implements Serializable{
	private String propertyName;
	private String propertyValue;
	private String description;
	
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "DataBasePropertyVO [propertyName=" + propertyName + ", propertyValue=" + propertyValue
				+ ", description=" + description + "]";
	}
	
	
}
