package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/Kiruxa/Downloads/Sublime%20Text%20Build%203211/HTML.html");

        WebElement sushiLink=driver.findElement(By.linkText("  Sushi"));
        sushiLink.click();
        WebElement sushiHeader=driver.findElement(By.className("Sushi"));
        String actualHeader = sushiHeader.getText().trim();
        String expectedHeader="Sushi";
        System.out.println(actualHeader.equals(expectedHeader) ? "CORRECT" : "WRONG");
        driver.navigate().back();
        WebElement franceLink=driver.findElement(By.linkText("France"));
        franceLink.click();
        WebElement franceHeader=driver.findElement(By.className("France"));
        String actualHeader2 = franceHeader.getText(). trim();
        String expectedHeader2="France";
        System.out.println(actualHeader2.equals(expectedHeader2) ? "CORRECT" : "WRONG");
        driver.navigate().back();


        driver.quit();

    }
}
