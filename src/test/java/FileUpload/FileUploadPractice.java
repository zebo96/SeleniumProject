package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile=driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("C:\\Users\\Kiruxa\\Desktop\\images.jpg");
        WebElement uploadButton= driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.click();
        Thread.sleep(3000);
        WebElement text= driver.findElement(By.cssSelector("#uploaded-files"));
        System.out.println(BrowserUtils.getText(text));

    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/upload/");

        WebElement chooseFile= driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("C:\\Users\\Kiruxa\\Desktop\\images.jpg");
        WebElement acceptButton= driver.findElement(By.cssSelector("#terms"));
        acceptButton.click();
        WebElement text1= driver.findElement(By.xpath("//b[.='Select file to send(max 196.45 MB)']"));
        String expected1="Select file to send(max 196.45 MB)";
        Assert.assertEquals(BrowserUtils.getText(text1), expected1);
        WebElement submitButton= driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();
        Thread.sleep(2000);
        WebElement text2= driver.findElement(By.xpath("//h3//center"));
        String expected2="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(BrowserUtils.getText(text2), expected2);
        System.out.println(BrowserUtils.getText(text2));
    }
}
