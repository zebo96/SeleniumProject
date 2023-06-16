package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazePlaceOrderPage {
    public BlazePlaceOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#name")
    WebElement name;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(css = "#card")
    WebElement creditCard;
    @FindBy(css = "#month")
    WebElement month;
    @FindBy(css = "#year")
    WebElement year;
    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;

    public void purchaseOrder(String name,String yourCountry, String yourCity, String cardNumber, String month, String year) throws InterruptedException {
       this.name.sendKeys(name);
       country.sendKeys(yourCountry);
       city.sendKeys(yourCity);
       creditCard.sendKeys(cardNumber);
       this.month.sendKeys(month);
       this.year.sendKeys(year);
       purchaseButton.click();
       Thread.sleep(2000);
    }
}
