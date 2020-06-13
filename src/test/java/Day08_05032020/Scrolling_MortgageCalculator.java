package Day08_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling_MortgageCalculator {
    public static void main(String[] args) throws InterruptedException {
        //set ChromeOption
        ChromeOptions options = new ChromeOptions();
        //maximize the window and make it private
        options.addArguments("start-maximized", "incognito");
        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);
        //navigate to mortgage calculator home page
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(2000);

        //declare and define javascript
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll all the way to the bottom
        jse.executeScript("scroll(0,5000)");
        Thread.sleep(2000);
        //scroll all the way up
       jse.executeScript("scroll(0,-5000)");
        //scrolling to an element view loan term
        try {
            WebElement loanTerm = driver.findElement(By.xpath("//*[@id='loanterm']"));
            jse.executeScript("arguments[0].scrollIntoView(true);", loanTerm);
        }catch (Exception e) {
            System.out.println("unable to locate the loan term" + e);
        }//end of try and catch



    } // end of main method
}//end of class
