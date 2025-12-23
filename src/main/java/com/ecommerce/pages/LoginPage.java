package com.ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ecommerce.base.TestBase;

public class LoginPage extends TestBase {

    // 1. Define Page Factory - Object Repository
    // @FindBy is the "Modern" way to locate elements. 
    // It is cleaner than driver.findElement(By.id("..."))
    
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountDropdown;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement loginOption;

    @FindBy(id = "input-email")
    WebElement emailField;

    @FindBy(id = "input-password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;
    
    // 2. Constructor to Initialize Elements
    // "this" means: Initialize the elements in THIS class using the driver
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    // 3. Actions (Methods that perform tasks on the page)
    
    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public void login(String email, String pwd) {
        myAccountDropdown.click();
        loginOption.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(pwd);
        loginButton.click();
        
        // Return type could be HomePage object (we will do this later)
    }
}