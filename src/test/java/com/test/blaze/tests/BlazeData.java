package com.test.blaze.tests;

import org.testng.annotations.DataProvider;

import javax.xml.namespace.QName;

public class BlazeData {
   @DataProvider(name = "orderData")
    public Object[][] getData(){
       return new Object[][]{
               {"Phones", "Nokia lumia 1520", "Product added", "Zebo", "USA", "Chicago", "123456789", "june", "2023"},
               {"Phones", "Iphone 6", "Product added", "Zebo", "USA", "Chicago", "123456789", "june", "2023"}
       };
    }
}
