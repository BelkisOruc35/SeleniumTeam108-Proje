package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C06_dropDownMenu extends TestBase {

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");



        WebElement ddm= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(ddm);
        bekle(2);
        //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(2);


        //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(2);


        //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(3);


        //	4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement>optionElementListesi=select.getOptions();
        System.out.println("=======================");
        for (WebElement eachelement:optionElementListesi
             ) {

            System.out.println(eachelement.getText());
        }



        //	5.Dropdown’un boyutununun 4 oldugunu test edin

        int expectedsize=4;
        int actualsize=optionElementListesi.size();
        Assert.assertEquals(expectedsize,actualsize);
        bekle(2);

    }


    }

