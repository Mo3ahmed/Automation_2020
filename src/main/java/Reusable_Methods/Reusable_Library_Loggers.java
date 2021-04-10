package Reusable_Methods;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Reusable_Library_Loggers {
    static WebDriver driver;

    static int timeout = 15;
    //method to re use chrome driver and chrome options
    public static WebDriver setDriver() throws InterruptedException, IOException {
        //kill all chrome driver instance
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver83.exe /T");
        Thread.sleep(2000);
        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver86.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized", "incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of

    public static WebDriver SetFirefox() {
        System.setProperty("webdriver.gecko.driver", "src//main//resources//geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }//end of firefox

    //method to compare expected with actual title
    public static void verifyTitle(WebDriver driver, String expectedTitle, ExtentTest logger) throws InterruptedException {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Expected title matches with actual " + actualTitle);
            logger.log(LogStatus.PASS, "Expected title matches with actual" + actualTitle);
        } else {
            System.out.println("Expected title does not match. actual title is " + actualTitle);
            logger.log(LogStatus.FAIL, " Expected title does not match. actual title is: " + actualTitle);
        }//end if else
    }//end of verify title

    //method to select a drop down value by visible text
    public static void dropdownByText(WebDriver driver, String locator, String userInput,String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Selecting a value on element " + elementName);
            logger.log(LogStatus.INFO,"Selecting a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userInput);
        }catch (Exception e){
            System.out.println("Unable to select element " + elementName + "" + e);
            logger.log(LogStatus.FAIL,"Unable to select element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);

        }//end of try catch
    }//end of drop down by text method

    //Method to enter user input on send Keys
    public static void enterKeys(WebDriver driver, String locator, String userInput,String elementName, ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            System.out.println("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            //Reporter.log("Entering a value on element" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
            element.clear();
            element.sendKeys(userInput);
        }catch (Exception e) {
            System.out.println("unable to enter element " + elementName+ " " + e);
            logger.log(LogStatus.FAIL,"unable to enter element " + elementName+ " " + e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }//end of try catch
    }//end of send keys method

    //method to click on an element
    public static void clickElement(WebDriver driver, String locator, String elementName, ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.click();
        }catch (Exception e) {
            System.out.println("unable to click on element" + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to click on element" + elementName + " " + e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }//end of try catch

    }//end of click method

    //method to submit on an element
    public static void submit(WebDriver driver, String locator, String elementName,ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Submitting a value on element " + elementName);
            logger.log(LogStatus.INFO,"Submitting a value on element " + elementName);
            //Reporter.log("unable to submit on element" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.submit();
        } catch (Exception e) {
            System.out.println("unable to submit element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to submit element " + elementName + " " + e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }//end of try catch
    }//end of submit method

    //method to return text from an element
    //method to return text from an element
    public static String captureText(WebDriver driver,String locator,String elementName,ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        try{
            System.out.println("Capturing a text from element " + elementName);
            logger.log(LogStatus.INFO,"Capturing a text from element " + elementName);
            //Reporter.log("unable to capture text " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            result = element.getText();
            System.out.println("My Text result is " + result);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
            getScreenShot(driver,logger,"image");
        }//end of try catch

        return result;
    }//end of captureText method

    //method to Mouse Hover on a element
    public static void Hover(WebDriver driver,String locator,String elementName,ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("Hovering over an element" + elementName);
            logger.log(LogStatus.INFO,"Hovering over an element" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("unable to Hover the mouse" + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to Hover the mouse" + elementName + " " + e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }//end of try and catch
    }//end of Mouse Hover on element

        //method to perform MouseClick
    public static void MouseClick(WebDriver driver,String locator, String elementName,ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            System.out.println("hover and click " +elementName);
            logger.log(LogStatus.INFO,"hover and click " +elementName);
           // WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
           WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Actions action = new Actions(driver);
            action.moveToElement(element).click().perform();
           // action.click(element).perform();
        }catch (Exception e) {
            System.out.println("unable to hover and click " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"unable to hover and click " + elementName + " " + e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }//end of try catch

    }//end of MouseClick

    //method to click by index on an element
    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName,ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking a value by index " + index + " on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking a value by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click by index " + index +  " on element " + elementName + " " + e);
            Thread.sleep(1000);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method
    //method to enter user input on send keys
    public static void userTypeAndHitEnter(WebDriver driver,String locator, String userInput, String elementName,ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            //Reporter.log("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Unable to enter element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter element " + elementName + " " + e);
            Thread.sleep(1000);
            getScreenShot(driver, logger, elementName);
        }
    }//end of userTypeAndHitEnter method

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,ExtentTest logger,String imageName) {
        try {
            String fileName = imageName + ".png";
            String directory = "src//main//java//HTML_Reports//Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture("Screenshots//" + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occurred while taking SCREENSHOT!!!");
            e.printStackTrace();
        }//end of try catch

    }//end of screenshot method


    }//end of Reusable class





