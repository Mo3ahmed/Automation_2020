package Day07_050220200;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Honda_new_tab_example {
    public static void main(String[] args) throws InterruptedException {
        //initializing the chrome options
        ChromeOptions options = new ChromeOptions();
        //setting the arguments
        options.addArguments("start-maximized" ,"incognito");
        //initializing the driver and the options
        WebDriver driver = new ChromeDriver(options);
        //navigate to Honda Financial
        driver.navigate().to("https://www.hondafinancialservices.com");
        Thread.sleep(2000);
        //i will use try and catch method after each element so i can pinpoint where exactly the error is
        try {
            //locating the  Honda owners link so we can open a new tab
            driver.findElement(By.xpath("//*[@id='link-owner']")).click();
        } catch (Exception e) {
            System.out.println("unable to click on owners link " + e);
        }//end of catch
        //define ArrayList to switch between tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //now switch to second tab
        driver.switchTo().window(tabs.get(1));
        //click on find a dealer
        try {
            //locating the element for dealers link
            driver.findElement(By.xpath("//*[contains(text(),'Dealers')]")).click();
        } catch (Exception e) {
            System.out.println("unable to click on Dealers link " + e);
        }//end of catch
        Thread.sleep(3000);
        //enter zipCode
        try {
            //locate the zipCode search field and sending keys
            driver.findElement(By.xpath("//*[@class='numericOnly']")).sendKeys("11208");
            driver.findElements(By.xpath("//*[@type='submit']")).get(2).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("unable to click on zipCode Search field " + e);
        }
        Thread.sleep(3000);
        //now i want to capture the text and print on my statement
            try {
                //defining the location variable as a WebElement
                WebElement location = driver.findElements(By.xpath("//li[@class='dealer odd']")).get(0);
                System.out.println("My dealer address is " + location.getText());
            } catch (Exception e){
                System.out.println("unable to click on Dealers link " + e);
            }//end of catch
            Thread.sleep(2000);
            //i will close the tab
            driver.close();
            //now switch to previous tab
            driver.switchTo().window(tabs.get(0));
            Thread.sleep(200);
            //quit the browser
            driver.quit();


    }//end of main method

 }//end of class
