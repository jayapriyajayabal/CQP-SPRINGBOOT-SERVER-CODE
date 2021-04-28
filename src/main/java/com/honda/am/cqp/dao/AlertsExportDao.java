/**
 * 
 */
package com.honda.am.cqp.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Shrirang Kadale
 *
 */
public interface AlertsExportDao {

	List<Map<String, Object>> getVoucherAlerts();
	
	public List<Map<String, Object>> getCallInAlerts();
	
	public List<Map<String, Object>> getUserAlerts();
}
