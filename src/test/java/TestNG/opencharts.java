package TestNG;

import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class opencharts {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(ConfigReader.readProperty("QA_url"));

        WebElement name=driver.findElement(By.id("input-username"));
        name.sendKeys(ConfigReader.readProperty("QA-openChart_username"));
        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys(ConfigReader.readProperty("QA_openChart_password"));
        WebElement login= driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(2000);
        String actt=driver.getTitle();
        String expt="Dashboard";
        Assert.assertEquals(actt,expt);

    }
    @Test
    public void negativeTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement name=driver.findElement(By.id("input-username"));
        name.sendKeys("demo");
        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("DEMO");
        WebElement login= driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(2000);
        WebElement error= driver.findElement(By.cssSelector(".alert-dismissible"));
        System.out.println(error.getText());




    }
@Test
    public void newTask() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options=new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    WebDriver driver=new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.navigate().to("https://demo.opencart.com/admin/");

    WebElement name=driver.findElement(By.id("input-username"));
    name.sendKeys("demo");
    WebElement password= driver.findElement(By.id("input-password"));
    password.sendKeys("demo");
    WebElement login= driver.findElement(By.tagName("button"));
    login.click();
    WebElement exit=driver.findElement(By.cssSelector(".btn-close"));
    exit.click();
    WebElement catalog= driver.findElement(By.cssSelector(".fa-tag"));
    catalog.click();
    Thread.sleep(2000);
    WebElement product=driver.findElement(By.linkText("Products"));
    System.out.println(product.getText());
    String actualName= product.getText();
    String expName="Products";
    Assert.assertEquals(actualName,expName);
    Assert.assertTrue(product.isDisplayed());
    Assert.assertTrue(product.isEnabled());


}
@Test
    public void validateBoxesFunctionality() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options=new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    WebDriver driver=new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.navigate().to("https://demo.opencart.com/admin/");

    WebElement name=driver.findElement(By.id("input-username"));
    name.sendKeys("demo");
    WebElement password= driver.findElement(By.id("input-password"));
    password.sendKeys("demo");
    WebElement login= driver.findElement(By.tagName("button"));
    login.click();
    WebElement exit=driver.findElement(By.cssSelector(".btn-close"));
    exit.click();
    WebElement catalog= driver.findElement(By.cssSelector(".fa-tag"));
    catalog.click();
    Thread.sleep(2000);
    WebElement product=driver.findElement(By.linkText("Products"));
    product.click();
    Thread.sleep(2000);

    List<WebElement> allBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
    for (int i=1; i<allBoxes.size();i++){
        Thread.sleep(2000);
        Assert.assertTrue(allBoxes.get(i).isDisplayed());
        Assert.assertTrue(allBoxes.get(i).isEnabled());
        Assert.assertFalse(allBoxes.get(i).isSelected());
        allBoxes.get(i).click();
        Assert.assertTrue(allBoxes.get(i).isSelected());
        allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);

    }


}
@Test
    public void validateProductButtonAscendingOrder() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options=new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    WebDriver driver=new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.navigate().to("https://demo.opencart.com/admin/");
    WebElement name=driver.findElement(By.id("input-username"));
    name.sendKeys("demo");
    WebElement password= driver.findElement(By.id("input-password"));
    password.sendKeys("demo");
    WebElement login= driver.findElement(By.tagName("button"));
    login.click();
    WebElement exit=driver.findElement(By.cssSelector(".btn-close"));
    exit.click();
    WebElement catalog= driver.findElement(By.cssSelector(".fa-tag"));
    catalog.click();
    Thread.sleep(2000);
    WebElement product=driver.findElement(By.linkText("Products"));
    product.click();
    Thread.sleep(2000);

    List<WebElement> allProducts=driver.findElements(By.xpath("//td[@class='text-start']"));

    List<String> actualProductOrder=new ArrayList<>();
    List<String> expectedProductOrder=new ArrayList<>();

    for (int i=1; i< allProducts.size(); i++){
        actualProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());
        expectedProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());

    }
    Collections.sort(expectedProductOrder);
    System.out.println(actualProductOrder);
    System.out.println(expectedProductOrder);
    Assert.assertEquals(actualProductOrder,expectedProductOrder);






}
@Test
public void validateDescendingOrder() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options=new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    WebDriver driver=new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.navigate().to("https://demo.opencart.com/admin/");
    WebElement name=driver.findElement(By.id("input-username"));
    name.sendKeys("demo");
    WebElement password= driver.findElement(By.id("input-password"));
    password.sendKeys("demo");
    WebElement login= driver.findElement(By.tagName("button"));
    login.click();
    WebElement exit=driver.findElement(By.cssSelector(".btn-close"));
    exit.click();
    WebElement catalog= driver.findElement(By.cssSelector(".fa-tag"));
    catalog.click();
    Thread.sleep(2000);
    WebElement product=driver.findElement(By.linkText("Products"));
    product.click();
    Thread.sleep(2000);
    WebElement productName= driver.findElement(By.xpath("//a[.='Product Name']"));
    productName.click();
    Thread.sleep(3000);
    List<WebElement> allProducts=driver.findElements(By.xpath("//td[@class='text-start']"));

    List<String> actualProductOrder=new ArrayList<>();
    List<String> expectedProductOrder=new ArrayList<>();


    for (int i=1; i< allProducts.size(); i++){
        actualProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());
        expectedProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());

    }
    Collections.sort(expectedProductOrder);
    Collections.reverse(expectedProductOrder);
    System.out.println(actualProductOrder);
    System.out.println(expectedProductOrder);
    Assert.assertEquals(actualProductOrder,expectedProductOrder);

}
}
