package Day05_04252020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Mortgage_calculator_item {
    public static void main(String[] args) throws InterruptedException {
    //set the chrome options
    ChromeOptions options = new ChromeOptions();
    //set the arguments you want for the driver
    options.addArguments("start-maximized", "incognito");
    //define the chrome driver
        WebDriver driver = new ChromeDriver(options);

        String[] PurPrice = new String[3];
        PurPrice[0] = "400760";
        PurPrice[1] = "650000";
        PurPrice[2] = "760000";

        String[] downPay = new String[3];
        downPay[0] = "20";
        downPay[1] = "25";
        downPay[2] = "15";

        String[] IntRate= new String[3];
        IntRate[0] = "3.6";
        IntRate[1] = "4.2";
        IntRate[2] = "5.6";

        String[] propInsurance = new String[3];
        propInsurance[0] = "1800";
        propInsurance[1] = "1235";
        propInsurance[2] = "2100";

        String[] startMonth = new String[3];
        startMonth[0] = "Jun";
        startMonth[1] = "Jan";
        startMonth[2] = "May";

        String[] startYear = new String[3];
        startYear[0] = "2020";
        startYear[1] = "2016";
        startYear[2] ="2019";

//begin of for loop
    for (int i = 0; i<PurPrice.length; i++){
    //navigate to mlcalc.com
    driver.navigate().to("https://www.mlcalc.com");
    //storing my actual title as a variable and then compare it with the requirement
    String actualTitle = driver.getTitle();
    if (actualTitle.contains("Mortgage")){
        System.out.println("Title contains keyword " + actualTitle);
    }else {
        System.out.println("Title does not match " + actualTitle);
    }//end of if else
        WebElement pPrice = driver.findElement(By.xpath("//input[@id='ma']"));
        pPrice.clear();
        pPrice.sendKeys(PurPrice[i]);
        Thread.sleep(2000);
        WebElement dPayment = driver.findElement(By.xpath("//input[@id='dp']"));
        dPayment.clear();
        dPayment.sendKeys("20");
        WebElement mTerm = driver.findElement(By.xpath("//*[@name='mt']"));
        mTerm.clear();
        mTerm.sendKeys("30");
        Thread.sleep(2000);
        WebElement iRate = driver.findElement(By.xpath("//*[@name='ir']"));
        iRate.clear();
        iRate.sendKeys("3.6");
        Thread.sleep(2000);
        WebElement pTax = driver.findElement(By.xpath("//*[@name='pt']"));
        pTax.clear();
        pTax.sendKeys("5,000");
        Thread.sleep(2000);
        WebElement pInsurance = driver.findElement(By.xpath("//*[@name='pi']"));
        pInsurance.clear();
        pInsurance.sendKeys("1,800");
        Thread.sleep(2000);
        WebElement hFees = driver.findElement(By.xpath("//*[@name='hf']"));
        hFees.clear();
        hFees.sendKeys("100");
        WebElement pMI = driver.findElement(By.xpath("//*[@name='mi']"));
        pMI.clear();
        pMI.sendKeys("0.52");
        Thread.sleep(2000);
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
        sYearList.selectByVisibleText(startYear[1]);
        Thread.sleep(2000);
        //locate the calculate button and click submit
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //locate the monthly payment and get the text
        String monthlyPay = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
        String payoffDate = driver.findElements(By.xpath("//*[@class='big']")).get(2).getText();
        System.out.println("My Loan amount is " + PurPrice[i] +" & My monthly payment is " + monthlyPay + " and my payoff date is " + payoffDate);
        Thread.sleep(2000);

    }//end of loop
        driver.quit();
    }//end of class

}//end of class


