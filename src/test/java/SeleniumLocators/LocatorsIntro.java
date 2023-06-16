package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    public static void main(String[] args) {
        //Locators is a way to locate(find) element and manipulate on it
        // ID Locator:
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.navigate().to("copy,paste url address");
        driver.manage().window().maximize();
        WebElement header = driver.findElement(By.id("provide unique id "));
        String actualHeader = header.getText(); // it gets the text from element
        String expectedHeader=" copy,paste the name of the element";
        System.out.println(actualHeader.equals(expectedHeader) ? "CORRECT" : "WRONG");

        // NAME Locator
        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Zebo");

        // CLASS Locator
        WebElement allTools=driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());
        WebElement javaBox=driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected());
        {
            javaBox.click();
        }
        System.out.println(javaBox.isDisplayed()? "SELECTED" : "nOT SELECTED");

        // TAG NAME Locator
        WebElement header2=driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());






    }




}
