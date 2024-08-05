package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SaucedemoPage {

    public SaucedemoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@placeholder='Username']")
    public WebElement usernameBox ;

    @FindBy(xpath = "//*[@placeholder='Password']")
    public WebElement passwordBox ;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "(//*[@class='inventory_item_name '])[1]")
    public WebElement firstProductNameElement;

    @FindBy(id = "add-to-cart")
    public WebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    public WebElement cartLink;

    @FindBy( className = "inventory_item_name")
    public WebElement cartProductNameElement;

}
