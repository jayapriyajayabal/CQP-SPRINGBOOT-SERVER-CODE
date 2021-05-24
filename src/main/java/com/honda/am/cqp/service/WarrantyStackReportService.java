
package com.honda.am.cqp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honda.am.cqp.dto.SupplierInfoDto;
import com.honda.am.cqp.dto.WarrantyReportsDto;
import com.honda.am.cqp.repository.WarrantyStackReportRepository;

@Service
public class WarrantyStackReportService {

	@Autowired
	private WarrantyStackReportRepository warantyStackReportRepository;
	

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

	public List<WarrantyReportsDto> getvaluesBySuppNo(String supplierNo) throws Exception {
		List<Object[]> tblOverallReplSummary = warantyStackReportRepository.getReportValuesBySupplier(supplierNo);
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
