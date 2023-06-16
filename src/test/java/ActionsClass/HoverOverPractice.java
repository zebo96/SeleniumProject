package ActionsClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoverOverPractice {
    @Test
    public void practiceMoveToElement() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window(). maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");

        Actions actions=new Actions(driver);
        actions.scrollByAmount(400,400).perform();

        List<WebElement> images=driver.findElements(By.xpath("//div[@class='product k-listview-item']"));
        List<WebElement> names=driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<String> actualNames=new ArrayList<>();
        List<String> expectedNames= Arrays.asList();
        List<WebElement> prices=driver.findElements(By.xpath("//div[@class='product-description']//p"));
        List<String> actualPrices=new ArrayList<>();
        List<String> expectedPrices=Arrays.asList();

        for (int i=0; i< images.size(); i++) {
        Thread.sleep(3000);
        actions.moveToElement(images.get(i)).perform();
        actualNames.add(BrowserUtils.getText(names.get(i)));
        actualPrices.add(BrowserUtils.getText(prices.get(i)));


        } System.out.println(actualNames);
        System.out.println(actualPrices);



    }
}
