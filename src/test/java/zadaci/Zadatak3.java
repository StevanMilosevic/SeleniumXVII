package zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak3 {
    public static void main(String[] args) {
        // //Zadatak 3
        ////Otici na Google
        ////Zatim ukucati "Wikipedia" u polje za pretragu
        ////Odraditi pretragu i otvoriti stranicu
        ////Na stranici Wikipedia pretraziti "Nikola Tesla"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        searchBox.sendKeys("Wikipedia");
        searchBox.sendKeys(ENTER);

        WebElement page = driver.findElement(By.xpath("/html/body/div[5]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"));
        page.click();

        WebElement searchWiki = driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input"));
        searchWiki.sendKeys("Nikola Tesla");
        searchWiki.sendKeys(ENTER);

    }
}
