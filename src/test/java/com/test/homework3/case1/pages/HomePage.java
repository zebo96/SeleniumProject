package com.test.homework3.case1.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h5")
    List<WebElement> names;
    @FindBy(xpath = "//div[@class='card-body']//button[@type='button']")
    WebElement addToCartButtons;
    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartButton;

    public void closeAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void addVaccine( String vaccineName) {
        for (WebElement name : names) {
            if (BrowserUtils.getText(name).contains(vaccineName)) {
                addToCartButtons.click();
                break;
            }

        }
    }


        public void goToCart () {
            cartButton.click();
        }
    }

