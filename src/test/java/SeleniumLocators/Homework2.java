package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement username= driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("Java");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");
        WebElement button= driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();
        WebElement error= driver.findElement(By.xpath("//h3"));
        System.out.println(error.getText().trim());
        driver.quit();


    }
}
