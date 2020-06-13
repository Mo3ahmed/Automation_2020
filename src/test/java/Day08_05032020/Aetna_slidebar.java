package Day08_05032020;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class Aetna_slidebar {
    public static void main(String[] args) throws InterruptedException {
        //set the property
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");
        //set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //maximize the window and make it private
        options.addArguments("start-maximized", "incognito");
        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);
        //define java script
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //call your mouse action
        Actions mouse = new Actions(driver);

        //ArrayList for Zipcode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11208");
        zipCode.add("11218");
        zipCode.add("10012");

        //Array List of miles
        ArrayList<Integer> Miles = new ArrayList<>();
        Miles.add(15);
        Miles.add(20);
        Miles.add(30);

        //for loop will start here
        for (int i = 0; i <3; i++){
        driver.navigate().to("https://www.aetna.com");
        Thread.sleep(3000);
        //verify title of the page and get title
            String pageTittle = driver.getTitle();
            if (pageTittle.equals("Health Insurance Plans | Aetna")) {
                System.out.println("Title matches with the expected tittle "+pageTittle);
            } else {
                System.out.println("The title of the page does not match with the actual title: " + pageTittle);
            }//end of if else statement
        Thread.sleep(3000);
        //try and catch for shop for a plan
            try {
                //find the element for shop for a plan and click
                driver.findElement(By.xpath("//*[@class='megamenu__primary--item']")).click();
            } catch (Exception e) {
                System.out.println("unable to click on shop for plan " + e);
            }//end of try & catch
            Thread.sleep(2000);
            //try and catch for medicare
            try {
                WebElement medicare = driver.findElement(By.xpath("//button[text()='Medicare']"));
                mouse.moveToElement(medicare).click().perform();
            } catch (Exception e) {
                System.out.println("unable to hover over Medicare " + e);
            }//end of try & catch
            Thread.sleep(2000);

            //try and catch for find a doctor
            try {
             driver.findElements(By.xpath("//*[text()='Find a doctor ']")).get(0).click();
            } catch (Exception e) {
                System.out.println("unable to click on find a doctor " + e);
            }//end of try & catch
            Thread.sleep(2000);

            //click on 2020 for yourself on yourself
            try {
                driver.findElement(By.xpath("//*[@class='primaryPurple BtnWidth mgbutton w400']")).click();
            } catch (Exception e) {
                System.out.println("unable to click on 2020 medicare for yourslef  " + e);
            }//end of try & catch
            Thread.sleep(2000);
            //slide bar range moving
            try {
                WebElement slideBar = driver.findElement(By.xpath("//*[@class='rz-pointer rz-pointer-min']"));
                Actions action = new Actions(driver);
                action.click(slideBar).build().perform();
                Thread.sleep(1000);
                for (int k = 0; k < 25; k++) {
                    action.sendKeys(Keys.ARROW_LEFT).build().perform();
                }//end of loop to make it zero
                for (int j = 0; j < Miles.get(i); j++) {
                    action.sendKeys(Keys.ARROW_RIGHT).build().perform();
                }//end of loop
            } catch (Exception e){
                System.out.println("unable to locate slide bar " +e);
            }//end of try and catch
            Thread.sleep(2000);
                //try and catch for zipcode field
                try {
                    WebElement zipField = driver.findElement(By.xpath("//*[@id='medZip']"));
                    zipField.clear();
                    zipField.sendKeys(zipCode.get(i));
                } catch (Exception e) {
                    System.out.println("unable to click on zipcode field " + e);
                }//end of try & catch
                Thread.sleep(3000);
                //select the zicode field
                try {
                    driver.findElement(By.xpath("//li[contains(@id,'option-0')]")).click();
                } catch (Exception e) {
                    System.out.println("unable to click on zipcode " + e);
                }//end of try & catch
                Thread.sleep(2000);
                //click on skip wihtout a plan
            try {
                driver.findElement(By.xpath("//*[@value='skip plan selection']")).click();
            } catch (Exception e) {
                System.out.println("unable to click on skip " + e);
            }//end of try & catch
            Thread.sleep(2000);

            //click on medical doctors and specialist
            try {
                WebElement scroll = driver.findElement(By.xpath("//*[contains(text(),'Medical Doctors')]"));
                jse.executeScript("arguments[0].scrollIntoView(true);",scroll);
                Thread.sleep(2000);
                scroll.click();
            } catch (Exception e) {
                System.out.println("unable to click on find a doctor " + e);
            }//end of try & catch
            Thread.sleep(2000);

            //find a primary doctor
            try {
                driver.findElement(By.xpath("//*[contains(text(),'Doctors (Primary')]")).click();
            } catch (Exception e) {
                System.out.println("unable to click on doctos primary  " + e);
            }//end of try & catch
            Thread.sleep(3000);

            //find a care physicians
            try {
                driver.findElement(By.xpath("//*[contains(text(),'Primary Care Physicians')]")).click();
            } catch (Exception e) {
                System.out.println("unable to click primary care physicians  " + e);
            }//end of try & catch
            Thread.sleep(5000);

            //get the name and address of the doctor
            try {
                WebElement address = driver.findElement(By.xpath("//*[@header='grid-hdr-name']"));
                address.getText();
                System.out.println("My ZipCode is " + zipCode.get(i)+" & The Care Physicians contact information is: " + " \n " + address.getText());
            }catch (Exception e){
                System.out.println("unable to get the doctors address " + e);
            }// en dof try and catch
            Thread.sleep(3000);

        }//end of for loop
        Thread.sleep(3000);
        driver.quit();

    }//end of main method


}//end of class
