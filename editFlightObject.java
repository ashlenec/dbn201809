package sqs.com.cloud9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class editFlightObject {
    WebDriver driver;

    private By seatNo = By.id("seat");
    private By updateBtn = By.xpath(("/html/body/div/div/div[2]/form/button"));


    public editFlightObject(WebDriver driver) {

        this.driver = driver;
    }

    public void assertEditPage(){

        String editHeader = "Edit Flight";
        By bodyTextLocator = By.tagName("body");

        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(editHeader));

    }

    public void assertUpdatedFlightInfo(){

        String editHeader = "Flight successfully updated";
        By bodyTextLocator = By.tagName("body");

        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(editHeader));

    }


    public void editBooking(WebDriver driver,  String newSeat) throws InterruptedException {

        assertEditPage();
        //Clear current seat no field.
        driver.findElement(seatNo).clear();
        //add new seat number
        driver.findElement(seatNo).sendKeys(newSeat);
        //select update button
        driver.findElement(updateBtn).click();
        //assert if true
        assertUpdatedFlightInfo();
    }
}
