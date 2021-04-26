/**
 * 
 */
package com.honda.am.cqp.dao;

import java.util.List;
import java.util.Map;

import com.honda.am.cqp.dto.VoucherDto;

/**
 * @author Shrirang Kadale
 *
 */
public interface VoucherAlertDao {

	List<Map<String, Object>> getVoucherAlerts();

}
