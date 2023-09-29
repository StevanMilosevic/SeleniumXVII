package zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

// ispitati funkcionalnost logovanja na strani: https://practicetestautomation.com/

public class Zadatak4 {
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

        String title = "Logged In Successfully";
        WebElement logInTitle = driver.findElement(By.className("post-title"));
        String actualTitle = logInTitle.getText();
        Assert.assertEquals(title, actualTitle);

        WebElement text = driver.findElement(By.className("has-text-align-center"));
        String expectedText = "Congratulations student. You successfully logged in!";
        String actualText = text.getText();
        Assert.assertEquals(actualText, expectedText);

        WebElement button = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(button.isDisplayed());

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

    }
}
