package zadaci;

// ispitati funkcionalnost log outa sa strane: https://practicetestautomation.com/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("Никола Тесла");

        Thread.sleep(2000);
        WebElement searchButton = driver.findElement(By.className("gNO89b"));
        searchButton.click();

        WebElement wikiLink = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        wikiLink.click();

        String expectedURL = "https://sr.wikipedia.org/sr-ec/%D0%9D%D0%B8%D0%BA%D0%BE%D0%BB%D0%B0_%D0%A2%D0%B5%D1%81%D0%BB%D0%B0";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        String expectedTitle = "Никола Тесла";
        WebElement pageTitle = driver.findElement(By.className("mw-page-title-main"));
        String actualTitle = pageTitle.getText();
        Assert.assertEquals(expectedTitle, actualTitle);

        WebElement pageImage = driver.findElement(By.className("mw-file-element"));
        Assert.assertTrue(pageImage.isDisplayed());

    }
}
