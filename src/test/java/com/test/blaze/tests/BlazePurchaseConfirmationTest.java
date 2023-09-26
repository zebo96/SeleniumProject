package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Test;

public class BlazePurchaseConfirmationTest extends BlazeTestBase{
    @Test
    public void BlazePurchaseConfirmationTest() throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.chooseCategory("Laptops");
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        blazeLaptopsPage.chooseLaptopBrand("MacBook Pro");
        BlazeMacBookProPage blazeMacBookProPage=new BlazeMacBookProPage(driver);
        blazeMacBookProPage.clickAddToCartButton(driver, "Product added");
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.validatePurchase();
        BlazePlaceOrderPage blazePlaceOrderPage=new BlazePlaceOrderPage(driver);
        blazePlaceOrderPage.purchaseOrder("Zebo","USA","Chicago","123456789","June","2023");
        BlazePurchaseConfirmationPage blazePurchaseConfirmationPage=new BlazePurchaseConfirmationPage(driver);
        blazePurchaseConfirmationPage.purchaseConfirmation("Thank you for your purchase!");
        blazePurchaseConfirmationPage.validateURL(driver);
    }
}
