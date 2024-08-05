package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.SaucedemoPage;
import utilities.ConfigReader;

public class SaucedemoStepdefinitions {

    SaucedemoPage saucedemoPage = new SaucedemoPage();
    String firstProductName = "";

    @Then("saucedemo username kutusuna {string} yazar")
    public void saucedemo_username_kutusuna_yazar(String username) {
        saucedemoPage.usernameBox.sendKeys(username);
    }
    @Then("saucedemo password kutusuna {string} yazar")
    public void saucedemo_password_kutusuna_yazar(String password) {
        saucedemoPage.passwordBox.sendKeys(password);
    }
    @Then("saucedemo login tusuna basar")
    public void saucedemo_login_tusuna_basar() {
        saucedemoPage.loginButton.click();
    }
    @Then("ilk urunun ismini kaydeder ve bu urunun sayfasina gider")
    public void ilk_urunun_ismini_kaydeder_ve_bu_urunun_sayfasina_gider() {
        firstProductName= saucedemoPage.firstProductNameElement.getText();
        saucedemoPage.firstProductNameElement.click();
    }
    @When("saucedemo add to Cart butonuna basar")
    public void saucedemo_add_to_cart_butonuna_basar() {
        saucedemoPage.addToCartButton.click();
    }
    @Then("saucedemo alisveris sepetine tiklar")
    public void saucedemo_alisveris_sepetine_tiklar() {
        saucedemoPage.cartLink.click();
    }
    @Then("sectigi urunun basarili olarak sepete eklendigini test eder")
    public void sectigi_urunun_basarili_olarak_sepete_eklendigini_test_eder() {
        String expectedProductName = firstProductName;
        String actualProductName = saucedemoPage.cartProductNameElement.getText();

        Assertions.assertEquals(expectedProductName,actualProductName);
    }
}
