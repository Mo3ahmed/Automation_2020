package Day_13_05302020;

import Reusable_Methods.Abstract_Class;
import Reusable_Methods.Reusable_Library;
import Reusable_Methods.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class List_Boolean_Abstract extends Abstract_Class {
    @Test
    public void yahoo_verification() throws InterruptedException {
        //navigate to yahoo.com
        logger.log(LogStatus.INFO,"navigating to yahoo.com");
        driver.navigate().to("https://www.yahoo.com");
        //wait time
        Thread.sleep(3000);
        //i want to count all the links in yahoo and print it
        logger.log(LogStatus.INFO,"getting all the nav bars count");
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px)')]"));
        //print the total links count
        System.out.println("Total links are "+ linkCount.size());
        logger.log(LogStatus.INFO,"Total links are "+ linkCount.size());
        //sign in
        Reusable_Library_Loggers.clickElement(driver,"//*[@id='Menu']","Sign in",logger);
        //wait time
        Thread.sleep(2000);
        //check if the sign in checkbox is selected using boolean
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //using if else condition
        if(checkboxState == true){
            System.out.println("Checkbox is selected by default ");
            logger.log(LogStatus.PASS,"Checkbox is selected by default");
        }else {
            System.out.println("Checkbox is not selected by default");
            logger.log(LogStatus.FAIL,"Checkbox is not selected by default");

        }//end of is else

       // System.out.println("is element selected? " +checkboxState);


    }//end of test


}//end of class
