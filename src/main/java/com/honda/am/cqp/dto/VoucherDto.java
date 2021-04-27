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
	private String supplierDesc;
	private String status;
	public String getSupplierNumber() {
		return supplierNumber;
	}
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}
	public String getSupplierDesc() {
		return supplierDesc;
	}
	public void setSupplierDesc(String supplierDesc) {
		this.supplierDesc = supplierDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "VoucherDto [supplierNumber=" + supplierNumber + ", supplierName=" + supplierDesc + ", status=" + status
				+ "]";
	}

}
