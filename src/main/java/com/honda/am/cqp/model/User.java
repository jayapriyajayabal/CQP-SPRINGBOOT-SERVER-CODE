/**
 * 
 */
package com.honda.am.cqp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Shrirang Kadale
 *
 */
@Entity
@Table(name = "tblUSER_PROFILE")
public class User {
	
    @Id
    private String USER_LOGIN;
    private String USER_TYPE;
    private String USER_FIRST_NAME;
    private String USER_LAST_NAME;
    private LocalDate USER_LAST_LOGIN;
    private String SUPP_NO;
    private String EMAIL_ID;
    private String FAX_NO;
    private LocalDate SECURITY_RECEIVED_DT;
    private String EXIST_IN_SECURITY;
    
    public User() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the uSER_LOGIN
	 */
    @Column(name = "USER_LOGIN", nullable = false)
	public String getUSER_LOGIN() {
		return USER_LOGIN;
	}
	/**
	 * @param uSER_LOGIN the uSER_LOGIN to set
	 */
	public void setUSER_LOGIN(String uSER_LOGIN) {
		USER_LOGIN = uSER_LOGIN;
	}
	/**
	 * @return the uSER_TYPE
	 */
	@Column(name = "USER_TYPE", nullable = true)
	public String getUSER_TYPE() {
		return USER_TYPE;
	}
	/**
	 * @param uSER_TYPE the uSER_TYPE to set
	 */
	public void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}
	/**
	 * @return the uSER_FIRST_NAME
	 */
	@Column(name = "USER_FIRST_NAME", nullable = true)
	public String getUSER_FIRST_NAME() {
		return USER_FIRST_NAME;
	}
	/**
	 * @param uSER_FIRST_NAME the uSER_FIRST_NAME to set
	 */
	public void setUSER_FIRST_NAME(String uSER_FIRST_NAME) {
		USER_FIRST_NAME = uSER_FIRST_NAME;
	}
	/**
	 * @return the uSER_LAST_NAME
	 */
	@Column(name = "USER_LAST_NAME", nullable = true)
	public String getUSER_LAST_NAME() {
		return USER_LAST_NAME;
	}
	/**
	 * @param uSER_LAST_NAME the uSER_LAST_NAME to set
	 */
	public void setUSER_LAST_NAME(String uSER_LAST_NAME) {
		USER_LAST_NAME = uSER_LAST_NAME;
	}
	/**
	 * @return the sER_LAST_LOGIN
	 */
	@Column(name = "USER_LAST_LOGIN", nullable = true)
	public LocalDate getUSER_LAST_LOGIN() {
		return USER_LAST_LOGIN;
	}
	/**
	 * @param sER_LAST_LOGIN the sER_LAST_LOGIN to set
	 */
	public void setUSER_LAST_LOGIN(LocalDate sER_LAST_LOGIN) {
		USER_LAST_LOGIN = sER_LAST_LOGIN;
	}
	/**
	 * @return the uPP_NO
	 */
	@Column(name = "SUPP_NO", nullable = true)
	public String getSUPP_NO() {
		return SUPP_NO;
	}
	/**
	 * @param uPP_NO the uPP_NO to set
	 */
	public void setSUPP_NO(String uPP_NO) {
		SUPP_NO = uPP_NO;
	}
	/**
	 * @return the eMAIL_ID
	 */
	@Column(name = "EMAIL_ID", nullable = true)
	public String getEMAIL_ID() {
		return EMAIL_ID;
	}
	/**
	 * @param eMAIL_ID the eMAIL_ID to set
	 */
	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}
	/**
	 * @return the fAX_NO
	 */
	@Column(name = "FAX_NO", nullable = true)
	public String getFAX_NO() {
		return FAX_NO;
	}
	/**
	 * @param fAX_NO the fAX_NO to set
	 */
	public void setFAX_NO(String fAX_NO) {
		FAX_NO = fAX_NO;
	}
	/**
	 * @return the sECURITY_RECEIVED_DT
	 */
	@Column(name = "SECURITY_RECEIVED_DT", nullable = true)
	public LocalDate getSECURITY_RECEIVED_DT() {
		return SECURITY_RECEIVED_DT;
	}
	/**
	 * @param sECURITY_RECEIVED_DT the sECURITY_RECEIVED_DT to set
	 */
	public void setSECURITY_RECEIVED_DT(LocalDate sECURITY_RECEIVED_DT) {
		SECURITY_RECEIVED_DT = sECURITY_RECEIVED_DT;
	}
	/**
	 * @return the eXIST_IN_SECURITY
	 */
	@Column(name = "EXIST_IN_SECURITY", nullable = true)
	public String getEXIST_IN_SECURITY() {
		return EXIST_IN_SECURITY;
	}
	/**
	 * @param eXIST_IN_SECURITY the eXIST_IN_SECURITY to set
	 */
	public void setEXIST_IN_SECURITY(String eXIST_IN_SECURITY) {
		EXIST_IN_SECURITY = eXIST_IN_SECURITY;
	}
    
	
}
