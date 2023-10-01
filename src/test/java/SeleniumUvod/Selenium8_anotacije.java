package SeleniumUvod;

import org.testng.annotations.*;

public class Selenium8_anotacije {
    //Kada radimo sa anotacijama ne pravimo vise main metodu

    //Svaka anotacija vazi za prvu narednu metodu na koju naidje
    //Before class se izvrsava jednom (na pocetku) pre svih ostalih metoda
    @BeforeClass
    public void beforeClassMethod() {
        System.out.println("***********");
        System.out.println("Ispis iz BEFORE CLASS");
        System.out.println("***********");
    }

    //Before method se izvrsava pre svake metode sa @Test anotacijom
    //Izvrsava se onoliko puta koliko ima @Test anotacija
    @BeforeMethod
    public void beforeMethodMethod() {
        System.out.println("+++++++++++");
        System.out.println("Ispis iz BEFORE METHOD");
        System.out.println("+++++++++++");
    }

    //Dodavanjem prioriteta odredjujemo kojim redosledom ce se izvrsiti metode
    //Ako ne stavimo prioritet podrazumeva se da ta metoda ima prioritet 0 i izvrsice se pre ostalih
    //Ako metode imaju isti prioritet onda ce se izvrsiti po abecednom redu
    //Brojevi za prioritet ne moraju biti 'konstantni' u smislu da se ide 1, 2, 3 itd
    //Mozete koristiti koje god brojeve zelite, na primer 13, 19, 24, 75
    @Test(priority = 10)
    public void testMethod1() {
        System.out.println("===========");
        System.out.println("Ispis iz TEST METHOD 1");
        System.out.println("===========");
    }

    @Test(priority = 20)
    public void testMethod2() {
        System.out.println("===========");
        System.out.println("Ispis iz TEST METHOD 2");
        System.out.println("===========");
    }

    @Test(priority = 30)
    public void testMethod3() {
        System.out.println("===========");
        System.out.println("Ispis iz TEST METHOD 3");
        System.out.println("===========");
    }

    @Test(priority = 15)
    public void testMethod4() {
        System.out.println("===========");
        System.out.println("Ispis iz TEST METHOD 4");
        System.out.println("===========");
    }

    //After method se izvrsava nakon svake @Test anotacije
    //Izvrsava se onoliko puta koliko ima @Test anotacija
    @AfterMethod
    public void afterMethodMethod() {
        System.out.println("------------");
        System.out.println("Ispis iz AFTER METHOD");
        System.out.println("------------");
    }

    //After class se izvrsava jednom (na kraju) posle svih metoda
    @AfterClass
    public void afterClassMethod() {
        System.out.println("!!!!!!!!!!!!");
        System.out.println("Ispis iz AFTER class");
        System.out.println("!!!!!!!!!!!!");
    }
}
