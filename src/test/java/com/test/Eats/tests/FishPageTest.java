package com.test.Eats.tests;

import com.test.Eats.pages.EatsMainPage;
import com.test.Eats.pages.FishPage;
import com.test.Eats.pages.SeaFoodPage;
import org.testng.annotations.Test;

public class FishPageTest extends EatsTestBase{
    @Test
    public void FishPageTest() throws InterruptedException {
        EatsMainPage eatsMainPage=new EatsMainPage(driver);
        eatsMainPage.chooseSection(driver);
        SeaFoodPage seaFoodPage=new SeaFoodPage();
        seaFoodPage.search(driver, "Fish for Dinner");
        FishPage fishPage=new FishPage();
        fishPage.chooseDinner("6-Ingredient Roasted Salmon Fillets");
    }
}
