package Day_17_06132020.Cucumber.Step_Definitions;

import Reusable_Methods.Reusable_Library;
import Reusable_Methods.Reusable_Library_Cucumber;
import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Google_Search_test_scenarios {
    WebDriver driver;

    //the annotations gherkins commands are @Given, @When, @And, @Then

    @Given ("^I navigate to google home page$")
    public void navigate() throws IOException, InterruptedException {
        driver = Reusable_Library.setDriver();
        driver.navigate().to("https://www.google.com");
    }//end of navigate

    @And("^I enter a keyword (.*) on search field$")
    public void searchField(String Cars){
        Reusable_Library.enterKeys(driver,"//*[@name='q']",Cars,"User Value");
    }//end of AND

    @And("^I click on search icon$")
    public void searchIcon() throws InterruptedException {
        Reusable_Library.submit(driver,"//*[@name='btnK']","SearchIcon");
        Thread.sleep(2000);
    }//end of AND

    @And("^I capture search result and print$")
    public void searchResult(){
        String searchResult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "capture text");
        String[] aarayResult = searchResult.split(" ");
        Reporter.addStepLog("Search number is " + aarayResult[1]);
    }//end of AND

    @And("^I click on More Icon$")
    public void MoreIcon(){
        Reusable_Library_Cucumber.clickElement(driver,"//*[@class='more-vert z1asCe SaPW2b']","More Icon");
    }//end of And

    @Then("^I can select the value (.*)$")
    public void MoreValues(String more) throws InterruptedException {
        Thread.sleep(1500);
        Reusable_Library_Cucumber.clickElement(driver,"//*[text()='"+more+"']","More value");
    }//end of more


}//end of test
