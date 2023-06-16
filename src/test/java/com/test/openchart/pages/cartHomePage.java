package com.test.openchart.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartHomePage {
    public cartHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@class='btn-close']")
    WebElement exitButton;
    @FindBy(xpath = "//a//i[@class='fas fa-user']")
    WebElement customers1;
    @FindBy(xpath = "//a[.='Customers']")
    WebElement customers2;

    public void goToCustomerPage(WebDriver driver) throws InterruptedException {
        exitButton.click();
        Thread.sleep(1000);
        customers1.click();
        Thread.sleep(500);
        customers2.click();
    }
}
