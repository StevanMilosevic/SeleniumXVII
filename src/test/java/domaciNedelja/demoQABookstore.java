package domaciNedelja;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application) preko cookies-a, dodati dve knjige
// na svoj nalog, zatim se izlogovati brisanjem cookies-a.
// Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.

public class demoQABookstore {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        Cookie cookie1 = new Cookie("userID", "0ddacf37-014c-4c33-9402-cc271bc6a7cb");
        Cookie cookie2 = new Cookie("userName", "bleksteva");
        Cookie cookie3a = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImJsZWtzdGV2YSIsInBhc3N3b3JkIjoiR29sdWJhYy0wMTIhIiwiaWF0IjoxNjk1OTg3Mzc1fQ.wdUP90OjhjFrSv3EyxdhDEwpBoxYs2XWaIpQIN7NzFY");
        Cookie cookie3 = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImJsZWtzdGV2YSIsInBhc3N3b3JkIjoiR29sdWJhYy0wMTIhIiwiaWF0IjoxNjk1OTk4MTM4fQ.C0-5UTV_acMxp919RAi8bCmI1LhG5jsQH1lObN5krPo");

        Cookie cookie4 = new Cookie("expires", "2023-10-06T11%3A54%3A10.261Z");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        driver.manage().addCookie(cookie4);

        driver.navigate().refresh();
        driver.navigate().to("https://demoqa.com/login/");

        /*WebElement elements = driver.findElement(By.cssSelector(".avatar.mx-auto.white"));
        elements.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 700)", "");

        WebElement elementGroup = driver.findElement(By.cssSelector("div.element-group:nth-child(6) > span:nth-child(1) > div:nth-child(1)"));
        elementGroup.click();

        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement loginPage = driver.findElement(By.cssSelector(".show > ul:nth-child(1) > li:nth-child(1) > span:nth-child(2)"));
        waits.until(ExpectedConditions.visibilityOf(loginPage));
        waits.pollingEvery(Duration.ofMillis(300));
        loginPage.click();*/

        driver.findElement(By.linkText("profile")).click();

        driver.findElement(By.cssSelector(".text-right.button.di")).click();
        //driver.findElement(By.id("submit")).click();
        //driver.switchTo().alert().accept();


    }
}
