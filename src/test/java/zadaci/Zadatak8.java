package zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

// //Zadatak 8
////Otici na stranicu https://imgflip.com/memegenerator
////Uploadovati sliku od koje treba napraviti mim
////Mim mora biti vezan za IT, QA ili kurs
////Sliku rucno skinuti i ubaciti na Slack thread poruku
////Autor mima sa najvise lajkova dobija pivo na druzenju
////Napomena: Izazov zadatka je kod lokatora, assertove ne treba dodavati i ne treba raditi sa anotacijama

public class Zadatak8 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://imgflip.com/memegenerator/");

        String slika = "C:\\Users\\Steva\\OneDrive\\Desktop\\bugs.jpg";
        driver.findElement(By.id("mm-show-upload")).click();
        WebElement uploadButton = driver.findElement(By.className("hidden-file-input"));

        uploadButton.sendKeys(slika);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("mm-upload-btn"))));
        driver.findElement(By.id("mm-upload-btn")).click();

        WebElement prviUpis = driver.findElement(By.cssSelector("#mm-settings > div.mm-boxes > div:nth-child(1) > div.mm-text-wrap > textarea"));

        prviUpis.clear();
        prviUpis.sendKeys("Chat GPT writes code");

        WebElement drugiUpis = driver.findElement(By.cssSelector("#mm-settings > div.mm-boxes > div:nth-child(2) > div.mm-text-wrap > textarea"));
        drugiUpis.clear();
        drugiUpis.sendKeys("Our code");

        WebElement generate = driver.findElement(By.cssSelector("#mm-settings > div.gen-wrap > div.gen-wrap-btns.clearfix > button.mm-generate.b.but"));
        generate.click();
    }
}