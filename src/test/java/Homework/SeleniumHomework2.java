package Homework;

import Utils.BrowserUtils;
import com.google.gson.internal.bind.util.ISO8601Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v110.css.model.Value;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeleniumHomework2 {
    @Test
    public void HomeworkCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String expectedTitle="Web Orders Login";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        WebElement name= driver.findElement(By.id("ctl00_MainContent_username"));
        name.sendKeys("Tester");
        WebElement password= driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement button= driver.findElement(By.id("ctl00_MainContent_login_button"));
        button.click();
        Thread.sleep(2000);
        String expectedTitle1="Web Orders";
        Assert.assertEquals(driver.getTitle(), expectedTitle1);
        WebElement Header= driver.findElement(By.tagName("h2"));
        String expectedHeader="List of All Orders";
        Assert.assertEquals(BrowserUtils.getText(Header), expectedHeader);




    }
    @Test
    public void Case2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement name= driver.findElement(By.id("ctl00_MainContent_username"));
        name.sendKeys("Tester");
        WebElement password= driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement button= driver.findElement(By.id("ctl00_MainContent_login_button"));
        button.click();
        Thread.sleep(2000);

        WebElement button2= driver.findElement(By.xpath("//a[.='View all products']"));
        button2.click();
        Thread.sleep(2000);
       // Assert.assertTrue(button2.isSelected());
        WebElement header=driver.findElement(By.tagName("h2"));
        String expectedheader="List of Products".trim();
        Assert.assertEquals(BrowserUtils.getText(header), expectedheader);
        Assert.assertTrue(driver.getCurrentUrl().contains("Products"));


    }
    @Test
    public void case3(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement name= driver.findElement(By.id("ctl00_MainContent_username"));
        name.sendKeys("Tester");
        WebElement password= driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement button= driver.findElement(By.id("ctl00_MainContent_login_button"));
        button.click();

       // List<WebElement> links=driver.findElements(By.xpath("//li//a"));
        // List<String> actual=new ArrayList<>();
       // List<String> expected= Arrays.asList("Default.aspx","Products.aspx","Process.aspx".trim());
       // Actions actions=new Actions(driver);
       // for (WebElement link:links){
          //  actions.moveToElement(link).perform();
         ///   String data= link.getAttribute("href");


     //   }

        WebElement links= driver.findElement(By.cssSelector("#ctl00_menu"));





    }
    @Test
    public void case4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement name= driver.findElement(By.id("ctl00_MainContent_username"));
        name.sendKeys("Tester");
        WebElement password= driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement button= driver.findElement(By.id("ctl00_MainContent_login_button"));
        button.click();
        WebElement orderButton= driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();
        WebElement product= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        Select choice=new Select(product);
        choice.selectByValue("ScreenSaver");
        WebElement quantity= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.clear();
        quantity.sendKeys("5");
        WebElement customerName=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        WebElement city= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement state= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        WebElement zip= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");
        WebElement mastercard= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        mastercard.click();
        WebElement cardNumber= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");
        WebElement expiration= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expiration.sendKeys("03/24");
        WebElement processButton= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();
        Thread.sleep(2000);
        WebElement text= driver.findElement(By.tagName("strong"));
        Assert.assertTrue(text.isDisplayed());
        WebElement view= driver.findElement(By.xpath("//a[.='View all orders']"));
        view.click();
        Thread.sleep(2000);
        WebElement newOrder= driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
        Assert.assertTrue(newOrder.isDisplayed());
        WebElement expectedName= driver.findElement(By.xpath("//tr//td[.='CodeFish IT School']"));
        String actualCustomerName=BrowserUtils.getText(expectedName);
        String expectedCustomerName="CodeFish IT School";
        Assert.assertEquals(actualCustomerName, expectedCustomerName);






    }

}
