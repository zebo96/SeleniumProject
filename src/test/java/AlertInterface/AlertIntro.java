package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void AlertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert= driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();
        Alert alert=driver.switchTo().alert();
        String actual=alert.getText().trim();
        String expected="I am a JS Alert";
        Assert.assertEquals(actual,expected);
        alert.accept(); //will click ok button
        WebElement message= driver.findElement(By.cssSelector("#result"));
        String actualm= BrowserUtils.getText(message);
        String expectedm="You successfully clicked an alert";
        Assert.assertEquals(actualm, expectedm);
    }
    @Test
    public void alertDismiss(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsConfirm= driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConfirm.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        WebElement message= driver.findElement(By.cssSelector("#result"));
        String actual=BrowserUtils.getText(message);
        String expected="You clicked: Cancel";
        Assert.assertEquals(actual, expected);

    }
    @Test
    public void alertSendKeys(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPrompt= driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt')]"));
        jsPrompt.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Homework is important");
        alert.accept();
        WebElement message= driver.findElement(By.cssSelector("#result"));
        String actual=BrowserUtils.getText(message);
        String expected="You entered: Homework is important";
        Assert.assertEquals(actual, expected);
    }
}
