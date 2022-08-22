package testsuite;

import basebrowser.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Logout extends BaseTest {
    String baseUrl = "http://automationexercise.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void  LogoutUser(){
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


        //5. Verify 'Login to your account' is visible
        String verfy = driver.findElement(By.xpath("//div[@class='login-form']")).getText();
        String acmess = verfy.substring(0);
        System.out.println(accmess);
        String exmess = "Login to your account\n" +
                        "Login";

        Assert.assertEquals(exmess,acmess);



        //6. Enter correct email address and password
        //  driver.findElement(By.xpath("//input[@name='email']")).sendKeys("text.p12@gmail.com");
        WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
        username.sendKeys("text.p12@gmail.com");

        // driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("123456");



        //7. Click 'login' button
        //driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
        WebElement login1 = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        login1.click();



        //8. Verify that 'Logged in as username' is visible
        String verify1 = driver.findElement(By.xpath("//*[contains(text(),' Logged in as ')]")).getText();
        String acc1 = verify1.substring(0);
        System.out.println(acc1);
        String exp1 = "Logged in as test";
        Assert.assertEquals(exp1,acc1);


        //9. Click 'Logout' button

        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();


        //10. Verify that user is navigated to login page
        String verfy1 = driver.findElement(By.xpath("//div[@class='login-form']")).getText();
        String acmess1 = verfy.substring(0);
        System.out.println(acmess1);
        String exmess1 = "Login to your account\n" +
                "Login";

        Assert.assertEquals(exmess1,acmess1);




    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
