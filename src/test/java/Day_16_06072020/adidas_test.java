package Day_16_06072020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class adidas_test {
    public static void main(String[] args) throws InterruptedException {
        //set the property
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver83.exe");
        //defining chrome option
        ChromeOptions option = new ChromeOptions();
        //adding arguments
        option.addArguments("start-maximized", "incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(option);
        //navigate to adidas home page
        driver.get("https://www.adidas.com/us");
        //locate the element as webelemnt
        WebElement Men = driver.findElement(By.xpath("//a[@href='/us/men']"));
        //call the mouse action
        Actions action = new Actions(driver);
        action.moveToElement(Men).perform();
        Thread.sleep(2000);
        //click on soccer
        driver.findElement(By.xpath("//*[@manual_cm_sp='header-_-men-_-shoes-_-running']")).click();
        Thread.sleep(2000);
        //click close
        driver.findElement(By.xpath("//*[@aria-label='Close']")).click();
        //click on a shoe
        driver.findElements(By.xpath("//img[@title='Ultraboost 20 Shoes']")).get(0).click();
        Thread.sleep(3000);
        //click on a size
        driver.findElement(By.xpath("//button[contains(@data-di-id,'-41a8c24')]")).click();
        Thread.sleep(1000);
        //click on add to the bag
        driver.findElements(By.xpath("//*[text()='Add To Bag']")).get(4).click();
        Thread.sleep(2000);
        //quit the driver
        driver.quit();


    }//end of main method
}//end of class
