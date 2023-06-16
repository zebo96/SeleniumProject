package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class HTMLAndJSPractice {
    @Test
    public void practiceBoth() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://sweetalert.js.org/");
        WebElement preview1=driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        preview1.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        WebElement preview2= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        preview2.click();
        Thread.sleep(3000);
        WebElement title= driver.findElement(By.xpath("//div[@class='swal-title']"));
        System.out.println(BrowserUtils.getText(title));
        WebElement text=driver.findElement(By.xpath("//div[@class='swal-text']"));
        System.out.println(BrowserUtils.getText(text));
        WebElement okButton=driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        okButton.click();

    }
}
