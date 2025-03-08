package Utilities;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static String[][] readExcel(String filePath, String sheetName) {
        String[][] data = null;

        // ✅ Create File object
        File file = new File(filePath);

        // ✅ Print File Name & Absolute Path
        System.out.println("📂 File Name: " + file.getName());
        System.out.println("📁 Absolute File Path: " + file.getAbsolutePath());
        System.out.println("🔍 File Exists: " + file.exists());

        // ✅ Check if the file exists
        if (!file.exists()) {
            System.err.println("❌ ERROR: Excel file not found! Check the path: " + file.getAbsolutePath());
            return null;
        }

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.err.println("❌ ERROR: Sheet '" + sheetName + "' not found in " + file.getAbsolutePath());
                return null;
            }

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            System.out.println("✅ Sheet Loaded: " + sheetName + " | Rows: " + rowCount + " | Columns: " + colCount);

            data = new String[rowCount - 1][colCount]; // Skip header row

            for (int i = 1; i < rowCount; i++) { // Read data from row 1
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = (cell != null) ? cell.toString() : "";
                }
            }
        } catch (IOException e) {
            System.err.println("❌ ERROR: Unable to read Excel file: " + e.getMessage());
        }

        return data;
    }
}


