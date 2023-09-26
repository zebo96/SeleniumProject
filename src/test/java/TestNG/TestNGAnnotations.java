package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I am beforeSuite annotation");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am beforeTest annotation");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am beforeClass annotation");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am BeforeMethod annotation");
    }
    @Test
    public void test1(){
        System.out.println("I am test1 annotation");
    }
    @Test
    public void test2(){
        System.out.println("I am test2 annotation");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am afterMethod annotation");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am afterClass annotation");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am afterTest annotation");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("I am afterSuite annotation");
    }
}
