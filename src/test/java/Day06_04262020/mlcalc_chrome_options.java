package Day06_04262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class mlcalc_chrome_options {
    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver83.exe");

        //set the chrome options
        ChromeOptions options = new ChromeOptions();

        //set the arguments you want for the driver
        options.addArguments("start-maximized", "incognito");

        //now simply define chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to mlcalc.com
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2000);
        //if i want to capture the title of that page
        //System.out.println("Title of the page is " + driver.getTitle());
        //store your actual title on a variable and then compare with your requirement
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Mortgage")) {
            System.out.println("Title contains Keyword " + actualTitle);
        } else {
            System.out.println("Title does not match " + actualTitle);
        } //end of if else
        //if same locator used more than once then store it as web element to reuse it
        WebElement pPrice = driver.findElement(By.xpath("//input[@id='ma']"));
        //clear the field first
        pPrice.clear();
        //enter your data
        pPrice.sendKeys("500000");
        Thread.sleep(2000);
        //storing the element
        WebElement dPayment = driver.findElement(By.xpath("//input[@id='dp']"));
        //clear the field
        dPayment.clear();
        //enter data
        dPayment.sendKeys("20");
        Thread.sleep(2000);
        //storing the element
        WebElement mTerm = driver.findElement(By.xpath("//*[@name='mt']"));
        //clear the field
        mTerm.clear();
        //enter data
        mTerm.sendKeys("30");
        Thread.sleep(2000);
        //storing the element
        WebElement iRate = driver.findElement(By.xpath("//*[@name='ir']"));
        //clear the field
        iRate.clear();
        //enter data
        iRate.sendKeys("3.6");
        Thread.sleep(2000);
        //storing the element
        WebElement pTax = driver.findElement(By.xpath("//*[@name='pt']"));
        //clear the field
        pTax.clear();
        //enter data
        pTax.sendKeys("5,000");
        Thread.sleep(2000);
        //storing the element
        WebElement pInsurance = driver.findElement(By.xpath("//*[@name='pi']"));
        //clear the field
        pInsurance.clear();
        //enter data
        pInsurance.sendKeys("1,800");
        Thread.sleep(2000);
        //storing the element
        WebElement hFees = driver.findElement(By.xpath("//*[@name='hf']"));
        //clear the field
        hFees.clear();
        //enter data
        hFees.sendKeys("100");
        //storing the element
        WebElement pMI = driver.findElement(By.xpath("//*[@name='mi']"));
        //clear the field
        pMI.clear();
        //enter data
        pMI.sendKeys("0.52");
        Thread.sleep(2000);
        //Store your start month in your WebElement and then call it
        WebElement sMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        //call my select command to select from the drop down
        Select sMonthList = new Select(sMonth);
        //Select the drop down value by visible text
        sMonthList.selectByVisibleText("Jun");
        Thread.sleep(2000);

        //Store your start year in your WebElement and then call it
        WebElement sYear = driver.findElement(By.xpath("//*[@id='fpdy']"));
        //call my select command to select from the drop down
        Select sYearList = new Select(sYear);
        //Select the drop down value by visible text
        sYearList.selectByVisibleText("2020");
        Thread.sleep(2000);
        //locate the calculate button and click submit
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //locate the monthly payment and get the text
        String monthlyPay = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
        String payoffDate = driver.findElements(By.xpath("//*[@class='big']")).get(2).getText();
        System.out.println("My monthly payment is " + monthlyPay + " and my payoff date is " + payoffDate);
        Thread.sleep(2000);


        //whenever drop down is not under select tag then we must click on the dropdown and then
        //click on the value of the dropdown
        //lets verify some of the start year to make sure its matching on the drop down
       //String[] yearArray = new String[]{"2005", "2020", "2035"};
      //for (int i = 0; i < yearArray.length; i++) {
          //  driver.findElement(By.xpath("//*[@name='sy']")).click();
            //Thread.sleep(2000);
            //driver.findElement(By.xpath("//*[text()='" + yearArray[i] + "']")).click();
       // }//end of loop

        driver.quit();
    }// end of class
}//end of main method
