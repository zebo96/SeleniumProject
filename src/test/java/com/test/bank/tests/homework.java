package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.homeworkBankCustomerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework {
    @Test
    public void homework() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/Login");

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addPublicFunctionality(driver, "Zebo", "Sabur", "60074", "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Zebo Sabur", "Dollar", "Account created successfully with account Number");

        bankManagerPage.customersFunctionality("Zebo", "Sabur", "60074");
        bankManagerPage.homeFunctionality();

        loginPage.clickCustomerButton();
        homeworkBankCustomerPage homework= new homeworkBankCustomerPage(driver);
        homework.chooseName("6");

        homework.clickLoginButton();
        homework.validateWelcome("Welcome Zebo Sabur !!");
        homework.clickDepositButton();
        homework.enterAmount("500");
        homework.clickConfirmDepositButton();
        homework.validateMessage("Deposit Successful");
        homework.clickWithdrawlButton();
        Thread.sleep(2000);
        homework.withdrawthisAmount("300");
        homework.clickConfirmWithdrawlButton();
        homework.validateMessage2("Transaction successful");
        homework.transactionFunctionality();

    }
}
