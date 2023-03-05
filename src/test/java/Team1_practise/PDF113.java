package Team1_practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PDF113 {

//            http://demo.guru99.com/test/guru99home/ sitesine gidiniz
//            2) sayfadaki iframe sayısını bulunuz.
//            3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
//            4) ilk iframe'den çıkıp ana sayfaya dönünüz
//            5) ikinci iframe'deki (Jmeter Made Easy) linke
//            (https://www.guru99.com/live-selenium-project.html) tıklayınız
//
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);

        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
    //            http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
//            2) sayfadaki iframe sayısını bulunuz.
        System.out.println(driver.findElements(By.tagName("iframe")).size());

//            3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
       WebElement frameElementi= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
       driver.switchTo().frame(frameElementi);
       driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
//            4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
//            5) ikinci iframe'deki (Jmeter Made Easy) linke
//            (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement frameElementi2= driver.findElement(By.name("a077aa5e"));
        driver.switchTo().frame(frameElementi2);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();


        Thread.sleep(3000);
//



    }






}