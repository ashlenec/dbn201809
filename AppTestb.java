package sqs.com.cloud9;


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */
public class AppTestb

{

    static WebDriver driver;
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
        Assert.assertEquals(actualTitle, expectedTitle);
        Thread.sleep(5000);

    }

    @BeforeClass

    public static void browserSetup() {


    }


    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldRegisterNewCustomer()

//Register Screen - FirstName, LastName, Email, Password
    {

        driver.findElement(By.linkText("Register")).click();

        registrationObject registrationPage;
        registrationPage = new registrationObject(driver);

        registrationPage.populateRegistration("Ashlene", "Curran", "ashc11@abc.com",
                "password");


    }


    @Test
    public void shouldLoginCustomer() throws InterruptedException {

        //driver.findElement(By.linkText("Login")).click();

        loginObject loginPage;
        loginPage = new loginObject(driver);
        loginPage.populateLogin("Ashlene.Curran@sqs.com",
                "Password123");

    }


    @Test
    public void shouldUpdateFlight() throws InterruptedException {

        //first log in customer
        shouldLoginCustomer();

        //Set the flight id and the seat number
        String flightID = "454";
        String newSeatNumber = "A99";

        // new itinerary object
        itineraryObject itineraryPage;
        itineraryPage = new itineraryObject(driver);



            editFlightObject editPage;
            editPage = new editFlightObject(driver);
            editPage.editBooking(driver, newSeatNumber);
        }



    @Test
    public void shouldDeleteFlight() throws InterruptedException {

        shouldLoginCustomer();

        //search for this flight
        String flightID = "474";


        // new itinerary object
        itineraryObject itineraryPage;
        itineraryPage = new itineraryObject(driver);
        //itineraryPage.scanBookings(flightID);
        String deleteFlightURL = "//10.9.10.39:81/sqlite/Main/deleteflight.php?FlightID=" + flightID;
       itineraryPage.scanBookings("474", "delete");
        //System.out.println("deleteflightURL is: " + deleteFlightURL);


        deleteFlightObject deleteFlightPage;
        deleteFlightPage = new deleteFlightObject(driver);
//        deleteFlightPage.assertDeleteFlight();


        //url search

        //url search


        }


    }



