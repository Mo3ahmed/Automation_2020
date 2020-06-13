package Metlife_Page_Object;

import Reusable_Methods.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MetLife_AI_PageObject extends Abstract_Class {
    @Test
    public void MetLife_Page_Object() throws InterruptedException {
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
            logger.log(LogStatus.INFO,"Navigating to the MetLife Home Page");
            driver.navigate().to("https://www.metlife.com");
            //wait time four seconds
            Thread.sleep(3000);
            //verify title
            MetLife_Base_Class.metLife_homePage().matchTitle();
            //click
            MetLife_Base_Class.metLife_homePage().SolutionTab();
            //click
            MetLife_Base_Class.metLife_homePage().TakeAlongDental();
            //verify title
            MetLife_Base_Class.metLife_enroll().verifyTittle();
            //click
            MetLife_Base_Class.metLife_enroll().ClickEnroll();

            //now defining ArrayList to switch between tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to second tab
            driver.switchTo().window(tabs.get(1));
            //wait time three seconds
            Thread.sleep(2000);
            //enter zipCode
            MetLife_Base_Class.metLife_zipCode().enterZipCode(zipCode.get(i));
            //click
            MetLife_Base_Class.metLife_zipCode().GoButton();
            Thread.sleep(3000);
            //Select PPOs
            MetLife_Base_Class.metLife_ppo().PPOPlans("//*[@class='" + dentalProgram.get(i) + "']");
            //click
            MetLife_Base_Class.metLife_ppo().ProgramEnroll();
            Thread.sleep(2000);
            //enter
            MetLife_Base_Class.metLife_ppo().referralCode(referralCode.get(i));
            //click go
            MetLife_Base_Class.metLife_ppo().ClickGoButton();
            //capture
            MetLife_Base_Class.metLife_ppo().ErrorMessage();
            //click
            MetLife_Base_Class.metLife_ppo().EnrollWithoutCode();
            Thread.sleep(2500);
            //capture ppo text
            MetLife_Base_Class.metLife_ppo().CapturePPOTittle(dentalProgram.get(i));
            //wait time two seconds
           // Thread.sleep(2000);

            //close the current tab
            driver.close();

            //switch back to the original tab
            driver.switchTo().window(tabs.get(0));

        }//end of for loop


    }//end of test

}//end of java class
