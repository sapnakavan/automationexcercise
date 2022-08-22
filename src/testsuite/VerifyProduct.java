package testsuite;

import basebrowser.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VerifyProduct extends BaseTest {
    String baseUrl ="http://automationexercise.com";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void VerifyAllProductsandproductdetailpage(){
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

        //6. The products list is visible


        //7. Click on 'View Product' of first product
        WebElement product1 = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        product1.click();


        //8. User is landed to product detail page


        //9. Verify that detail  is visible: product name, category, price, availability, condition, brand
        WebElement ver = driver.findElement(By.xpath("//div[@class='product-information']"));
        String accme= ver.getText();
        String expome = "Blue Top\n" +
                "Category: Women > Tops\n" +
                "Rs. 500\n" +
                "Quantity: Add to cart\n" +
                "Availability: In Stock\n" +
                "Condition: New\n" +
                "Brand: Polo";
        Assert.assertEquals(expome,accme);


    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
