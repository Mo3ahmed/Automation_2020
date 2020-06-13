package Yahoo_Page_Class;

import Reusable_Methods.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Base_Class extends Abstract_Class {

    public Yahoo_Base_Class(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
    }//end of constructor

    //create a new name to refer to the actual page class
    //object for yahoo home page
    public static Yahoo_HomePage yahoo_homePage(){
        Yahoo_HomePage yahoo_homePage = new Yahoo_HomePage(driver);
        return yahoo_homePage;
    }//end of static method

    //object for yahoo search results page
    public static Yahoo_Search_Results yahoo_search_results(){
        Yahoo_Search_Results yahoo_search_results = new Yahoo_Search_Results(driver);
        return yahoo_search_results;
    }//end of object reference for yahoo search results static method

}//end of java class
