package com.honda.am.cqp.util;
 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.honda.am.cqp.dto.UserDto;
 
public class UserExcelExporterUtil {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<UserDto> listAlerts;
     
    public UserExcelExporterUtil(List<UserDto> userList) {
        this.listAlerts = userList;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("User-Sheet");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "User Login", style);      
        createCell(row, 1, "User Type", style);       
        createCell(row, 2, "First Name", style);    
        createCell(row, 3, "Last Name", style);
//        createCell(row, 4, "Supplier Number", style);
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (UserDto user : listAlerts) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            //TODO : 2671 rows - export to excel taking so much time
            if(rowCount > 200) {
            	break;
            }
            createCell(row, columnCount++, user.getUserLogin(), style);
            createCell(row, columnCount++, user.getUserType(), style);
            createCell(row, columnCount++, user.getFirstName(), style);
            createCell(row, columnCount++, user.getLastName(), style);
            createCell(row, columnCount++, user.getSupplierNumber(), style); 
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
