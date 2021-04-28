/*package com.honda.am.cqp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.Repository;

import com.honda.am.cqp.model.User;

@Repository
public interface CallInRepository extends JpaRepository<User, Long> {
  
    @Query(value = "SELECT CPL_DTL.CALLIN_PART_SK CIPL_NO, CPL_DTL.SUPP_NO, SUPP.SUPP_NAME, STS.STATUS_NAME  \r\n" + 
    		"FROM dbo.tblCALL_IN_DETAIL CPL_DTL INNER JOIN dbo.tblSTATUS \r\n" + 
    		"STS ON CPL_DTL.STATUS_ID = STS.STATUS_ID INNER JOIN  \r\n" + 
    		"dbo.tblCQ_SUPPLIER_INFO SUPP ON CPL_DTL.SUPP_NO = SUPP.SUPP_NO WHERE  \r\n" + 
    		"STS.STATUS_TYPE = 'CALL-IN' AND STS.STATUS_NAME = 'NEW' AND \r\n" + 
    		"CPL_DTL.QTR_END_DATE > GETDATE() AND CPL_DTL.SUPP_NO IN(SELECT SUPP_NO FROM  \r\n" + 
    		"dbo.tblCQ_SUPPLIER_MAPPING)  \r\n" + 
    		"ORDER BY CPL_DTL.SUPP_NO, SUPP.SUPP_NAME, CALLIN_PART_SK", nativeQuery = true)
    public List<User> getCallInAlerts();
}



*/