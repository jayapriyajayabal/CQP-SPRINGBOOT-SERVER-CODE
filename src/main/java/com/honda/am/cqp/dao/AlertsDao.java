/**
 * 
 */
package com.honda.am.cqp.dao;

import java.sql.SQLException;
import java.util.Map;

/**
 * @author Shrirang Kadale
 *
 */
public interface AlertsDao {
	
	public Map getUserAlertsCount() throws SQLException;

}
