package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_practise extends TestBase {
    @Test
    public void test01(){

    //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement ilksayfyazielementi=driver.findElement(By.tagName("h3"));

    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedtext="Opening a new window";
        String actualtext=ilksayfyazielementi.getText();
        Assert.assertEquals(expectedtext,actualtext);
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        bekle(2);
        String ilksyfwhd=driver.getWindowHandle();
        System.out.println(ilksyfwhd);

    //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        /*
            Eger switchToNewWindow() method'u kullanilirsa
            driver yeni acilan sayfaya gecis yapar
            Ancak bu method kullanilmadan
            bir link tiklandiginda, yeni bir sayfa aciliyorsa
            driver yeni sayfaya gecis yapmaz
            bizim yeni acilan sayfanin
            windowHandle degerini bulup
            driver'i o sayfaya gecirmemiz GEREKLIDIR
            link'e click yaptigimizda acik 2 sayfamiz oluyor
            bunlardan bir tanesi windowHandle degerini kaydettigimiz ILK SAYFA
            digeri ise windowHandle degerini bilmedigimiz IKINCI SAYFA
            biz getWindowHandles() method'u ile
            bir SET olarak iki sayfanin windowHandle degerlerini alabiliyoruz
            O SET icerisinde
            ilkSayfaWHD'ine esit olmayan String'i
            ikinciSayfaWHD olarak atayabiliriz
         */
        Set <String>tumSayfalarWHDSeti=driver.getWindowHandles();
        String ikincisyfwhd ="";
        for (String each:tumSayfalarWHDSeti
             ) {
            if (!each.equals(ilksyfwhd)){
                ikincisyfwhd=each;
            }

        }
        System.out.println(tumSayfalarWHDSeti);
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikincisyfwhd);
        expectedTitle="New Window";
        actualTitle=driver.getTitle();
        bekle(2);
      //  Assert.assertEquals(expectedTitle,actualTitle);
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        String ikinciSyfText=driver.findElement(By.tagName("h3")).getText();
        expectedtext="New Window";
        Assert.assertEquals(expectedtext,ikinciSyfText);
    //● Bir önceki pencereye geri döndükten sonra
    // sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilksyfwhd);
        expectedTitle = "The Internet";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        bekle(3);


        }}

