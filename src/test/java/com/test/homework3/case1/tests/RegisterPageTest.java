package com.test.homework3.case1.tests;

import com.test.homework3.case1.pages.LoginPage;
import com.test.homework3.case1.pages.RegisterPage;
import org.testng.annotations.Test;

public class RegisterPageTest extends  Homework3TestBase{
    @Test
    public void RegisterPageTest() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginClear();
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.registerNew("Zebo", "1234");
        loginPage.Login("Zebo", "1234");

    }
}
