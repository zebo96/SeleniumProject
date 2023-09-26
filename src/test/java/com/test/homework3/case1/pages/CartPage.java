package com.test.homework3.case1.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(tagName = "td")
    List<WebElement> vaccines;
    public void checkVaccines(String v1, String v2){
        for ( WebElement vaccine:vaccines){
            if (BrowserUtils.getText(vaccine).contains(v1) || BrowserUtils.getText(vaccine).contains(v2)){
                System.out.println("pass");

            }
        }
    }
}
