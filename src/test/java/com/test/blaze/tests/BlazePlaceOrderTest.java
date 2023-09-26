package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BlazePlaceOrderTest extends BlazeTestBase{
    @Test
    public void BlazePlaceOrderTest() throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.chooseCategory("Laptops");
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        blazeLaptopsPage.chooseLaptopBrand("MacBook Pro");
        BlazeMacBookProPage blazeMacBookProPage=new BlazeMacBookProPage(driver);
        blazeMacBookProPage.clickAddToCartButton(driver, "Product added");
//        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
//        blazeCartPage.validatePurchase("MacBook Pro", "1100");
        BlazePlaceOrderPage blazePlaceOrderPage=new BlazePlaceOrderPage(driver);
        blazePlaceOrderPage.purchaseOrder("Zebo","USA","Chicago","123456789","June","2023");
    }
    @Test(dataProvider = "orderData", dataProviderClass = BlazeData.class)
    public void BlazePlaceOrderTestDataProviderPractice(String category, String brand, String expectedMessage, String firstName, String country, String city, String card, String month, String year) throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.chooseCategory(category);
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        blazeLaptopsPage.chooseLaptopBrand(brand);
        BlazeMacBookProPage blazeMacBookProPage=new BlazeMacBookProPage(driver);
        blazeMacBookProPage.clickAddToCartButton(driver, expectedMessage);
        BlazePlaceOrderPage blazePlaceOrderPage=new BlazePlaceOrderPage(driver);
        blazePlaceOrderPage.purchaseOrder(firstName,country,city,card,month,year);
    }
    @Parameters({"option","macbookType","expectedMessage","expectedTitle","expectedPrice2","name","country","city","number","month","year",})
    @Test
    public void BlazePlaceOrderTestParameter(String option, String macbookType,String expectedMessage,String expectedTitle,String expectedPrice,String name,String country,String city, String number,String month, String year) throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.chooseCategory(option);
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        blazeLaptopsPage.chooseLaptopBrand(macbookType);
        BlazeMacBookProPage blazeMacBookProPage=new BlazeMacBookProPage(driver);
        blazeMacBookProPage.clickAddToCartButton(driver, expectedMessage);
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.validatePurchase();
        BlazePlaceOrderPage blazePlaceOrderPage=new BlazePlaceOrderPage(driver);
        blazePlaceOrderPage.purchaseOrder(name,country,city,number,month,year);
    }
}
