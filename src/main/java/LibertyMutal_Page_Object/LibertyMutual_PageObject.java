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
        Thread.sleep(5000);
        //scroll to bottom
        LibertyMutual_Base_Class.libertyMutual_homePage().ScrollToBottom();

        Thread.sleep(1000);
        //get the parent window handle
        String parentHandle = driver.getWindowHandle();
        //click on feedback box
        LibertyMutual_Base_Class.libertyMutual_homePage().FeedBackButton();
        Thread.sleep(2000);
        //switch focus to the new window
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
        //close current window
        driver.close();
        //switch back to the previous window
        driver.switchTo().window(parentHandle);

    }//end of test

}//end of class
