package testsuite;

import basebrowser.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest_1 extends BaseTest {

    String baseUrl ="http://automationexercise.com";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void LoginUserwithcorrectemailandpassword(){
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
        String acmess = verfy.substring(0,21);
        System.out.println(acmess);
        String exmess = "Login to your account";


        Assert.assertEquals(exmess,acmess);



        //Enter correct email address and password
      //  driver.findElement(By.xpath("//input[@name='email']")).sendKeys("text.p12@gmail.com");
           WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
           username.sendKeys("text.p12@gmail.com");

       // driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
           WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
           password.sendKeys("123456");



        // Click 'login' button
       //driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
        WebElement login1 = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        login1.click();


        //Verify that 'Logged in as username' is visible
        String verify1 = driver.findElement(By.xpath("//*[contains(text(),' Logged in as ')]")).getText();
        String acc1 = verify1.substring(0);
        System.out.println(acc1);
        String exp1 = "Logged in as test";
        Assert.assertEquals(exp1,acc1);


       //Click 'Delete Account' button
       // driver.findElement(By.linkText("Delete Account")).click();
        WebElement delete = driver.findElement(By.linkText("Delete Account"));
        delete.click();




       //. Verify that 'ACCOUNT DELETED!' is visible
        String ver = driver.findElement(By.xpath("//div[@class='page-header']")).getText();
        String acc = ver.substring(0);
        System.out.println(acc);
        String exp = "Delete Account";

        Assert.assertEquals(exp,acc);

    }
    @After
    public void teardown(){
        closeBrowser();
    }



}
