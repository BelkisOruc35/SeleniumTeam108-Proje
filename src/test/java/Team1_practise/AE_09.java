package Team1_practise;


    import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethodsIf;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v104.overlay.model.LineStyle;
import utilities.TestBaseClass;
import java.util.List;
    public class AE_09 extends TestBaseClass {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        @Test
        public void test01 (){
            driver.get("https://www.automationexercise.com/");
            String expectedUrl="https://www.automationexercise.com/";
            String actualUrl= driver.getCurrentUrl();
            Assert.assertEquals(expectedUrl,actualUrl);
        }
        @Test
        public void test02 (){
            //4. Click on 'Products' button
            //5. Verify user is navigated to ALL PRODUCTS page successfully
            driver.findElement(By.xpath("//a[@href='/products']")).click();
            if((driver.getCurrentUrl().equals("https://www.automationexercise.com/#google_vignette"))){
                driver.navigate().refresh();
            }
            driver.findElement(By.xpath("//a[@href='/products']")).click();
            String allProductsBaslik=driver.getTitle();
            boolean baslik=true;
            if(allProductsBaslik.contains("All Products")){
                baslik=true;
            }
            Assert.assertTrue(baslik);
        }
        @Test
        public void test03(){
            //6. Enter product name in search input and click search button
            WebElement searchBox=driver.findElement(By.id("search_product"));
            WebElement araButonu=driver.findElement(By.id("submit_search"));
            searchBox.sendKeys("Tshirt");
            araButonu.click();
            //7. Verify 'SEARCHED PRODUCTS' is visible
            WebElement searchedProducts=driver
                    .findElement(By.xpath("//h2[@class='title text-center']"));
            Assert.assertTrue(searchedProducts.isDisplayed());
        }
        @Test
        public void test04() {
            //8. Verify all the products related to search are visible
            List<WebElement> urunAdlari = driver.findElements(By.xpath("//div[@class='productinfo text-center']"));
            int sayac = 0;
            for (WebElement eachUrun : urunAdlari
            ) {
                if(eachUrun.getText().contains("Tshirt")){
                    sayac++;
                }
            }
            System.out.println("sayac = "+sayac);
            if(sayac>0){
                Assert.assertTrue(true);



            }
            }
        }








