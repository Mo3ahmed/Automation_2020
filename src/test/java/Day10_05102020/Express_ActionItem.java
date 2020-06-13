package Day10_05102020;

import Reusable_Methods.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Express_ActionItem {
    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {
        //locate the readable file path
        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/Xpress_ActionItem.xls"));
        //locate the readable worksheet
        Sheet readableSheet = readableFile.getSheet(0);
        // create a writable workbook to mimic readable file because we shouldn't write on readable file
        WritableWorkbook writeableFile = Workbook.createWorkbook(new File("src/Resource/Xpress_ActionItem_Results.xls"), readableFile);
        //create writeable sheet
        WritableSheet writableSheet = writeableFile.getSheet(0);
        //get the total rows which are not empty
        int rows = writableSheet.getRows();
        //define the webDriver using reusable library
        WebDriver driver = Reusable_Library.setDriver();
        //define for loop
        for (int i = 1; i < rows; i++) {
            //Store all the values from the column as a String Variable
            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String streetAdd = writableSheet.getCell(6, i).getContents();
            String postalCode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String State = writableSheet.getCell(9, i).getContents();
            String CCNumber = writableSheet.getCell(10, i).getContents();
            String ExpMonth = writableSheet.getCell(11, i).getContents();
            String ExpYear = writableSheet.getCell(12, i).getContents();
            String CvvCode = writableSheet.getCell(13, i).getContents();
            String ErrorMessage = writableSheet.getCell(14, i).getContents();

            //navigate to Express Home page
            driver.navigate().to("https://www.express.com");
            //timeout
            Thread.sleep(3000);
            //call reusable method to hover over the Women tab
            Reusable_Library.Hover(driver, "//a[text()='Women']", "Women");
            //Timeout
            Thread.sleep(1000);
            //call reusable method to click on dress using mouseClick
            Reusable_Library.MouseClick(driver, "//a[text()='Dresses']", "Dress");
            //timeout
           // Thread.sleep(5000);
            //call your click method to click on dress
            Reusable_Library.clickElement(driver, "//a[text()='off the shoulder ruffle maxi dress']", " Maxi Dress");
            //select a size using click method
            Reusable_Library.clickElement(driver,"//*[text()='"+size+"']","Size");
           // Reusable_Library.clickElement(driver, "//button[@value='" + size + "']", "size");
            //Click on Add to Bag using click Method
            Reusable_Library.clickElement(driver, "//*[text()='Add to Bag']", "Add to bag");
            //timeout
            Thread.sleep(2000);
            //hover over the shopping bag
            Reusable_Library.Hover(driver,"//div[@class='DesktopHeader_icons__25y0X ravenDesktopIcons']/div[3]","View Bag");
            //timeout
            Thread.sleep(2000);
            //Click on the view bag using click method
            Reusable_Library.clickElement(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ']","View Bag");
            //timeout
            Thread.sleep(2000);
            //enter quantity using drop dropdown menu
            Reusable_Library.dropdownByText(driver,"//*[@id='qdd-0-quantity']",quantity,"Quantity");
            //Click on checkout using the clickable method
            Reusable_Library.clickElement(driver,"//*[text()='Checkout']","CheckOut");
            //click on continue  as a guest
            Reusable_Library.clickElement(driver,"//*[text()='Continue as Guest']","Continue as Guest ");
            Thread.sleep(2000);
            //Enter First Name using sendKeys Method
            Reusable_Library.enterKeys(driver,"//*[@id='contact-information-firstname']",firstName,"First Name");
            //Enter last Name using sendKeys Method
            Reusable_Library.enterKeys(driver,"//*[@name='lastname']",lastName,"Last name");
            //Enter Email using sendKeys method
            Reusable_Library.enterKeys(driver,"//input[@name='email']",email,"Enter email");
            //Renter Email using the sendKeys method
            Reusable_Library.enterKeys(driver,"//*[@name='confirmEmail']",email,"Confirm Email");
            //Enter Phone number using sendKeys Method
            Reusable_Library.enterKeys(driver,"//*[@name='phone']",phoneNumber,"Phone Number");
            //click continue using the click method
            Reusable_Library.clickElement(driver,"//*[text()='Continue']","Continue");
            //timeout
            Thread.sleep(2000);
            //enter Street Address using sendKeys Method
            Reusable_Library.enterKeys(driver,"//*[@name='shipping.line1']", streetAdd,"Street Address");
            //Enter zipCode using sendKeys Method
            Reusable_Library.enterKeys(driver,"//*[@name='shipping.postalCode']",postalCode,"ZipCode");
            //Enter City using sendKeys Method
            Reusable_Library.enterKeys(driver,"//*[@name='shipping.city']",city,"Enter City ");
            //Enter the State using dropdown method
            Reusable_Library.dropdownByText(driver,"//*[@name='shipping.state']",State,"State");
            //Click Continue
            Reusable_Library.clickElement(driver,"//*[text()='Continue']","Continue");
            //timeout
            Thread.sleep(2000);
            //Click on continue again
            Reusable_Library.clickElement(driver,"//*[text()='Continue']","Continue");
            //timeout
            Thread.sleep(2000);
            //enter credit card info using the sendKeys Method
            Reusable_Library.enterKeys(driver,"//*[@id='creditCardNumberInput']",CCNumber,"Credit Card Number");
            //select Exp Month using the select Method
            Reusable_Library.dropdownByText(driver,"//select[@name='expMonth']",ExpMonth,"Exp Month");
            //select Exp Year using the select Method
            Reusable_Library.dropdownByText(driver,"//select[@name='expYear']",ExpYear,"Exp Year");
            //end CVV code using sendKeys Method
            Reusable_Library.enterKeys(driver,"//*[@name='cvv']",CvvCode,"CVV Code");
            //Click on Place order using the Click Method
            Reusable_Library.clickElement(driver,"//*[text()='Place Order']","Place Order");
            //timeout
            Thread.sleep(2000);
            //Store the error result as a String so we can call it in our print Statement
            String results= Reusable_Library.captureText(driver,"//div[@id='rvn-note-NaN']","Error Message");
            //Print the statement
            System.out.println("My error Message is " + results);

            //write the search number result back to writable sheet
            Label label = new Label(14,i,results);

            //write back to cell
            writableSheet.addCell(label);

            driver.manage().deleteAllCookies();

        }//end of for loop

        //write and close the writeable and readable close
        writeableFile.write();
        writeableFile.close();
        readableFile.close();

        //quit the browser
        driver.quit();

        //open the writable worksheet to view the results
        Desktop.getDesktop().open(new File("src\\Resource\\Xpress_ActionItem_Results.xls"));

    }//end of main method
}//end of class
