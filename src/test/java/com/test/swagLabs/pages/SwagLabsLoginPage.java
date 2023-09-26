package com.test.swagLabs.pages;

import Utils.BrowserUtils;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SwagLabsLoginPage {
    public SwagLabsLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#user-name")
    WebElement username;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement loginButton;
    @FindBy(tagName = "h3")
    WebElement errorText;
    @FindBy(css = ".inventory_item_name")
    List<WebElement> titles;
    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement header;
    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement description;
    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement price;


    public void Login(String username, String password){
        this.username.sendKeys(username);
       this.password.sendKeys(password);
        loginButton.click();
    }
    public void error(String expectedMessage){
        Assert.assertTrue(BrowserUtils.getText(errorText).contains(expectedMessage));
    }
    public void Validations(String expectedTitle, String expectedHeader, String expectedWord, String expectedPrice){
        for (WebElement title:titles){
            if (BrowserUtils.getText(title).contains(expectedTitle)){
                title.click();
                Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
                Assert.assertTrue(BrowserUtils.getText(description).contains(expectedWord));
                Assert.assertEquals(BrowserUtils.getText(price),expectedPrice);
                break;
            }
        }
    }
}
