package testsuite;

import basebrowser.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl ="http://automationexercise.com";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void  RegisterUserwithexistingemail(){
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


        //4. Click on 'Signup / Login' button
        //driver.findElement(By.linkText(" Signup / Login")).click();
        WebElement login = driver.findElement(By.linkText("Signup / Login"));
        login.click();


        //5. Verify 'New User Signup!' is visible
        WebElement ver = driver.findElement(By.xpath("//div[@class='signup-form']"));
        String acc = ver.getText();
        String exp = "New User Signup!\n" +
                     "Signup";
        Assert.assertEquals(exp,acc);



        //6. Enter name and already registered email address
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("text");

        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("text.p12@gmail.com");

        //7. Click 'Signup' button
      WebElement signup = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
      signup.click();


        //8. Verify error 'Email Address already exist!' is visible
        WebElement verify1 = driver.findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]"));
        String acc1 = verify1.getText();
        String exp1 = "Email Address already exist!";
        Assert.assertEquals(exp1,acc1);


    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
