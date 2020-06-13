package Day11_05172020;

import Reusable_Methods.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Google_Search_TestNG {
    //when using annotation method your local declare outside the before Method
    //so i can call it in all my annotation method

    WebDriver driver;
    ArrayList<String> cars = new ArrayList();
    @BeforeMethod
    public void callDriver() throws IOException, InterruptedException {
    driver = Reusable_Library.setDriver();
        cars.add("Bmw");
        cars.add("Lexus");

    }//end of before method
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }//end of AfterMethod

    @Test
    public void googleSearch() throws InterruptedException {
        for (int i=0; i<cars.size(); i++) {
            driver.navigate().to("https://www.google.com");
            //enter Keyword cars in search field
            Reusable_Library.enterKeys(driver, "//*[@name='q']", cars.get(i), "SearchField");
            //click on submit
            Reusable_Library.submit(driver, "//*[@name='btnK']", "Submit button");
            Thread.sleep(2000);
            //capture text and print out the search number
            String searchResult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "capture text");
            //Spilt the text
            String[] aarayResult = searchResult.split(" ");
            Reporter.log("My search number for car is " + aarayResult[1]);
            System.out.println("My search number is " + aarayResult[1]);
        }//end of for loop
    }//end of Google Test

}//end of class

