package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Selenium13 {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void verifyThatUserCanLogIn() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        username.clear();
        username.sendKeys("student");
        password.clear();
        password.sendKeys("Password123");
        submitButton.click();

        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutButton.isDisplayed());
    }

    @Test
    public void verifyThatUserCannotLogIn() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        username.clear();
        username.sendKeys("1254");
        password.clear();
        password.sendKeys("Password123");
        submitButton.click();

        //Kada hocemo da testiramo da element NIJE prisutan na stranici
        //Moramo da koristimo try catch blok
        //Naredni deo koda je zakomentarisao i ne radi

        /*WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertFalse(logoutButton.isDisplayed());*/

        //Da bismo utvrdili da element nije prisutan prvo moramo da napravimo boolean i dodelimo vrednost false
        //Zatim u try bloku menjamo vrednost prethodnog booleana AKO JE ELEMENT PRONADJEN
        //Sto znaci ako element bude pronadjen (.isDisplayed() = true)
        //Onda ce boolean da se promeni sa false na true
        //Nakon try catch bloka ubacujemo assert koji ce proveriti bas ovaj boolean
        //Poruka u catch bloku nije potrebna, potrebno je samo proslediti parametar Exception i naziv (u ovom slucaju je naziv e, ali moze biti bilo sta)

        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {
            System.out.println("Element not found");
        }
        Assert.assertFalse(logOut);

        //Nakon testa obavezno treba proveriti da li test radi tako sto cemo kreirati situaciju da element bude nadjen
        //U ovom slucaju cemo se uspesno ulogovati
    }
}