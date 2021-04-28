
package com.honda.am.cqp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honda.am.cqp.model.User;
import com.honda.am.cqp.repository.UserRepository;

@Service
public class AlertsExportService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUserDetails() {
		 List<User> user =  userRepository.getUserAlerts();
	        return user;
		
	}
}
