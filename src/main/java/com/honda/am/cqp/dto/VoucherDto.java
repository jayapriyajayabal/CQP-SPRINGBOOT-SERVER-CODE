/**
 * 
 */
package com.honda.am.cqp.dto;

/**
 * @author Shrirang Kadale
 *
 */
public class VoucherDto {
	
	private String supplierNumber;
	private String supplierName;
	private String status;
	public String getSupplierNumber() {
		return supplierNumber;
	}
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "VoucherDto [supplierNumber=" + supplierNumber + ", supplierName=" + supplierName + ", status=" + status
				+ "]";
	}

}
