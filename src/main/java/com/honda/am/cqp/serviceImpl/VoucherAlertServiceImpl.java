/**
 * 
 */
package com.honda.am.cqp.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honda.am.cqp.dao.VoucherAlertDao;
import com.honda.am.cqp.dto.VoucherDto;
import com.honda.am.cqp.service.VoucherAlertService;

/**
 * @author Shrirang Kadale
 *
 */

@Service
public class VoucherAlertServiceImpl implements VoucherAlertService {

	@Autowired
	private VoucherAlertDao voucherAlertDao;

	@Override
	public List<VoucherDto> getVoucherAlerts() {

		List<Map<String, Object>> dataList = voucherAlertDao.getVoucherAlerts();
		System.out.println(dataList);

		List<VoucherDto> list = new ArrayList<>();
		for (int i = 0; i < dataList.size(); i++) {
			// TODO : VoucherDto
			/*
			 * UserDto userDto = new UserDto();
			 * 
			 * userDto.setUserLogin(dataList.get(i).get("USER_LOGIN").toString());
			 * userDto.setUserType(dataList.get(i).get("USER_TYPE").toString());
			 * userDto.setFirstName(dataList.get(i).get("USER_FIRST_NAME").toString());
			 * userDto.setLastName(dataList.get(i).get("USER_LAST_NAME").toString()); //
			 * userDto.setUserLogin(dataList.get(i).get("USER_SUPP_NO").toString());
			 * 
			 * list.add(userDto);
			 */
		}
		return list;

	}

}
