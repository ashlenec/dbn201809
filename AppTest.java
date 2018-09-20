package sqs.com.cloud9;



import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;



/**
 * Unit test for simple App.
 */
public class AppTest 

{

   static  WebDriver driver;
   private String registrationSuccessful = "Registration Was Successful ";
   private By bodyTextLocator = By.tagName("body");
   private String cloud9RegistrationHeader = "Cloud 9 - Register";

    @Before
            public void testSetup() throws InterruptedException {
        System.setProperty("ChromeDriver", "C:\\chromedriver");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        String baseUrl = "http://10.9.10.39:81/sqlite/Main/login.html";
        String expectedTitle = "Cloud9 Airlines";
        driver.get(baseUrl);
        driver.getTitle();
        String actualTitle = driver.getTitle();
        System.out.println("Actual title is : " + actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle);
    Thread.sleep(5000);

    }

    @BeforeClass

    public static void browserSetup()
    {


    }


    /**
     * Rigorous Test :-)
     */
   @Test
public void shouldRegisterNewCustomer() throws InterruptedException

//Register Screen - FirstName, LastName, Email, Password
   {
    driver.findElement(By.xpath("/html/body/div/form/center/a")).click();
    driver.findElement(By.name("firstname")).sendKeys("Ashlene");
    driver.findElement(By.name("lastname")).sendKeys("Curran");
    driver.findElement(By.name("email")).sendKeys("Ashlene1Curran1@sqs.com");
    driver.findElement(By.name("password")).sendKeys("Password123");
    driver.findElement(By.xpath("/html/body/div/form/button")).click();
    Thread.sleep(5000);

    String bodyText = driver.findElement(bodyTextLocator).getText();
    Assert.assertTrue("Text not found!", bodyText.contains(registrationSuccessful));


}


    @Test
    public void shouldLoginCustomer() throws InterruptedException

    //Register Screen - FirstName, LastName, Email, Password
    //Copy - xpath control f -- copy (xpath)
    {

        driver.findElement(By.xpath("/html/body/div/form")).click();
        driver.findElement(By.xpath("/html/body/div/form")).click();
        driver.findElement(By.name("email")).sendKeys("Ashlene.Curran@sqs.com");
        driver.findElement(By.name("password")).sendKeys("Password123");
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        //Go to homepage
        Thread.sleep(5000);
        driver.findElement(By.xpath(" /html/body/center[3]/a")).click();

        Thread.sleep(5000);



    }



   /* @After
    public void tearDown () {
        driver.close();
    }*/


    /*@Test
    public void shouldAnswerWithFalse()
    {
        assertTrue( false );
    }

*/
}


