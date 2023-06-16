package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoodReadsXPATHPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.goodreads.com/ap/register?language=en_US&openid.assoc_handle=amzn_goodreads_web_na&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.return_to=https%3A%2F%2Fwww.goodreads.com%2Fap-handler%2Fregister&siteState=23afd14440cf7725203792f7e8a301e2");

      WebElement name= driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
      name.sendKeys("Zebo");
      WebElement email= driver.findElement(By.xpath("//input[@id='ap_email']"));
      email.sendKeys("zebo9402@gmail.com");
      WebElement password= driver.findElement(By.xpath("//input[@id='ap_password']"));
      password.sendKeys("123456");
      WebElement confirm= driver.findElement(By.xpath("//input[@id='ap_password_check']"));
      confirm.sendKeys("123456");


    }
}
