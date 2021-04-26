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

import com.honda.am.cqp.dao.UserAlertDao;

/**
 * @author Shrirang Kadale
 *
 */

@Repository
public class UserAlertDaoImpl implements UserAlertDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getUserAlerts() {		
		
		final String GET_USER_DETAIL_ADMIN =
				new StringBuffer()
					.append(" SELECT USER_PROFILE.USER_FIRST_NAME AS USER_FIRST_NAME,")
					.append(" USER_PROFILE.USER_LAST_NAME AS USER_LAST_NAME, ")
					.append(" USER_PROFILE.USER_LOGIN AS USER_LOGIN,")
					.append(" USER_PROFILE.USER_TYPE AS USER_TYPE, ")
					.append(" USER_PROFILE.SUPP_NO AS SUPP_NO,")
					.append(" Convert(varchar(10),USER_LAST_LOGIN,101) AS USER_LAST_LOGIN, ")
					/*Start - Enhancement - Display security received date for no role search*/
					.append(" Convert(varchar(10),SECURITY_RECEIVED_DT,101) AS SECURITY_RECEIVED_DT, ")
					/*End - Enhancement - Display security received date for no role search*/
					/*Start-Enhancement-Ability to view if user exist in security*/
					.append(" EXIST_IN_SECURITY, ")
					/*End-Enhancement-Ability to view if user exist in security*/
					.append(" ROLE_DESC.ROLE_NAME AS ROLE_NAME, ROLE_DESC.ROLE_ID AS ROLE_ID ")
					.append(" FROM ").append("dbo.tblUSER_PROFILE").append(" USER_PROFILE  LEFT OUTER JOIN ")
					.append("dbo.tblUSER_ROLE_MAPPING").append(" USER_ROLE_MAP ")
					.append(" ON USER_PROFILE.USER_LOGIN = USER_ROLE_MAP.USER_LOGIN LEFT OUTER JOIN ")
					.append("dbo.tblROLE_DESC").append(" ROLE_DESC ON ")
					.append(" USER_ROLE_MAP.ROLE_ID=ROLE_DESC.ROLE_ID")
					.append(" where 1=1 ").toString();

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		dataList = jdbcTemplate.queryForList(GET_USER_DETAIL_ADMIN);
		System.out.println(dataList);
		return dataList;
		}

}
