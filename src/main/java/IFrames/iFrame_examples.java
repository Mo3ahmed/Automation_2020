package IFrames;

import Reusable_Methods.Abstract_Class;
import Reusable_Methods.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class iFrame_examples extends Abstract_Class {
    @Test
    public void iFrame() throws InterruptedException {
        logger.log(LogStatus.INFO, "Navigating to lets Kode it practice page ");
        driver.navigate().to("https://letskodeit.teachable.com/p/practice");
        Thread.sleep(2000);
        logger.log(LogStatus.INFO, "Scrolling to the bottom of the page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,1200)");
        Thread.sleep(3000);
        logger.log(LogStatus.INFO, "switching to iFrame ");
        driver.switchTo().frame("courses-iframe");
        Reusable_Library_Loggers.enterKeys(driver, "//*[contains(@id,'-courses')]", "Python", "SearchBox", logger);
        Reusable_Library_Loggers.clickElement(driver, "//*[contains(@id,'-course-button')]", "clickSearch", logger);
        Thread.sleep(2000);
    }//end of test

}//end of class
