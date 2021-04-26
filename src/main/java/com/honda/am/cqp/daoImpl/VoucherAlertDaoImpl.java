/**
 * 
 */
package com.honda.am.cqp.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.honda.am.cqp.dao.VoucherAlertDao;

/**
 * @author Shrirang Kadale
 *
 */
public class VoucherAlertDaoImpl implements VoucherAlertDao {

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
				+ " WHERE " + " T1.SUPP_NO= 011620 AND T1.STATUS_ID = T2.STATUS_ID";

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();

		dataList = jdbcTemplate.queryForList(GET_CURR_VCHR_SUMMARY);
		System.out.println(dataList);
		return dataList;
	}

}
