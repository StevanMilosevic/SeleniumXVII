package zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WordpressLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");

        WebElement logIn = driver.findElement(By.linkText("Log In"));
        logIn.click();

        WebElement username = driver.findElement(By.id("usernameOrEmail"));
        username.clear();
        username.sendKeys("bleksteva");

        WebElement button = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        button.click();

        Thread.sleep(2000);
        WebElement pass = driver.findElement(By.id("password"));
        pass.clear();
        pass.sendKeys("vlaskiCarobnjak");

        button.click();

        Thread.sleep(4000);

        WebElement header = driver.findElement(By.className("masterbar__item-content"));

        WebElement span = driver.findElement(By.cssSelector("div.following__intro-copy > span"));
        String expectedText = "Welcome! Reader is a custom magazine. Follow your favorite sites and their latest posts will appear here. Read, like, and comment in a distraction-free environment.";
        String actualText = span.getText();

        WebElement write = driver.findElement(By.className("masterbar__item-content"));

        WebElement myProfile = driver.findElement(By.className("gravatar masterbar__item-me-gravatar"));
        myProfile.click();

        Assert.assertTrue(header.isDisplayed());
        Assert.assertEquals(actualText, expectedText);
        Assert.assertTrue(write.isDisplayed());


    }
}
