package testsuite;

import basebrowser.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest_2 extends BaseTest {
    String baseUrl = "http://automationexercise.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void LoginUserwithincorrectemailandpassword() {
        // Verify that home page is visible successfully
        String verify = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]")).getText();
        String accmess = verify.substring(0);
        System.out.println(accmess);
        String expmess ="Home";
        Assert.assertEquals(expmess, accmess);


        //Click on 'Signup / Login' button
        //driver.findElement(By.linkText(" Signup / Login")).click();
        WebElement login = driver.findElement(By.linkText("Signup / Login"));
        login.click();

        // Verify 'Login to your account' is visible
        String verfy = driver.findElement(By.xpath("//div[@class='login-form']")).getText();
        String acmess = verfy.substring(0);
        System.out.println(acmess);
        String exmess = "Login to your account\n" +
                        "Login";

        Assert.assertEquals(exmess,acmess);



        //Enter incorrect email address and password
        //  driver.findElement(By.xpath("//input[@name='email']")).sendKeys("text12@gmail.com");
        WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
        username.sendKeys("text12@gmail.com");

        // driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12456");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("12356");

        //Click 'login' button
        //driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
        WebElement login1 = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        login1.click();


        //Verify error 'Your email or password is incorrect!' is visible
         String verify2 = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).getText();
         String acc2 = verify2.substring(0);
        System.out.println(acc2);
         String exp2 = "Your email or password is incorrect!";
         Assert.assertEquals(exp2,acc2);

    }
    @After
    public void teardown(){
        closeBrowser();
    }
}