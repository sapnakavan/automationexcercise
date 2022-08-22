package testsuite;

import basebrowser.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VerifyProduct extends BaseTest {
    String baseUrl ="http://automationexercise.com";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void VerifyAllProductsandproductdetailpage() {
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
        Assert.assertEquals(expo, acc);

        //6. The products list is visible
        WebElement VisibleProductList = driver.findElement(By.xpath("//div[@class='features_items']"));
        VisibleProductList.getText();




        //7. Click on 'View Product' of first product
        WebElement product1 = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        product1.click();


        //8. User is landed to product detail page
        WebElement VerifyProductDetailPg = driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']"));
        VerifyProductDetailPg.getText();




        //9. Verify that detail  is visible: product name, category, price, availability, condition, brand
        String text=driver.findElement(By.xpath("//div[@class='product-information']/p[4]")).getText();
        System.out.println(text);
        String actualText=text.substring(7);
        System.out.println(actualText);
        String expectedText="Polo";
        Assert.assertEquals(actualText,expectedText);


        String text1=driver.findElement(By.xpath("//div[@class='product-information']/p[3]")).getText();
        System.out.println(text1);
        String actualText1=text1.substring(11);
        System.out.println(actualText1);
        String expectedText1="New";
        Assert.assertEquals(actualText1,expectedText1);



        String text3=driver.findElement(By.xpath("//div[@class='product-information']/p[2]")).getText();
        System.out.println(text3);
        String actualText3=text3.substring(14);
        System.out.println(actualText3);
        String expectedText3="In Stock";
        Assert.assertEquals(actualText3,expectedText3);



        String text4=driver.findElement(By.xpath("//div[@class='product-information']/p[1]")).getText();
        System.out.println(text4);
        String actualText4=text.substring(10);
        System.out.println(actualText4);
        String expectedText4="o";
        Assert.assertEquals(actualText4,expectedText4);


    }

    @After
    public void teardown(){
        closeBrowser();
    }
}
