package sqs.com.cloud9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class itineraryObject {
    WebDriver driver;

    public itineraryObject(WebDriver driver) {

        this.driver = driver;
    }

    public String scanBookings(String flightID, String performAction) {

        System.out.println("The Flight ID is : " + flightID);

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));

        System.out.println("The Number of rows is : " + rows.size());

        int rowNum = rows.size();
        String columnContents;
        Boolean flightIDFound = false;
        String updateURL = "URL NOT DEFINED";
        String updateURL1 = "URL NOT DEFINED";


        for (int i = 1; i < rowNum; i++) {
            List<WebElement> colVals1 = rows.get(i).findElements(By.tagName("td"));

            for (int j = 0; j < 6; j++) {
                columnContents = colVals1.get(j).getText();

                if (columnContents.equals(flightID)) {
                    System.out.println("Has Found : i=" + i + " : j = " + j);
                    System.out.println("Column Contents = " + columnContents);
                    flightIDFound = true;


                    updateURL = "http://10.9.10.39:81/sqlite/Main/editflight.php?FlightID=" + flightID;
                    updateURL1 = "//10.9.10.39:81/sqlite/Main/deleteflight.php?FlightID=" + flightID;
                }
            }

        }



                    if (flightIDFound) {
                    } else {
                       System.out.println("notfound");
                    }

                //update flight
                    if (performAction == "update") {
                        return updateURL;


                    } else {
                    //to delete flight
                        return updateURL1;
                    }

                }

            }



