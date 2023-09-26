package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderLogic {
    @DataProvider(name = "couples")
    public Object[][] getData() {
        return new Object[][]{
                {"Ahmet","Leyla"},
                {"Anna","Ivan"},
                {"Damon","Elena"},
                {"Manon","Dorian"}
        };
    }

    @Test(dataProvider = "couples", dataProviderClass = allDataPractice.class)
    public void test1(String firstPerson, String secondPerson){
        System.out.println(firstPerson+secondPerson);
    }
    @Test
    public void test2(){
        System.out.println("Anna"+"ivan");
    }
    @Test
    public void test3(){
        System.out.println("Damon"+"Elena");
    }
    @Test
    public void test4(){
        System.out.println("Manon"+"Dorian");
    }
}
