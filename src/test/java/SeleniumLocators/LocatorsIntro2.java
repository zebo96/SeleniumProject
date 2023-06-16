package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file://Users/codefish/Desktop/Techtorial.html");

        //LINKTEXT Locator
        WebElement javaLink=driver.findElement(By.linkText("java"));
        javaLink.click();

        WebElement javaHeader=driver.findElement(By.tagName("h1"));
        String actualHeader=javaHeader.getText().trim();
        String expectedHeader="Java";
        System.out.println(actualHeader.equals(expectedHeader)? "CORRECT" : "FALSE");

        //PARTIALLINK Locator
        WebElement restApi= driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());


    }
}
