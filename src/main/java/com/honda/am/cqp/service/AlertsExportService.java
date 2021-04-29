
package com.honda.am.cqp.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honda.am.cqp.dto.UserDto;
import com.honda.am.cqp.model.TblVOUCHER_SUMMARY;
import com.honda.am.cqp.repository.UserRepository;
import com.honda.am.cqp.repository.VoucherRepository;

@Service
public class AlertsExportService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VoucherRepository voucherRepository;

	public List<UserDto> getUserDetails() {
		try {
			List<Object[]> user = userRepository.getUserAlerts();
			
			List<UserDto> list = new ArrayList<>();
			
			for(Object[] dto : user) {
				
				UserDto userDto = new UserDto();
				userDto.setUserLogin((String) dto[0]);
				userDto.setUserType((String) dto[1]);
				userDto.setUserFirstName((String) dto[2]);
				userDto.setUserLastName((String) dto[3]);
				userDto.setSuppNo((String) dto[4]);
				userDto.setUserLastLogin((Timestamp) dto[5]);
				
				list.add(userDto);
				
			}

			return list;
		} finally {
			System.err.println("I am happy");
		}
	}


	public List<TblVOUCHER_SUMMARY> getVoucherDetails() {
		List<TblVOUCHER_SUMMARY> user = voucherRepository.getVoucherAlerts();
		return user;

	}
}
