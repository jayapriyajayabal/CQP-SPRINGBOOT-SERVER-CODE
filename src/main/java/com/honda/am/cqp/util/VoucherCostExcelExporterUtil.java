package com.honda.am.cqp.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.honda.am.cqp.dto.VoucherCostDto;

public class VoucherCostExcelExporterUtil {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<VoucherCostDto> listAlerts;

	public VoucherCostExcelExporterUtil(List<VoucherCostDto> list) {
		this.listAlerts = list;
		workbook = new XSSFWorkbook();
	}

	private void writeHeaderLine() {
		sheet = workbook.createSheet("Voucher-Cost-Sheet");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		style.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        style.setFillPattern(FillPatternType.ALT_BARS);

		createCell(row, 0, "Supplier No", style);
		createCell(row, 1, "Supplier Name", style);
		createCell(row, 2, "Short Part No", style);
		createCell(row, 3, "Part No", style);
		createCell(row, 4, "Model Name", style);
		createCell(row, 5, "Model Years", style);
		createCell(row, 6, "FOB Amount", style);
		createCell(row, 7, "DEALER_NET_Amount", style);
		createCell(row, 8, "FLAT_RATE_Amount", style);

	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private void writeDataLines() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(12);
		style.setFont(font);
		for (VoucherCostDto voucher : listAlerts) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, voucher.getSuppNo(), style);
			createCell(row, columnCount++, voucher.getSuppName(), style);
			createCell(row, columnCount++, voucher.getShortPartNo(), style);
			createCell(row, columnCount++, voucher.getPartNo(), style);
			createCell(row, columnCount++, voucher.getModelNames(), style);
			createCell(row, columnCount++, voucher.getModelYears(), style);
			createCell(row, columnCount++, voucher.getFobAmt(), style);
			createCell(row, columnCount++, voucher.getDealerNetAmt(), style);
			createCell(row, columnCount++, voucher.getFlatRateAmt(), style);
		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}
}
