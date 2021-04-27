/**
 * 
 */
package com.honda.am.cqp.service;

import java.util.List;

import com.honda.am.cqp.dto.UserDto;

/**
 * @author Shrirang Kadale
 *
 */
public interface UserAlertService {

	public List<UserDto> getUserAlerts();

	public Integer getUserAlertsCount();

}
