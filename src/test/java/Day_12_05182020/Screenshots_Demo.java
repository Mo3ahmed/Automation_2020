package Day_12_05182020;

import Reusable_Methods.Reusable_Library;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshots_Demo {
    //always call your local driver outside
    WebDriver driver;

    //create a static string to create a random file name generator
    public static String getRandomString(int length){
    StringBuilder sb = new StringBuilder();
    String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWX1234567890";
    for (int i = 0; i< length; i++){
        int index = (int)(Math.random() * characters.length());
        sb.append(characters.charAt(index));
    }//end of for loop
        return sb.toString();
    }//end of random string

    @BeforeMethod
    public void preCondition() throws IOException, InterruptedException {
        driver = Reusable_Library.setDriver();

    }//end of before method
    @Test
    public void testScreenshots() throws InterruptedException {
     driver.navigate().to("https://www.facebook.com");
     Thread.sleep(3000);
     Reusable_Library.clickElement(driver,"//button[@name='websubmit']","Submit");
    }//end of test

    @AfterMethod
    public void postCondition() throws IOException {
     String filename = getRandomString(10) + ".png";
     String directory = System.getProperty("user.dir") + "//Screenshots//";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory+ filename));
        driver.quit();


    }//end of After Method


}//end of class
