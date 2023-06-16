package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {
    public BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomer;
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;
    @FindBy(css = "#userSelect")
    WebElement customerName;
    @FindBy(css = "#currency")
    WebElement currency;
    @FindBy(xpath = "//button[.='Process']")
    WebElement processButton;
    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customerButton;
    @FindBy(tagName = "input")
    WebElement searchBox;
    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInformation;

    //Homework
    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homeButton;




    public void addPublicFunctionality(WebDriver driver,String firstName,String lastName,String postCode, String expectedMessage) throws InterruptedException {
        addCustomerButton.click();
        Thread.sleep(2000);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submitAddCustomer.submit();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }
    public void OpenAccountFunctionality(WebDriver driver, String customerName, String currency, String expectedMessage) throws InterruptedException {
        openAccountButton.click();
        Thread.sleep(2000);
        BrowserUtils.selectBy(this.customerName, customerName, "text");
        BrowserUtils.selectBy(this.currency, currency, "value");
        processButton.click();
        Thread.sleep(2000);

        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
        alert.accept();
    }
    public void customersFunctionality(String customerName, String lastName, String postCode){
        customerButton.click();
        searchBox.sendKeys(customerName);
        List<String> expectedNames= Arrays.asList(customerName,lastName,postCode);

        for (int i=0; i< allInformation.size(); i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedNames.get(i));
        }
    }
    public void homeFunctionality(){
        homeButton.click();
    }
}
