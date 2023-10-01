package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Selenium9_findElements {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        //Hocu da kliknem na karticu i nasao sam lokator
        /*WebElement card = driver.findElement(By.className("card-body"));
        card.click();*/
        //Zatim hocu da kliknem na drugu i vidim da imaju isti lokator
        //Kada imamo iste lokatore za vise elemenata, onda ih mozemo smestiti u listu

        List<WebElement> card = driver.findElements(By.className("card-body"));
        //Obratiti paznju da se napise u mnozini .findElements
        //Hocu da kliknem na 4. clan liste i to radim ovako:
        //card.get(3).click();

        //Ali sta ako se sutra doda novi element pre toga ili se promeni redosled, onda ovaj klik na index nece biti validan
        //Zato pravim petlju koja ce proci kroz sve elemente
        //Zatim ce proveriti naziv elementa
        //I ako je to naziv koji mi treba onda cu da kliknem bas na taj element

        for (int i = 0; i < card.size(); i++) {
            if (card.get(i).getText().equals("Widgets")) {
                card.get(i).click();
                break;
            }
        }
        //Obavezno staviti break; komandu nakon klika da bi petlja prestala dalje da trazi elemente
    }
}