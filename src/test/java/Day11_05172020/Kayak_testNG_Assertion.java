package Day11_05172020;

import Reusable_Methods.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Kayak_testNG_Assertion {
 //declare the WebDriver outside of all method
 WebDriver driver;
 @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
     driver = Reusable_Library.setDriver();
 }//end of before suite
 @Test
 public void KayakTestCase() throws InterruptedException {
 driver.navigate().to("https://www.kayak.com");
 Thread.sleep(2000);
 //verify title using hard assertion
    // Assert.assertEquals(driver.getTitle(),"Search Hotels, Cars");
 //verify using soft assertion
     SoftAssert softassert = new SoftAssert();
     softassert.assertEquals(driver.getTitle(),"Search Hotels,Cars");
     //click airport or city
     Reusable_Library.clickElement(driver,"//*[text()='Enter an airport or city']","Search Field ");
     Thread.sleep(2000);
     //enter an airport
     Reusable_Library.enterKeys(driver,"//*[@name='pickup']","JFK","Search Field");
     Thread.sleep(3000);
     //pass assertALL that way it doesn't ski= your test step
     softassert.assertAll();

 }//end of test
    @AfterSuite
    public void classSession (){
     driver.quit();
    }//end of after suite

}
