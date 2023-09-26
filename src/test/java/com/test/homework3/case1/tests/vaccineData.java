package com.test.homework3.case1.tests;

import org.testng.annotations.DataProvider;

public class vaccineData {
    @DataProvider(name = "vaccineData")
    public Object[][] getData(){
        return new Object[][]{
                {"Sputnik Vaccine"},
                {"Pfizer Vaccine"}
        }  ;
    }
}
