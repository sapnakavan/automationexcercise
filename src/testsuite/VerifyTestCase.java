package testsuite;

import basebrowser.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VerifyTestCase extends BaseTest {
    String baseUrl ="http://automationexercise.com";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void VerifyTestCasesPage(){
        //Verify that home page is visible successfully
        String verify = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]")).getText();
        String accmess = verify.substring(0);
        System.out.println(accmess);
        String expmess ="Home";
        Assert.assertEquals(expmess, accmess);



        //4. Click on 'Test Cases' button
        WebElement product = driver.findElement(By.xpath("//*[(text()=' Test Cases')]"));
        product.click();



        //5. Verify user is navigated to test cases page successfully
        String verify1 = driver.findElement(By.xpath("//*[text()='Test Cases']")).getText();
        String acc = verify1.substring(0);
        System.out.println(acc);
        String expo = "TEST CASES";
        Assert.assertEquals(expo,acc);

    }
    @After
   public void teardown(){
        closeBrowser();
    }

}
