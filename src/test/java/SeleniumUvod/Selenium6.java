package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium6 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");

        Cookie cookie = new Cookie("wordpress_logged_in", "dragoljubqa%7C1790530498%7CVUoz7kSbkJmId2zzAO0ndOMZd69wZ6qj45PXU1JLYvU%7Caac5ed0d449fa47881bde20e8d0591d8698bebf2ce381cda2aedc231fd3b3dc6");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
}