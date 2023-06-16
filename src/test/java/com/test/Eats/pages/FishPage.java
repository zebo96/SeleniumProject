package com.test.Eats.pages;

import Utils.BrowserUtils;
import com.test.Eats.tests.EatsTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FishPage extends EatsTestBase {
    public void FishPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//label[@for='starRating_score_4Star']")
    WebElement fourStarButton;
    @FindBy(xpath = "//label[@for='pop_search_editor']")
    WebElement editorChoiceButton;
    @FindBy(xpath = "//span[@class='card__underline']")
    WebElement description;
    public void chooseDinner(String expectedDescription) throws InterruptedException {
        fourStarButton.click();
        Thread.sleep(1000);
        editorChoiceButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(description), expectedDescription);
    }
}
