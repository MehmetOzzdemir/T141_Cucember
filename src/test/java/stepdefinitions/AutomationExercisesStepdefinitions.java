package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.AutomationExercisesPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class AutomationExercisesStepdefinitions {

    AutomationExercisesPage automationExercisesPage = new AutomationExercisesPage();
    Faker faker = new Faker();
    String fakeFirstName;
    Actions actions = new Actions(Driver.getDriver());


    @Then("cookies kabul eder")
    public void cookies_kabul_eder() {
        automationExercisesPage.cookies.click();
    }

    @Given("user sign up linkine tiklar")
    public void userSignUpLinkineTiklar() {
        automationExercisesPage.loginButton.click();
    }

    @Then("user New user signUp bolumune fake name ve email adresi girer")
    public void userNewUserSignUpBolumuneFakeNameVeEmailAdresiGirer() {
        fakeFirstName = faker.name().firstName();
        automationExercisesPage.nameBox.sendKeys(fakeFirstName);
        automationExercisesPage.emailBox.sendKeys(faker.internet().emailAddress());
    }

    @Given("signUp butonuna basar")
    public void signupButonunaBasar() {
        automationExercisesPage.signupButton.click();
    }

    @Then("user fake bilgilerle kisisel bilgilerini ve iletisim bilgilerini girer")
    public void userFakeBilgilerleKisiselBilgileriniVeIletisimBilgileriniGirer() {

        actions.click(automationExercisesPage.genderRadioButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeFirstName)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Texas")
                .sendKeys(Keys.TAB)
                .sendKeys("Dallas")
                .sendKeys(Keys.TAB)
                .sendKeys("71000")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .perform();


        ReusableMethods.wait(5);
    }

    @And("user Create Account butonuna basar")
    public void userCreateAccountButonunaBasar() {
        automationExercisesPage.createAccountButonu.click();
    }

    @Then("hesap olustugunu test eder")
    public void hesapOlustugunuTestEder() {
        Assertions.assertTrue(automationExercisesPage.accountCreatedYaziElementi.isDisplayed());
    }
}
