package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BlazeCartPage {
    public BlazeCartPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#cartur")
    WebElement cart;
    @FindBy(xpath = "//td[.='MacBook Pro']")
    WebElement title;
    @FindBy(xpath = "//td[.='1100']")
    WebElement price;
    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;

    public void validatePurchase() throws InterruptedException {
        Thread.sleep(2000);
        cart.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(title), expectedTitle);
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(price), expectedPrice);
        placeOrderButton.click();
        Thread.sleep(2000);
    }

    //ANOTHER WAY TO DO IT
    @FindBy(xpath = "//td")
  List<WebElement> information; //picture; title; price; delete
   public void getInfoFromCart(String expectedTitle, String expectedPrice){
        List<String> expectedInfo= Arrays.asList("",expectedTitle, expectedPrice,"");
       for (int i=0; i< information.size()-1; i++){
           Assert.assertEquals(BrowserUtils.getText(information.get(i)), expectedInfo);
        }
  }


}
