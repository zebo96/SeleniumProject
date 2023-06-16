package com.test.Eats.pages;

import Utils.BrowserUtils;
import com.test.Eats.tests.EatsTestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeaFoodPage extends EatsTestBase {
    public void SeaFoodPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='search-form-input']")
    WebElement searchBar;
    @FindBy(css = "#button_1-0")
    WebElement searchButton;
    public void search(WebDriver driver, String text) throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame("height-change-listener");
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", searchBar);
        Thread.sleep(1000);
        searchBar.sendKeys(text);
        Thread.sleep(2000);
        searchButton.click();
    }
}
