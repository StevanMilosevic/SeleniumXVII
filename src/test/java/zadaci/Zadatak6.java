package zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement logInButton = driver.findElement(By.linkText("Log In"));
        logInButton.click();

        //Sleepers - ceka dok se ne zavrsi cekanje (bilo 3, 5 ili 10 sekundi) i ceka do kraja bilo da se element pojavi ili ne
        //Implicit wait - ceka odredjeno vreme dok ne baci "NoElementFound" Exception (ali ce cekati najvise onoliko vremena koliko prosledite - ovde je to 10 sekundi)
        //Explicit wait - ceka dok se ne ispuni zadat uslov (ali ce cekati najvise onoliko vremena koliko prosledite u objektu - ovde je to 5 sekundi)
        //Fluent wait

        String validUsername = "dragoljubqa";
        String validPassword = "Swordfish123!@#";
        WebElement usernameField = driver.findElement(By.id("usernameOrEmail"));
        usernameField.clear();
        usernameField.sendKeys(validUsername);

        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton.click();

        //Thread.sleep(10000);
        //Imao sam cekanje zato sto password polje se nije odmah pojavilo, ali je ovde pomogao implicit wait
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(validPassword);

        continueButton.click();
        //Thread.sleep(10000);
        //Imao sam cekanje zato sto sam cekao da se ulogujem i to gledam po URL-u
        //Ovde koristim explicit wait gde program ceka dok URL ne bude kao ovaj prosledjen

        wait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/dragoljubqa.wordpress.com"));

        //Posto imam cekanje za URL onda mogu da uklonim assert gde proveravam URL
        //Jer iako URL nije dobar meni ce svakako test da padne ovde
        /*String expectedURL = "https://wordpress.com/home/dragoljubqa.wordpress.com";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);*/

        WebElement profileButton = driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me"));
        profileButton.click();
        //Thread.sleep(10000);
        //Implicit wait je i ovde pomogao da ne moram da cekam element

        WebElement profileName = driver.findElement(By.className("profile-gravatar__user-display-name"));
        String profileNameText = profileName.getText();

        Assert.assertEquals(profileNameText, validUsername);

        WebElement logoutButton = driver.findElement(By.className("sidebar__me-signout-text"));
        Assert.assertTrue(logoutButton.isDisplayed());


    }
}