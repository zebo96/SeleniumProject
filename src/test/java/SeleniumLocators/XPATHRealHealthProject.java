package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHRealHealthProject {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeapp= driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeapp.click();
        WebElement name= driver.findElement(By.xpath("//input[@id='txt-username']"));
        name.sendKeys("John Doe");
        WebElement password= driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement login= driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();
        WebElement select= driver.findElement(By.xpath("//select[@id='combo_facility']"));
        select.sendKeys("Seoul CURA Healthcare Center");
        WebElement apply= driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (apply.isDisplayed() && !apply.isSelected());
        apply.click();
        WebElement program= driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        program.click();
        WebElement date= driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("03/05/2023");
        WebElement comment= driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("I would like to make an appointment");
        WebElement button= driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        button.click();
        WebElement header= driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        String actHeader= header.getText().trim();
        String expectedHeader = "Appointment Confirmation";
        if (actHeader.equals(expectedHeader)){

            System.out.println("Passed");
        } else{
            System.out.println("Failed");
        }
        WebElement fac= driver.findElement(By.xpath("//p[@id='facility']"));
        System.out.println(fac.getText());
        WebElement app= driver.findElement(By.xpath("//p[@id='hospital_readmission']"));
        System.out.println(app.getText());
        WebElement health= driver.findElement(By.xpath("//p[@id='program']"));
        System.out.println(health.getText());
        WebElement visit= driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println(visit.getText());
        WebElement com= driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println(com.getText());
        WebElement go= driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        go.click();
        driver.quit();




    }
}
