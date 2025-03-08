package Testcasespackages;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Basepackage.Baseclass;
import Pagespackages.Loginpage;



   

    
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Logintest extends Baseclass {

    // ✅ Fetch login credentials from Excel
    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() {
        String filePath = "C:\\Users\\janakiramu\\git\\lankarepository\\qa\\src\\test\\resources\\TestResults_Login.xlsx"
        		+ ""; // Correct File Path
        String sheetName = "LoginResults";  // ✅ Change this to your actual sheet name

        // Print debug information
        System.out.println("📁 Loading Excel File: " + filePath);
        System.out.println("📄 Using Sheet Name: " + sheetName);

        return Utilities.ExcelReader.readExcel(filePath, sheetName);
    }

    @Test(dataProvider = "LoginData")
    public void testLogin(String username, String password) {
        Loginpage lp = new Loginpage(driver);
        lp.enterUsername(username);
        lp.enterPassword(password);
        lp.clickLoginButton();

        System.out.println("✅ Login Attempt: Username: " + username + " | Password: " + password);
    }
}


