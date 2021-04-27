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

import com.honda.am.cqp.dao.CallInAlertDao;

/**
 * @author Shrirang Kadale
 *
 */

@Repository
public class CallInAlertDaoImpl implements CallInAlertDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

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
