package domaciNedelja;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.Keys.ENTER;

// Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application) preko cookies-a, dodati dve knjige
// na svoj nalog, zatim se izlogovati brisanjem cookies-a.
// Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.

public class testDemoQABookstore {
    WebDriver driver;
    String baseURL;
    Set<Cookie> cookies;
    static final String USERNAME = "bleksteva";
    static final String PASSWORD = "Golubac-012!";
    public void openCard(String cardName){
        List<WebElement> cards = driver.findElements(By.cssSelector(".card.mt-4.top-card"));
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals(cardName)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cards.get(i));
                cards.get(i).click();
                break;
            }
        }
    }
    public void goToLoginPage(){
        WebElement login = driver.findElement(By.cssSelector(".show > ul:nth-child(1) > li:nth-child(1) > span:nth-child(2)"));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)", "");
        login.click();
    }
    public void logIn(String user, String pass){
        WebElement userName = driver.findElement(By.id("userName"));
        userName.clear();
        userName.sendKeys(user);

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys(pass);

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
    }
    public void logOut(){
        WebElement logOutButton = driver.findElement(By.id("submit"));
        logOutButton.click();
    }
    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void getReady() throws InterruptedException {
        baseURL = "https://demoqa.com/";
        driver.navigate().to(baseURL);
        driver.manage().deleteAllCookies();     // ovo radim da bi poceli skroz bez cookies
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        openCard("Book Store Application");
        goToLoginPage();
        logIn(USERNAME, PASSWORD);

        Thread.sleep(1000);

        // hvatam cookies
        cookies = driver.manage().getCookies();

        logOut();
        driver.findElement(By.cssSelector("#app > header:nth-child(1) > a:nth-child(1) > img:nth-child(1)")).click();
    }
    // odavde ide zadatak:
    // Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application) preko cookies-a, dodati dve knjige
    @Test
    public void test1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // logujem se preko kolacica
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token") || cookie.getName().equals("userName") ||
                    cookie.getName().equals("expires") || cookie.getName().equals("userID")) {
                driver.manage().addCookie(cookie);
            }
        }
        driver.navigate().refresh();
        openCard("Book Store Application");
        goToLoginPage();

        // ulazim u korpu i brisem odande sve
        driver.findElement(By.linkText("profile")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 150)", "");
        driver.findElement(By.cssSelector(".text-right.button.di")).click();

        WebElement okButton = driver.findElement(By.id("closeSmallModal-ok"));
        okButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        WebElement goToStore = driver.findElement(By.id("gotoStore"));
        goToStore.sendKeys(ENTER);

        // kupovina prve knjige
        List<WebElement> knjige = driver.findElements(By.className("action-buttons"));
        knjige.get(0).click();
        js.executeScript("window.scrollBy(0, 350)", "");
        WebElement addButton = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector(".text-right.fullButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.findElement((By.cssSelector(".text-left.fullButton"))).click();

        // kupovina druge knjige
        knjige = driver.findElements(By.className("action-buttons"));
        knjige.get(1).click();
        js.executeScript("window.scrollBy(0, 350)", "");
        addButton = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        goToLoginPage();
        driver.findElement(By.linkText("profile")).click();
        // 1 asertacija - LogOutButton
        WebElement logOutButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(logOutButton.isDisplayed());

        // 2 assertacija - knjiga 1
        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        String expectedText = "Git Pocket Guide";
        String actualText = book1.getText();
        Assert.assertEquals(actualText, expectedText);

        // 3 asertacija - knjiga 2
        WebElement book2 = driver.findElement(By.partialLinkText("Learning JavaS"));
        String expectedText1 = "Learning JavaScript Design Patterns";
        String actualText1 = book2.getText();
        Assert.assertEquals(actualText1, expectedText1);

        // brisemo sve cookies
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("#app > header:nth-child(1) > a:nth-child(1) > img:nth-child(1)")).click();
    }
    @Test
    public void test2(){
        openCard("Book Store Application");
        goToLoginPage();
        logIn(USERNAME, PASSWORD);

        // 1 asertacija - LogOutButton
        WebElement logOutButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(logOutButton.isDisplayed());

        // 2 assertacija - knjiga 1
        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        String expectedText = "Git Pocket Guide";
        String actualText = book1.getText();
        Assert.assertEquals(actualText, expectedText);

        // 3 asertacija - knjiga 2
        WebElement book2 = driver.findElement(By.partialLinkText("Learning JavaS"));
        String expectedText1 = "Learning JavaScript Design Patterns";
        String actualText1 = book2.getText();
        Assert.assertEquals(actualText1, expectedText1);
    }
    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}