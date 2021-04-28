/**
 * 
 */
package com.honda.am.cqp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.honda.am.cqp.Interface.IAlertsService;

import com.honda.am.cqp.model.User;
import com.honda.am.cqp.repository.UserRepository;



/**
 * @author Shrirang Kadale
 *
 */
@Service
public class AlertsService implements IAlertsService {
	
	@Autowired
	private UserRepository userRepository;
	
	 @Override
	public List<User> getUserDetails() {
		 List<User> user =  userRepository.getUserAlerts();
	        return user;
		
	}
}
