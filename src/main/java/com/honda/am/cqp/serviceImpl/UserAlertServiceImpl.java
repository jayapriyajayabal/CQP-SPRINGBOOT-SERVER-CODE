/**
 * 
 */
package com.honda.am.cqp.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.honda.am.cqp.dao.UserAlertDao;
import com.honda.am.cqp.dto.UserDto;
import com.honda.am.cqp.service.UserAlertService;

/**
 * @author Shrirang Kadale
 *
 */
public class UserAlertServiceImpl implements UserAlertService {

	@Autowired
	private UserAlertDao userAlertDao;

	@Override
	public List<UserDto> getUserAlerts() {

		List<Map<String, Object>> dataList = userAlertDao.getUserAlerts();
		System.out.println(dataList);

		List<UserDto> list = new ArrayList<>();
		for (int i = 0; i < dataList.size(); i++) {

			UserDto userDto = new UserDto();

			userDto.setUserLogin(dataList.get(i).get("USER_LOGIN").toString());
			userDto.setUserType(dataList.get(i).get("USER_TYPE").toString());
			userDto.setFirstName(dataList.get(i).get("USER_FIRST_NAME").toString());
			userDto.setLastName(dataList.get(i).get("USER_LAST_NAME").toString());
			// userDto.setUserLogin(dataList.get(i).get("USER_SUPP_NO").toString());

			list.add(userDto);
		}
		return list;

	}
}
