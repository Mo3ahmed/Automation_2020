package Day04_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loop_test_practice {
    public static void main(String[] args) throws InterruptedException {
        // you declare and define the define the driver
        WebDriver driver = new ChromeDriver();

        //creating dynamic array
        String[] serach = new String[3];
        serach[0] = "Covid-19";
        serach[1] = "New York";
        serach[2] = "Wuhan";

        //for loop will start from here
        for (int i = 0; i<serach.length; i++){

            //opening the browser automatically
            driver.navigate().to("https://www.google.com");

            //maximize your browser
            driver.manage().window().maximize();

            //wait few seconds after navigate to page so browser can load propertly
            Thread.sleep(2000);

            //locate the search field by inspecting it first then enter a keyword "car"
            driver.findElement(By.name("q")).sendKeys(serach[i]);
            Thread.sleep(2000);

            //click on google search
            //if click doesn't work then hit .submit(); which basically pressing "enter" key

            driver.findElement(By.name("btnK")).click();
            Thread.sleep(2000);

            // to capture a test from a web site you need to
            String message = driver.findElement(By.id("result-stats")).getText();

            //using array variable to split above message
            String[] arrayResult = message.split(" ");
            System.out.println("My search is " + serach[i] + "My search result is " + arrayResult[1]);
            Thread.sleep(2000);

        } //end of loop

        driver.quit();

    }//end of main method
}//end of class
