/**
 * 
 */
package com.honda.am.cqp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honda.am.cqp.dto.CallInDto;
import com.honda.am.cqp.service.CallInAlertService;
import com.honda.am.cqp.util.CallInExcelExporterUtil;

/**
 * @author Shrirang Kadale
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/api/alerts")
public class CallInAlertController {
	
	@Autowired
	private CallInAlertService callInAlertService;
	
	@GetMapping("/callin")
	public List<CallInDto> getUserAlerts(HttpServletResponse response) throws IOException {
		return callInAlertService.getCallInAlerts();
	}

	@GetMapping("/callin/export/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_sheet.xls";
		response.setHeader(headerKey, headerValue);

		List<CallInDto> list = callInAlertService.getCallInAlerts();
		
		System.out.println("callInDto ===== " + list);

		CallInExcelExporterUtil excelExporter = new CallInExcelExporterUtil(list);

		excelExporter.export(response);
		
		
	}
}
