package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartLoginPage {
    public CartLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='username']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//title[contains(text(),'Dashboard')]")
    WebElement title;
    @FindBy(css = "#alert")
    WebElement errorMessage;


    public void loginFunctionality(String name, String yourPassword) throws InterruptedException {
        username.sendKeys(name);
        password.sendKeys(yourPassword);
        loginButton.click(); Thread.sleep(2000);
    }
    public void switchButton(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    public void titleValidation(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle().trim(), expectedTitle);
    }
    public void error(String expectedMessage){
        Assert.assertEquals(errorMessage.getText(), expectedMessage);
    }
}
