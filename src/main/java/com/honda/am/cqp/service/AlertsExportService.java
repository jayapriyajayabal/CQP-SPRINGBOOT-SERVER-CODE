
package com.honda.am.cqp.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honda.am.cqp.dto.UserDto;
import com.honda.am.cqp.dto.VoucherDto;
import com.honda.am.cqp.repository.CallInRepository;
import com.honda.am.cqp.repository.UserRepository;
import com.honda.am.cqp.repository.VoucherRepository;

@Service
public class AlertsExportService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VoucherRepository voucherRepository;
	
	@Autowired
	private CallInRepository callInRepository;

	public List<UserDto> getUserDetails() {
			List<Object[]> user = userRepository.getUserAlerts();

			List<UserDto> list = new ArrayList<>();

			for (Object[] dto : user) {

				UserDto userDto = new UserDto();
				userDto.setUserLogin((String) dto[0]);
				userDto.setUserType((String) dto[1]);
				userDto.setUserFirstName((String) dto[2]);
				userDto.setUserLastName((String) dto[3]);
				userDto.setSuppNo((String) dto[4]);
				userDto.setUserLastLogin((Timestamp) dto[5]);
				//userDto.setUserLastLogin(dto[5]);

				list.add(userDto);

			}

			return list;
	}

	public List<VoucherDto> getVoucherDetails() {
		try {
			List<Object[]> voucher = voucherRepository.getVoucherAlerts();
			
			List<VoucherDto> list = new ArrayList<>();
			
			for (Object[] dto : voucher) {
				VoucherDto voucherDto = new VoucherDto();
				voucherDto.setVoucherNo((String) dto[0]);
				voucherDto.setSuppNo((String) dto[1]);
				voucherDto.setQtrNo((String) dto[2]);
				voucherDto.setQtrYear((String) dto[3]);
				voucherDto.setSuppName((String) dto[4]);
				voucherDto.setStatusId((int) dto[5]);
				voucherDto.setVoucherDesc((String) dto[6]);
				voucherDto.setIssueDate((Timestamp) dto[7]);
				voucherDto.setDueDate((Timestamp) dto[8]);
				voucherDto.setSubTotalAmt((BigDecimal) dto[9]);
				voucherDto.setTotalAddlShippingChargesAmt((BigDecimal) dto[10]);
				voucherDto.setTotalSupplierResponsibilityPct((BigDecimal) dto[11]);
				voucherDto.setSupplierRespAddlShippingChargesAmt((BigDecimal) dto[12]);
				voucherDto.setOverallAdjustmentAmt((BigDecimal) dto[13]);
				voucherDto.setDiagnosticAdjustmentAmt((BigDecimal) dto[14]);
				voucherDto.setTotalAmt((BigDecimal) dto[15]);
				voucherDto.setTotalMarketClaim((BigDecimal) dto[16]);
				voucherDto.setCalcShippingRespPct((BigDecimal) dto[17]);
				voucherDto.setTotalSupplierChargeAmt((BigDecimal) dto[18]);
				voucherDto.setStatusName((String) dto[19]);
				voucherDto.setTotalSupplierRespSubTotalAmt((BigDecimal) dto[20]);
				voucherDto.setPlantOverallAdjFlag((String) dto[21]);
				
				list.add(voucherDto);
			}
			return list;
		}finally {
			System.err.println("I am happy");
		}

	}
	
	public List<Object[]> getCallInDetails() {
		List<Object[]> user = callInRepository.getCallInAlerts();

		List<UserDto> list = new ArrayList<>();

/*		for (Object[] dto : user) {

			UserDto userDto = new UserDto();
			userDto.setUserLogin((String) dto[0]);
			userDto.setUserType((String) dto[1]);
			userDto.setUserFirstName((String) dto[2]);
			userDto.setUserLastName((String) dto[3]);
			userDto.setSuppNo((String) dto[4]);
			userDto.setUserLastLogin((Timestamp) dto[5]);
			//userDto.setUserLastLogin(dto[5]);

			list.add(userDto);

		}*/

		return user;
}
	public List<Object[]> getVoucherCostAlerts(){
		List<Object[]> voucher =voucherRepository.getVoucherAlerts();
		return voucher;
	}
}
