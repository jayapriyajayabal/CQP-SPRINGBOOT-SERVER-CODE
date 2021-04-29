package com.honda.am.cqp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.Repository;

import com.honda.am.cqp.model.TblUSER_PROFILE;
  
@Repository
public interface UserRepository extends JpaRepository<TblUSER_PROFILE, String> {
  
/*    @Query(value = "				SELECT  USER_PROFILE.USER_LOGIN, USER_TYPE, USER_FIRST_NAME, 
				USER_LAST_NAME,  USER_PROFILE.SUPP_NO as SUPP_SUPP_NO, 
				
				CONVERT(VARCHAR,USER_LAST_LOGIN,101) AS USER_LAST_LOGIN,
				SUPP_MAP.SUPP_NO AS CQ_SUPP_NO FROM dbo.tblUSER_PROFILE
				
				 USER_PROFILE LEFT OUTER JOIN dbo.tblUSER_ROLE_MAPPING
				 USER_ROLE_MAP ON USER_PROFILE.USER_LOGIN = USER_ROLE_MAP.USER_LOGIN 
				 
				 LEFT OUTER JOIN dbo.tblCQ_SUPPLIER_MAPPING SUPP_MAP
				 ON USER_PROFILE.USER_LOGIN = SUPP_MAP.CQ_USER_LOGIN
				 
				 WHERE USER_ROLE_MAP.ROLE_ID IS NULL;", nativeQuery = true)
				 
    public List<TableUserProfile> getUserAlerts();*/
	
	
    @Query("SELECT user.userLogin, user.userType, user.userFirstName, user.userLastName, user.suppNo AS sNo," +
    		" user.userLastLogin as ulLogin," +
    		" suppMap.id.suppNo FROM TblUSER_PROFILE user" +
    		" LEFT OUTER JOIN TblUSER_ROLE_MAPPING userRoleMap ON user.userLogin = userRoleMap.id.userLogin" + 
    		" LEFT OUTER JOIN TblCQ_SUPPLIER_MAPPING suppMap" + 
    		" ON user.userLogin = suppMap.id.cqUserLogin" +
    		" WHERE userRoleMap.id.roleId IS NULL")
    public List<Object[]> getUserAlerts();
}