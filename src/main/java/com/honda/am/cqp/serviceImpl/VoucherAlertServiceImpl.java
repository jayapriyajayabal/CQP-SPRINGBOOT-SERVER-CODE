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
			
			 VoucherDto voucherDto = new VoucherDto();
			  
			 voucherDto.setSupplierNumber((String) dataList.get(i).get("SUPP_NO"));
			 voucherDto.setSupplierName((String) dataList.get(i).get("SUPP_NAME"));
			 voucherDto.setStatus((String) dataList.get(i).get("STATUS_NAME"));
			  
			  list.add(voucherDto);
			 
		}
		return list;

	}

}
