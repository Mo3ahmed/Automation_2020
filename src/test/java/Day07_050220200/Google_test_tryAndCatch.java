package Day07_050220200;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Google_test_tryAndCatch {
    public static void main(String[] args) throws InterruptedException {
        //set the system chrome driver path at least once in one of your main method
        //webdriver.chrome.driver in lower case string followed by the driver path

        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver83.exe");

        // you declare and define the define the driver
        WebDriver driver = new ChromeDriver();

        //set arrayList for the cars
        //dont need to define the size/length and also dont need to define the index numbers
        //its a resizeable array
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Honda");
        cars.add("BMW");
        cars.add("Audi");
        for (int i = 0; i < cars.size(); i++) {
            //opening the browser automatically
            driver.navigate().to("https://www.google.com");

            //maximize your browser
            driver.manage().window().maximize();

            //wait few seconds after navigate to page so browser can load propertly
            Thread.sleep(2000);
            //using catch exception to handle any error
            try {
                //locate the search field by inspecting it first then enter a keyword "car"
                WebElement search = driver.findElement(By.xpath("//*[@name='q']"));
                search.sendKeys(cars.get(i));
            } catch (Exception e) {
                System.out.println("unable to enter data on Search Field " + e);
            }//end of catch
            Thread.sleep(2000);

            //click on google search
            //if click doesn't work then hit .submit(); which basically pressing "enter" key
            try {
                driver.findElement(By.name("btnK")).submit();
            } catch (Exception e) {
                System.out.println("Unable to click on Search Icon " + e);
            }//end of catch
            Thread.sleep(2000);

            // to capture a test from a web site you need to
            try {
                String message = driver.findElement(By.id("result-stats")).getText();
                //using array variable to split above message
                String[] arrayResult = message.split(" ");
                System.out.println("My search number is " + arrayResult[1]);
            } catch (Exception e) {
                System.out.println("Unable to capture on Search Result " + e);
            }//end of try and catch

            Thread.sleep(2000);
            //quit the session will kill the driver from your task memory
        }//end of for loop
        driver.quit();


    }//end of main method

}//end of class

