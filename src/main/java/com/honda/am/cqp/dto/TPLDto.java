package com.honda.am.cqp.dto;

import java.sql.Timestamp;

public class TPLDto {

	private int tplRefID;

	private String userLogin;
	private String userType;
	private String SuppName;
	private String StatusName;
	private String userFirstName;
	private String userLastName;
	private Timestamp userLastLogin;
	private String suppNo;

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

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public Timestamp getUserLastLogin() {
		return userLastLogin;
	}

	public void setUserLastLogin(Timestamp userLastLogin) {
		this.userLastLogin = userLastLogin;
	}

	public String getSuppNo() {
		return suppNo;
	}

	public void setSuppNo(String dto) {
		this.suppNo = dto;
	}

	@Override
	public String toString() {
		return "UserDto [userLogin=" + userLogin + ", userType=" + userType + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", userLastLogin=" + userLastLogin + ", suppNo=" + suppNo
				+ ",SuppName=" + SuppName + ",StatusName=" + StatusName + "]";
	}

	public String getStatusName() {
		return StatusName;
	}

	public void setStatusName(String statusName) {
		StatusName = statusName;
	}

	public String getSuppName() {
		return SuppName;
	}

	public void setSuppName(String suppName) {
		SuppName = suppName;
	}

	public int getTplRefID() {
		return tplRefID;
	}

	public void setTplRefID(int tplRefID) {
		this.tplRefID = tplRefID;
	}

}
