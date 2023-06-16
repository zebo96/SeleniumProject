package ActionsClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.archivers.zip.X0017_StrongEncryptionHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class dragAndDrop {
    @Test
    public void dragAndDropMethods() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        Actions actions=new Actions(driver);
        actions.scrollByAmount(200,200).perform();
        WebElement orangeBox= driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actualMessage= BrowserUtils.getText(orangeBox);
        String expectedMessage="... Or here.";
        Assert.assertEquals(actualMessage, expectedMessage);

        String actualColor=orangeBox.getCssValue("background-color");
        String expectedColor="rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualColor, expectedColor);

        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        Thread.sleep(3000);
        actions.dragAndDrop(draggable,orangeBox).perform();

        Thread.sleep(3000);
        orangeBox= driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actualAfterDragAndDrop=BrowserUtils.getText(orangeBox);
        String expectedAfterDragAndDrop="You did great!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);



    }
    @Test
    public void DragAndDropPractice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement blueBox= driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessage=BrowserUtils.getText(blueBox);
        String expectedMessage=BrowserUtils.getText(blueBox);
        Assert.assertEquals(actualMessage, expectedMessage);

        String actualColor=blueBox.getCssValue("background-color").trim();
        String expectedColor="rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor, expectedColor);

        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();

        Thread.sleep(3000);
        blueBox.getCssValue("background-color").trim();
        String actualAfterDragAndDrop=BrowserUtils.getText(blueBox);
        String expectedAfterDragAndDrop="You did great!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);


    }
}
