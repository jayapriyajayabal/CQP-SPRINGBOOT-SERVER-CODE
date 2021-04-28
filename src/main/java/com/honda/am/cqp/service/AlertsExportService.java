
package com.honda.am.cqp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honda.am.cqp.model.TblUSER_PROFILE;
import com.honda.am.cqp.model.TblVOUCHER_SUMMARY;
import com.honda.am.cqp.repository.UserRepository;
import com.honda.am.cqp.repository.VoucherRepository;

@Service
public class AlertsExportService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VoucherRepository voucherRepository;

	public List<TblUSER_PROFILE> getUserDetails() {
		List<TblUSER_PROFILE> user = userRepository.getUserAlerts();
		return user;

	}
	
	public List<TblVOUCHER_SUMMARY> getVoucherDetails() {
		List<TblVOUCHER_SUMMARY> user = voucherRepository.getVoucherAlerts();
		return user;

	}
}
