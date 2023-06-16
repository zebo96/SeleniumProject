package com.test.openchart.tests;

import com.test.openchart.pages.CartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartLoginTest extends OpenChartTestBase{
    @Test
    public void loginFunctionality() throws InterruptedException {
        CartLoginPage cartLoginPage=new CartLoginPage(driver);
        cartLoginPage.loginFunctionality("demo","demo");

        cartLoginPage.switchButton(driver);
        cartLoginPage.titleValidation(driver, "Dashboard");
    }
    @Test
    public void validateNegativeLogin() throws InterruptedException {
        CartLoginPage cartLoginPage=new CartLoginPage(driver);
        cartLoginPage.loginFunctionality("demo","1234");
        cartLoginPage.error("No match for Username and/or Password.");
    }

}
