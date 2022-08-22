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


        //4. Click on 'Test Cases' button
        WebElement product = driver.findElement(By.xpath("//*[(text()=' Test Cases')]"));
        product.click();



        //5. Verify user is navigated to test cases page successfully
        WebElement verify1 = driver.findElement(By.xpath("//*[text()='Test Cases']"));
        String acc = verify1.getText();
        String expo = "TEST CASES";
        Assert.assertEquals(expo,acc);

    }
    @After
   public void teardown(){
        closeBrowser();
    }

}
