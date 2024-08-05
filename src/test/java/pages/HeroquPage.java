package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HeroquPage {

    public HeroquPage() {
        PageFactory.initElements(Driver.getDriver(),this);


    }

    @FindBy(xpath = "//*[text()='Add Element']")
    public WebElement addButton;

    @FindBy(xpath = "//*[text()='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[text()='Add/Remove Elements']")
    public WebElement addRemoveElements;
}
