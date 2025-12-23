package com.ecommerce.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    // Constructor: Load the config file explicitly
    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") 
                    + "/src/main/resources/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to Initialize Browser
    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            // Selenium 4.6+ manages drivers automatically (no need for System.setProperty)
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // Using Duration (New in Selenium 4)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get(prop.getProperty("url"));
    }
    
    public static String takeScreenshot(String testMethodName) {
        // Check if driver is alive
        if (driver == null) {
            System.out.println("Driver is NULL. Cannot take screenshot for: " + testMethodName);
            return null; // Return null to indicate no screenshot taken
        }

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String destination = System.getProperty("user.dir") + "/screenshots/" + testMethodName + "_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(srcFile, new File(destination));
            return destination;
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
            return null;
        }
    }
    
}