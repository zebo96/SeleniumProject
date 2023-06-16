package com.test.Eats.tests;

import com.test.Eats.pages.EatsMainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class EatsMainPageTest extends EatsTestBase {
    @Test
    public void EatsMainPageTest() throws InterruptedException {
        EatsMainPage eatsMainPage=new EatsMainPage(driver);
        eatsMainPage.chooseSection(driver);

    }
}
