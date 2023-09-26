package com.test.homework3.case1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this );
    }
    @FindBy(xpath = "//input[@name='username']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[@name='loginbtn']")
    WebElement registerButton;
    public void registerNew(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        registerButton.click();
    }
}
