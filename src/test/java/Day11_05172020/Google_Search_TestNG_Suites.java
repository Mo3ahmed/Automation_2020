package Day11_05172020;

import Reusable_Methods.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google_Search_TestNG_Suites {
    WebDriver driver;
    String getURL;

    @Test(priority = 1)
    public void googleSearch() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        //enter Keyword cars in search field
        Reusable_Library.enterKeys(driver,"//*[@name='q']","Cars","SearchField");
        //click on submit
        Reusable_Library.submit(driver,"//*[@name='btnK']","Submit button");
        Thread.sleep(2000);
        //capture the url
        getURL = driver.getCurrentUrl();

    }//end of test
    @Test(dependsOnMethods = "googleSearch")
    public void captureTheResult() throws InterruptedException {
        driver.navigate().to(getURL);
        Thread.sleep(2000);
        //capture text and print out the search number
        String searchResult = Reusable_Library.captureText(driver,"//*[@id='result-stats']","capture text") ;
        //Spilt the text
        String[] aarayResult = searchResult.split(" ");
        System.out.println("My search number is " +aarayResult[1]);
    }//end of google test

    //pre condition before test
    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException {
        driver = Reusable_Library.setDriver();
    }//end of BeforeMethod

    //post condition after test
    @AfterSuite

    public void quitDriver(){
        driver.quit();
    }//end of afterMethod

}//end of class

