package com.test.homework3.case1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='username']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[@name='regbtn']")
    WebElement registerButton;
    @FindBy(xpath = "//button[@name='loginbtn']")
    WebElement loginButton;

    public void loginClear(){
        username.clear();
        password.clear();
        registerButton.click();
    }
    public  void Login(String username, String password) throws InterruptedException {
        Thread.sleep(1000);
        this.username.clear();
        Thread.sleep(1000);
        this.username.sendKeys(username);
        Thread.sleep(1000);
        this.password.clear();
        Thread.sleep(1000);
        this.password.sendKeys(password);
        Thread.sleep(1000);
        loginButton.click();
    }

}
