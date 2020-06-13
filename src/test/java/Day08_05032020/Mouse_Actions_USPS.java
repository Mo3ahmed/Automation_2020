package Day08_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Actions_USPS {
    public static void main(String[] args) throws InterruptedException {
        //set ChromeOption
        ChromeOptions options = new ChromeOptions();
        //maximize the window and make it private
        options.addArguments("start-maximized", "incognito");
        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);
        //navigate to USPS.com
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(2000);
        //call your mouse action
        Actions mouse = new Actions(driver);
        try{
            WebElement mailndShip = driver.findElement(By.xpath("//*[text()='Mail & Ship']"));
            //call your action command
            mouse.moveToElement(mailndShip).perform();
        }catch (Exception e){
            System.out.println("unable to hover over Mail & Ship" + e);
        }//end of Mail & Ship
        Thread.sleep(2000);
        //click on Click-N-Ship
        try{
            WebElement ClicknShip = driver.findElement(By.xpath("//*[@class='tool-cns']/a[text()='Click-N-Ship']"));
            //call your action command
            mouse.moveToElement(ClicknShip).click().perform();
            //this is to submit using mouse action
            //clickandShip.submit();
            //mouse.moveToElement(ClicknShip).sendKeys(Keys.ENTER).perform();
        }catch (Exception e){
            System.out.println("unable to hover over Click & Ship" + e);
        }//end of Mail & Ship

    }//end of main method
}//end of class
