package com.test.swagLabs.tests;

import Utils.ConfigReader;

import com.test.swagLabs.pages.SwagLabsLoginPage;

import org.testng.Assert;

import org.testng.annotations.Test;

public class SwagLabsLoginPageTest extends TestBase{
    @Test(dataProvider = "SwagData", dataProviderClass = SwagLabsAllDataClass.class)
    public void positiveTest( String username, String password, String expectedUrl){
        SwagLabsLoginPage swagLabsLoginPage=new SwagLabsLoginPage(driver);
        swagLabsLoginPage.Login(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }
    @Test(dataProvider = "SwagData2", dataProviderClass = SwagLabsAllDataClass.class)
    public void negativeTest(String username, String password, String expectedMessage){
        SwagLabsLoginPage swagLabsLoginPage=new SwagLabsLoginPage(driver);
        swagLabsLoginPage.Login(username,password);
        swagLabsLoginPage.error(expectedMessage);

    }
    @Test(dataProvider = "itemsData", dataProviderClass = SwagLabsAllDataClass.class)
    public void ConfigTest(String expectedTitle, String expectedHeader, String expectedWord, String expectedPrice){
        SwagLabsLoginPage swagLabsLoginPage=new SwagLabsLoginPage(driver);
        swagLabsLoginPage.Login(ConfigReader.readProperty("SwagUsername"), ConfigReader.readProperty("SwagPassword"));
        swagLabsLoginPage.Validations(expectedTitle,expectedHeader,expectedWord,expectedPrice);

    }
}
