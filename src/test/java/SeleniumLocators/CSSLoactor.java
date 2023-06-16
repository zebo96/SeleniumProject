package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSSLoactor {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        WebElement search= driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        search.sendKeys("watch ");
        WebElement button= driver.findElement(By.cssSelector(".wt-nudge-r-1"));
        button.click();
        String actualURL= driver.getCurrentUrl();
        String expectedURL="https://www.etsy.com/search?q=watch&ref=search_bar";
        System.out.println(actualURL.equals(expectedURL) ? "passed": "failed");
        driver.quit();
    }
}
