package com.honda.am.cqp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.Repository;

import com.honda.am.cqp.model.TblUSER_PROFILE;
  
/*public interface UserRepository extends Repository<User, Long> {
  
    @Query(value = "SELECT  USER_PROFILE.USER_LOGIN, USER_TYPE, USER_FIRST_NAME, \r\n" + 
    		"				USER_LAST_NAME,  USER_PROFILE.SUPP_NO as SUPP_SUPP_NO, \r\n" + 
    		"				CONVERT(VARCHAR,USER_LAST_LOGIN,101) AS USER_LAST_LOGIN,\r\n" + 
    		"				SUPP_MAP.SUPP_NO AS CQ_SUPP_NO FROM dbo.tblUSER_PROFILE\r\n" + 
    		"				 USER_PROFILE LEFT OUTER JOIN dbo.tblUSER_ROLE_MAPPING\r\n" + 
    		"				 USER_ROLE_MAP ON USER_PROFILE.USER_LOGIN = USER_ROLE_MAP.USER_LOGIN \r\n" + 
    		"				 LEFT OUTER JOIN dbo.tblCQ_SUPPLIER_MAPPING SUPP_MAP\r\n" + 
    		"				 ON USER_PROFILE.USER_LOGIN = SUPP_MAP.CQ_USER_LOGIN\r\n" + 
    		"				 WHERE USER_ROLE_MAP.ROLE_ID IS NULL", nativeQuery = true)
    public List<User> getUserAlerts();*/
//}




@Repository
public interface UserRepository extends JpaRepository<TblUSER_PROFILE, Long> {
/*  
    @Query(value = "SELECT USER_PROFILE.USER_LOGIN, USER_TYPE, USER_FIRST_NAME, \r\n" + 
    		"				USER_LAST_NAME,  USER_PROFILE.SUPP_NO as SUPP_SUPP_NO, \r\n" + 
    		"				CONVERT(VARCHAR,USER_LAST_LOGIN,101) AS USER_LAST_LOGIN,\r\n" + 
    		"				SUPP_MAP.SUPP_NO AS CQ_SUPP_NO FROM tblUSER_PROFILE\r\n" + 
    		"				 USER_PROFILE LEFT OUTER JOIN tblUSER_ROLE_MAPPING\r\n" + 
    		"				 USER_ROLE_MAP ON USER_PROFILE.USER_LOGIN = USER_ROLE_MAP.USER_LOGIN \r\n" + 
    		"				 LEFT OUTER JOIN tblCQ_SUPPLIER_MAPPING SUPP_MAP\r\n" + 
    		"				 ON USER_PROFILE.USER_LOGIN = SUPP_MAP.CQ_USER_LOGIN \r\n" + 
    		"				 WHERE USER_ROLE_MAP.ROLE_ID IS NULL", nativeQuery = true)
    public List<TblUSER_PROFILE> getUserAlerts();*/
	
    @Query(value = "SELECT * FROM tblCQ_SUPPLIER_MAPPING", nativeQuery = true)
    public List<TblUSER_PROFILE> getUserAlerts();
}