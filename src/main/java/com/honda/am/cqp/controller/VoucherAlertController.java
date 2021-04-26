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

import com.honda.am.cqp.dto.UserDto;
import com.honda.am.cqp.service.UserAlertService;
import com.honda.am.cqp.util.UserExcelExporterUtil;

/**
 * @author Shrirang Kadale
 *
 */


@RestController
@CrossOrigin
@RequestMapping("/api/alerts")
public class VoucherAlertController {
	@Autowired
	private UserAlertService userAlertService;

	@GetMapping("/voucher/export/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=alerts_sheet.xls";
		response.setHeader(headerKey, headerValue);

		List<UserDto> list = userAlertService.getUserAlerts();

		UserExcelExporterUtil excelExporter = new UserExcelExporterUtil(list);

		excelExporter.export(response);
	}
}
