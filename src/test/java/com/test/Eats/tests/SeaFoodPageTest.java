package com.test.Eats.tests;

import com.test.Eats.pages.EatsMainPage;
import com.test.Eats.pages.SeaFoodPage;
import org.testng.annotations.Test;

public class SeaFoodPageTest extends EatsTestBase{
    @Test
    public void SeaFoodPageTest() throws InterruptedException {
        EatsMainPage eatsMainPage=new EatsMainPage(driver);
        eatsMainPage.chooseSection(driver);
        SeaFoodPage seaFoodPage=new SeaFoodPage();
        seaFoodPage.search(driver,"Fish for dinner");
    }
}
