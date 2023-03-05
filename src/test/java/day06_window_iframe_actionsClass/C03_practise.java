package day06_window_iframe_actionsClass;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_practise extends TestBase {
    @Test
public void test01() {


        // amazon anasayfaya gidip, arama kutusunun erisilebilir oldugunu test edin
        driver.get("https://www.amazon.com");
        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramakutusu.isEnabled());
        String amazonHandleWindowDegeri= driver.getWindowHandle();
        bekle(3);
        // yeni bir tab olarak wisequarter.com'a gidin

        /* once yeni bir tab olusturup
           driver'i o sayfaya gecirmeliyiz (switch)
         */
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String expectedicerik="wisequarter";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedicerik));
        String wiseWindowHandleDegeri=driver.getWindowHandle();


        // amazon'un acik oldugu tab'a geri donun

        /*
            Daha once acilmis olan bir window'a gecis yapmak icin
            O sayfanin windowHandle degerine ihtiyacimiz var
            Testimiz boyle bir gorevi iceriyorsa
            o sayfada iken windowHandle degerini alip kayit yapmaliyiz
         */
        driver.switchTo().window(amazonHandleWindowDegeri);
        aramakutusu.sendKeys("Nutella" + Keys.ENTER);
        bekle(3);
        String actualsonucyazisi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        expectedicerik="Nutella";
        Assert.assertTrue(actualsonucyazisi.contains(expectedicerik));

        // yeni bir window olarak youtube.com'a gidin
            driver.switchTo().newWindow(WindowType.WINDOW);
            driver.get("https://www.youtube.com");


        // Url'in youtube icerdigini test edin
            expectedicerik="youtube";
            actualUrl=driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains(expectedicerik));
            bekle(2);



        // wisequarter'in acik oldugu sayfaya donun
        driver.switchTo().window(wiseWindowHandleDegeri);

        // Title'in Wise Quarter icerdigini test edin
        expectedicerik="Wise Quarter";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedicerik));
        bekle(3);

    }

    }


