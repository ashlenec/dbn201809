package sqs.com.cloud9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginObject {

        WebDriver driver;

    // Text Boxes - email and password

        private By emailLocator = By.name("email");
        private By passwordLocator = By.name("password");
        private By loginButtonLocator = By.xpath("/html/body/div/form/button");
        private By bodyTextLocator = By.tagName("body");

        //button for home-page
        private By homepageButtonLocator = By.xpath("/html/body/center[3]/a");

        //Login page headers
        private String cloud9LoginHeader = "Cloud9 - Sign in";

        //login successful header
        private String loginSuccessful = "Welcome";


        //login object
        public loginObject(WebDriver driver) {

            this.driver = driver;
        }
        // Method to click login  - find login button and click
           public void clickLogin(WebDriver driver){

        //System.out.println("Click Login Button");
        driver.findElement(loginButtonLocator).click();
    }


    public void clickHomepage(WebDriver driver){

        //System.out.println("Click Login Button");
        driver.findElement(homepageButtonLocator).click();
        System.out.println("Proceeding to Homepage ");
    }

    //assert the login header - check header contains welcome
        public void assertLoginHeader(){
            String bodyText = driver.findElement(bodyTextLocator).getText();
            Assert.assertTrue("Text not found!", bodyText.contains(cloud9LoginHeader));
        }


        //check login successful
        public void assertLoginSuccessful(){
            String bodyText = driver.findElement(bodyTextLocator).getText();
            Assert.assertTrue("Text not found!", bodyText.contains(loginSuccessful));
            System.out.println("Login has been Successful ");
        }

        //method to populate the text boxes - email and password - select login.
        public void populateLogin(String emailAddress, String password) throws InterruptedException {

            assertLoginHeader();
            driver.findElement(emailLocator).sendKeys(emailAddress);
            driver.findElement(passwordLocator).sendKeys(password);
            clickLogin(driver);
            assertLoginSuccessful();

            //navigate to homepage
            clickHomepage(driver);

        }
    }

