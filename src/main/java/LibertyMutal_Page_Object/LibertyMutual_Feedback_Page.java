package LibertyMutal_Page_Object;

import Reusable_Methods.Abstract_Class;
import Reusable_Methods.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LibertyMutual_Feedback_Page extends Abstract_Class {
    //define the logger so its local to the class
    ExtentTest logger;

    //we need to create a constructor method that defines the page object
// driver and logger to be reused locally to the page class
    public LibertyMutual_Feedback_Page(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        //local page logger gets abstract class logger when you use it in page object concept
        this.logger = super.logger;
    }//end of constructor

    //click on radio button
    public LibertyMutual_Feedback_Page RadioButton() throws InterruptedException {
        Reusable_Library_Loggers.clickByIndex(driver, "//*[@class='q-radio']", 0, "radio button", logger);
        return new LibertyMutual_Feedback_Page(driver);
    }//end of radio click

    //click on comment box and type the message
    public LibertyMutual_Feedback_Page CommentBox() throws InterruptedException {
        Reusable_Library_Loggers.enterKeys(driver, "//*[@id='QR~QID9']", "I really like the customer service agents", "Comment Box", logger);
        return new LibertyMutual_Feedback_Page(driver);
    }//end of comment box

    //click on submit button
    public LibertyMutual_Feedback_Page Submit() throws InterruptedException {
        Reusable_Library_Loggers.clickElement(driver, "//*[@id='NextButton']", "Submit", logger);
        return new LibertyMutual_Feedback_Page(driver);
    }//end of submit button

    //capture text of the message
    public LibertyMutual_Feedback_Page CaptureText() throws InterruptedException {
        Reusable_Library_Loggers.captureText(driver, "//*[contains(@style,':#404040')]", "Capture text", logger);
        logger.log(LogStatus.INFO, "the text is" + CaptureText());
        return new LibertyMutual_Feedback_Page(driver);
    }//end of capture text method


}//end of class
