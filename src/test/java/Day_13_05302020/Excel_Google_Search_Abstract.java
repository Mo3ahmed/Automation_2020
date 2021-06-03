package Day_13_05302020;

import Reusable_Methods.Abstract_Class;
import Reusable_Methods.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Excel_Google_Search_Abstract extends Abstract_Class {
    @Test
   public void GoogleSearch() throws IOException, BiffException, WriteException, InterruptedException {
    //Step 1:
   //locate the readable file path
        Workbook readableFile = Workbook.getWorkbook(new File("src//Main//resources//Google_search.xls"));
    //Step 2:
    //locate the readable worksheet
        Sheet readableSheet = readableFile.getSheet(0);
    //Step 3
        // create a writable workbook to mimic readable file because we shouldn't write on readable file
        WritableWorkbook writeableFile = Workbook.createWorkbook(new File("src//Main//resources//Google_search_Result.xls"),readableFile);
     //create writeable sheet
        WritableSheet writableSheet = writeableFile.getSheet(0);
     //get the total rows which are not empty
        int rows = writableSheet.getRows();;
        //define for loop
        for(int i=1; i<rows; i++){
        //Step 4:
        //store the cars column value as a String variable
        //columns are always hard coded whereas the rows are dynamic based on your i
        String cars = writableSheet.getCell(0,i).getContents();
        //navigate to google page
        logger.log(LogStatus.INFO,"Navigating to Google Home Page");
        driver.navigate().to("https://www.google.com");
        //timeout
        Thread.sleep(2000);
        //reusable library to enter car values on search field
        Reusable_Library_Loggers.enterKeys(driver,"//*[@name='q']",cars,"Search Field",logger);
        //reusable library to click on google search
        Reusable_Library_Loggers.submit(driver,"//*[@name='btnK']","Google Search",logger);
        //timeout
        Thread.sleep(2000);
        String result = Reusable_Library_Loggers.captureText(driver,"//*[@id='result-stats']","Search Result",logger);
        String[] resultArray = result.split(" ");
            System.out.println("My search number is " + resultArray[1]);
         logger.log(LogStatus.INFO,"My search number is " + resultArray[1]);
        //Step 5
        //write the search number result back to writable sheet
            //1 represent the columns which you want to send new result and I is the dynamic row
            Label label = new Label(1,i,resultArray[1] + " " + resultArray[3]+ " "+resultArray[4]);
            //adding back to writing cell
            writableSheet.addCell(label);
        }//end of loop
        //outside of the loop we need to write and close excel
        writeableFile.write();
        writeableFile.close();
        readableFile.close();

    }//end of Test method

}//end of Java Class


//adding one more line