package Metlife_Page_Object;

import Reusable_Methods.Abstract_Class;
import Reusable_Methods.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class MetLife_ZipCode extends Abstract_Class {
    //define the logger so its local to the class
    ExtentTest logger;

    //we need to create a constructor method that defines the page object
    //driver and logger to be reused locally to the page class
    public MetLife_ZipCode(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets to abstract class logger when you use it in page object concept
        this.logger= super.logger;
    }//end of constructor

    //method to enter ZipCode
    public MetLife_ZipCode enterZipCode(String UserInput) throws InterruptedException {
        Reusable_Library_Loggers.enterKeys(driver,"//*[@id='txtZipCode']",UserInput,"ZipCode",logger);
        return new MetLife_ZipCode(driver);
    }//end of ZipCode Method

    //Method to click on the Go button
    public MetLife_ZipCode GoButton() throws InterruptedException {
        Reusable_Library_Loggers.clickElement(driver,"//*[text()='GO']","Go",logger);
        return new MetLife_ZipCode(driver);
    }//end of Go button




}//end of java class
