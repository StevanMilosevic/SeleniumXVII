package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();    // setujemo chrome driver
        WebDriver driver = new ChromeDriver();      // kreiramo objekat od chrome drivera
        driver.manage().window().maximize();
        //driver.get("https://www.google.com/");    // Dajemo komandu drajveru koji link da otvori
        driver.navigate().to("https://www.google.com/");
        // ovde driver ceka povratne informacije pre nego sto otvori

        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        driver.navigate().forward();
        driver.quit();

    }
}
