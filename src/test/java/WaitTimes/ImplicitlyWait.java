package WaitTimes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitlyWait {
    //We store under DriverHelper and here is the syntax:
    //This works for all webElements you are looking under your page
    @Test
    public void implicitlyWait(){
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
