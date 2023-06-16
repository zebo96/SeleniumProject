package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement name= driver.findElement(By.xpath("//input[@id='userName']"));
        name.sendKeys("Zebo Saburova");

        WebElement email= driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("zebo9402@gmail.com");
        WebElement currentAddress= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("1181 E Randville Drive Palatine IL");
        WebElement permanentAddress= driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("1181 E Randville Drive Palatine IL");
        WebElement submit= driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();
        WebElement name2= driver.findElement(By.xpath("//p[@class='mb-1']"));
        String actualn= name2.getText().trim();
        String expectedn="Name:Zebo Saburova";
        System.out.println(actualn.equals(expectedn) ? "Passed" : "Failed");
        WebElement email2= driver.findElement(By.xpath("//p[@id='email']"));
        String actemail=email2.getText().trim();
        String expectedemail="Email:zebo9402@gmail.com";
        System.out.println(actemail.equals(expectedemail) ? "Passed" : "Failed");
        WebElement caddr= driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String actcaddr= caddr.getText().trim();
        String expcaddr="Current Address :1181 E Randville Drive Palatine IL";
        System.out.println(actcaddr.equals(expcaddr) ? "Passed" : "Failed");
        WebElement peraddr= driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String actperaddr=peraddr.getText().trim();
        String expperaddr="Permananet Address :1181 E Randville Drive Palatine IL";
        System.out.println(actperaddr.equals(expperaddr) ? "Passed" : "Failed");
        driver.quit();


    }
}
