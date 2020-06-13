package Metlife_Page_Object;

import Reusable_Methods.Abstract_Class;
import Reusable_Methods.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Enroll extends Abstract_Class {
    //define the logger so its local to the class
    ExtentTest logger;

    //we need to create a constructor method that defines the page object
    //driver and logger to be reused locally to the page class
    public MetLife_Enroll(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets to abstract class logger when you use it in page object concept
        this.logger= super.logger;
    }//end of constructor

//verify the title of the TakeAlong Dental Page

    public MetLife_Enroll verifyTittle() throws InterruptedException {
    Reusable_Library_Loggers.verifyTitle(driver,"MetLife TakeAlong Dental | MetLife",logger);
    return new MetLife_Enroll(driver);
    }//end of verifying tittle

    //click on enroll now
    public MetLife_Enroll ClickEnroll() throws InterruptedException {
    Reusable_Library_Loggers.clickElement(driver,"//*[contains(text(),'Enroll Now')]","EnrollNow",logger);
    return new MetLife_Enroll(driver);
    }//end of enroll now


}//end of class
