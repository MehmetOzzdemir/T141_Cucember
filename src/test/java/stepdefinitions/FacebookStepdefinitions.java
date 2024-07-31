package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class FacebookStepdefinitions {

    FacebookPage facebookPage = new FacebookPage();

    @Then("facebook cookies kabul eder")
    public void facebook_cookies_kabul_eder() {
        facebookPage.cookiesKabulButonu.click();
    }

    @Then("facebook'da yeni hesap olustur butonna basar")
    public void facebook_da_yeni_hesap_olustur_butonna_basar() {
        facebookPage.yeniKayitOlusturButonu.click();
    }

    @When("Faker class'indan bilgilerle facebook kayit formunu doldurur")
    public void faker_class_indan_bilgilerle_facebook_kayit_formunu_doldurur() {
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();

        String fakeEmail = faker.internet().emailAddress();

        actions.sendKeys(faker.name().firstName(), Keys.TAB)
                .sendKeys(faker.name().lastName(), Keys.TAB)
                .sendKeys("domates@biber.com").perform();

        ReusableMethods.wait(2);

        actions.sendKeys(Keys.TAB)
                .sendKeys("domates@biber.com",Keys.TAB)
                .sendKeys(faker.internet().password(),Keys.TAB)
                .sendKeys(Keys.TAB,Keys.TAB).sendKeys("15")
                .sendKeys(Keys.TAB,"Mar").sendKeys(Keys.TAB)
                .sendKeys("1989",Keys.TAB).sendKeys(Keys.ARROW_RIGHT).perform();


    }

    @Then("facebook kayit ol butonuna basar")
    public void facebook_kayit_ol_butonuna_basar() {
        facebookPage.signUpButonu.click();

    }
}
