package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement button= driver.findElement(By.xpath("//a[.='Click Here']"));
        button.click();
        Thread.sleep(2000);
        WebElement text= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(text));
        System.out.println(driver.getWindowHandle()); //main pageID-->The Internet
        String mainPageID= driver.getWindowHandle();
        Set<String> allPagesID=driver.getWindowHandles();
        for (String id:allPagesID){
            if (!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        text= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(text));
    }
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button= driver.findElement(By.cssSelector("#newTabBtn"));
        button.click();
        String mainPageID= driver.getWindowHandle();
        Set<String> allPagesID=driver.getWindowHandles();
        for (String id:allPagesID){
            if (!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        Thread.sleep(2000);
        WebElement header= driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String actual=header.getText();
        String expected="AlertsDemo";
        Assert.assertEquals(actual,expected);
        String ActualTitle= driver.getTitle().trim();
        String expectedTitle="AlertsDemo - H Y R Tutorials".trim();
        Assert.assertEquals(ActualTitle, expectedTitle);
        WebElement newButton= driver.findElement(By.cssSelector("#alertBox"));
        BrowserUtils.clickWithJS(driver, newButton);



    }
}
