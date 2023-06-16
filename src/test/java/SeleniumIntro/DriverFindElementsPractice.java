package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Duration;
import java.util.List;

public class DriverFindElementsPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> links=driver.findElements(By.tagName("li"));
        int counter=0;
        for (WebElement link:links){
            System.out.println(link.getText());
            counter++;
        }
        System.out.println(counter);

        //Task2
        //Print it if length is equal amd more than 12 and count how many
        int counter2=0;
        for (WebElement link:links) {
            if (link.getText().length()>=12){
                System.out.println(link.getText());
                counter2++;
            }

        }
        System.out.println(counter2);


    }
}
