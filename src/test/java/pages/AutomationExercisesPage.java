package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisesPage {
    public AutomationExercisesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement nameBox;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailBox;

    @FindBy(xpath = "//*[text()='Signup']")
    public WebElement signupButton;

    @FindBy(id = "id_gender1")
    public WebElement genderRadioButton;

    @FindBy(xpath = "//*[text()='Create Account']")
    public WebElement createAccountButonu;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement accountCreatedYaziElementi;

    @FindBy(xpath = "(//*[@class='fc-button-label'])[1]")
    public WebElement cookies;
}
