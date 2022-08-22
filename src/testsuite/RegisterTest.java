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
        String verify = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]")).getText();
        String accmess = verify.substring(0);
        System.out.println(accmess);
        String expmess ="Home";
        Assert.assertEquals(expmess, accmess);



        //4. Click on 'Signup / Login' button
        //driver.findElement(By.linkText(" Signup / Login")).click();
        WebElement login = driver.findElement(By.linkText("Signup / Login"));
        login.click();


        //5. Verify 'New User Signup!' is visible
        String ver = driver.findElement(By.xpath("//div[@class='signup-form']")).getText();
        String acc = ver.substring(0);
        System.out.println(acc);
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
        String verify1 = driver.findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]")).getText();
        String acc1 = verify1.substring(0);
        System.out.println(acc1);
        String exp1 = "Email Address already exist!";
        Assert.assertEquals(exp1,acc1);


    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
