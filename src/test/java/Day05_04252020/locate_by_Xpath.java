package Day05_04252020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locate_by_Xpath {
    public static void main(String[] args) throws InterruptedException {
        //define your wen driver
        WebDriver driver = new ChromeDriver();
        //navigate to amazon.com
        driver.navigate().to("https://www.amazon.com");
        //maximize window
        driver.manage().window().maximize();
        //wait time

        Thread.sleep(2000);
        //enter a keyword in search field
        //finding ID or Name // or lets you have more flexibility
        driver.findElement(By.xpath("//*[@name='field-keywords' or @id='twotabsearchtextbox']")).sendKeys("laptop");
        //click on search
        driver.findElement(By.xpath("//*[@value='Go']")).click();
        Thread.sleep(2000);
        //locate the property using ElementS instead of element
       //driver.findElements(By.xpath("//*[@class='s-image']")).get(2).click();
        //Thread.sleep(2000);
        //using contains Xpath to find elements
        driver.findElements(By.xpath("//*[contains(@class,'s-image')]")).get(1).click();
        Thread.sleep(2000);
        //re-navigate back to home page
        //driver.navigate().to("https://www.amazon.com");





        driver.quit();



    }//end of main

}//end of class
