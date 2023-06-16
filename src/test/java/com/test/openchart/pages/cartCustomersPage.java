package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class cartCustomersPage {
    public cartCustomersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addNewButton;
    @FindBy(css = "#input-firstname")
    WebElement firstName;
    @FindBy(css = "#input-lastname")
    WebElement lastName;
    @FindBy(css = "#input-email")
    WebElement email;
    @FindBy(css = "#input-password")
    WebElement password;
    @FindBy(css = "#input-confirm")
    WebElement confirmPassword;
    @FindBy(xpath = "//button//i[@class='fas fa-save']")
    WebElement saveButton;
    @FindBy(css = ".alert")
    WebElement message;

    public void addNewCustomer(WebDriver driver, String name, String lastName, String email, String password, String repeatPassword) throws InterruptedException {
        addNewButton.click();
        Thread.sleep(1000);
        firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        confirmPassword.sendKeys(repeatPassword);
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        actions.scrollByAmount(200,200).perform();
        JavascriptExecutor js= (JavascriptExecutor) driver;
        BrowserUtils.clickWithJS(driver,saveButton);
        Thread.sleep(1000);
    }
    public void validateMessage(String expectedMessage){
        Assert.assertEquals(message.getText(),expectedMessage);
    }

}
