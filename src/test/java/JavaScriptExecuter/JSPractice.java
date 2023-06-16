package JavaScriptExecuter;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.common.initializedfields.qual.EnsuresInitializedFields;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v110.overlay.model.LineStyle;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.cssSelector("#yesRadio"));
        Actions actions = new Actions(driver);
        actions.click(yesButton).perform();
        // IF ACTIONS DOES NOT WORK
        // JavascriptExecutor js=(JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click()", yesButton);
        Thread.sleep(2000);

        WebElement message = driver.findElement(By.xpath("//span[@class='text-success']"));
        String expectedM = "Yes";
        Assert.assertEquals(BrowserUtils.getText(message), expectedM);

        WebElement impressiveButton = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        actions.click(impressiveButton).perform();
        Thread.sleep(2000);

        WebElement message2 = driver.findElement(By.xpath("//span[@class='text-success']"));
        String expectedM2 = "Impressive";
        Assert.assertEquals(BrowserUtils.getText(message2), expectedM2);

        WebElement noButton = driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertTrue(!noButton.isEnabled());

    }
 @Test
    public void scrollIntoView() throws InterruptedException {
     WebDriverManager.chromedriver().setup();
     ChromeOptions chromeOptions = new ChromeOptions();
     chromeOptions.addArguments("--remote-allow-origins=*");
     WebDriver driver = new ChromeDriver(chromeOptions);
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("https://techtorialacademy.com");

     WebElement findOutCourse= driver.findElement(By.xpath("//span[contains(text(),'which course')]"));
     JavascriptExecutor js=(JavascriptExecutor) driver;
     js.executeScript("arguments[0].scrollIntoView(true)", findOutCourse);
     Thread.sleep(2000);
     findOutCourse.click();

 }
 @Test
    public void practice2() throws InterruptedException {
     WebDriverManager.chromedriver().setup();
     ChromeOptions chromeOptions = new ChromeOptions();
     chromeOptions.addArguments("--remote-allow-origins=*");
     WebDriver driver = new ChromeDriver(chromeOptions);
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("https://techtorialacademy.com");

     WebElement copyright=driver.findElement(By.xpath("//div[contains(text(),'Copyright © 2023')]"));
     JavascriptExecutor js=(JavascriptExecutor) driver;
     js.executeScript("arguments[0].scrollIntoView(true)", copyright);
     Thread.sleep(2000);
     String expectedText="Copyright © 2023";
     Assert.assertEquals(BrowserUtils.getText(copyright), expectedText);

     WebElement applyButton= driver.findElement(By.xpath("//span[.='Apply Now']"));
     JavascriptExecutor js2=(JavascriptExecutor)driver;
     js2.executeScript("arguments[0].scrollIntoView(true)", applyButton);
     js2.executeScript("arguments[0].click(true)", applyButton);
     Thread.sleep(2000);
     driver.getTitle();
     List<WebElement> lists=driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
     List<String> actual=new ArrayList<>();
     List<String> expected=Arrays.asList();
     Actions actions=new Actions(driver);
     for (int i=0; i< lists.size(); i++){
         Thread.sleep(2000);
         actions.moveToElement(lists.get(i)).perform();
         actual.add(BrowserUtils.getText(lists.get(i)));
     }
     System.out.println(actual);











 }
 @Test
    public void Practice3(){
     WebDriverManager.chromedriver().setup();
     ChromeOptions chromeOptions = new ChromeOptions();
     chromeOptions.addArguments("--remote-allow-origins=*");
     WebDriver driver = new ChromeDriver(chromeOptions);
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("https://techtorialacademy.com");

     WebElement copyright=driver.findElement(By.xpath("//div[contains(text(),'Copyright © 2023')]"));
     BrowserUtils.scrollWithJS(driver,copyright);
     String actualText=BrowserUtils.getText(copyright);
     String expectedText="Copyright © 2023";
     Assert.assertEquals(actualText,expectedText);

     WebElement applyNow=driver.findElement(By.xpath("//span[.='Apply Now']"));
     BrowserUtils.scrollWithJS(driver,applyNow);
     BrowserUtils.clickWithJS(driver,applyNow);

     String actualTitle=BrowserUtils.getTitleWithJS(driver);
     String expectedTitle="Apply Now";
     Assert.assertEquals(actualTitle,expectedTitle);

     List<WebElement> allInformation=driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
     List<String> expectedInformation=Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");
     for (int i=0; i<allInformation.size(); i++){
         Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)), expectedInformation.get(i));
     }
 }

}
