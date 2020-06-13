package Day9_05092020;

import Reusable_Methods.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Statefarm_Test {

    public static void main(String[] args) throws InterruptedException {
        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver83.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        WebDriver driver = new ChromeDriver(options);

        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        ArrayList<String> ZipCode = new ArrayList<>();
        ZipCode.add("11208");
        ZipCode.add("11416");

        ArrayList<String> ProductType = new ArrayList<>();
        ProductType.add("Homeowners");
        ProductType.add("Auto");

        for(int i = 0; i < ZipCode.size(); i++) {
            //navigate to mortgage calculator home page
            driver.navigate().to("https://www.statefarm.com");
            Thread.sleep(2500);
            //call my reusable method to compare title
            Reusable_Library.verifyTitle(driver, "Auto, Life Insurance");
            //call my reusable method to select product drop down
            Reusable_Library.dropdownByText(driver, "//*[@id='popDropdown']", ProductType.get(i), "Product Dropdown");
            //call my reusable method to enter a zipcode
            Reusable_Library.enterKeys(driver, "//*[@id='quote-main-zip-code-input']", ZipCode.get(i), "Zipcode");
            Thread.sleep(2000);
            //call hover over mouse action
            Reusable_Library.Hover(driver,"//*[contains(@class,'-w_mt-10')]","Button");
            Thread.sleep(4000);
            //MouseClick
            Reusable_Library.MouseClick(driver,"//*[contains(@class,'-w_mt-10')]","MouseClick");
            Thread.sleep(2000);
            //call my reusable method to click on quote
            Reusable_Library.clickElement(driver, "//*[text()='Start Quote']", "Start Quote");

        }//end of loop

        Thread.sleep(2000);
        driver.quit();

    }//end of main



}//end of java class
