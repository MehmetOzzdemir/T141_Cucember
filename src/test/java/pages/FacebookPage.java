package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement emailKutusu;

    @FindBy(id = "pass")
    public WebElement passwordKutusu;

    @FindBy(name = "login")
    public WebElement loginButonu;

    @FindBy(xpath = "(//*[text()='Allow all cookies'])[2]")
    public WebElement cookiesKabulButonu;

    @FindBy(xpath = "//*[@class='pam _3-95 _9ay3 uiBoxRed']")
    public WebElement basariliGirisYapilamadiUyarisi;

    @FindBy(xpath = "//*[@data-testid='open-registration-form-button']")
    public WebElement yeniKayitOlusturButonu;

    @FindBy(name = "websubmit")
    public WebElement signUpButonu;


}
