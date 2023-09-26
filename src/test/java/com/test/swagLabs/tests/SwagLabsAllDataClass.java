package com.test.swagLabs.tests;

import org.testng.annotations.DataProvider;

public class SwagLabsAllDataClass {
    @DataProvider(name = "SwagData")
    public Object[][] getData(){
        return new Object[][]{
                {"standard_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
                {"problem_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
                {"performance_glitch_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"}
        }  ;
    }
    @DataProvider(name = "SwagData2")
    public Object[][] getData2(){
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "1234", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"}
        };
    }
    @DataProvider(name = "itemsData")
    public Object[][] getData3(){
        return new Object[][]{
                {"Sauce Labs Backpack","Sauce Labs Backpack", "Sly Pack", "$29.99"},
                {"Sauce Labs Bike Light","Sauce Labs Bike Light", "AAA battery", "$9.99"},
                {"Sauce Labs Bolt T-Shirt","Sauce Labs Bolt T-Shirt", "Get your testing", "$15.99"},
                {"Sauce Labs Fleece Jacket","Sauce Labs Fleece Jacket", "midweight", "$49.99"},
                {"Sauce Labs Onesie","Sauce Labs Onesie", "Rib snap", "$7.99"},
                {"Test.allTheThings() T-Shirt (Red)","Test.allTheThings() T-Shirt (Red)", "This classic", "$15.99"}
        };
    }
}
