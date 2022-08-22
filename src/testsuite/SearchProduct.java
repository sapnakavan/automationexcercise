package testsuite;

import basebrowser.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchProduct extends BaseTest {
    String baseUrl ="http://automationexercise.com";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void SearchProduct(){
        //Verify that home page is visible successfully
        String verify = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]")).getText();
        String accmess = verify.substring(0);
        System.out.println(accmess);
        String expmess ="Home";
        Assert.assertEquals(expmess, accmess);



        //4. Click on 'Products' button
        WebElement product = driver.findElement(By.xpath("//*[(text()=' Products')]"));
        product.click();



        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String verify1 = driver.findElement(By.xpath("//*[text()='All Products']")).getText();
        String acc = verify1.substring(0);
        System.out.println(acc);
        String expo = "ALL PRODUCTS";
        Assert.assertEquals(expo,acc);


        //6. Enter product name in search input and click search button
        WebElement proname = driver.findElement(By.xpath("//input[@id='search_product']"));
        proname.sendKeys("blue top");

        WebElement search = driver.findElement(By.xpath("//button[@id='submit_search']"));
        search.click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        String verify2 = driver.findElement(By.xpath("//*[text()='Searched Products']")).getText();
        String acc2 = verify2.substring(0);
        System.out.println(acc2);
        String expo2 = "SEARCHED PRODUCTS";
        Assert.assertEquals(expo2,acc2);



        //8. Verify all the products related to search are visible
        String versearch = driver.findElement(By.xpath("//div[@class='product-image-wrapper']")).getText();
        String acc1 = versearch.substring(0);
        System.out.println(acc1);
        String expo1= "Rs. 500\n" +
                      "Blue Top\n" +
                      "Add to cart\n" +
                      "View Product";

        Assert.assertEquals(expo1,acc1);






    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
