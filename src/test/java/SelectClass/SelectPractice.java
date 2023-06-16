package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SelectPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/Kiruxa/Downloads/Techtorial%20(1).html");
        Thread.sleep(3000);
        WebElement button= driver.findElement(By.xpath("//select[@name='country']"));
        Select choice=new Select(button);
        String actual=choice.getFirstSelectedOption().getText().trim();
        String expected="UNITED STATES";
        Assert.assertEquals(actual,expected);

        List<WebElement> list=choice.getOptions();
        int counter=0;
        for (WebElement country:list){
            System.out.println(country.getText().trim());
            counter++;
        }
        System.out.println(counter);

        Thread.sleep(2000);
        choice.selectByVisibleText("UZBEKISTAN ".trim());
        Thread.sleep(2000);
        choice.selectByValue("4");
        Thread.sleep(2000);
        choice.selectByIndex(12);









    }
}
