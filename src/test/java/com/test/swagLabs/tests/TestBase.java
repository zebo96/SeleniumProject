package com.test.swagLabs.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get("https://www.saucedemo.com/");
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            BrowserUtils.getScreenShot(driver, "Pictures");
        }
        //  driver.quit();
    }
}
