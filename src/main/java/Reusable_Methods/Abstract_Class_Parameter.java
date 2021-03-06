package Reusable_Methods;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_Class_Parameter {
    // you need to set the global variable as public static in order
    //to be used on your @test classes
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    //define before suite to set a static driver
    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
    //define the report path
        reports = new ExtentReports("src//main//java//HTML_Reports//TestReport.html",true);
    }//end of before suite

    //before method will be used to capture a unique @test name that you gave on your test classes
    //use @parameter which will allow you to chose the browser you want to test
    @Parameters("Browser")
    @BeforeMethod
    public void getMethodName(Method testName, String Browser) throws IOException, InterruptedException {
        if (Browser.equalsIgnoreCase("Chrome")){
            driver = Reusable_Library_Loggers.setDriver();
        }else if (Browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","src//main//resources//geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }//end of conditional statement
     //start the logger here to capture the method name
     logger = reports.startTest(testName.getName() + "-" + Browser);
    }//end of before method

    //after method will end each test
    @AfterMethod
    public void endTest(){
        reports.endTest(logger);
    }//end of after method

    //After suite will quit and flush to your report
    @AfterSuite
    public void PostCondition (){
        //driver.quit():
        reports.flush();
    }//end of after suite



}//end of java class
