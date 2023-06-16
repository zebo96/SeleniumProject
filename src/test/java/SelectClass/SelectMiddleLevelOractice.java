package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectMiddleLevelOractice {
    @Test
    public void validateOrderMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengers=driver.findElement(By.xpath("//select[@name='passCount']"));
        Select choice=new Select(passengers);
        choice.selectByVisibleText("4");
        WebElement from= driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select choice2=new Select(from);
        String actual=choice2.getFirstSelectedOption().getText().trim();
        String expected="Acapulco".trim();
        Assert.assertEquals(actual,expected);
        WebElement date= driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select choice3=new Select(date);
        choice3.selectByValue("8");
        WebElement day=driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select choice4=new Select(day);
        choice4.selectByValue("15");
        WebElement destination= driver.findElement(By.xpath("//select[@name='toPort']"));
        Select choice5=new Select(destination);
        choice5.selectByValue("Paris");
        WebElement returnDate= driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select choice6=new Select(returnDate);
        choice6.selectByValue("12");
        WebElement returnDay= driver.findElement(By.xpath("//select[@name='toDay']"));
        Select choice7=new Select(returnDay);
        choice7.selectByValue("15");
        WebElement firstClass= driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        WebElement airline= driver.findElement(By.xpath("//select[@name='airline']"));
        Select choice8=new Select(airline);
        choice8.selectByVisibleText("Unified Airlines".trim());
        Thread.sleep(3000);
        WebElement cont= driver.findElement(By.xpath("//input[@name='findFlights']"));
        cont.click();
        WebElement text= driver.findElement(By.xpath("//font[@size='4']"));
        Assert.assertEquals(text,"After flight finder - No Seats Available".trim());






    }
    public void validateOrderMessageShortCut() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
       // Select choice = new Select(passengers);
       // choice.selectByVisibleText("4");
        BrowserUtils.selectBy(passengers,"4","value");


        WebElement from = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select choice2 = new Select(from);
        String actual = choice2.getFirstSelectedOption().getText().trim();
        String expected = "Acapulco".trim();
        Assert.assertEquals(actual, expected);
        WebElement date = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        //Select choice3 = new Select(date);
        //choice3.selectByValue("8");
        BrowserUtils.selectBy(date,"8","value");
        WebElement day = driver.findElement(By.xpath("//select[@name='fromDay']"));
        //Select choice4 = new Select(day);
        //choice4.selectByValue("15");
        BrowserUtils.selectBy(day,"15", "value");
        WebElement destination = driver.findElement(By.xpath("//select[@name='toPort']"));
        //Select choice5 = new Select(destination);
        //choice5.selectByValue("Paris");
        BrowserUtils.selectBy(destination, "Paris","text");
        WebElement returnDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        //Select choice6 = new Select(returnDate);
        //choice6.selectByValue("12");
        BrowserUtils.selectBy(returnDate,"12","value");
        WebElement returnDay = driver.findElement(By.xpath("//select[@name='toDay']"));
       // Select choice7 = new Select(returnDay);
       // choice7.selectByValue("15");
        BrowserUtils.selectBy(returnDay,"15","value");
        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select choice8 = new Select(airline);
        choice8.selectByVisibleText("Unified Airlines".trim());
        Thread.sleep(3000);
        WebElement cont = driver.findElement(By.xpath("//input[@name='findFlights']"));
        cont.click();
        WebElement text = driver.findElement(By.xpath("//font[@size='4']"));
        Assert.assertEquals(BrowserUtils.getText(text), "After flight finder - No Seats Available");
    }
}
