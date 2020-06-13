package Day_15_06062020;

import Reusable_Methods.Abstract_Class;
import Yahoo_Page_Class.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Yahoo_PageObject_Serach_Results extends Abstract_Class {
    @Test
    public void Yahoo_Search_Results() throws InterruptedException {
        logger.log(LogStatus.INFO,"navigating to yahoo home page");
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2500);
        Yahoo_Base_Class.yahoo_homePage().searchField("cars");
        //click
        Yahoo_Base_Class.yahoo_homePage().searchIcon();
        Thread.sleep(2000);
        //scroll down
        Yahoo_Base_Class.yahoo_search_results().scrollDown();
        //get the text
        Thread.sleep(1000);
        Yahoo_Base_Class.yahoo_search_results().searchNumber();

    }//end of test


}//end of java class
