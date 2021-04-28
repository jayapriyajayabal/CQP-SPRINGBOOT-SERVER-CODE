/*package com.honda.am.cqp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.honda.am.cqp.Application;
import com.honda.am.cqp.model.Alert;
import com.honda.am.cqp.model.Employee;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlertControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllEmployees() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/alerts",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetEmployeeById() {
		Employee employee = restTemplate.getForObject(getRootUrl() + "/alerts/1", Employee.class);
		System.out.println(employee.getFirstName());
		assertNotNull(employee);
	}

	@Test
	public void testCreateEmployee() {
		Alert alert = new Alert();
		alert.setSupplier("admin@gmail.com");
		alert.setStatus("admin");
		alert.setAlert_test("admin");

		ResponseEntity<Employee> postResponse = restTemplate.postForEntity(getRootUrl() + "/alerts", alert, Employee.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateEmployee() {
		int id = 1;
		Alert alert = restTemplate.getForObject(getRootUrl() + "/alerts/" + id, Alert.class);
		alert.setSupplier("admin1");
		alert.setStatus("admin2");

		restTemplate.put(getRootUrl() + "/alerts/" + id, alert);

		Alert updatedAlert = restTemplate.getForObject(getRootUrl() + "/alerts/" + id, Alert.class);
		assertNotNull(updatedAlert);
	}

	@Test
	public void testDeleteEmployee() {
		int id = 2;
		Alert alert = restTemplate.getForObject(getRootUrl() + "/alerts/" + id, Alert.class);
		assertNotNull(alert);

		restTemplate.delete(getRootUrl() + "/alerts/" + id);

		try {
			alert = restTemplate.getForObject(getRootUrl() + "/alerts/" + id, Alert.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
*/