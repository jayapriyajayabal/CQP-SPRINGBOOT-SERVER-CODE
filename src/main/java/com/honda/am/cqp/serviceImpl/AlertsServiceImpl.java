/**
 * 
 */
package com.honda.am.cqp.serviceImpl;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honda.am.cqp.dao.AlertsDao;
import com.honda.am.cqp.service.AlertsService;

/**
 * @author Shrirang Kadale
 *
 */

@Service
public class AlertsServiceImpl implements AlertsService  {
	
	@Autowired
	private AlertsDao alertsDao;
	
	@Override
	public Map getUserAlertsCount() throws SQLException {
		
		return alertsDao.getUserAlertsCount();
	}

}
