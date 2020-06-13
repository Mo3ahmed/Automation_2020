package Yahoo_Page_Class;

import Reusable_Methods.Abstract_Class;
import Reusable_Methods.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Search_Results extends Abstract_Class {
    ExtentTest logger;
    public Yahoo_Search_Results(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets to abstract class logger when you use it in page object concept
        this.logger= super.logger;
    }//end of constructor

    public Yahoo_Search_Results scrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        logger.log(LogStatus.INFO,"Scrolling to the bottom of search result page");
        jse.executeScript("scroll(0,6000);");
        return new Yahoo_Search_Results(driver);
    }//end of scrolling method

    //method to capture the results
    public Yahoo_Search_Results searchNumber() throws InterruptedException {
        String searchResults = Reusable_Library_Loggers.captureText(driver,"//*[@class='compPagination']","Search Result",logger);
        String[] searchNumber = searchResults.split("Next");
        logger.log(LogStatus.INFO,"My Search Number is " +searchNumber[1]);
        return new Yahoo_Search_Results(driver);
    }//end of Search field



}//end of java class
