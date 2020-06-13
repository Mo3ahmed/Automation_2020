package Day_13_05302020;

import Reusable_Methods.Abstract_Class;
import Reusable_Methods.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ActionItem_WeightWatch_Abstract extends Abstract_Class {

@Test
public void WeightWatch() throws InterruptedException {
        //Dynamic array to loop
        String[] zipCode = new String[3];
        zipCode[0] = "11208";
        zipCode[1] = "10302";
        zipCode[2] = "11218";

        //for loop will begin here
        for (int i = 0; i < zipCode.length; i++) {
            //navigate to weight watchers site
            logger.log(LogStatus.INFO,"Navigating to Weight Watcher Home Page");
            driver.navigate().to("https://www.weightwatchers.com");
            //wait to reload
            Thread.sleep(2000);
            //verify  the title of the page with the actual title
            //i will use if else statement to verify the tittle of the page
            Reusable_Library_Loggers.verifyTitle(driver,"Weight Watchers:Weight Loss & Welness Help",logger);
            //locate the studio link and click
            Reusable_Library_Loggers.clickElement(driver,"//*[@data-e2e-name='find_a workshop']","Studio link",logger);
            Thread.sleep(1000);
            //locating the search field and the search button and sending keys
            Reusable_Library_Loggers.enterKeys(driver,"//*[@name='meetingSearch']",zipCode[i],"Zipcode", logger);
            Thread.sleep(2000);
            Reusable_Library_Loggers.clickElement(driver,"//*[@spice='SEARCH_BUTTON']","Search",logger);
            Thread.sleep(2000);
            //Storing the linkElement so we can call it inside the if else statement
            //all the studios link share the same element but it is unique  so i saved the element as a string
            String linkElement = "//*[@class='location__name']";
            //if else condition will start from here
            //if the is zipCode = 0 then click on the 2nd link
            if (i == 0) {
                driver.findElements(By.xpath(linkElement)).get(0).click();
                Thread.sleep(2000);
            }
            //if the zipCode is = 1 then click on the 3rd link
            if (i == 1) {
                driver.findElements(By.xpath(linkElement)).get(1).click();
                Thread.sleep(2000);
            }
            //if the zipCode is = 2 then click on the 1st link
            if (i == 2) {
                driver.findElements(By.xpath(linkElement)).get(0).click();
                Thread.sleep(2000);
            }//end of if conditions
            //locating the address of the studio and getting the text
            Reusable_Library_Loggers.captureText(driver,"//*[@class='location']","Studio address",logger);
            //locating the table element and getting the text
            Reusable_Library_Loggers.captureText(driver,"//*[@class='meeting-schedule meeting-detail-bottom-section']","get hours of operation",logger);
            Thread.sleep(2000);

        }//end of loop

}//end of test method

}//end of class




