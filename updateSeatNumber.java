package com.sqs.cloud9A;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class updateSeatNumber {
    WebDriver driver;



    public String  bookingID = "287";
    private By seatNumber = By.name("seat");
    private By saveUpdate = By.xpath("/html/body/div/div/div[2]/form/button");
    private By bodyTextLocator = By.tagName("body");
    private String updateSuccessful = "Flight successfully updated";

    public updateSeatNumber(WebDriver driver) {
        this.driver = driver;
    }



    public void saveUpdateButton(WebDriver driver){

        //System.out.println("Click Register Button");
        driver.findElement(saveUpdate).click();
    }


    public void assertUpdateSuccessful(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(updateSuccessful));
        System.out.println("Update of seat no  has been Successful ");
    }

    public void scanSeatandUpdate(String newSeat){


        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));

        System.out.println("Number of rows is " + rows.size());

        int rowNum =  rows.size();

        // Get booking id for latest booking
        List<WebElement> colVals2 = rows.get(rowNum-1).findElements(By.tagName("td"));
        //System.out.println("What is this " + colVals2.get(3).getText());
        String columnContents;


        for(int i=1; i<rowNum; i++){
            List<WebElement> colVals1 = rows.get(i).findElements(By.tagName("td"));
            for(int j=0; j<6; j++){
                columnContents = colVals1.get(j).getText();
                if (columnContents.equals(bookingID)) {
                    System.out.println("Yippeee,  found it: i=" + i + " : j = " + j);
                    System.out.println("Column Contents = " + columnContents);

                    //navigate to update
                    String  baseURL = "http://10.9.10.39:81/sqlite/Main/editflight.php?FlightID=" + bookingID;
                    driver.get(baseURL);
                    //clear current seat number and replace
                    driver.findElement(seatNumber).clear();
                    driver.findElement(seatNumber).sendKeys(newSeat);

                    saveUpdateButton(driver);
                    System.out.println("seat number updated !!");
                    assertUpdateSuccessful();




                }
                System.out.println("j= " + j + " : " + colVals1.get(j).getText());
                // If we come out of the loop and have not found the ID, then print a relevant message
            }
        }
    }
}
