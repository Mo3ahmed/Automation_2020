package Day10_05102020;

import Reusable_Methods.Reusable_Library;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Macys {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = Reusable_Library.setDriver();
        driver.navigate().to("https://www.macys.com");
        Thread.sleep(2000);
        Reusable_Library.Hover(driver,"//*[@id='shopByDepartmentDropdown']","Menu");
        Reusable_Library.Hover(driver,"//*[contains(text(),'women-_-118_women')]","Women");
        Reusable_Library.MouseClick(driver,"//*[contains(@href,'131_skirts_COL1')]","Skirts");






    Thread.sleep(3000);
    driver.quit();
    }

}
