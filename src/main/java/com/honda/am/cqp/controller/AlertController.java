package com.honda.am.cqp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honda.am.cqp.exception.ResourceNotFoundException;
import com.honda.am.cqp.model.Alert;
import com.honda.am.cqp.repository.AlertRepository;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class AlertController {
	@Autowired
	private AlertRepository alertRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	private static final Logger log = LoggerFactory.getLogger(AlertController.class);
	
	@GetMapping("/alerts")
	public List<Map<String, Object>> getAllAlerts() {
		
		final String GET_CURR_VCHR_SUMMARY =
				"SELECT "
					+ "T1.VOUCHER_NO,"
					+ "T1.SUPP_NO,T1.QTR_NO,T1.QTR_YEAR,T1.SUPP_NAME,T1.STATUS_ID,T1.VOUCHER_DESC,"
					+ "T1.ISSUE_DATE,T1.DUE_DATE,T1.SUB_TOTAL_AMT,T1.TOTAL_ADDL_SHIPPING_CHARGES_AMT,"
					+ "T1.TOTAL_SUPPLIER_RESPONSIBILITY_PCT,T1.SUPPLIER_RESP_ADDL_SHIPPING_CHARGES_AMT,"
					+ "T1.OVERALL_ADJUSTMENT_AMT,T1.DIAGNOSTIC_ADJUSTMENT_AMT,T1.TOTAL_AMT,"
					+ "T1.TOTAL_MARKET_CLAIM,T1.SUB_TOTAL_AMT,T1.CALC_SHIPPING_RESP_PCT,"
					+ "SUPPLIER_RESP_ADDL_SHIPPING_CHARGES_AMT ,T1.TOTAL_SUPPLIER_CHARGE_AMT,"
					+ "T2.STATUS_NAME,T1.TOTAL_SUPPLIER_RESP_SUB_TOTAL_AMT"
					/*Start - Ability to enter overall adjustments data by individual plants*/
					+ ", T1.PLANT_OVERALL_ADJ_FLAG "
					/*End - Ability to enter overall adjustments data by individual plants*/
					+ " FROM "
					+ " dbo "
					+ ".tblVOUCHER_SUMMARY T1 (NOLOCK) ,"
					+ " dbo "
					+ ".tblSTATUS T2 (NOLOCK)"
					+ " WHERE "
					+ " T1.SUPP_NO= 011620 AND T1.STATUS_ID = T2.STATUS_ID";
		
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		
		dataList = jdbcTemplate.queryForList(
						GET_CURR_VCHR_SUMMARY);
		System.out.println(dataList);
		
/*		log.info("fetching list of alerts data...");
		List<Alert> findAll = alertRepository.findAll();
	    log.info("[FIND_ALL] {}", findAll);*/
		return dataList;
		
	}

	@GetMapping("/alerts/{id}")
	public ResponseEntity<Alert> getEmployeeById(@PathVariable(value = "id") Long alertId)
			throws ResourceNotFoundException {
		Alert alert = alertRepository.findById(alertId)
				.orElseThrow(() -> new ResourceNotFoundException("alertId not found for this id :: " + alertId));
		return ResponseEntity.ok().body(alert);
	}

	@PostMapping("/alerts")
	public Alert createAlert(@Valid @RequestBody Alert alert) {
		return alertRepository.save(alert);
	}

	/*@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}*/

	@DeleteMapping("/alerts/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long alertId)
			throws ResourceNotFoundException {
		Alert alert = alertRepository.findById(alertId)
				.orElseThrow(() -> new ResourceNotFoundException("you don't have permission to delete this alert : " + alertId));

		alertRepository.delete(alert);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
 
}
