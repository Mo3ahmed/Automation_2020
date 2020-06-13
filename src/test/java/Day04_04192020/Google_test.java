package Day04_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_test {
    public static void main(String[] args) throws InterruptedException {
        //set the system chrome driver path at least once in one of your main method
        //webdriver.chrome.driver in lower case string followed by the driver path

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver83.exe");

        // you declare and define the define the driver
        WebDriver driver = new ChromeDriver();

        //opening the browser automatically
        driver.navigate().to("https://www.google.com");

        //maximize your browser
        driver.manage().window().maximize();

        //wait few seconds after navigate to page so browser can load propertly
        Thread.sleep(2000);

        //locate the search field by inspecting it first then enter a keyword "car"
        driver.findElement(By.name("q")).sendKeys("Cars");
        Thread.sleep(2000);

        //click on google search
        //if click doesn't work then hit .submit(); which basically pressing "enter" key

        driver.findElement(By.name("btnK")).click();
        Thread.sleep(2000);

        // to capture a test from a web site you need to
        String message = driver.findElement(By.id("result-stats")).getText();

        //using array variable to split above message
        String[] arrayResult = message.split(" ");
        System.out.println("My search number is " + arrayResult[1]);
        Thread.sleep(2000);

        //quit the session will kill the driver from your task memory
        driver.quit();











    }//end of main method

}//end of class

