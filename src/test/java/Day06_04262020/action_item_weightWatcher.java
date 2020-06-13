package Day06_04262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class action_item_weightWatcher {
    public static void main(String[] args) throws InterruptedException {
        //set ChromeOptions
        ChromeOptions options = new ChromeOptions();

        //maximize the window and make it private
        options.addArguments("start-maximized", "incognito");

        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);

        //Dynamic array to loop
        String[] zipCode = new String[3];
        zipCode[0] = "11208";
        zipCode[1] = "10302";
        zipCode[2] = "11218";

        //for loop will begin here
        for (int i = 0; i < zipCode.length; i++) {
            //navigate to weight watchers site
            driver.navigate().to("https://www.weightwatchers.com");

            //wait to reload
            Thread.sleep(2000);

            //verify  the title of the page with the actual title
            //i will use if else statement to verify the tittle of the page
            String verifyTitle = driver.getTitle();
            if (verifyTitle.equals("Weight Watchers:Weight Loss & Welness Help")) {
                System.out.println("Title match with the expected title");
            } else {
                System.out.println("Title does not match " + verifyTitle);
            }//end of if else
            //locate the studio link and click
            driver.findElement(By.xpath("//*[@class='find-a-meeting']")).click();
            Thread.sleep(2000);
            //locating the search field and the search button and sending keys
            driver.findElement(By.xpath("//*[@name='meetingSearch']")).sendKeys(zipCode[i]);
            Thread.sleep(2000);
            //locate the search button and click
            driver.findElement(By.xpath("//*[@spice='SEARCH_BUTTON']")).click();
            //Storing the linkElement so we can call it inside the if else statement
            //all the studios link share the same element but it is unique  so i saved the element as a string
            String linkElement = "//*[@class='location__name']";
            //if else condition will start from here
            //if the is zipCode = 0 then click on the 2nd link
            if (i == 0) {
                driver.findElements(By.xpath(linkElement)).get(1).click();
                Thread.sleep(2000);
            }
            //if the zipCode is = 1 then click on the 3rd link
            if (i == 1) {
                driver.findElements(By.xpath(linkElement)).get(2).click();
                Thread.sleep(2000);
            }
            //if the zipCode is = 2 then click on the 1st link
            if (i == 2) {
                driver.findElements(By.xpath(linkElement)).get(0).click();
                Thread.sleep(2000);
            }//end of if conditions

            //locating the address of the studio and getting the text
            String studioLink = driver.findElement(By.xpath("//*[@class='location']")).getText();
            //printing out the address of each studios linked with the zipCode
            System.out.println("My zipCode is " + zipCode[i] + " and my studio name and address is: " + studioLink);
            //locating the table element and getting the text
            String tableLink = driver.findElement(By.xpath("//*[@class='meeting-schedule meeting-detail-bottom-section']")).getText();
            //Printing out the schedule for each studios
            System.out.println("Virtual studio hours are: " + tableLink);
            Thread.sleep(2000);

        }//end of loop

        driver.quit();

    }//end of main method

}//end of class
