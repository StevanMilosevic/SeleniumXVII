package domaciPonedeljak;

// Domaci Zadatak 2:
//https://demoqa.com/text-box napisati test case za dati text box

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box/");
        String userName = "Pera Peric";
        String userEmail = "perin@mejl.com";
        String trenutnaAdresa = "Kralja Petra 16";
        String stalnaAdresa = "Cara Dusana 15";

        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys(userName);

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys(userEmail);

        WebElement currAddress = driver.findElement(By.id("currentAddress"));
        currAddress.sendKeys(trenutnaAdresa);

        WebElement permAddr = driver.findElement(By.id("permanentAddress"));
        permAddr.sendKeys(stalnaAdresa);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)","");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement displayDiv = driver.findElement(By.cssSelector(".border.col-md-12.col-sm-12"));

        WebElement divUser = driver.findElement(By.id("name"));
        String actualUserText = divUser.getText();
        String expectedUserText = "Name:" + userName;

        WebElement divEmail = driver.findElement(By.id("email"));
        String actualUserEmail = divEmail.getText();
        String expectedUserEmail = "Email:" + userEmail;

        WebElement divCurr = driver.findElement(By.cssSelector("div[id*='output'] p:nth-child(3)"));
        String actualCurr = divCurr.getText();
        String expectedCurrAdd = "Current Address :" + trenutnaAdresa;

        WebElement divPerm1 = driver.findElement(By.cssSelector("div[id*='output'] p:nth-child(4)"));
        String actualPerm = divPerm1.getText();
        String expectedPermAddress = "Permananet Address :" + stalnaAdresa;

        Assert.assertTrue(displayDiv.isDisplayed());
        Assert.assertEquals(actualUserText, expectedUserText);
        Assert.assertEquals(actualUserEmail, expectedUserEmail);
        Assert.assertEquals(actualCurr, expectedCurrAdd);
        Assert.assertEquals(actualPerm, expectedPermAddress);
    }
}
