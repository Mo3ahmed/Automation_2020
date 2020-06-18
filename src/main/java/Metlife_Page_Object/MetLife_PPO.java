package Metlife_Page_Object;

import Reusable_Methods.Abstract_Class;
import Reusable_Methods.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MetLife_PPO extends Abstract_Class {
    //define the logger so its local to the class
    ExtentTest logger;

    //we need to create a constructor method that defines the page object
    //driver and logger to be reused locally to the page class
    public MetLife_PPO(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets to abstract class logger when you use it in page object concept
        this.logger= super.logger;
    }//end of constructor

    //Method for selecting a Dental PPO
    public MetLife_PPO PPOPlans(String Xpath) throws InterruptedException {
        Reusable_Library_Loggers.clickElement(driver,Xpath,"PPO",logger);
        return new MetLife_PPO(driver);
    }//end of

    //method to click enroll in program
    public MetLife_PPO ProgramEnroll() throws InterruptedException {
        Reusable_Library_Loggers.clickElement(driver,"//*[@id='topenrolltab']","Enroll Program",logger);
        return new MetLife_PPO(driver);
    }//end of enroll program method

    //method to enter referral code
    public MetLife_PPO referralCode(String ReferralCode) throws InterruptedException {
        Reusable_Library_Loggers.enterKeys(driver,"//*[@id='txtBxPromocode']",ReferralCode,"PromoCode",logger);
        return new MetLife_PPO(driver);
    }//end of referral code

    //Method to click on Go button
    public MetLife_PPO ClickGoButton() throws InterruptedException {
        Reusable_Library_Loggers.clickElement(driver,"//button[text()='GO']","Go Button",logger);
        return new MetLife_PPO(driver);
    }//end of the Go button

    //method to capture error message
    public MetLife_PPO ErrorMessage() throws InterruptedException {
        Reusable_Library_Loggers.captureText(driver,"//*[@id='lblRefCodeError']","Error Message",logger);
        return new MetLife_PPO(driver);
    }//end of the ErrorMethod

    //Method to enroll without a code
    public MetLife_PPO EnrollWithoutCode() throws InterruptedException {
        Reusable_Library_Loggers.clickElement(driver,"//*[@id='withoutrefcode']","Enroll Without Code",logger);
        return new MetLife_PPO(driver);
    }//end of enroll without code

    //Method to capture PPO title
    public MetLife_PPO CapturePPOTittle(String DentalProgram) {
        //try and catch method will begin here
        try {
            //find PPOs "category" element and store the PPO text as a WebElement so i call it inside the my if else statement
            //here we need to use the first PPO text instead of the second PPO because for some weird reason it does not work
            WebElement ActualPPO = driver.findElement(By.xpath("//div[@class='col-sm-8']"));
            //if else statement to determine if the actual PPO match with the expect PPO
            if (ActualPPO.getText().contains(DentalProgram)) {
                System.out.println("Actual PPO matches with the Expected PPO: " + ActualPPO.getText());
            } else {
                System.out.println("Actual PPO does not matches with the Expected PPO " + ActualPPO.getText());
            }//end of if else
        } catch (Exception e) {
            System.out.println("Unable to capture text " + e);
        }//end of try and catch
        return new MetLife_PPO(driver);
    }//end of PPO Tittle



}//end of the class

