package Team1_practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ayseHocaodev1 {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() {

        // url'ye git: https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        // ilk adı doldur
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Kalender");

        // soyadını doldur
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Tersgider");

        // cinsiyeti kontrol et
        driver.findElement(By.id("sex-0")).click();

        // deneyimi kontrol edin
        driver.findElement(By.id("exp-0")).click();

        // tarihi doldur
        driver.findElement(By.id("datepicker")).sendKeys("28.07.2017");

        // mesleğinizi seçin -> Otomasyon Test Cihazı
        driver.findElement(By.id("profession-1")).click();

        // aracınızı seçin -> Selenyum Web Sürücüsü
        driver.findElement(By.id("tool-2")).click();

        //    choose your continent -> Antartica
        WebElement ddm = driver.findElement(By.xpath("//select[@id='continents']"));

        Select select = new Select(ddm);

        select.selectByVisibleText("Antartica");

        //    choose your command  -> Browser Commands
        WebElement ddm1=driver.findElement(By.xpath("//select[@id='selenium_commands']"));
        Select select1 = new Select(ddm);

        select.selectByIndex(0);

        //    click submit button
        driver.findElement(By.id("submit")).click();
    }
}
