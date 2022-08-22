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
        WebElement verify = driver.findElement(By.xpath("//header[@id='header']"));
        String accmess = verify.getText();
        String expmess = "Home\n" +
                "\uE8F8 Products\n" +
                "Cart\n" +
                "Signup / Login\n" +
                "Test Cases\n" +
                "API Testing\n" +
                "Video Tutorials\n" +
                "Contact us";
        Assert.assertEquals(expmess,accmess);


        //4. Click on 'Products' button
        WebElement product = driver.findElement(By.xpath("//*[(text()=' Products')]"));
        product.click();



        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement verify1 = driver.findElement(By.xpath("//*[text()='All Products']"));
        String acc = verify1.getText();
        String expo = "ALL PRODUCTS";
        Assert.assertEquals(expo,acc);


        //6. Enter product name in search input and click search button
        WebElement proname = driver.findElement(By.xpath("//input[@id='search_product']"));
        proname.sendKeys("blue top");

        WebElement search = driver.findElement(By.xpath("//button[@id='submit_search']"));
        search.click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement verify2 = driver.findElement(By.xpath("//*[text()='Searched Products']"));
        String acc2 = verify2.getText();
        String expo2 = "SEARCHED PRODUCTS";
        Assert.assertEquals(expo2,acc2);



        //8. Verify all the products related to search are visible
       WebElement verify3 = driver.findElement(By.xpath(""));
       String acc3 = verify3.getText();
       String expo3 = "";
       Assert.assertEquals(expo3,acc3);



    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
