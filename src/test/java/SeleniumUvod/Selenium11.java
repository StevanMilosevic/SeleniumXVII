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

public class Selenium11 {
    //Sve je isto kao u klasi Selenium10 osim sto se ovde testovi izvrsavaju u posebnim browserima sekvencionalno

    //Testovi se mogu izvrsiti sekvencionalno ili paralelno
    //Sekvencionalno znaci da naredni test ceka da se prethodni test zavrsi da bi poceo sa svojim izvrsavanjem
    //Paralelno znaci da se testovi u razlicitim browserima izvrsavaju u isto vreme

    //Paralelni testovi su brzi za izvrsavanje citavog test suite-a (skup testova u klasi)
    //Ali mogu uticati jedni na druge preko Cookies

    //Na primer ako u jednom browseru dodate nesto u korpu na vasem nalogu
    //Moze se desiti da ce drugi test i drugi browser da pokupe taj token i da test bude korumpiran
    WebDriver driver;

    @BeforeMethod
    public void pageSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
    }

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

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
