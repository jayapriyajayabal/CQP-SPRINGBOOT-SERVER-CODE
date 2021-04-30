package com.honda.am.cqp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.Repository;

import com.honda.am.cqp.model.TblPART_COST_INFO;

@Repository
public interface VoucherCostRepository extends JpaRepository<TblPART_COST_INFO, Long> {

	/*@Query(value = "SELECT '' AS SUPP_NO, 'Missing Part Cost Info' AS SUPP_NAME, '--' AS SHORT_PART_NO \r\n"
			+ ", '--' AS PART_NO, '--' AS MODEL_NAMES, '--' AS MODEL_YEARS, 0 AS FOB_AMT, 0 AS DEALER_NET_AMT,  \r\n"
			+ " COUNT(*) AS FLAT_RATE_AMT FROM    dbo  .tblPART_COST_INFO AS A  \r\n"
			+ " WHERE (A.FOB_AMT=0 OR A.DEALER_NET_AMT=0 OR A.FLAT_RATE_AMT=0 OR A.KILOGRAMS_QTY=0 OR A.POUNDS_QTY=0)  \r\n"
			+ "UNION ALL \r\n"
			+ "SELECT DISTINCT COALESCE(B.SUPP_NO,'') AS SUPP_NO, COALESCE(B.SUPP_NAME,'') AS SUPP_NAME, A.SHORT_PART_NO,  \r\n"
			+ "A.PART_NO, COALESCE(B.MODEL_NAMES,'') AS MODEL_NAMES, COALESCE(B.MODEL_YEARS,'') AS MODEL_YEARS, A.FOB_AMT,A.DEALER_NET_AMT,  \r\n"
			+ " A.FLAT_RATE_AMT  FROM      dbo  .tblPART_COST_INFO AS A  \r\n"
			+ "LEFT JOIN      dbo  .tblGAPS AS B ON A.PART_NO = B.FORMAT_LONG_PART \r\n"
			+ "WHERE A.SHORT_PART_NO IN (SELECT DISTINCT B.SHORT_PART_NO  \r\n"
			+ "					   FROM     dbo  .tblCQ_SUPPLIER_MAPPING AS A  \r\n"
			+ "						 INNER JOIN    dbo  .tblSUPP_PART_INFO AS B ON A.SUPP_NO = B.SUPP_NO \r\n"
			+ "					 WHERE A.CQ_USER_LOGIN= 'aaron.jarrett@continental-corporation.com') \r\n"
			+ "AND (A.FOB_AMT=0 OR A.DEALER_NET_AMT=0 OR A.FLAT_RATE_AMT=0 OR A.KILOGRAMS_QTY=0 OR A.POUNDS_QTY=0)\r\n"
			+ "", nativeQuery = true)
	public List<Object[]> getVoucherAlerts1();*/

	@Query(
			"SELECT '' AS suppNo, 'Missing Part Cost Info' AS suppName, '--' AS shortPartNo\r\n" + 
			", '--' AS partNo, '--' AS modelNames, '--' AS modelYears, 0 AS fobAmt, 0 AS dealerNetAmt,\r\n" + 
			"COUNT(*) AS flatRateAmt FROM TblPART_COST_INFO AS A\r\n" + 
			"WHERE (A.fobAmt=0 OR A.dealerNetAmt=0 OR A.flatRateAmt=0 OR A.kilogramsQty=0 OR A.poundsQty=0)\r\n" + 
			"UNION ALL\r\n" + 
			"SELECT DISTINCT COALESCE(B.suppNo,'') AS suppNo, COALESCE(B.suppName,'') AS suppNo, A.shortPartNo,\r\n" + 
			"A.partNo, COALESCE(B.modelNames,'') AS modelNames, COALESCE(B.modelYears,'') AS modelYears, A.fobAmt,A.dealerNetAmt,\r\n" + 
			"A.flatRateAmt FROM TblPART_COST_INFO AS A\r\n" + 
			"LEFT JOIN TblGAP AS B ON A.partNo = B.formatLongPart\r\n" + 
			"WHERE A.shortPartNo IN (SELECT DISTINCT B.shortPartNo\r\n" + 
			"FROM TblCQ_SUPPLIER_MAPPING AS A\r\n" + 
			"INNER JOIN TblSUPP_PART_INFO AS B ON A.suppNo = B.suppNo\r\n" + 
			"WHERE A.id.cqUserLogin= 'aaron.jarrett@continental-corporation.com')\r\n" + 
			"AND (A.fobAmt=0 OR A.dealerNetAmt=0 OR A.flatRateAmt=0 OR A.kilogramsQty=0 OR A.poundsQty=0)")
	public List<Object[]> getVoucherCostAlerts();
}