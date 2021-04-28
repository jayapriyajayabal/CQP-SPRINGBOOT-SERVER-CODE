package com.honda.am.cqp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.honda.am.cqp.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  
    @Query("				SELECT  USER_PROFILE.USER_LOGIN, USER_TYPE, USER_FIRST_NAME, \r\n" + 
    		"				USER_LAST_NAME,  USER_PROFILE.SUPP_NO as SUPP_SUPP_NO, \r\n" + 
    		"				CONVERT(VARCHAR,USER_LAST_LOGIN,101) AS USER_LAST_LOGIN,\r\n" + 
    		"				SUPP_MAP.SUPP_NO AS CQ_SUPP_NO FROM dbo.tblUSER_PROFILE\r\n" + 
    		"				 USER_PROFILE LEFT OUTER JOIN dbo.tblUSER_ROLE_MAPPING\r\n" + 
    		"				 USER_ROLE_MAP ON USER_PROFILE.USER_LOGIN = USER_ROLE_MAP.USER_LOGIN \r\n" + 
    		"				 LEFT OUTER JOIN dbo.tblCQ_SUPPLIER_MAPPING SUPP_MAP\r\n" + 
    		"				 ON USER_PROFILE.USER_LOGIN = SUPP_MAP.CQ_USER_LOGIN\r\n" + 
    		"				 WHERE USER_ROLE_MAP.ROLE_ID IS NULL")
    public List<User> getUserAlerts();
}