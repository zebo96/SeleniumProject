package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName= driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Zebo");
        WebElement lastName= driver.findElement(By.xpath("//input[@id= 'input-lastname'] "));
        lastName.sendKeys("Saburova");
        WebElement email= driver.findElement(By.xpath("//input[@id= 'input-email'] "));
        email.sendKeys("zebo9402@email.com");
        WebElement phone= driver.findElement(By.xpath("//input[@id=  'input-telephone']"));
        phone.sendKeys("1234567890");
        WebElement password=driver.findElement(By.xpath("//input[@id=  'input-password'] "));
        password.sendKeys("1234");
        WebElement confirm= driver.findElement(By.xpath("//input[@id= 'input-confirm']"));
        confirm.sendKeys("1234");
        Thread.sleep(3000);
        WebElement checkbox= driver.findElement(By.xpath("//input[@name=  'agree'] "));
        checkbox.click();
        WebElement button= driver.findElement(By.xpath("//input[@value= 'Continue'] "));
        button.click();




    }
}
