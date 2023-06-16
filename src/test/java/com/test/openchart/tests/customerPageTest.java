package com.test.openchart.tests;

import com.test.openchart.pages.CartLoginPage;
import com.test.openchart.pages.cartCustomersPage;
import com.test.openchart.pages.cartHomePage;
import org.testng.annotations.Test;

public class customerPageTest extends OpenChartTestBase {
    @Test
            public void addNewCustomerTest() throws InterruptedException {
    CartLoginPage cartLoginPage=new CartLoginPage(driver);
    cartHomePage cartHomePage=new cartHomePage(driver);
    cartCustomersPage cartCustomerPage=new cartCustomersPage(driver);

    cartLoginPage.loginFunctionality("demo", "demo");
    cartHomePage.goToCustomerPage(driver);
    cartCustomerPage.addNewCustomer(driver, "Zebo", "Sabur", "zebo@gmail.com", "1234","1234");
    cartCustomerPage.validateMessage("Warning: You do not have permission to modify customers!");


    }
}
