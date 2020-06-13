package Day06_04262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class libertyMutual_findLocal_Agent_byZipCodes {
    public static void main(String[] args) throws InterruptedException {
        //define the chrome options
        ChromeOptions options = new ChromeOptions();
        //add the arguments to start window in a private mode and start maximized
        options.addArguments("start-maximized", "incognito");
        //define the chrome driver and add the options
        WebDriver driver = new ChromeDriver(options);
        //create a dynamic string array for zipCodes
        String[] zipCode = new String[4];
        zipCode[0] = "11208";
        zipCode[1] = "11218";
        zipCode[2] = "10012";
        zipCode[3] = "12206";
        //for loop will begin here
        for (int i = 0; i<zipCode.length; i++) {
            //Navigate to Liberty Mutual Home Page
            driver.navigate().to("https://www.libertymutual.com");
            //give 2 seconds to load
            Thread.sleep(3000);
            //verify the title of the page match with the requirement
            String Title = driver.getTitle();
            if (Title.equals("Start Saving with a Free Custom Quote | Liberty Mutual")) {
                System.out.println("Title match as expected: " + Title);
            } else {
                System.out.println("Title does not match");
            }//end of if else
            Thread.sleep(2000);
            //locate the ziCode search field and send keys
            driver.findElement(By.xpath("//*[@aria-label='Zip Code']")).sendKeys(zipCode[i]);
            //give two seconds to reload
            Thread.sleep(3000);
            //locate search element and click
            driver.findElements(By.xpath("//button[contains(@class,'secondary')]")).get(0).click();
            //depending on how fast the browser is loading you may need to put longer wait time for the element to show up and load
            //otherwise your code will not run if your browser is still loading
            Thread.sleep(4000);
            //storing the element as a string so i can call it in the if statement
            String officeLink = "//*[text()='Show agents in this office']";
            //i will use the if statement here
            //if i==0 then click on the first office link
            if (i==0){
                driver.findElements(By.xpath(officeLink)).get(0).click();
                Thread.sleep(3000);
            }
            //if i==1 then click on the 2nd office link
            if (i==1){
                driver.findElements(By.xpath(officeLink)).get(2).click();
                Thread.sleep(3000);
            }
            //if i==2 then click on the 3rd office link
            if (i==2){
                driver.findElements(By.xpath(officeLink)).get(3).click();
                Thread.sleep(3000);
            }
            //if i==3 then click on the 4th office link
            if (i==3){
                driver.findElements(By.xpath(officeLink)).get(1).click();
                Thread.sleep(3000);
            }//end of if else statement
            //strong the office address element as a string
            String officeHoursAndLocation = driver.findElement(By.xpath("//*[@class='jsx-188877792 office']")).getText();
            System.out.println("My zipCode is " +zipCode[i] + " and my local agent office is: " + officeHoursAndLocation);
            Thread.sleep(3000);

        }//end of loop

        driver.quit();


    }//end of main method

}//end of class
