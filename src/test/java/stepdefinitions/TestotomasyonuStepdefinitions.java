package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestotomasyonuStepdefinitions {
    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Given("kullanici testotomasyonu anasayfaya gider")
    public void kullanici_testotomasyonu_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
    }

    @When("arama kutusuna phone yazip aratir")
    public void arama_kutusuna_phone_yazip_aratir() {
        testotomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toSearch"), Keys.ENTER);
    }

    @Then("arama sonucunda urun bulunabildigini test eder")
    public void arama_sonucunda_urun_bulunabildigini_test_eder() {
        Assertions.assertTrue(testotomasyonuPage.resultElementList.size() > 0);
    }

    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.quitDriver();
    }


    @When("arama kutusuna dress yazip aratir")
    public void aramaKutusunaDressYazipAratir() {
        testotomasyonuPage.searchBox.sendKeys("dress", Keys.ENTER);
    }

    @When("arama kutusuna samsung yazip aratir")
    public void aramaKutusunaSamsungYazipAratir() {
        testotomasyonuPage.searchBox.sendKeys("samsung", Keys.ENTER);
    }

    @When("arama kutusuna tax yazip aratir")
    public void aramaKutusunaTaxYazipAratir() {
        testotomasyonuPage.searchBox.sendKeys("tax" + Keys.ENTER);
    }

    @When("arama kutusuna table yazip aratir")
    public void aramaKutusunaTableYazipAratir() {
        testotomasyonuPage.searchBox.sendKeys("table" + Keys.ENTER);
    }

    @When("arama kutusuna {string} yazip aratir")
    public void aramaKutusunaYazipAratir(String istenenKelime) {
        testotomasyonuPage.searchBox.sendKeys(istenenKelime, Keys.ENTER);
    }


    @And("{int} saniye bekler")
    public void saniye_bekler(Integer saniye) {
        // Write code here that turns the phrase above into concrete actions
        ReusableMethods.wait(saniye);

    }

    @Given("kullanici {string} anasayfaya gider")
    public void kullanici_anasayfaya_gider(String configdenIstenenUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(configdenIstenenUrl));
    }

    @Then("account butonuna basar")
    public void account_butonuna_basar() {
        testotomasyonuPage.accountLink.click();
    }

    @Then("email olarak {string} girer")
    public void email_olarak_girer(String email) {
        testotomasyonuPage.loginEmailBox.sendKeys(ConfigReader.getProperty(email));
    }

    @Then("password olarak {string} girer")
    public void password_olarak_girer(String password) {
        testotomasyonuPage.loginPasswordBox.sendKeys(ConfigReader.getProperty(password));
    }

    @Then("signIn butonuna basar")
    public void sign_ın_butonuna_basar() {
        testotomasyonuPage.loginSigninButton.click();
    }

    @Then("basarili giris yapilabildigini test eder")
    public void basarili_giris_yapilabildigini_test_eder() {
        Assertions.assertTrue(testotomasyonuPage.logoutButton.isDisplayed());
    }


    @Then("giris yapilamadigini test eder")
    public void girisYapilamadiginiTestEder() {
        Assertions.assertTrue(testotomasyonuPage.loginSigninButton.isDisplayed());
    }
}
