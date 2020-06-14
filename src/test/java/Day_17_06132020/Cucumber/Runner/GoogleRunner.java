package Day_17_06132020.Cucumber.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Day_17_06132020/Cucumber/Features/Google.feature"},
        glue = {"Day_17_06132020/Cucumber/Step_Definitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}

)//end of array of argument you are passing

public class GoogleRunner {
  //empty class

}//end of class
