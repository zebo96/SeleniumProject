package ActionsClass;

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

public class PracticeActions {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement box= driver.findElement(By.id("droppable"));
        String actualText= BrowserUtils.getText(box).trim();
        String expectedText="Drop here";
        Assert.assertEquals(actualText, expectedText);

        WebElement draggable= driver.findElement(By.id("draggable"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(box).release().perform();

        Thread.sleep(3000);
        String actualText2=BrowserUtils.getText(box).trim();
        String expectedText2="Dropped!";
        Assert.assertEquals(actualText2, expectedText2);

        String actualColor= box.getCssValue("background-color").trim();
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor, expectedColor);
    }
    @Test
    public void ClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement accept= driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        accept.click();

        WebElement notAcceptable= driver.findElement(By.cssSelector("#notAcceptable"));
        String actualText=BrowserUtils.getText(notAcceptable).trim();
        String expectedText="Not Acceptable";
        Assert.assertEquals(actualText, expectedText);

        WebElement dropHere= driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        String actualText2=BrowserUtils.getText(dropHere).trim();
        String expectedText2="Drop here";
        Assert.assertEquals(actualText2, expectedText2);

        Actions actions=new Actions(driver);
        actions.clickAndHold(notAcceptable).moveToElement(dropHere).release().perform();

        Thread.sleep(3000);
        dropHere= driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        String actualText3=BrowserUtils.getText(dropHere).trim();
        String expectedText3="Drop here";
        Assert.assertEquals(actualText3, expectedText3);


    }
}
