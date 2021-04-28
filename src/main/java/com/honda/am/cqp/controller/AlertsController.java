/**
 * 
 *//*
package com.honda.am.cqp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honda.am.cqp.service.AlertsService;

*//**
 * @author Shrirang Kadale
 *
 *//*

@RestController
@CrossOrigin
@RequestMapping("/api/alerts")
public class AlertsController {
	
	@Autowired
	private AlertsService alertsService;
	
	//@GetMapping("/users")
	//public Map getUserAlerts(HttpServletResponse response) throws IOException, SQLException {
		Map map = alertsService.getUserAlertsCount();
		System.out.println(map.get("USER").toString());
		//return alertsService.getUserAlertsCount();
	}

}
*/