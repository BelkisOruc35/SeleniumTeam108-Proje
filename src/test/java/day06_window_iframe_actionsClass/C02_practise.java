package day06_window_iframe_actionsClass;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_practise extends TestBase {


           /* Bazen locate islemimizden emin olmamiza ragmen
            Locator calismaz
            Bunun sebebi kullanmak istedigimiz webelement'in
            bir iframe'in child'i olmasi olabilir.
            Eger Kullanmak istedigimiz webelement
            anasayfa icine gomulen baska bir websayfasinin elementi ise
            once gomulu sayfaya gecmemiz gerekir
            HTML komutlarinda sayfa icerisine sayfa gomebilmek icin
            <iframe> kullanilir
            Biz de istedigimiz elementi kullanmak icin once
            o frame'e switch yapmaliyiz
            1- gecis yapmak istediginiz frame'i locate edin
            2- switchTo() ile o frame'e gecis yapin
            3- Sonra istediginiz element ile istediginiz islemi yapin


    // https://the-internet.herokuapp.com/iframe  adresine gidin


    // "Your content goes here." yazisinin gorunur oldugunu test edin
    // Elemental Selenium linkine click yapin

            Bir frame'e gecis yaptiktan sonra
            oradan cikincaya veya baska bir frame'e gecinceye kadar
            driver o frame icerisinde kalir
            isimiz bittiginde veya baska frame'e gecmek istedigimizde
            once calisacagimiz yere gecis yapmaliyiz*/
    @Test
    public void iframetesti(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement frameElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);
        bekle(3);

        WebElement yaziElementi=driver.findElement(By.tagName("p"));
        Assert.assertTrue(yaziElementi.isDisplayed());
        bekle(3);
        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        driver.switchTo().defaultContent();

        bekle(3);


    }

    }


