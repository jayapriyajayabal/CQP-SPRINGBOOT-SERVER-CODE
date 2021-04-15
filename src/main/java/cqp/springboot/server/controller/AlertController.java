package cqp.springboot.server.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cqp.springboot.server.exception.ResourceNotFoundException;
import cqp.springboot.server.model.Alert;
import cqp.springboot.server.repository.AlertRepository;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class AlertController {
	@Autowired
	private AlertRepository alertRepository;
	
	private static final Logger log = LoggerFactory.getLogger(AlertController.class);
	
	@GetMapping("/alerts")
	public List<Alert> getAllAlerts() {
		log.info("fetching list of alerts data...");
		List<Alert> findAll = alertRepository.findAll();
	    log.info("[FIND_ALL] {}", findAll);
		return findAll;
		
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
	
	 @GetMapping("/alerts/export/excel")
	    public void exportToExcel(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=alerts_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Alert> findAll = alertRepository.findAll();
	         
	        UserExcelExporter excelExporter = new UserExcelExporter(findAll);
	         
	        excelExporter.export(response);    
	    }  
}
