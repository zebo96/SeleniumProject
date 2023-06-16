package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends BanlTestBase{
    @Test
    public void validateAddCustomerFunctionality() throws InterruptedException {
       // WebDriverManager.chromedriver().setup();
        //ChromeOptions options=new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
       // WebDriver driver=new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();
        //driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/Login");

        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();
        Thread.sleep(3000);

        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addPublicFunctionality(driver,"Zebo", "Sabur", "60074", "Customer added successfully with customer id");
    }
    @Test
    public void validateOpenAccountFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/Login");

        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();

        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addPublicFunctionality(driver,"Zebo", "Sabur", "60074", "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Zebo Sabur", "Dollar", "Account created successfully with account Number");
    }
    @Test
    public void validateCustomerFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/Login");

        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addPublicFunctionality(driver,"Zebo", "Sabur", "60074", "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Zebo Sabur", "Dollar", "Account created successfully with account Number");

        bankManagerPage.customersFunctionality("Zebo","Sabur","60074");

    }
    @Test
    public void homework() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/Login");

        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addPublicFunctionality(driver,"Zebo", "Sabur", "60074", "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Zebo Sabur", "Dollar", "Account created successfully with account Number");

        bankManagerPage.customersFunctionality("Zebo","Sabur","60074");
        bankManagerPage.homeFunctionality();
    }
}
