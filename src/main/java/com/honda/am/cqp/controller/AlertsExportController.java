/**
 * 
 */
package com.honda.am.cqp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honda.am.cqp.dto.UserDto;
import com.honda.am.cqp.model.TblUSER_PROFILE;
import com.honda.am.cqp.model.TblVOUCHER_SUMMARY;
import com.honda.am.cqp.service.AlertsExportService;

/**
 * @author Shrirang Kadale
 *
 */


@RestController
@CrossOrigin
@RequestMapping("/api/alerts")
public class AlertsExportController {
	
	@Autowired
	private AlertsExportService alertsExportService;

	@GetMapping("/voucher/export/excel")
	public void exportVoucherToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=voucher_sheet.xls";
		response.setHeader(headerKey, headerValue);

		List<TblVOUCHER_SUMMARY> list = alertsExportService.getVoucherDetails();

	//	VoucherExcelExporterUtil excelExporter = new VoucherExcelExporterUtil(list);

	//	excelExporter.export(response);
	}
	
	@GetMapping("/user/export/excel")
	public List<UserDto> exportUserToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_sheet.xls";
		response.setHeader(headerKey, headerValue);

		List<UserDto> list = alertsExportService.getUserDetails();
		
		System.out.println("UserDto ===== " + list.toString());
		
		return list;

		//return list;
		//UserExcelExporterUtil excelExporter = new UserExcelExporterUtil(list);

		//excelExporter.export(response);
	}
	
/*	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_sheet.xls";
		response.setHeader(headerKey, headerValue);

		List<CallInDto> list = alertsExportService.getCallInAlerts();
		
		System.out.println("callInDto ===== " + list);

		CallInExcelExporterUtil excelExporter = new CallInExcelExporterUtil(list);

		excelExporter.export(response);
		
		
	}*/
}
