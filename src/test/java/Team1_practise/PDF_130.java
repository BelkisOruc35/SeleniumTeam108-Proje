package Team1_practise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class PDF_130 extends TestBase {
 //  Yeni bir class olusturalim: MouseActions3
//1- https://www.amazon.com/ adresine gidin
//2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
//    mouse’u bu menunun ustune getirin
//3- “Create a list” butonuna basin
//4- Acilan sayfada “Your Lists” yazisi oldugunu test edin


    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //    mouse’u bu menunun ustune getirin

        Actions action=new Actions(driver);
        WebElement accountlist= driver.findElement(By.id("nav-link-accountList"));
        action.moveToElement(accountlist).perform();

        //3- “Create a list” butonuna basin
       driver.findElement(By.xpath("//span[text()='Create a List']")).click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
       String actualtext=driver.findElement(By.xpath("//div[@role='heading']")).getText();
       String expectedtext="Your Lists";
       Assert.assertEquals(actualtext,expectedtext);
       Thread.sleep(2000);











    }






}
