package GetWindowHandle;

import Java.IfStatements;
import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {
    @Test
    public void practiceMultipleWindows() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        String mainPageID= driver.getWindowHandle();
        Set<String> allPagesID=driver.getWindowHandles();
        for (String id:allPagesID){
            if (!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        BrowserUtils.switchByTitle(driver,"Contact");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"Kickstart");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "Courses");
        System.out.println(driver.getTitle());








    }

    @Test
    public void RealTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button4=driver.findElement(By.cssSelector("#newTabsBtn"));
        button4.click();
        BrowserUtils.switchByTitle(driver, "Basic");
        Thread.sleep(2000);
        WebElement firstName= driver.findElement(By.id("firstName"));
        firstName.sendKeys("Zebo");
        WebElement lastName= driver.findElement(By.id("lastName"));
        lastName.sendKeys("Saburova");
        WebElement gender= driver.findElement(By.id("femalerb"));
        gender.click();
        WebElement language=driver.findElement(By.id("englishchbx"));
        language.click();
        WebElement email= driver.findElement(By.id("email"));
        email.sendKeys("Zebo@gmail.com");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("1234");
        WebElement registerButton= driver.findElement(By.id("registerbtn"));
        registerButton.click();
        Thread.sleep(2000);
        WebElement text=driver.findElement(By.cssSelector("#msg"));
        String actual=text.getText();
        String expected="Registration is Successful";
        Assert.assertEquals(actual, expected);
        BrowserUtils.switchByTitle(driver, "Window");
        Thread.sleep(2000);
        WebElement header= driver.findElement(By.xpath("//h1[@class='post-title entry-title'] "));
        String actualHeader=header.getText().trim();
        String expectedHeader="Window Handles Practice".trim();
        Assert.assertEquals(actualHeader, expectedHeader);
        BrowserUtils.switchByTitle(driver, "AlertsDemo");
        Thread.sleep(2000);
        WebElement box= driver.findElement(By.id("promptBox"));
        box.click();
        Thread.sleep(2000);
        driver.quit();


    }
}
