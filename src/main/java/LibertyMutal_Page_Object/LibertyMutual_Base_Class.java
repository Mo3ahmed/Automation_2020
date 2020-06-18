package LibertyMutal_Page_Object;

import Reusable_Methods.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LibertyMutual_Base_Class extends Abstract_Class {
    public LibertyMutual_Base_Class(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }//end of constructor

    //object for LibertyMutual Home page
    public static LibertyMutual_HomePage libertyMutual_homePage() {
        LibertyMutual_HomePage libertyMutual_homePage = new LibertyMutual_HomePage(driver);
        return libertyMutual_homePage;
    }//end of LibertyMutual Home page

    //object for feedbackPage
    public static LibertyMutual_Feedback_Page libertyMutual_feedback_page() {
        LibertyMutual_Feedback_Page libertyMutual_feedback_page = new LibertyMutual_Feedback_Page(driver);
        return libertyMutual_feedback_page;
    }//end of LibertyMutual FeedbackPage


}//end of class
