package Team1_practise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class PDF95 extends TestBase {
    /*Assertions
1. Bir Class olusturalim YanlisEmailTesti
2. http://automationpractice.com/index.php sayfasina gidelim
3. Sign in butonuna basalim
4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “There was a problem”
   uyarisi ciktigini test edelim*/

    @Test
    public void yanlisEmailTesti(){
        driver.get("https://www.amazon.com");
        bekle(5);
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        bekle(5);
        WebElement emailbox= driver.findElement(By.id("ap_email"));
        emailbox.sendKeys("belkisoruc35gmail.com"+ Keys.ENTER);

        WebElement uyari=driver.findElement(By.xpath("//span[@class='a-list-item']"));
        Assert.assertTrue(uyari.isDisplayed());
        bekle(3);
    }









}

