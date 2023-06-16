package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SeleniumDriverMethods {

    //driver.get()
    //driver.manage.windows.maximize()
    //driver.getTitle()
    //driver.getCurrentURL()
    //driver.navigate.to()
    //driver.navigate.refresh()
    //driver.navigate.back()
    //driver.navigate.forward()
    //driver.getPageSource()
    //driver.close()
    //driver.quit()

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().to("https:www.youtube.com/");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.navigate().back();
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().forward();
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        System.out.println(driver.getPageSource()); // it gets the html structure
        driver.quit(); //it closes all pages opened from one automation





    }



}
