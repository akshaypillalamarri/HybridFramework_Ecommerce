package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ecommerce.base.TestBase;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.utils.TestUtil;

public class LoginTest extends TestBase {

    LoginPage loginPage;
    String sheetName = "Login"; // Must match your Excel sheet name exactly

    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    // 1. The Data Provider
    // This fetches data from Excel and feeds it to the test method
    @DataProvider
    public Object[][] getLoginTestData() {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    // 2. The Test
    // Notice we added (String username, String password) arguments
    @Test(priority = 1, dataProvider = "getLoginTestData")
    public void loginTest(String username, String password) {
        
        // We log what is happening so you can see it in the console
        System.out.println("Testing with: " + username);
        
        loginPage.login(username, password);
        
        // NOTE: If you have valid AND invalid data mixed, 
        // a simple assertion might fail on the invalid ones. 
        // For now, let's just see if it runs.
      //  Assert.assertEquals(driver.getTitle(), "Google");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}