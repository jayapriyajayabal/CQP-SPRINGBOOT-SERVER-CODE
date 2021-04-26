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

import com.honda.am.cqp.dto.VoucherDto;
import com.honda.am.cqp.service.VoucherAlertService;
import com.honda.am.cqp.util.VoucherExcelExporterUtil;

/**
 * @author Shrirang Kadale
 *
 */


@RestController
@CrossOrigin
@RequestMapping("/api/alerts")
public class VoucherAlertController {
	@Autowired
	private VoucherAlertService voucherAlertService;
	
	@GetMapping("/voucher")
	public List<VoucherDto> getVouchers(HttpServletResponse response) throws IOException {
		return voucherAlertService.getVoucherAlerts();
	}

	@GetMapping("/voucher/export/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=voucher_sheet.xls";
		response.setHeader(headerKey, headerValue);

		List<VoucherDto> list = voucherAlertService.getVoucherAlerts();

		VoucherExcelExporterUtil excelExporter = new VoucherExcelExporterUtil(list);

		excelExporter.export(response);
	}
}
