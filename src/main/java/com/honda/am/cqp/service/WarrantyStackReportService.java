
package com.honda.am.cqp.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.LinkedHashSet;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.honda.am.cqp.dto.CallInDto;
import com.honda.am.cqp.dto.SupplierInfoDto;
import com.honda.am.cqp.dto.TPLDto;
import com.honda.am.cqp.dto.UserDto;
import com.honda.am.cqp.dto.VoucherCostDto;
import com.honda.am.cqp.dto.VoucherDto;
import com.honda.am.cqp.dto.WarrantyReportsDto;
import com.honda.am.cqp.dto.WarrantyReportsDto2;
import com.honda.am.cqp.exception.ResourceNotFoundException;
import com.honda.am.cqp.model.TblCQ_SUPPLIER_INFO;
import com.honda.am.cqp.model.TblOVERALL_REPL_SUMMARY;
import com.honda.am.cqp.repository.CallInRepository;
import com.honda.am.cqp.repository.TplRepository;
import com.honda.am.cqp.repository.UserRepository;
import com.honda.am.cqp.repository.VoucherCostRepository;
import com.honda.am.cqp.repository.VoucherRepository;
import com.honda.am.cqp.repository.WarrantyStackReportRepository;

@Service
public class WarrantyStackReportService {

	@Autowired
	private WarrantyStackReportRepository warantyStackReportRepository;
	private Object value;

	/*
	 * public List<TblCQ_SUPPLIER_INFO> getAllValues() { //return
	 * warantyStackReportRepository.findAll(); }
	 */

	public List<SupplierInfoDto> getSupplierNoName() {
		List<Object[]> tblcqSupplierInfo = warantyStackReportRepository.getSupplierNameNo();
		List<SupplierInfoDto> supplierInfoDtoList = new ArrayList<SupplierInfoDto>();

		for (Object[] dto : tblcqSupplierInfo) {
			;

			SupplierInfoDto supplierInfoDTO = new SupplierInfoDto();
			supplierInfoDTO.setSupplierNameNo((String) dto[0]);
			supplierInfoDTO.setSuppNo((String) dto[1]);

			supplierInfoDtoList.add(supplierInfoDTO);

		}

		return supplierInfoDtoList;
	}

	public List<WarrantyReportsDto> getvaluesBySuppNo() throws Exception {
		List<Object[]> tblOverallReplSummary = warantyStackReportRepository.getReportValuesBySupplier();
		ArrayList<WarrantyReportsDto> warrantyInfoDtoList = new ArrayList<WarrantyReportsDto>();
		List<WarrantyReportsDto> newWarrantyList = new ArrayList<WarrantyReportsDto>();
		List<Integer> dataodsy1 = new ArrayList<Integer>();
		List<Integer> hmapssport1 = new ArrayList<Integer>();
		List<Integer> dataodsy2 = new ArrayList<Integer>();
		List<Integer> hmapssport2 = new ArrayList<Integer>();

		WarrantyReportsDto warrantyReportsDTO = new WarrantyReportsDto();

		for (Object[] dto : tblOverallReplSummary) {
			String[] ShortPartNo = ((String) dto[1]).split("_", 0);
			if (dto[7].equals("HMA ODYSSEY")) {

				if (ShortPartNo[1].equals("KA")) {
					warrantyReportsDTO = new WarrantyReportsDto();
					dataodsy1.add((Integer) dto[5]);
					warrantyReportsDTO.setPart("KA");
					warrantyReportsDTO.setCheck("ody_kA");
					warrantyReportsDTO.setData(dataodsy1);
					warrantyReportsDTO.setModelfactory((String) dto[7]);
					warrantyInfoDtoList.add(warrantyReportsDTO);
					newWarrantyList = removeDuplicates(warrantyInfoDtoList);
				} else {

					warrantyReportsDTO = new WarrantyReportsDto();
					dataodsy2.add((Integer) dto[5]);
					warrantyReportsDTO.setCheck("ody_kC");
					warrantyReportsDTO.setPart("KC");
					warrantyReportsDTO.setData(dataodsy2);
					warrantyReportsDTO.setModelfactory((String) dto[7]);
					warrantyInfoDtoList.add(warrantyReportsDTO);
					newWarrantyList = removeDuplicates(warrantyInfoDtoList);
				}
			} else if (dto[7].equals("HMA PASSPORT")) {
				if (ShortPartNo[1].equals("KA")) {
					warrantyReportsDTO = new WarrantyReportsDto();
					hmapssport1.add((Integer) dto[5]);
					warrantyReportsDTO.setCheck("pass_kA");
					warrantyReportsDTO.setData(hmapssport1);
					warrantyReportsDTO.setModelfactory((String) dto[7]);
					warrantyInfoDtoList.add(warrantyReportsDTO);
					newWarrantyList = removeDuplicates(warrantyInfoDtoList);
				} else {
					warrantyReportsDTO = new WarrantyReportsDto();
					hmapssport2.add((Integer) dto[5]);
					warrantyReportsDTO.setPart("KC");
					warrantyReportsDTO.setCheck("pass_kC");
					warrantyReportsDTO.setData(hmapssport2);
					warrantyReportsDTO.setModelfactory((String) dto[7]);
					warrantyInfoDtoList.add(warrantyReportsDTO);
					newWarrantyList = removeDuplicates(warrantyInfoDtoList);
				}

			}
		}
		return newWarrantyList;

	}

	public static <T> List<WarrantyReportsDto> removeDuplicates(ArrayList<WarrantyReportsDto> list) {
		Set deptSet = new HashSet<>();
		for (WarrantyReportsDto employee : list) {
			System.out.println(employee.getModelfactory());
		}
		list.removeIf(p -> !deptSet.add(p.getCheck()));

		list.forEach(dept -> System.out.println(dept.getModelfactory()));
		return list;
	}

}
