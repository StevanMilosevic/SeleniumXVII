package zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Zadatak9 {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();

        WebElement tlp = driver.findElement(By.linkText("Test Login Page"));
        tlp.click();

        WebElement usernameFild = driver.findElement(By.id("username"));
        usernameFild.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement errorMsg = driver.findElement(By.id("error"));
        String expectedMsg = "Your password is invalid!";

        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertEquals(errorMsg.getText(), expectedMsg);


    }
}
