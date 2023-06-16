package com.test.Eats.pages;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import com.test.Eats.tests.EatsTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class EatsMainPage extends EatsTestBase {
    public EatsMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredientsButton;
    @FindBy(xpath = "//a[.='Fish & Seafood']")
    WebElement fishAndSeaFood;
    public void chooseSection(WebDriver driver) throws InterruptedException {
        Actions actions=new Actions(driver);
        actions.moveToElement(ingredientsButton).perform();
        actions.click(fishAndSeaFood).perform();
        Thread.sleep(2000);
    }
}
