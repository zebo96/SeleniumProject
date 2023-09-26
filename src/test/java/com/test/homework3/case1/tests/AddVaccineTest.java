package com.test.homework3.case1.tests;

import com.test.homework3.case1.pages.CartPage;
import com.test.homework3.case1.pages.HomePage;
import com.test.homework3.case1.pages.LoginPage;
import com.test.homework3.case1.pages.RegisterPage;
import org.testng.annotations.Test;

public class AddVaccineTest extends Homework3TestBase{
    @Test(priority = 1)
    public void RegisterPageTest() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginClear();
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.registerNew("Zebo", "1234");
        loginPage.Login("Zebo", "1234");

    }
    @Test(dataProvider = "vaccineData", dataProviderClass = vaccineData.class)
    public void AddVaccineTest(String vaccineName) throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.Login("Zebo", "1234");
        HomePage homePage=new HomePage(driver);
        homePage.addVaccine(vaccineName);

    }
//    @Test()
//    public void CartTest() throws InterruptedException {
//        LoginPage loginPage=new LoginPage(driver);
//        loginPage.Login("Zebo", "1234");
//        HomePage homePage=new HomePage(driver);
//        homePage.addVaccine("Pfizer Vaccine");
//
//        homePage.goToCart();
//    }
//    @Test()
//    public void vaccineValidation() throws InterruptedException {
//        LoginPage loginPage=new LoginPage(driver);
//        loginPage.Login("Zebo", "1234");
//        HomePage homePage=new HomePage(driver);
//        homePage.addVaccine("Pfizer Vaccine");
//        homePage.goToCart();
//        CartPage cartPage=new CartPage(driver);
//        cartPage.checkVaccines("Pfizer Vaccine", "Sputnik Vaccine");
//    }

}
