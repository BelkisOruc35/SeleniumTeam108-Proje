package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C01_projeyeseleniumEkleme {
    /*
      Bir projede selenium ile otomasyon yapabilmek icin
      projeye 2 sey eklemeliyiz
      1- Selenium kutuphanesi
      2- kullanmak istedigimiz browser(lar)in selenium driver'i
        (Biz sadece chrome kullanip sonra daha gelismis framework'lere gecis yapacagiz)
      dosyalari projeye eklemek icin
      1- selenium dev sayfasindan dosyalari bilgisayarimiza indiriyoruz
      2- bunlari unzip yapip, projemizde olusturdugumuz drivers klasorune tasiyoruz
      3- projeye selenium kutuphanelerini (jar dosyalarini) ekliyoruz
   */
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().minimize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.wisequarter.com");
    }


}
