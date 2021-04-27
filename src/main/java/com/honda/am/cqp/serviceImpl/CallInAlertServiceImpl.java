/**
 * 
 */
package com.honda.am.cqp.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honda.am.cqp.dao.CallInAlertDao;
import com.honda.am.cqp.dto.CallInDto;
import com.honda.am.cqp.service.CallInAlertService;

/**
 * @author Shrirang Kadale
 *
 */

@Service
public class CallInAlertServiceImpl implements CallInAlertService {
	
	@Autowired
	private CallInAlertDao callInAlertDao;

	@Override
	public List<CallInDto> getCallInAlerts() {

		List<Map<String, Object>> dataList = callInAlertDao.getCallInAlerts();
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
