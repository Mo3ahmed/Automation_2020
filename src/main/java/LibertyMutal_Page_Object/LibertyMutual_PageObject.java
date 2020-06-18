package LibertyMutal_Page_Object;

import Reusable_Methods.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class LibertyMutual_PageObject extends Abstract_Class {
    @Test
    public void LibertyMutual_PageObject() throws InterruptedException {
        logger.log(LogStatus.INFO, "Navigating to LibertyMutual Home Page");
        driver.navigate().to("https://www.libertymutual.com");
        //wait time
        Thread.sleep(2000);
        //scroll to bottom
        LibertyMutual_Base_Class.libertyMutual_homePage().ScrollToBottom();
        //click on feedback box
        Thread.sleep(1000);
        String parentHandle = driver.getWindowHandle();
        LibertyMutual_Base_Class.libertyMutual_homePage().FeedBackButton();
        Thread.sleep(2000);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }//end of for
        //select the radio button
        LibertyMutual_Base_Class.libertyMutual_feedback_page().RadioButton();
        //click and send comments
        LibertyMutual_Base_Class.libertyMutual_feedback_page().CommentBox();
        //click submit
        LibertyMutual_Base_Class.libertyMutual_feedback_page().Submit();
        Thread.sleep(1000);
        //capture text
        LibertyMutual_Base_Class.libertyMutual_feedback_page().CaptureText();
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(parentHandle);

    }//end of test

}//end of class
