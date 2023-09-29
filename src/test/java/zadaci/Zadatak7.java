package zadaci;

// Zadatak 7
//https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2
//Testirati dodavanje knjige u korpu i da li se knjiga obrise kada obrisete kolacice

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak7 {
            public static void main(String[] args) {
        /*Zadatak 7
        https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2
        Testirati dodavanje knjige u korpu i da li se knjiga obrise kada obrisete kolacice*/

                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

                //Kada hocu da testiram dodavanje knjige, moram prvo da proverim da li mi je korpa prazna
                //Jer ako korpa nije prazna, moze se desiti da funkcionalnost dodavanja ne radi, a meni test prodje jer ce naci knjigu u korpi
                WebElement cartBeforeAdding = driver.findElement(By.id("nav-cart-count"));
                Assert.assertEquals(cartBeforeAdding.getText(), "0");

                //Nije mi dovoljno da proverim samo broj, zelim da otvorim korpu i da se uverim da je prazna
                cartBeforeAdding.click();
                WebElement emptyCart = driver.findElement(By.cssSelector(".a-row.sc-your-amazon-cart-is-empty"));
                Assert.assertTrue(emptyCart.isDisplayed());

                //Kada se uverim da je prazna vracam se nazad
                driver.navigate().back();

                //Dodajem knjigu u korpu
                WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
                addToCartButton.click();

                //Proveravam da li sam dobio uspesnu poruku i da li se broj promenio sa 0 na 1
                WebElement itemAddedToCartMessage = driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"));
                Assert.assertTrue(itemAddedToCartMessage.isDisplayed());

                WebElement cartAfterAdding = driver.findElement(By.id("nav-cart-count"));
                Assert.assertEquals(cartAfterAdding.getText(), "1");

                //Takodje proveravam da li je nesto zapravo dodato u korpu
                cartAfterAdding.click();
                WebElement itemInCart = driver.findElement(By.className("sc-list-item-content"));
                Assert.assertTrue(itemInCart.isDisplayed());

                //Brisem sve kolacice da bih ispraznio korpu
                driver.manage().deleteAllCookies();
                driver.navigate().refresh();

                //Ponovo proveravam da li mi je korpa prazna
                WebElement emptyCartAfterRemoval = driver.findElement(By.cssSelector(".a-row.sc-your-amazon-cart-is-empty"));
                Assert.assertTrue(emptyCartAfterRemoval.isDisplayed());

                WebElement cartAfterRemoval = driver.findElement(By.id("nav-cart-count"));
                Assert.assertEquals(cartAfterRemoval.getText(), "0");

            }
        }