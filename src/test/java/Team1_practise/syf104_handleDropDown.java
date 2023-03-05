package Team1_practise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

public class syf104_handleDropDown extends TestBaseClass {

    /*Handle Dropdown
1. http://zero.webappsecurity.com/ Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
    kontrol edin.*/
    @Test
    public void test01(){
        //        1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //        2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        bekle(2);
        //        3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");
        bekle(2);
        //        4. Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");
        bekle(2);
        //        5. Sign in tusuna basin
        driver.findElement(By.name("submit")).click();
        bekle(2);
        //        6. Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //        7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        bekle(2);
        //        8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(ddm);
       select.selectByIndex(6);
        bekle(2);
        //        9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("2000");
        //        10. “US Dollars” in secilmedigini test edin
        WebElement dollars=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(dollars.isSelected());

        //        11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        //        12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        //        13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        WebElement text=driver.findElement(By.id("alert_content"));

        Assert.assertTrue(text.isDisplayed());
        bekle(2);
        //        kontrol edin.


    }

}
