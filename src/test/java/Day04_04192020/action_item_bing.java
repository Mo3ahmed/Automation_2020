package Day04_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class action_item_bing {
    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver property
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");
        //declaring and defining web driver
        WebDriver driver = new ChromeDriver();

        //dynamic array to loop
        String[] Sports = new String[3];
        Sports[0] = "Cricket ";
        Sports[1] = "Soccer ";
        Sports[2] = "Football ";


        //loop will start from here
        for (int i = 0; i < Sports.length; i++) {

            //declaring the website which we want to open
            driver.navigate().to("https://www.bing.com");

            //maximize the windows
            driver.manage().window().maximize();

            //wait time
            Thread.sleep(2000);

            //inspect the elements on search field
            driver.findElement(By.id("sb_form_q")).sendKeys(Sports[i]);
            driver.findElement(By.id("sb_form_q")).submit();
            Thread.sleep(2000);

            //in order to capture a search result from the website you need
            String message = driver.findElement(By.className("sb_count")).getText();

            //using array variable to spilt the search result
            String[] searchResult = message.split(" ");
            System.out.println("My Sport is " + Sports[i] + "My search result is " + searchResult[0]);
            Thread.sleep(2000);


        }//end of loop
        //quit the driver
        driver.quit();


    }//end of main method

}//end of java class
