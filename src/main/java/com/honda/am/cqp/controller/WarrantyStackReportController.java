package com.honda.am.cqp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honda.am.cqp.dto.AlertDto;
import com.honda.am.cqp.dto.SupplierInfoDto;
import com.honda.am.cqp.dto.WarrantyReportsDto;
import com.honda.am.cqp.dto.WarrantyReportsDto2;
import com.honda.am.cqp.exception.ResourceNotFoundException;
import com.honda.am.cqp.model.TblCQ_SUPPLIER_INFO;
import com.honda.am.cqp.model.TblMESSAGE_CENTER;
import com.honda.am.cqp.model.TblOVERALL_REPL_SUMMARY;
import com.honda.am.cqp.service.AlertsService;

import com.honda.am.cqp.service.WarrantyStackReportService;

@RestController
@CrossOrigin
@RequestMapping("/api/warrantyReport")
public class WarrantyStackReportController {

	@Autowired
	private WarrantyStackReportService warrantyStackReportService;

	
	@GetMapping("/allSupplierNameNo")
	public List<SupplierInfoDto> getSupplierNoName() {
		
		return warrantyStackReportService.getSupplierNoName();
	}

	@GetMapping("/valuesBySupplier")
	public List<WarrantyReportsDto> getvaluesBySuppNo()
			throws ResourceNotFoundException {
		List<WarrantyReportsDto> tblOverallReplSummary = null;
		try {
			tblOverallReplSummary = warrantyStackReportService.getvaluesBySuppNo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tblOverallReplSummary;
	}

	
	/*@GetMapping("/valuesBySupplier/{id}")
	public ResponseEntity<TblCQ_SUPPLIER_INFO> getvaluesBySuppNo(@PathVariable(value = "suppNo") Long suppNo)
			throws ResourceNotFoundException {
		ResponseEntity<TblCQ_SUPPLIER_INFO> tblOverallReplSummary = warrantyStackReportService.getvaluesBySuppNo(suppNo);
		return tblOverallReplSummary;
	}*/

}