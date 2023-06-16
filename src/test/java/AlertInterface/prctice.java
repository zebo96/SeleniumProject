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

public class prctice {
    @Test
    public void alertPractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://hyrtutorials.com/p/alertsdemo.html");

        WebElement button1= driver.findElement(By.cssSelector("#alertBox"));
        button1.click();
        Alert alert=driver.switchTo().alert();
        String actualText1= alert.getText().trim();
        String expectedText1="I am an alert box!";
        Assert.assertEquals(actualText1, expectedText1);
        alert.accept();
        WebElement output1= driver.findElement(By.cssSelector("#output"));
        String expectedOutput1="You selected alert popup";
        Assert.assertEquals(BrowserUtils.getText(output1), expectedOutput1);

        WebElement button2= driver.findElement(By.cssSelector("#confirmBox"));
        button2.click();
        Alert alert2=driver.switchTo().alert();
        String actualText2=alert2.getText().trim();
        String expectedText2="Press a button!";
        Assert.assertEquals(actualText2, expectedText2);
        alert.dismiss();
        WebElement output2= driver.findElement(By.cssSelector("#output"));
        String expectedOutput2="You pressed Cancel in confirmation popup";
        Assert.assertEquals(BrowserUtils.getText(output2), expectedOutput2);

        WebElement button3= driver.findElement(By.cssSelector("#promptBox"));
        button3.click();
        Alert alert3=driver.switchTo().alert();
        alert3.sendKeys("Zebo");
        alert3.accept();
        WebElement output3= driver.findElement(By.cssSelector("#output"));
        String expectedOutput3="You entered text Zebo in propmt popup";
        Assert.assertEquals(BrowserUtils.getText(output3), expectedOutput3);


    }
}
