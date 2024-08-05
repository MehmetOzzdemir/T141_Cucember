package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HeroquPage;
import utilities.ReusableMethods;

import java.util.NoSuchElementException;

public class HeroquAppStepdefinitions {

    HeroquPage heroquPage = new HeroquPage();

    @When("kullanici Add Element butonuna basar")
    public void kullaniciAddElementButonunaBasar() {
        heroquPage.addButton.click();
    }

    @And("Delete butonu’nun gorunur oldugunu test eder")
    public void deleteButonuNunGorunurOldugunuTestEder() {
        Assertions.assertTrue(heroquPage.deleteButton.isDisplayed());
    }

    @Then("Delete tusuna basar")
    public void deleteTusunaBasar() {
        heroquPage.deleteButton.click();
    }

    @Then("Delete butonunun kayboldugunu test eder")
    public void delete_butonunun_kayboldugunu_test_eder() {

        boolean deleteButonuKayipMi = false;

        ReusableMethods.wait(2);
        try {
            Assertions.assertFalse(heroquPage.deleteButton.isDisplayed());
            // Olmayan bir elementin assert'i olmaz
            // olmayan elementi kullanmak istedigimizde NoSuchElementException olusur
            // biz de bunu try catch ile firsata cevirdik
            //
        } catch (Exception e) {

            ReusableMethods.wait(1);
            deleteButonuKayipMi = true;
        }

        // bizden istenen asil assertion'i simdi yapalim

        Assertions.assertTrue(deleteButonuKayipMi);

    }

    @And("Add Remove Elements yazisinin gorunur oldugunu test eder")
    public void addRemoveElementsYazisininGorunurOldugunuTestEder() {
        Assertions.assertTrue(heroquPage.addRemoveElements.isDisplayed());
    }
}
