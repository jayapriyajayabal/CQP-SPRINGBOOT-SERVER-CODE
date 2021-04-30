package com.honda.am.cqp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.honda.am.cqp.model.TbltransferPartListDetail;

@Repository
public interface TPLRepository extends JpaRepository<TbltransferPartListDetail, String> {

	/*
	 * @Query("SELECT user.userLogin, user.userType, user.userFirstName, user.userLastName, user.suppNo AS sNo,"
	 * + " user.userLastLogin as ulLogin," +
	 * " suppMap.id.suppNo FROM TblUSER_PROFILE user" +
	 * " LEFT OUTER JOIN TblUSER_ROLE_MAPPING userRoleMap ON user.userLogin = userRoleMap.id.userLogin"
	 * + " LEFT OUTER JOIN TblCQ_SUPPLIER_MAPPING suppMap" +
	 * " ON user.userLogin = suppMap.id.cqUserLogin" +
	 * " WHERE userRoleMap.id.roleId IS NULL")
	 */
	/*@Query("SELECT tpl_dtl.transferPartListDetailSk , " + " tpl_dtl.suppNo, supp.suppName, sts.statusName "
			+ " FROM TbltransferPartListDetail as tpl_dtl "
			+ " INNER JOIN TbltransferPartListItemDetail as tpl_itm_dtl "
			+ " ON tpl_dtl.transferPartListDetailSk = tpl_itm_dtl.transferPartListItemDetailSk "
			+ " INNER JOIN Tblstatus " + " sts ON tpl_itm_dtl.statusId = sts.statusId "
			+ " INNER JOIN TblcqSupplierInfo " + " supp ON tpl_dtl.suppNo = supp.suppNo "
			+ " WHERE sts.statusType = 'TPL' AND " + " sts.statusName IN ('NEW','ACTIVE','REOPENED_FOR_ANALYSIS') AND "
			+ " tpl_dtl.suppNo IN (SELECT tsm.id.suppNo FROM TblcqSupplierMapping  as tsm WHERE CQ_USER_LOGIN='bill_converse@tstna.com') "
			+ " ORDER BY tpl_dtl.suppNo, supp.suppName, tpl_itm_dtl.transferPartListDetailSk, sts.statusName")*/

	@Query("Select a from TbltransferPartListItemDetail a")
	public List<Object[]> getTPAAlerts();
}