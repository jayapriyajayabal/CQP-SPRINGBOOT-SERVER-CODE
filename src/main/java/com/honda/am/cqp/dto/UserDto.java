/**
 * 
 */
package com.honda.am.cqp.dto;

/**
 * @author Shrirang Kadale
 *
 */
public class UserDto {

	private String userLogin;
	private String userType;
	private String firstName;
	private String lastName;
	private String supplierNumber;

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	@Override
	public String toString() {
		return "UserDto [userLogin=" + userLogin + ", userType=" + userType + ", firstName=" + firstName + ", lastName="
				+ lastName + ", supplierNumber=" + supplierNumber + "]";
	}

}
