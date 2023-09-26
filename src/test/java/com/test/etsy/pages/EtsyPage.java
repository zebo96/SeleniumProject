package com.test.etsy.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class EtsyPage {
    public EtsyPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "search_query")
    WebElement searchBar;
    @FindBy(xpath = "//span[@class='wt-icon wt-nudge-b-2 wt-nudge-r-1']")
    WebElement searchButton;
    @FindBy(xpath = "//a//div//h3")
    List<WebElement> descriptions;
    public void searchBoxFunctionality(String searchName) throws InterruptedException {
        Thread.sleep(2000);
        searchBar.sendKeys(searchName);
        Thread.sleep(2000);
        searchButton.click();
    }
    public void SearchResults(String word1, String word2, String word3){
        for (WebElement description:descriptions){
            String text=BrowserUtils.getText(description).toLowerCase();
            Assert.assertTrue(text.contains(word1) ||text.contains(word2)|| text.contains(word3));
        }
    }
}
