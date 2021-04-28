/**
 * 
 */
package com.honda.am.cqp.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.honda.am.cqp.dao.AlertsDao;
import com.honda.am.cqp.dto.ManageAlertsDTO;

/**
 * @author Shrirang Kadale
 *
 */

@Service
public class AlertsDaoImpl implements AlertsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Map getUserAlertsCount() throws SQLException {
		//Declare variables
		List dataList = null;
		Map resultMap = null;
		String prevAlertType = null;
		String alertType = null;
		
		ManageAlertsDTO manageAlertsDTO = null;

		CallableStatement cstmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			
			Connection connection = jdbcTemplate.getDataSource().getConnection();
			  CallableStatement callableStatement = connection.prepareCall("{call dbo.USP_ALERTS (?, ?)}");
			  callableStatement.setString(1, "FirstName");
			  callableStatement.setString(2, " LastName");
			  callableStatement.execute();
			  
			  rs = callableStatement.getResultSet();
			//Populate the data from resultset
			dataList = new ArrayList();
			resultMap = new HashMap();
			if(rs!=null){

				while(rs.next()){
					alertType = (rs.getString("ITEM_TYPE")).toUpperCase();
					if(prevAlertType!=null && !alertType.equals(prevAlertType)){
						resultMap.put(prevAlertType, dataList);
						dataList = new ArrayList();
					}
					
					manageAlertsDTO = new ManageAlertsDTO();
					manageAlertsDTO.setAlertType(alertType);
					manageAlertsDTO.setAlertText(rs.getString("ITEM_TEXT"));
					manageAlertsDTO.setSupplierNo(rs.getString("SUPP_NO"));
					manageAlertsDTO.setStatus(rs.getString("STATUS"));
					
					dataList.add(manageAlertsDTO);
					
					prevAlertType = alertType;
				}
				
				if(alertType!=null && resultMap.get(alertType)==null){
					resultMap.put(alertType, dataList);
				}
			}
		} finally {
			
		}
			
		//return the results
		return resultMap;


		
	}

}
