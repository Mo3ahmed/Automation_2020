package LibertyMutal_Page_Object;

import Reusable_Methods.Abstract_Class;
import Reusable_Methods.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LibertyMutual_HomePage extends Abstract_Class {
    //define the logger so it is local to the class
    ExtentTest logger;

    //we need to create a constructor method that defines the page object
    //driver and logger to be reused locally to the page class
    public LibertyMutual_HomePage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        //local page logger gets to abstract class logger when you use it in page object concept
        this.logger = super.logger;
    }//end of constructor

    //Method to scroll to bottom of the page
    public LibertyMutual_HomePage ScrollToBottom() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,5000)");
        Thread.sleep(2000);
        return new LibertyMutual_HomePage(driver);
    }//end of Scroll Method

    //Method to click on FeedBack
    public LibertyMutual_HomePage FeedBackButton() throws InterruptedException {
        Reusable_Library_Loggers.clickElement(driver, "//*[text()='Give us your feedback']", "Feedback", logger);
        return new LibertyMutual_HomePage(driver);
    }//end of click method


}//end of class
