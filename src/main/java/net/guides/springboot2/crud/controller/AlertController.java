package net.guides.springboot2.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.model.Alert;
import net.guides.springboot2.crud.model.Employee;
import net.guides.springboot2.crud.repository.AlertRepository;
import net.guides.springboot2.crud.repository.EmployeeRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AlertController {
	@Autowired
	private AlertRepository alertRepository;

	@GetMapping("/alerts")
	public List<Alert> getAllAlerts() {
		return alertRepository.findAll();
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
				.orElseThrow(() -> new ResourceNotFoundException("Alert not found for this id :: " + alertId));

		alertRepository.delete(alert);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
