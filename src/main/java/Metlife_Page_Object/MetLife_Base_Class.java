package Metlife_Page_Object;

import Reusable_Methods.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Base_Class extends Abstract_Class {
    public MetLife_Base_Class(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
    }//end of constructor

    //object for MetLife Home Page
    public static MetLife_HomePage metLife_homePage(){
        MetLife_HomePage metLife_homePage = new MetLife_HomePage(driver);
        return metLife_homePage;
    }//end of MetLife Home page

    //object for MetLife Enroll page
    public static MetLife_Enroll metLife_enroll(){
        MetLife_Enroll metLife_enroll = new MetLife_Enroll(driver);
        return metLife_enroll;
    }//end of enroll page

    //object for MetLife ZipCode Page
    public static MetLife_ZipCode metLife_zipCode(){
        MetLife_ZipCode metLife_zipCode = new MetLife_ZipCode(driver);
        return metLife_zipCode;
    }//end of ZipCode page

    //method for MetLife PPO Page
    public static MetLife_PPO metLife_ppo(){
        MetLife_PPO metLife_ppo = new MetLife_PPO(driver);
        return metLife_ppo;
    }//end of MetLife PPO Page


}//end of java class
