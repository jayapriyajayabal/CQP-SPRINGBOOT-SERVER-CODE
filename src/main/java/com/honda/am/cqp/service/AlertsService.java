/**
 * 
 */
package com.honda.am.cqp.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honda.am.cqp.model.TblMESSAGE_CENTER;
import com.honda.am.cqp.repository.MessageCenterRepository;

/**
 * @author Shrirang Kadale
 *
 */
@Service
public class AlertsService {

	@Autowired
	private MessageCenterRepository messageRepository;

	public List<TblMESSAGE_CENTER> getMessage() {
		try {
			List<Object[]> inbox = messageRepository.getMessage();

			List<TblMESSAGE_CENTER> list = new ArrayList<>();

			for (Object[] dto : inbox) {
				TblMESSAGE_CENTER msg = new TblMESSAGE_CENTER();
				msg.setMessageId((int) dto[0]);
				msg.setMessage((String) dto[1]);
				msg.setCreatedBy((String) dto[2]);
				msg.setCreatedTs((Timestamp) dto[3]);
				msg.setUserType((char) dto[4]);
				msg.setSuppNo((String) dto[5]);
				msg.setExpiryDate((Timestamp) dto[6]);

				list.add(msg);
			}
			return list;
		} finally {
			// TODO: handle finally clause
		}
	}

}
