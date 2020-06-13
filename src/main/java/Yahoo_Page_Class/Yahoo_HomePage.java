package Yahoo_Page_Class;

import Reusable_Methods.Abstract_Class;
import Reusable_Methods.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_HomePage extends Abstract_Class {
    ExtentTest logger;

    //we need to create a constructor method that defines the page object
    //driver and logger to be reused locally to the page class
    public Yahoo_HomePage(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets to abstract class logger when you use it in page object concept
        this.logger= super.logger;
    }//end of constructor
   //page objects everything is a return method
   //method for SerachField
   public Yahoo_HomePage searchField(String userValue) throws InterruptedException {
       Reusable_Library_Loggers.enterKeys(driver,"//*[@id='header-search-input']",userValue,"Search Field",logger);
        return new Yahoo_HomePage(driver);
   }//end of Search field

    //method for Search icon
    public Yahoo_HomePage searchIcon() throws InterruptedException {
        Reusable_Library_Loggers.clickElement(driver,"//*[@id='header-desktop-search-button']","Search Icon",logger);
        // the driver that 1 used is returning you the same page
        return new Yahoo_HomePage(driver);
    }//end of Search icon


}//end of class
