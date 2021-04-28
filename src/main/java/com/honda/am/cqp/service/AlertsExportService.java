/**
 * 
 */
package com.honda.am.cqp.service;

import java.util.List;

import com.honda.am.cqp.dto.CallInDto;
import com.honda.am.cqp.dto.UserDto;
import com.honda.am.cqp.dto.VoucherDto;
import com.honda.am.cqp.model.User;

/**
 * @author Shrirang Kadale
 *
 */
public interface AlertsExportService {
	
	public List<CallInDto> getCallInAlerts();
	
	public List<User> getUserAlerts();
	
	public List<VoucherDto> getVoucherAlerts();

}
