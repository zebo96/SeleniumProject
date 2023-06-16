package com.test.blaze.tests;

import com.test.blaze.pages.*;
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
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.validatePurchase("MacBook Pro", "1100");
        BlazePlaceOrderPage blazePlaceOrderPage=new BlazePlaceOrderPage(driver);
        blazePlaceOrderPage.purchaseOrder("Zebo","USA","Chicago","123456789","June","2023");
    }
}
