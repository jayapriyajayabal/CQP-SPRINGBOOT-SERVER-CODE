/**
 * 
 */
package com.honda.am.cqp.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honda.am.cqp.dao.AlertsExportDao;
import com.honda.am.cqp.dto.CallInDto;
import com.honda.am.cqp.dto.UserDto;
import com.honda.am.cqp.dto.VoucherDto;
import com.honda.am.cqp.model.User;
import com.honda.am.cqp.repository.UserRepository;
import com.honda.am.cqp.service.AlertsExportService;

/**
 * @author Shrirang Kadale
 *
 */

@Service
public class AlertsExportServiceImpl implements AlertsExportService {

	@Autowired
	private AlertsExportDao alertsExportDao;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<VoucherDto> getVoucherAlerts() {

		List<Map<String, Object>> dataList = alertsExportDao.getVoucherAlerts();
		
		
		
		System.out.println(dataList);

		List<VoucherDto> list = new ArrayList<>();
		for (int i = 0; i < dataList.size(); i++) {
			// TODO : VoucherDto
			
			 VoucherDto voucherDto = new VoucherDto();
			  
			 voucherDto.setSupplierNumber((String) dataList.get(i).get("SUPP_NO"));
			 voucherDto.setSupplierDesc((String) dataList.get(i).get("VOUCHER_DESC"));
			 voucherDto.setStatus((String) dataList.get(i).get("STATUS_NAME"));
			  
			  list.add(voucherDto);
			 
		}
		return list;

	}
	
	
	
	@Override
	public List<User> getUserAlerts() {
		
		List<User> list = userRepository.getUserAlerts();
		
		return list;

		/*List<Map<String, Object>> dataList = alertsExportDao.getUserAlerts();
		System.out.println(dataList);

		List<UserDto> list = new ArrayList<>();
		for (int i = 0; i < dataList.size(); i++) {

			UserDto userDto = new UserDto();
*/
			/*userDto.setUserLogin(dataList.get(i).get("USER_LOGIN").toString());
			userDto.setUserType(dataList.get(i).get("USER_TYPE").toString());
			userDto.setFirstName(dataList.get(i).get("USER_FIRST_NAME").toString());
			userDto.setLastName(dataList.get(i).get("USER_LAST_NAME").toString());
			// userDto.setUserLogin(dataList.get(i).get("USER_SUPP_NO").toString());

			list.add(userDto);
		}
		return list;*/

	}
	@Override
	public List<CallInDto> getCallInAlerts() {

		List<Map<String, Object>> dataList = alertsExportDao.getCallInAlerts();
		System.out.println(dataList);

		List<CallInDto> list = new ArrayList<>();
		for (int i = 0; i < dataList.size(); i++) {

			CallInDto callInDto = new CallInDto();

			callInDto.setSupplierNumber(dataList.get(i).get("SUPP_NO").toString());
			callInDto.setSupplierName(dataList.get(i).get("SUPP_NAME").toString());
			callInDto.setStatus(dataList.get(i).get("STATUS_NAME").toString());

			list.add(callInDto);
		}
		return list;

	}


}
