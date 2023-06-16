package com.test.blaze.tests;

import com.test.blaze.pages.BlazeCartPage;
import com.test.blaze.pages.BlazeHomePage;
import com.test.blaze.pages.BlazeLaptopsPage;
import com.test.blaze.pages.BlazeMacBookProPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BlazeCartPageTest extends BlazeTestBase{
    @Test
    public void BlazeCartPageTest() throws InterruptedException {
        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);
        blazeHomePage.chooseCategory("Laptops");
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        blazeLaptopsPage.chooseLaptopBrand("MacBook Pro");
        BlazeMacBookProPage blazeMacBookProPage=new BlazeMacBookProPage(driver);
        blazeMacBookProPage.clickAddToCartButton(driver, "Product added");
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.validatePurchase("MacBook Pro", "1100");
    }
}
