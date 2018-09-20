package sqs.com.cloud9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class deleteFlightObject {

    WebDriver driver;

    //delete button


    public deleteFlightObject(WebDriver driver) {

        this.driver = driver;
    }

    public void assertDeleteFlight() {

        String editHeader = "Flight successfully deleted.";
        By bodyTextLocator = By.tagName("body");

        String bodyText = driver.findElement(bodyTextLocator).getText();
//        Assert.assertTrue("Text not found!", bodyText.contains(editHeader));

    }

    public void populateDelete(String flightID) {

        assertDeleteFlight();
    }
}




