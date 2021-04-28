/**
 * 
 */
package com.honda.am.cqp.dto;

/**
 * @author Shrirang Kadale
 *
 */
public class ManageAlertsDTO {
	
	private String supplierNo;;
	private String status;;
	private String alertText;;
	private String alertType;
	public String getSupplierNo() {
		return supplierNo;
	}
	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAlertText() {
		return alertText;
	}
	public void setAlertText(String alertText) {
		this.alertText = alertText;
	}
	public String getAlertType() {
		return alertType;
	}
	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}
	

}
