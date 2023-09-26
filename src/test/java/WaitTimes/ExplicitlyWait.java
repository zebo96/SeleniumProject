package WaitTimes;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitlyWait {
    @Test
    public void validateTheText(){
        WebDriver driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton=driver.findElement(By.tagName("button"));
        startButton.click();
        WebElement text= driver.findElement(By.xpath("//div[@id='finish']//h4"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        text=wait.until(ExpectedConditions.visibilityOf(text));
        Assert.assertEquals(BrowserUtils.getText(text),"Hello World!");
    }
    @Test
    public void DynamicControls(){
        WebDriver driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
        WebElement removeButton= driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();
        WebElement text= driver.findElement(By.xpath("//p[@id='message']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        text=wait.until(ExpectedConditions.visibilityOf(text));
        Assert.assertEquals(BrowserUtils.getText(text),"It's gone!");
    }
}
