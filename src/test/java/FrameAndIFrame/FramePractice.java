package FrameAndIFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FramePractice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement text=driver.findElement(By.tagName("h3"));
        String actual= text.getText();
        String expected="An iFrame containing the TinyMCE WYSIWYG Editor".trim();
        Assert.assertEquals(actual, expected);
        driver.switchTo().frame("mce_0_ifr");
        WebElement text2=driver.findElement(By.xpath("//html//body[@id='tinymce']"));
        text2.clear();
        text2.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        text=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(text));


    }
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        WebElement pavillion= driver.findElement(By.linkText("Pavilion"));
        pavillion.click();
        BrowserUtils.switchByTitle(driver,"Home");
        Thread.sleep(2000);
        WebElement selenium= driver.findElement(By.xpath("//header//ul//li//a//span//span[.='Selenium']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(selenium).perform();
        Thread.sleep(1000);
        WebElement seleniumPython= driver.findElement(By.xpath("//header//ul//li//ul//li//a//span//span[.='Selenium-Python']"));
        actions.click(seleniumPython).perform();
        Thread.sleep(1000);
        WebElement header= driver.findElement(By.tagName("h1"));
        String expected="Selenium-Python Tutorial";
        Assert.assertEquals(BrowserUtils.getText(header), expected);
        List<WebElement> links= driver.findElements(By.xpath("//p//a"));
        for (WebElement link:links){
            System.out.println(BrowserUtils.getText(link));
        }
        //Task2
        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Frame1");
        WebElement category1=driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();
        BrowserUtils.switchByTitle(driver, "Archives");
        WebElement header2= driver.findElement(By.tagName("h1"));
        String expectedHeader2="Category Archives: SeleniumTesting";
        Assert.assertEquals(BrowserUtils.getText(header2), expectedHeader2);
        List<WebElement> allHeader=driver.findElements(By.xpath("//h3//a"));
        for (WebElement head:allHeader){
            System.out.println(BrowserUtils.getText(head));
        }
        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Frame1");
        WebElement text= driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(text));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.linkText("Category3"));
        category3.click();
        BrowserUtils.switchByTitle(driver, "Archives");
        WebElement header3= driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(header3));



    }

}
