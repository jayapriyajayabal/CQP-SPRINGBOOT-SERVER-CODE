/**
 * 
 */
package com.honda.am.cqp.dto;

/**
 * @author Shrirang Kadale
 *
 */
public class BaseDto {
	
	private String columnName;
	private String versionNumber;
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

}
