package Team1_practise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;
import utilities.TestBaseClass;

public class TekrarTesti extends TestBaseClass {
    // 1- C01_TekrarTesti isimli bir class olusturun
    // 2- https://www.google.com/ adresine gidin
    // 3- cookies uyarisini kabul ederek kapatin
    // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin
    // 5- Arama cubuguna “Nutella” yazip aratin
    // 6- Bulunan sonuc sayisini yazdirin
    // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    // 8- Sayfayi kapatin

    @Test
    public void test01(){
        driver.get("https://www.google.com/");
        String actualtext=driver.getTitle();
        String expectedtext="Google";
        Assert.assertEquals(actualtext,expectedtext);

        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella"+ Keys.ENTER);
        String sonucYazisi=driver.findElement(By.id("result-stats")).getText();


        String[] sonucYaziArr=sonucYazisi.split(" ");

        String sonucSayisiStr= sonucYaziArr[1]; // 156.000.000
        sonucSayisiStr = sonucSayisiStr.replaceAll("\\D","");

        int actualSonucSayisi= Integer.parseInt(sonucSayisiStr);
        int expectedSonucSayisi=10000000;
        Assert.assertTrue(actualSonucSayisi>expectedSonucSayisi);




    }


}
