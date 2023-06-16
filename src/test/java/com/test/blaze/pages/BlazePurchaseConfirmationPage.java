package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazePurchaseConfirmationPage {
    public BlazePurchaseConfirmationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[.='Thank you for your purchase!']")
    WebElement message;
    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;
    public void purchaseConfirmation(String expectedMessage) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(message), expectedMessage);
        okButton.click();
        Thread.sleep(2000);
    }
    public void validateURL(WebDriver driver){
        System.out.println(driver.getCurrentUrl());
    }
}
