package com.ecommerce.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ecommerce.base.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReporterNG extends TestBase implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext context) {
        // 1. Configure the Report
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        // 2. Attach configuration to ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Your Name");
        extent.setSystemInfo("Environment", "QA");
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
        
        // Attempt to take screenshot
        String screenshotPath = TestBase.takeScreenshot(result.getName());
        
        // Only attach if screenshot exists
        if (screenshotPath != null) {
            test.addScreenCaptureFromPath(screenshotPath);
        } else {
            test.log(Status.FAIL, "Screenshot not available (Driver was null)");
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test Skipped");
    }

    public void onFinish(ITestContext context) {
        // 4. Write everything to the file
        extent.flush();
    }
    
    // Empty implementations for other interface methods we don't need right now
    public void onTestStart(ITestResult result) {}
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
}