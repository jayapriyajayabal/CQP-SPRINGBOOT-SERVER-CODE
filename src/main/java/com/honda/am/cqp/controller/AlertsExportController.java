
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
import com.honda.am.cqp.dto.TPLDto;
import com.honda.am.cqp.dto.UserDto;
import com.honda.am.cqp.dto.VoucherCostDto;
import com.honda.am.cqp.dto.VoucherDto;
import com.honda.am.cqp.service.AlertsExportService;
import com.honda.am.cqp.util.CallInExcelExporterUtil;
import com.honda.am.cqp.util.TPLExcelExporterUtil;
import com.honda.am.cqp.util.UserExcelExporterUtil;
import com.honda.am.cqp.util.VoucherCostExcelExporterUtil;
import com.honda.am.cqp.util.VoucherExcelExporterUtil;

@RestController
@CrossOrigin
@RequestMapping("/api/alerts")
public class AlertsExportController {

	@Autowired
	private AlertsExportService alertsExportService;

	@GetMapping("/voucher/export/excel")
	public List<VoucherDto> exportVoucherToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=voucher_sheet.xls";
		response.setHeader(headerKey, headerValue);

		List<VoucherDto> list = alertsExportService.getVoucherDetails();
		System.out.println("UserDto ===== " + list.toString());

		VoucherExcelExporterUtil excelExporter = new VoucherExcelExporterUtil(list);
		excelExporter.export(response);

		return list;

	}

	@GetMapping("/user/export/excel")
	public List<UserDto> exportUserToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_sheet.xls";
		response.setHeader(headerKey, headerValue);

		List<UserDto> list = alertsExportService.getUserDetails();

		System.out.println("UserDto ===== " + list.toString());

		UserExcelExporterUtil excelExporter = new UserExcelExporterUtil(list);
		excelExporter.export(response);
		return list;
	}

	@GetMapping("/callin/export/excel")
	public List<CallInDto> exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_sheet.xls";
		response.setHeader(headerKey, headerValue);

		List<CallInDto> list = alertsExportService.getCallInDetails();

		System.out.println("callInDto ===== " + list);

		CallInExcelExporterUtil excelExporter = new CallInExcelExporterUtil(list);

		excelExporter.export(response);

		return list;
	}

	@GetMapping("/vouchercost/export/excel")
	public List<VoucherCostDto> exportVoucherCostToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_sheet.xls";
		response.setHeader(headerKey, headerValue);

		List<VoucherCostDto> list = alertsExportService.getVoucherCostAlerts();

		System.out.println("callInDto ===== " + list);

		VoucherCostExcelExporterUtil excelExporter = new VoucherCostExcelExporterUtil(list);

		excelExporter.export(response);

		return list;
	}

	@GetMapping("/tpl/export/excel")
	public void exportTplToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_sheet.xls";
		response.setHeader(headerKey, headerValue);

		List<TPLDto> list = alertsExportService.getTPLAlerts();

		System.out.println("UserDto ===== " + list);

		TPLExcelExporterUtil excelExporter = new TPLExcelExporterUtil(list);

		excelExporter.export(response);
	}

}
