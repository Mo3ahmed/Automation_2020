package Day11_05172020;

import Reusable_Methods.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Kayak_Action_Item {
    //set the driver
    WebDriver driver;
    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet wSheet;

    @BeforeSuite
    public void PreCondition() throws IOException, BiffException, InterruptedException {
        //define the path of readable file
        readableFile = Workbook.getWorkbook(new File("src//main//resources//Google_Search.xls"));
        //define readable sheet
        readableSheet = readableFile.getSheet(1);
        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src//main//resources//Google_Search_Results.xls"), readableFile);
        //define the writable sheet
        wSheet = writableFile.getSheet(1);
        //defined the driver
        driver = Reusable_Library.setDriver();
    }//end of BeforeMethod

    @Test
    public void KayakCarSelect() throws InterruptedException, WriteException {
        //initialize the rows and get contents from the rows
        int row = wSheet.getRows();
        //for loop will start here
        for (int i = 1; i < row; i++) {
            //store all the vales from the excel column as a string variable
            String Airport = wSheet.getCell(0, i).getContents();
            String StartDate = wSheet.getCell(1, i).getContents();
            String StartTime = wSheet.getCell(2, i).getContents();
            String EndDate = wSheet.getCell(3, i).getContents();
            String EndTime = wSheet.getCell(4, i).getContents();
            String VehicleSize = wSheet.getCell(5, i).getContents();
            String VehicleInfo = wSheet.getCell(6, i).getContents();
            String TotalAmount = wSheet.getCell(7, i).getContents();

            //navigate to Kayak home page
            driver.navigate().to("https://www.kayak.com");
            //timeout
            Thread.sleep(2000);
            //click on search field using click method
            Reusable_Library.clickElement(driver, "//*[@data-placeholder='Enter an airport or city']", "Search field");
            //type in airport name using the enterKeys method
            Reusable_Library.enterKeys(driver, "//*[@name='pickup']", Airport, "Enter AirportName");
            //select the desired airport
            Reusable_Library.MouseClick(driver, "//li[@tabindex='0']", "click on airport");
            //click on end date on calender
            Reusable_Library.clickByIndex(driver, "//*[@aria-label='Drop-off date']", 0, "click on end date");
            //select the end date first
            Reusable_Library.userTypeAndHitEnter(driver, "//*[contains(@id,'-dropoff-date-input')]", EndDate, "End Date");
            //click on end time using clickByIndex Method
            Reusable_Library.clickByIndex(driver, "//div[@class='_iKN _j0E _iQh _j0F']", 1, "Click Time");
            //click on desire time
            Reusable_Library.clickByIndex(driver, "//li[@aria-label='" + EndTime + "']", 1, "End Time");
            //click on Start Date using clickByIndex Method
            Reusable_Library.clickByIndex(driver, "//*[@aria-label='Pick-up date']", 0, "Click Start Calender");
            //type in the pick up dates using userType Method
            Reusable_Library.userTypeAndHitEnter(driver, "//div[contains(@id,'pickup-date-input')]", StartDate, "Start Date");
            //click outside using mouseClick
            Reusable_Library.MouseClick(driver, "//*[@class='title-section']", "Click Outside");
            //select start time
            Reusable_Library.clickByIndex(driver, "//li[@aria-label='" + StartTime + "']", 0, "StartTime");
            //click on search icon
            Reusable_Library.clickElement(driver, "//*[@class='_h-2 _ivP _iv1']", "Search icon");
            Thread.sleep(2000);
            //click view deal
            Reusable_Library.clickByIndex(driver, "//div[contains(@id,'" + VehicleSize + "')]", 1, "Car Size");
            // wait few seconds as it take some time to load
            Thread.sleep(4000);
            //click on view deal using index
            Reusable_Library.clickByIndex(driver, "//*[text()='View Deal']", 1, "View Deal");
            //wait time
            Thread.sleep(3000);

            //now defining ArrayList to switch between tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to second tab
            driver.switchTo().window(tabs.get(1));
            //wait time
            Thread.sleep(2000);
            //capture the vehicle pick up info using the capture text method
            String vehicleInfo = Reusable_Library.captureText(driver, "//*[@class='col-12 col-lg-8 col-xl-8 carresult' or @class='Checkout-Car-Book-Main-CarSummary' or @class='search_filters']", "Results");
            //print the results for vehicle info
            System.out.println("My Vehicle info is " + vehicleInfo);
            //write the vehicle info back to writeable sheet
            Label info = new Label(6, i, vehicleInfo);
            //write back to writable cell
            wSheet.addCell(info);
            //close the current tab
            driver.close();

            //switch back to the original tab
            driver.switchTo().window(tabs.get(0));
            //delete all cookies
            driver.manage().deleteAllCookies();

        }//end of for loop

    }//end of test

    @AfterSuite
    public void PostCondition() throws IOException, WriteException {
        //write the results back to the excel sheet
        writableFile.write();
        writableFile.close();
        readableFile.close();

        //quit the browser
        driver.quit();
    }//end of After method


}//end of Java Class
