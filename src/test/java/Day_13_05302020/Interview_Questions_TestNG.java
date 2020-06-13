package Day_13_05302020;

import Reusable_Methods.Abstract_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Interview_Questions_TestNG extends Abstract_Class {
    @Test(priority = 1)
    public void YahooSearch() throws InterruptedException {
        //navigating to Yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        //wait 2 seconds
        Thread.sleep(2000);
        //inspect the Search field and type QA
        driver.findElement(By.xpath("//*[@id='header-search-input']")).sendKeys("QA");
        //inspect search button and click search
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(1000);
        //click on QA Wikipedia
        driver.findElement(By.xpath("//*[contains(@href,'Quality_assurance')]")).click();
        Thread.sleep(2000);
        //define arrayList for new window
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        //switch to new window
        driver.switchTo().window(newTab.get(1));
        //verify the page contains the phrase Middle Age"
        String pageSource = " Middle Ages";
        if (driver.getPageSource().contains("Middle Ages")) {
            System.out.println("page contains the expected text:" + pageSource);
        } else {
            System.out.println("page does not contains the expected text");
        }//end of if else

   /*//verify the page contains the phrase "Middle Ages" using try and catch exception
    try {
        boolean phrase = driver.getPageSource().contains("Middle Ages");
        System.out.println("page contains the expected text " +phrase);
    }catch (Exception e){
        System.out.println("page does not contains the expected text" +e);
    }//end of try catch*/

        //close the current page
        driver.close();
        //switch to previous tab
        driver.switchTo().window(newTab.get(0));
    }//end of Test 1

    @Test(priority = 2)
    public void Checkbox() throws InterruptedException {
        //navigate to Washington.edu
        driver.navigate().to("https://faculty.washington.edu/chudler/java/boxes.html");
        Thread.sleep(1000);
        //inspect the checkboxes and get the count of total checkboxes
        List<WebElement> checkbox = driver.findElements(By.xpath("//*[@type='checkbox']"));
        System.out.println("Total Checkboxes are " + checkbox.size());
        for (WebElement totalLink : checkbox) {
            totalLink.click();
        }//end of for

    }//end of test 2

    @Test(priority = 3)
    public void Counts() {
        for (int i = 0; i <= 100; i++) {
            if (i % 5 == 0) {
            } else {
                System.out.println(i);
            }//end of if else
        }//end of for loop

    }//end of test 3

    @Test(priority = 4)
    public void ListValues() {
        //creating a dynamic array for the values
        String[] values = new String[5];
        values[0] = "a";
        values[1] = "b";
        values[2] = "c";
        values[3] = "d";
        values[4] = "e";
        for (int i = 0; i < values.length; i++) {
            if(values[i].equals("a")||values[i].equals("e")){
                System.out.println(" Vowel");
            }else{
                System.out.println(" Non-Vowels");
            }//end of if else


        }//end of for loop


    }//end of test


}//end of class
