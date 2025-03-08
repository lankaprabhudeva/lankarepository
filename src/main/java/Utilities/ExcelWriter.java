package Utilities;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {

    public static void createExcelFile(String filePath, String sheetName, String[] headers, String[][] data) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);

        // Create header row
        Row headerRow = sheet.createRow(0);
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Write data to the sheet
        for (int rowNum = 0; rowNum < data.length; rowNum++) {
            Row row = sheet.createRow(rowNum + 1); // +1 to skip header row
            for (int colNum = 0; colNum < data[rowNum].length; colNum++) {
                row.createCell(colNum).setCellValue(data[rowNum][colNum]);
            }
        }

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write to file
        try (FileOutputStream fileOut = new FileOutputStream(new File(filePath))) {
            workbook.write(fileOut);
            workbook.close();
            System.out.println("✅ Excel file created: " + filePath);
        } catch (IOException e) {
            System.err.println("❌ Error creating Excel file: " + e.getMessage());
        }
    }
}




