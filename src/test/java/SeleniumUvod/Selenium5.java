package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

// //Potrebno je preko Gugla naci stranicu Wikipedije o Nikoli Tesli na cirilici

public class Selenium5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();

        WebElement tlp = driver.findElement(By.linkText("Test Login Page"));
        tlp.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("Password123");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement button = driver.findElement(By.linkText("Log out"));
        button.click();

        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualURL);

    }
}
