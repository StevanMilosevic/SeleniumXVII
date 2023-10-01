package zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak9 {
        WebDriver driver;
        String user;
        String pass;
        @BeforeClass
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://practicetestautomation.com/");
        }
        @BeforeMethod
        public void gettingToLogInPage(){
            WebElement practice = driver.findElement(By.id("menu-item-20"));
            practice.click();

            WebElement tlp = driver.findElement(By.linkText("Test Login Page"));
            tlp.click();

        }
        public void enteringValues(String user, String pass){
            WebElement username = driver.findElement(By.id("username"));
            username.clear();
            username.sendKeys(user);
            WebElement password = driver.findElement(By.id("password"));
            password.clear();
            password.sendKeys(pass);
            WebElement submit = driver.findElement(By.id("submit"));
            submit.click();
        }
        @Test
        public void checkIfUserCanLogInWithWrongUsername(){
            user = "000";
            pass = "Password123";

            enteringValues(user, pass);

            boolean logOut = false;
            try{
                logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
            }catch(Exception e){}
            Assert.assertFalse(logOut);
        }

        @Test
        public void checkIfUserCanLogInWithWrongPassword(){
            enteringValues("student", "000");

            boolean logOut = false;
            try{
                logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
            }catch(Exception e){}
            Assert.assertFalse(logOut);
        }
    @Test
    public void checkIfUserCanLogInWithWrongUsernameAndPassword(){
        enteringValues("000", "000");

        boolean logOut = false;
        try{
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        }catch(Exception e){}
        Assert.assertFalse(logOut);
    }


}
