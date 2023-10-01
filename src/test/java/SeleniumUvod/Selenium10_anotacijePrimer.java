package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Selenium10_anotacijePrimer {

    //Koristeci anotacije za testiranje login stranice mogu da biram:
    //Da li hocu da se sve testira u jednom browseru
    //Da li hocu da svaki test otvara poseban browser

    //Obe opcije su u redu i imaju svoje prednosti i mane

    //Ako radim sve u jednom browseru testovi se mnogo brze izvrsavaju
    //Ali mogu biti nestabilni jer ce jedni testovi direktno uticati na druge

    //Ako radim svaki browser za sebe onda se testovi sporije izvrsavaju
    //Ali su testovi nezavisni jedni od drugih

    //Ovo je primer gde sve radim u JEDNOM browseru

    //Da bi driver mogao da bude vidljiv u vise metoda moram da ga deklarisem (napravim) van svih metoda
    //A inicijalizujem (dodeljujem vrednost) ga u setUp metodi
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //Code koji se izvrsava samo jednom na pocetku
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void pageSetUp() {
        //Code koji se izvrsava pre svakog testa
        driver.navigate().to("https://demoqa.com/");
    }

    //Nazivi test metoda treba da imaju naziv test kejseva
    @Test
    public void goToElements() {
        List<WebElement> card = driver.findElements(By.className("card-body"));
        for (int i = 0; i < card.size(); i++) {
            if (card.get(i).getText().equals("Elements")) {
                card.get(i).click();
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/elements");
    }

    @Test
    public void goToForms() {
        List<WebElement> card = driver.findElements(By.className("card-body"));
        for (int i = 0; i < card.size(); i++) {
            if (card.get(i).getText().equals("Forms")) {
                card.get(i).click();
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/forms");
    }

    @Test
    public void goToAlerts() {
        List<WebElement> card = driver.findElements(By.className("card-body"));
        for (int i = 0; i < card.size(); i++) {
            if (card.get(i).getText().equals("Alerts, Frame & Windows")) {
                card.get(i).click();
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/alertsWindows");
    }

    @Test
    public void goToWidgets() {
        List<WebElement> card = driver.findElements(By.className("card-body"));
        for (int i = 0; i < card.size(); i++) {
            if (card.get(i).getText().equals("Widgets")) {
                card.get(i).click();
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/widgets");
    }

    @Test
    public void goToInteractions() {
        List<WebElement> card = driver.findElements(By.className("card-body"));
        for (int i = 0; i < card.size(); i++) {
            if (card.get(i).getText().equals("Interactions")) {
                card.get(i).click();
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/interaction");
    }

    @Test
    public void goToBookstore() {
        List<WebElement> card = driver.findElements(By.className("card-body"));
        for (int i = 0; i < card.size(); i++) {
            if (card.get(i).getText().equals("Book Store Application")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card.get(i));
                card.get(i).click();
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books");
    }

    @AfterClass
    public void tearDown() {
        //Code koji ce se izvrsiti samo jednom na kraju
        driver.quit();
    }

}