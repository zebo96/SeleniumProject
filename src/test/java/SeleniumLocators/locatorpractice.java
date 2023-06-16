package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.i18nformatter.qual.I18nFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class locatorpractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement element=driver.findElement(By.name("firstname"));
        element.sendKeys("Zebo");

        WebElement element1= driver.findElement(By.name("lastname"));
        element1.sendKeys("Saburova");

        WebElement element2= driver.findElement(By.id("sex-1"));
        if (element2.isDisplayed() && !element2.isSelected());{
        element2.click();
        }

        WebElement exp= driver.findElement(By.id("exp-0"));
        if (exp.isDisplayed() && !exp.isSelected());{
        exp.click();
        }

        WebElement date= driver.findElement(By.id("datepicker"));
        date.sendKeys("05/17/2023");

        WebElement profession= driver.findElement(By.id("profession-0"));
        if (profession.isDisplayed() && !profession.isSelected()); {
        profession.click();
        }

        WebElement profession2=driver.findElement(By.id("profession-1"));
        if (profession2.isDisplayed() && !profession2.isSelected()); {
        profession2.click();
        }

        WebElement aTools= driver.findElement(By.id("tool-2"));
        if (aTools.isDisplayed() && !aTools.isSelected()); {
            aTools.click();
        }
        WebElement cont= driver.findElement(By.className("input-xlarge"));
        cont.sendKeys("Asia");

        WebElement button= driver.findElement(By.id("submit"));
        button.click();


    }
}
