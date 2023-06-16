package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    @Test
    public void HeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com");

        WebElement type= driver.findElement(By.id("make-model-search-stocktype"));
        BrowserUtils.selectBy(type,"new", "value");
        WebElement carName= driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(carName,"lexus","value");
        WebElement model= driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(model,"lexus-rx_350","value");
        WebElement price= driver.findElement(By.id("make-model-max-price"));
        Select choice=new Select(price);
        String actualDefault=choice.getFirstSelectedOption().getText().trim();
        String expectedDefault="No max price";
        Assert.assertEquals(actualDefault,expectedDefault);
        WebElement distance= driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(distance, "40 miles", "text");
        WebElement zip= driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zip.clear();
        zip.sendKeys("60056");
        WebElement button=driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        button.click();
        Thread.sleep(3000);
        WebElement text= driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        Assert.assertEquals(BrowserUtils.getText(text),"New Lexus RX 350 for sale".trim());
        WebElement sortBy= driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        BrowserUtils.selectBy(sortBy,"Lowest price","text");
        Thread.sleep(2000);
        List<WebElement> names=driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement name:names){
            Assert.assertTrue(BrowserUtils.getText(name).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(name));
        }
        List<WebElement> allPrices=driver.findElements(By.cssSelector(".primary-price"));
        List<Integer> actualPrice=new ArrayList<>();
        List<Integer> expectedPrice=new ArrayList<>();
        for (int i=0; i<allPrices.size(); i++){
            actualPrice.add(Integer.parseInt(BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",","")));
            expectedPrice.add(Integer.parseInt(BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",","")));
        }
        Collections.sort(expectedPrice);
        Assert.assertEquals(actualPrice,expectedPrice);
        System.out.println(actualPrice);
        System.out.println(expectedPrice);
















        
    }
}