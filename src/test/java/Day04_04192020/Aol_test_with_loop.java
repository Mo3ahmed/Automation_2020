package Day04_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Aol_test_with_loop {
    public static void main(String[] args) throws InterruptedException {
    //declaring chrome driver
        WebDriver driver = new ChromeDriver();
    //declaring dynamic array string
        String[] sports = new String[5];
        sports[0] = "Soccer ";
        sports[1] = "Cricket";
        sports[2] = "Basketball ";
        sports[3] = "Hockey ";
        sports[4] = "American Football ";
    //creating while loop so it will continue to navigate until quit
    int i = 0;
    while(i<sports.length){
    //opening the search engine
    driver.navigate().to("https://search.aol.com");

    //maximize the window
    driver.manage().window().maximize();

    //wait a few seconds
    Thread.sleep(2000);

    //locate the search field and send the desired keywords
    driver.findElement(By.name("q")).sendKeys(sports[i]);
    Thread.sleep(2000);

    //now find search button element and click search
    driver.findElement(By.xpath("//button[@class='sbb']")).click();
    Thread.sleep(2000);

    //capture the result
    String message = driver.findElement(By.xpath("//span[@class=' fz-13']")).getText();

    //using array variable to spilt search results
    String[] searchResult = message.split(" ");
    System.out.println("My sport is " + sports[i] + "My search result number is " + searchResult[1]);
    Thread.sleep(2000);
    i = i + 1;


    }//end of while loop

    driver.quit();

    }//end of main method

}// end of class

