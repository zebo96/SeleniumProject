package TestNG;

import org.testng.annotations.DataProvider;

public class allDataPractice {
    @DataProvider(name = "couples")
    public Object[][] getData() {
        return new Object[][]{
                {"Ahmet","Leyla"},
                {"Anna","Ivan"},
                {"Damon","Elena"},
                {"Manon","Dorian"}
        };
    }
}
