package Testcasespackages;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Basepackage.Baseclass;
import Pagespackages.Loginpage;

public class Logintest extends Baseclass {

    // ✅ Fetch login credentials from Excel
    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() {
        String filePath = "C:\\Users\\janakiramu\\git\\lankarepository\\qa\\src\\test\\resources\\TestResults_Login.xlsx";
        String sheetName = "LoginResults";  

        System.out.println("📁 Loading Excel File: " + filePath);
        System.out.println("📄 Using Sheet Name: " + sheetName);

        return Utilities.ExcelReader.readExcel(filePath, sheetName);
    }

    @Test(dataProvider = "LoginData")
    public void testLogin(String username, String password, String expectedMessage, String isValid) {
        Loginpage lp = new Loginpage(driver);
        lp.enterUsername(username);
        lp.enterPassword(password);
        lp.clickLoginButton();

        System.out.println("✅ Login Attempt: Username: " + username + " | Password: " + password);

        // ✅ Convert "Yes"/"No" from Excel to boolean
        boolean expectedResult = isValid.equalsIgnoreCase("Yes");

        if (expectedResult) {
            // ✅ Assert dashboard is displayed for valid login
            Assert.assertTrue(lp.isDashboarddisplayed(), " ");
        } else {
            // ✅ Verify error message for invalid login
            String actualError = lp.Errormessage();
            Assert.assertEquals(actualError, expectedMessage, "Invalid credentials");
        }
    }
}
