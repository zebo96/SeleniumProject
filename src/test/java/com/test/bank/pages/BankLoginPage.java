package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {
    public BankLoginPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".mainHeading")
    WebElement header;
    @FindBy(xpath = "//button[.='Customer Login']" )
    WebElement customerLogin;
    @FindBy(xpath = "//button[contains(text(),'Bank Manager')]")
    WebElement ManagerLogin;
    public  void LoginPageComponentsValidation(String expectedHeader){
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Assert.assertTrue(customerLogin.isDisplayed()&& customerLogin.isEnabled());
        Assert.assertTrue(ManagerLogin.isDisplayed()&& ManagerLogin.isEnabled());
    }
    public void clickManagerButton() {
        ManagerLogin.click();
    }
    public void clickCustomerButton(){
        customerLogin.click();
    }
}
