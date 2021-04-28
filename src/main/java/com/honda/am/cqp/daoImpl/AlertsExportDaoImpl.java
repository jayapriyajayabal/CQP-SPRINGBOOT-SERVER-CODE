/**
 * 
 */
package com.honda.am.cqp.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.honda.am.cqp.dao.AlertsExportDao;

/**
 * @author Shrirang Kadale
 *
 */

@Repository
public class AlertsExportDaoImpl implements AlertsExportDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getVoucherAlerts() {

		final String GET_CURR_VCHR_SUMMARY = "SELECT " + "T1.VOUCHER_NO,"
				+ "T1.SUPP_NO,T1.QTR_NO,T1.QTR_YEAR,T1.SUPP_NAME,T1.STATUS_ID,T1.VOUCHER_DESC,"
				+ "T1.ISSUE_DATE,T1.DUE_DATE,T1.SUB_TOTAL_AMT,T1.TOTAL_ADDL_SHIPPING_CHARGES_AMT,"
				+ "T1.TOTAL_SUPPLIER_RESPONSIBILITY_PCT,T1.SUPPLIER_RESP_ADDL_SHIPPING_CHARGES_AMT,"
				+ "T1.OVERALL_ADJUSTMENT_AMT,T1.DIAGNOSTIC_ADJUSTMENT_AMT,T1.TOTAL_AMT,"
				+ "T1.TOTAL_MARKET_CLAIM,T1.SUB_TOTAL_AMT,T1.CALC_SHIPPING_RESP_PCT,"
				+ "SUPPLIER_RESP_ADDL_SHIPPING_CHARGES_AMT ,T1.TOTAL_SUPPLIER_CHARGE_AMT,"
				+ "T2.STATUS_NAME,T1.TOTAL_SUPPLIER_RESP_SUB_TOTAL_AMT"
				/* Start - Ability to enter overall adjustments data by individual plants */
				+ ", T1.PLANT_OVERALL_ADJ_FLAG "
				/* End - Ability to enter overall adjustments data by individual plants */
				+ " FROM " + " dbo " + ".tblVOUCHER_SUMMARY T1 (NOLOCK) ," + " dbo " + ".tblSTATUS T2 (NOLOCK)"
				+ " WHERE " 
				+ " T1.SUPP_NO= 140290 AND "
				+ "T1.STATUS_ID = T2.STATUS_ID";

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();

		dataList = jdbcTemplate.queryForList(GET_CURR_VCHR_SUMMARY);
		System.out.println(dataList);
		return dataList;
	}
	

	@Override
	public List<Map<String, Object>> getUserAlerts() {		
		

		final String SELECT_USER_ALERTS_DTLS = new StringBuffer()
				.append("SELECT count(*) USER_PROFILE.USER_LOGIN, USER_TYPE, USER_FIRST_NAME, ")
				.append("USER_LAST_NAME,  USER_PROFILE.SUPP_NO as SUPP_SUPP_NO, ")
				.append("CONVERT(VARCHAR,USER_LAST_LOGIN,101) AS USER_LAST_LOGIN,")
				.append("SUPP_MAP.SUPP_NO AS CQ_SUPP_NO").append(" FROM ").append("dbo.tblUSER_PROFILE")
				.append(" USER_PROFILE ").append(" LEFT OUTER JOIN ").append("dbo.tblUSER_ROLE_MAPPING")
				.append(" USER_ROLE_MAP ").append(" ON USER_PROFILE.USER_LOGIN = USER_ROLE_MAP.USER_LOGIN ")
				.append(" LEFT OUTER JOIN ").append("dbo.tblCQ_SUPPLIER_MAPPING").append(" SUPP_MAP")
				.append(" ON USER_PROFILE.USER_LOGIN = SUPP_MAP.CQ_USER_LOGIN")
				.append(" WHERE USER_ROLE_MAP.ROLE_ID IS NULL").toString();

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		dataList = jdbcTemplate.queryForList(SELECT_USER_ALERTS_DTLS);
		return dataList;
		}
	
	@Override
	public List<Map<String, Object>> getCallInAlerts() {

		final String SELECT_CALLIN_ALERTS_DTLS_HONDA = new StringBuffer()
				.append("SELECT CPL_DTL.CALLIN_PART_SK CIPL_NO, CPL_DTL.SUPP_NO, SUPP.SUPP_NAME, STS.STATUS_NAME")
				.append(" FROM ").append("dbo.tblCALL_IN_DETAIL").append(" CPL_DTL INNER JOIN ").append("dbo.tblSTATUS")
				.append(" STS ON CPL_DTL.STATUS_ID = STS.STATUS_ID").append(" INNER JOIN ")
				.append("dbo.tblCQ_SUPPLIER_INFO").append(" SUPP ON CPL_DTL.SUPP_NO = SUPP.SUPP_NO WHERE")
				//.append(" CPL_DTL.IN_USE_BY_NAME = ? AND ")
				.append(" STS.STATUS_TYPE = 'CALL-IN' AND STS.STATUS_NAME = 'NEW' AND")
				.append(" CPL_DTL.SUPP_NO IN (").append(" SELECT SUPP_NO FROM ")
				.append("dbo.tblCQ_SUPPLIER_MAPPING ) ")
				//.append(" WHERE CQ_USER_LOGIN = ?")
				.append("ORDER BY CPL_DTL.SUPP_NO, SUPP.SUPP_NAME, CALLIN_PART_SK").toString();

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		dataList = jdbcTemplate.queryForList(SELECT_CALLIN_ALERTS_DTLS_HONDA);
		return dataList;
	}


}
