package Testcasespackages;

import org.testng.annotations.Test;

import Utilities.ExcelWriter;



import org.testng.annotations.Test;


public class CreateExcelTest {

    @Test
    public void testCreateMultipleExcelFiles() {
        String folderPath = "src/test/resources/"; // Define the folder path

        // Define different Excel files with their column headers
        String[][] fileDetails = {
            {"TestResults_Login.xlsx", "LoginResults", "Username,Password,ExpectedMessage,IsValid"}
        };

        // Sample data for each file
        String[][][] data = {
            { // Login Data
                {"Admin", "admin123"," ","Yes"},
                { "aadmin123", "admin123","Invalid credentials","No"},
                {  "Admin","Admin123","Invalid credentials","No"}
            }
        }; 

        
        for (int i = 0; i < fileDetails.length; i++) {
            String filePath = folderPath + fileDetails[i][0]; // Define inside loop
            String sheetName = fileDetails[i][1];
            String[] headers = fileDetails[i][2].split(",");

            // Call ExcelWriter to create the file
            ExcelWriter.createExcelFile(filePath, sheetName, headers, data[i]);
        }
    }
}
