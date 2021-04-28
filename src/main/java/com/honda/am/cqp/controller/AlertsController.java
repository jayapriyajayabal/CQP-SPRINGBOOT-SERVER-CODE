/**
 * 
 */
package com.honda.am.cqp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honda.am.cqp.model.User;
import com.honda.am.cqp.service.AlertsService;



/**
 * @author Shrirang Kadale
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/api/alerts")
public class AlertsController {
	
	@Autowired
	private AlertsService alertsService;
	
	 
	 @GetMapping("/alerts")
		public List<User> getAllgetUserDetails() {
			//log.info("fetching list of alerts data...");
			List<User> user = alertsService.getUserDetails();
		   // log.info("[FIND_ALL] {}", findAll);
			return user;
			
		}
	 
	 @GetMapping("/user")
	    public List<User> findCitiesNameEndsWith(Model model) {

	        List<User> user = (List<User>) alertsService.getUserDetails();

	        model.addAttribute("user", user);

	        return user;
	    }
	
	@GetMapping("/tpl")
	public List<Map<String, Object>> getTPLAlerts() {
		return null;
       /* final String SELECT_TPL_ALERTS_DTLS_SUPPLIER =
		         "SELECT TPL_ITM_DTL.TRANSFER_PART_LIST_ITEM_DETAIL_SK, "
			    + " TPL_DTL.SUPP_NO, SUPP.SUPP_NAME SUPPLIER, STS.STATUS_NAME "
			    + " FROM TPL_DETAIL_TABLE AS  TPL_DTL "
			    + " INNER JOIN TPL_ITEM_DETAIL_TABLE AS TPL_ITM_DTL "
			    + " ON TPL_DTL.TRANSFER_PART_LIST_DETAIL_SK = TPL_ITM_DTL.TRANSFER_PART_LIST_DETAIL_SK "	
			    + " INNER JOIN STATUS_TABLE"
			    + " STS ON TPL_ITM_DTL.STATUS_ID = STS.STATUS_ID "
			    + " INNER JOIN SUPPLIER_TABLE"
			    + " SUPP ON TPL_DTL.SUPP_NO = SUPP.SUPP_NO "
			     + " WHERE STS.STATUS_TYPE = 'TPL' AND "
			+" STS.STATUS_NAME IN ('NEW','ACTIVE','REOPENED_FOR_ANALYSIS') AND " 
			+" TPL_DTL.SUPP_NO = ? "
			+" ORDER BY TPL_DTL.SUPP_NO, SUPP.SUPP_NAME, TPL_ITM_DTL.TRANSFER_PART_LIST_ITEM_DETAIL_SK, STS.STATUS_NAME";
			
				List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
				
				dataList = jdbcTemplate.queryForList(SELECT_TPL_ALERTS_DTLS_SUPPLIER);
				System.out.println(dataList);
				return dataList;
*/
	}
}
