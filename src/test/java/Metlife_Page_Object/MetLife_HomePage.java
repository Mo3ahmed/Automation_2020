package Metlife_Page_Object;

import Reusable_Methods.Abstract_Class;
import Reusable_Methods.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

public class MetLife_HomePage extends Abstract_Class {
    //define the logger so its local to the class
    ExtentTest logger;

    //we need to create a constructor method that defines the page object
    //driver and logger to be reused locally to the page class
    public MetLife_HomePage(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets to abstract class logger when you use it in page object concept
        this.logger= super.logger;
    }//end of constructor

//verify title of the home page
    public MetLife_HomePage matchTitle() throws InterruptedException {
        Reusable_Library_Loggers.verifyTitle(driver,"Insurance & Employee Benefit | Metlife",logger);
        return new MetLife_HomePage(driver);
    }//end of verifyTtitle

//hover over to the solution
    public MetLife_HomePage SolutionTab() throws InterruptedException {
        Reusable_Library_Loggers.Hover(driver,"//*[contains(text(),'SOLUTION')]","Solution",logger);
        return new MetLife_HomePage(driver);
    }//end of solution Tab

//click on MetLife TakeAlong Dental
public MetLife_HomePage TakeAlongDental() throws InterruptedException {
        Reusable_Library_Loggers.clickElement(driver,"//a[text()='MetLife TakeAlong Dental']","TakeAlongDental",logger);
        return new MetLife_HomePage(driver);
}//end of TakeAlong Dental


}//end of class
