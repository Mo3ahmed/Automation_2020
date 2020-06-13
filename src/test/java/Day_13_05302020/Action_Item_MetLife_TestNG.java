package Day_13_05302020;

import Reusable_Methods.Abstract_Class;
import Reusable_Methods.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Action_Item_MetLife_TestNG extends Abstract_Class {
    @Test
    public void MetLife() throws InterruptedException {
        //create an ArrayList for the following variables
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11208");
        zipCode.add("11218");
        zipCode.add("10012");
        //ArrayList for dentalPrograms
        ArrayList<String> dentalProgram = new ArrayList<>();
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");
        //ArrayList for referralCodes
        ArrayList<String> referralCode = new ArrayList<>();
        referralCode.add("56729");
        referralCode.add("62863");
        referralCode.add("63537");

        //for loop will begin here
        for (int i = 0; i < zipCode.size(); i++) {
            logger.log(LogStatus.INFO,"Navigating to Google Home Page");
            driver.navigate().to("https://www.metlife.com");
            //wait time four seconds
            Thread.sleep(3000);
            //verify the tittle of the page and get tittle
            Reusable_Library_Loggers.verifyTitle(driver,"Insurance & Employee Benefit | Metlife",logger);
            //click on solution
            Reusable_Library_Loggers.clickElement(driver,"//*[contains(text(),'SOLUTION')]","Solution",logger);
            //click on dental program
            Reusable_Library_Loggers.clickElement(driver,"//*[contains(text(),'MetLife TakeAlong Dental')]","TakeAlong Dental",logger);
            //get title of the MetLife TakeAlong page
            Reusable_Library_Loggers.verifyTitle(driver,"MetLife TakeAlong Dental | MetLife",logger);
            Thread.sleep(2000);
            //find the element for the Enroll Now button and click
             Reusable_Library_Loggers.clickElement(driver,"//*[contains(text(),'Enroll Now')]","Enroll Now",logger);
             Thread.sleep(2000);
            //now defining ArrayList to switch between tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to second tab
            driver.switchTo().window(tabs.get(1));
            //wait time three seconds
            Thread.sleep(2000);
            Reusable_Library_Loggers.enterKeys(driver,"//*[@id='txtZipCode']",zipCode.get(i),"ZipCode",logger);
            //find the element of the 'GO' button and click
            Reusable_Library_Loggers.clickElement(driver,"//*[text()='GO']","Go button",logger);
            //select dental PPO
            Reusable_Library_Loggers.clickElement(driver,"//*[@class='" + dentalProgram.get(i) + "']","PPO",logger);
            //find the element for the Enroll in Program option and click
            Reusable_Library_Loggers.clickElement(driver,"//*[@id='topenrolltab']","Enroll Programs",logger);
            //inspect the referral field variable and find the element
            Reusable_Library_Loggers.enterKeys(driver,"//*[@id='txtBxPromocode']",referralCode.get(i),"promo code",logger);
            Thread.sleep(1000);
            //inspect the "GO" button and find the element and then click
            Reusable_Library_Loggers.clickElement(driver,"//button[text()='GO']","GO button",logger);
            Thread.sleep(1000);
            //find the element of the error message and capture text
            Reusable_Library_Loggers.captureText(driver,"//*[@id='lblRefCodeError']","Error Message",logger);
            //find the element of "Enroll without referral code" and click
            Reusable_Library_Loggers.clickElement(driver,"//*[@id='withoutrefcode']","Enroll without code",logger);
            //try & catch method will begin here
            try {
                //find PPOs "category" element and store the PPO text as a WebElement so i call it inside the my if else statement
                //here we need to use the first PPO text instead of the second PPO because for some weird reason it does not work
                WebElement ActualPPO = driver.findElement(By.xpath("//div[@class='col-sm-8']"));
                //if else statement to determine if the actual PPO match with the expect PPO
                if (ActualPPO.getText().contains(dentalProgram.get(i))) {
                    System.out.println("Actual PPO matches with the Expected PPO: " + ActualPPO.getText());
                } else {
                    System.out.println("Actual PPO does not matches with the Expected PPO " + ActualPPO.getText());
                }//end of if else
            } catch (Exception e) {
                System.out.println("Unable to capture text " + e);
            }//end of try and catch

            //wait time two seconds
            Thread.sleep(2000);

            //close the current tab
            driver.close();

            //switch back to the original tab
            driver.switchTo().window(tabs.get(0));

        }//end of for loop


    }//end of Test

} //end of class
