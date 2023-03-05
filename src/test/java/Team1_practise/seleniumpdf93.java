package Team1_practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class seleniumpdf93 {
   /* Assertions
1) Bir class oluşturun: YoutubeAssertions
2) https://www.youtube.com adresine gidin
3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin*/

static WebDriver driver;

@BeforeClass
    public static void setup(){
   WebDriverManager.chromedriver().setup();
   driver=new ChromeDriver();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }
@Test
public void titleTest(){
    driver.get("https://www.youtube.com" );
    String expectedTitle="YouTube";
    String actualTitle=driver.getTitle();
    Assert.assertEquals(expectedTitle,actualTitle);



}
@Test
    public void imageTest(){

    WebElement image=driver.findElement(By.xpath("//yt-icon[@class='style-scope ytd-logo'][1]"));
    Assert.assertTrue(image.isDisplayed());


}
// Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
public void searchBox(){
    WebElement searchBox=driver.findElement(By.id("search-input"));
    Assert.assertTrue(searchBox.isEnabled());
    }
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin*/
    @Test
    public void wrongtitleTest() {

        String expectedTitle = "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(expectedTitle, actualTitle);


    }}


