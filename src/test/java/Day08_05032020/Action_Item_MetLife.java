package Day08_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Action_Item_MetLife {
    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver property
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");
        //set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //maximize the window and make it private
        options.addArguments("start-maximized", "incognito");
        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);
        //create an ArrayList for the following variables
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11208");
        zipCode.add("11218");
        zipCode.add("10012");
        //ArrayList for dentalPrograms
        ArrayList<String> dentalProgram = new ArrayList<>();
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");
        //ArrayList for referralCodes
        ArrayList<String> referralCode = new ArrayList<>();
        referralCode.add("56729");
        referralCode.add("62863");
        referralCode.add("63537");

        //for loop will begin here
        for (int i = 0; i < zipCode.size(); i++) {
            driver.navigate().to("https://www.metlife.com");
            //wait time four seconds
            Thread.sleep(4000);
            //verify the tittle of the page and get tittle
            String pageTittle = driver.getTitle();
            if (pageTittle.equals("Insurance & Employee Benefit | Metlife")) {
                System.out.print("Title matches with the expected tittle ");
            } else {
                System.out.print("The title of the page does not match with the actual title: " + pageTittle);
            }//end of if else statement

            //try & catch method will begin here
            try {
                //find the element for Solution menu and click
                driver.findElement(By.xpath("//*[contains(text(),'SOLUTION')]")).click();
            } catch (Exception e) {
                System.out.print("unable to click on Solution " + e);
            }//end of try & catch

            //try & catch method will begin here
            try {
                //find the element for MetLife TakeAlong Dental Program and click
                driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
                //wait time three seconds
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.print("unable to click on MetLife Take Along link " + e);
            }//end of try & catch

            //get title of the MetLife TakeAlong page
            String newTittle = driver.getTitle();
            //if else method in use to verify the tittle of the page
            if (newTittle.equals("MetLife TakeAlong Dental | MetLife")) {
                System.out.println("Title of the page matches with the expected tittle ");
            } else {
                System.out.println("The title does not match with the actual title " + pageTittle);
            }//end of if else statement
            Thread.sleep(2000);
            //try & catch method will begin here
            try {
                //find the element for the Enroll Now button and click
                driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("unable to click on Enroll Now " + e);
            }//end of try & catch

            //now defining ArrayList to switch between tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to second tab
            driver.switchTo().window(tabs.get(1));
            //wait time three seconds
            Thread.sleep(2000);

            //try & catch method will begin here
            try {
                //locate the search field for ZipCode and find the element
                WebElement zipCodeLink = driver.findElement(By.xpath("//*[@id='txtZipCode']"));
                //clear any Auto populated text
                zipCodeLink.clear();
                //send ZipCode
                zipCodeLink.sendKeys(zipCode.get(i));
                //exception method with +e will print where exactly the error is
            } catch (Exception e) {
                System.out.println("unable to click on ZipCode field  " + e);
            }//end of try & catch

            //try & catch method will begin here
            try {
                //find the element of the 'GO' button and click
                driver.findElement(By.xpath("//*[text()='GO']")).click();
                //wait about six seconds after clicking go, so it gives the website enough time to load which will reduce the change of any errors
                Thread.sleep(6000);
            } catch (Exception e) {
                System.out.println("Unable to click on ZipCode search button " + e);
            }//end of try & catch

            //try & catch method will begin here
            try {
                //we are inspecting the different kinds of dental programs and then clicking it
                //however, our dental PPOs has the same class value as  our dentalProgram variables, therefor we are passing the variable "i"
                //as a class property inside the Xpath
                driver.findElement(By.xpath("//*[@class='" + dentalProgram.get(i) + "']")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to click on PPO " + e);
            }//end of try & catch

            //try & catch method will begin here
            try {
                //find the element for the Enroll in Program option and click
                driver.findElement(By.xpath("//*[@id='topenrolltab']")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to click on Enroll In Program Now " + e);
            }//end of try & catch

            //try & catch method will begin here
            try {
                //store the referral field variable as a WebElement so we can call it later to send the referralCode variable (i) to iterate
                //inspect the referral field variable and find the element
                WebElement referralField = driver.findElement(By.xpath("//*[@id='txtBxPromocode']"));
                referralField.sendKeys(referralCode.get(i));
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to locate referral search field " + e);
            }//end of try & catch

            //try & catch method will begin here
            try {
                //inspect the "GO" button and find the element and then click
                driver.findElement(By.xpath("//button[text()='GO']")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to click on GO button " + e);
            }//end of try & catch
            

            //try & catch method will begin here
            try {
                //in order to capture the error message i need to store the errorMessage as a WebElement so i can
                //call it to capture the text and the call it again on my print statement to print the error message
                //find the element of the error message
                WebElement errorMessage = driver.findElement(By.xpath("//*[@id='lblRefCodeError']"));
                //capture the error message
                errorMessage.getText();
                //print the error message
                System.out.println("Error Message is: " + errorMessage.getText());
                //wait time 2 seconds
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to capture error message " + e);
            }//end of  Try & catch

            //try & catch method will begin here
            try {
                //find the element of "Enroll without referral code" and click
                driver.findElement(By.xpath("//*[@id='withoutrefcode']")).click();
                //wait time two seconds
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to click on Enroll in Program " + e);
            }//end of try & catch

            //try & catch method will begin here
            try {
                //find PPOs "category" element and store the PPO text as a WebElement so i call it inside the my if else statement
                //here we need to use the first PPO text instead of the second PPO because for some weird reason it does not work
                WebElement ActualPPO = driver.findElement(By.xpath("//div[@class='col-sm-8']"));
                //if else statement to determine if the actual PPO match with the expect PPO
                if (ActualPPO.getText().contains(dentalProgram.get(i))) {
                    System.out.println("Actual PPO matches with the Expected PPO: " + ActualPPO.getText());
                } else {
                    System.out.println("Actual PPO does not matches with the Expected PPO " + ActualPPO.getText());
                }//end of if else
            } catch (Exception e) {
                System.out.println("Unable to capture text " + e);
            }//end of try and catch

            //wait time two seconds
            Thread.sleep(2000);

            //close the current tab
            driver.close();

            //wait time two seconds
            Thread.sleep(2000);

            //switch back to the original tab
            driver.switchTo().window(tabs.get(0));

        }//end of for loop
        //wait time 2 seconds
        Thread.sleep(2000);

        //quit the browser
        driver.quit();

    }//end of main method

}//end of class
