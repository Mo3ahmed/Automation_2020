package Day07_050220200;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Met_life_tabs {
    public static void main(String[] args) throws InterruptedException {
        //set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //maximize the window and make it private
        options.addArguments("start-maximized", "incognito");
        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);
        //navigate to met life homepage
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11208");
        zipCode.add("11218");
        zipCode.add("10012");
        for (int i = 0; i<zipCode.size(); i++) {
            driver.navigate().to("https://www.metlife.com");
            Thread.sleep(4000);
            try {
                //locate the search field by inspecting it first then enter a keyword "car"
                driver.findElement(By.xpath("//*[contains(text(),'SOLUTION')]")).click();
            } catch (Exception e) {
                System.out.println("unable to click on Solution " + e);
            }//end of catch
            try {
                //locate the search field by inspecting it first then enter a keyword "car"
                driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
            } catch (Exception e) {
                System.out.println("unable to click on MetLife Take Along link " + e);
                Thread.sleep(4000);
            }//end of catch

            Thread.sleep(3000);
            try {
                //locate the search field by inspecting it first then enter a keyword "car"
                driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
            } catch (Exception e) {
                System.out.println("unable to click on Enroll Now " + e);
            }//end of catch
            //now define array list to switch between tabs
            //everytime a new window open you need to redefine the ArrayList below
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to second tab
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(3000);
            //enter your zipcode
            try {
                //locate the search
              WebElement zipCodeLink = driver.findElement(By.xpath("//*[@id='txtZipCode']"));
              zipCodeLink.clear();
              Thread.sleep(3000);
              zipCodeLink.sendKeys(zipCode.get(i));
            } catch (Exception e) {
                System.out.println("unable to click on zipcode field  " + e);
            }//end of catch
            Thread.sleep(3000);
            try{
                driver.findElement(By.xpath("//*[text()='GO']")).click();
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println("Unable to click on search field " + e);
            }
            driver.close();
            Thread.sleep(2000);
            driver.switchTo().window(tabs.get(0));

            //wait a 2 seconds
            Thread.sleep(2000);
        }//end of for loop

        //i want to close this tab
       // driver.close();

        //switch to previous tab
       // driver.switchTo().window(tabs.get(0));
       // Thread.sleep(2000);
        //if another tabs open redefine the arrayList again
       // tabs = new ArrayList<>(driver.getWindowHandles());

        driver.quit();

    }//end od main method
}//end of class
