package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebUniversityPage {

    public WebUniversityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//h1[text()='LOGIN PORTAL']")
    public WebElement loginPortalButton;

    @FindBy(xpath = "//*[@*='Username']")
    public WebElement usernameBox;

    @FindBy(xpath ="//*[@*='Password']" )
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@*='submit']")
    public WebElement loginButton;
}
